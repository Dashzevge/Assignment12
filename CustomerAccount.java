package assignment12;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}   

public class CustomerAccount {
        String Cus_name;
        int Acc_no;
        double Balance;
        
        public static void main(String[] args) {
    		
    		CustomerAccount tp = new CustomerAccount("Tamy", 411026834, 500);
    		
    		try {
                tp.withdraw(700);
                tp.withdraw(450); 
            } catch (InsufficientBalanceException e) {
                System.out.println("Exception : " + e.getMessage());
            } catch (LowBalanceException e) {
                System.out.println("Exception : " + e.getMessage());
            }

            try {
                tp.withdraw(450); 
            } catch (InsufficientBalanceException e) {
                System.out.println("Exception: " + e.getMessage());
            } catch (LowBalanceException e) {
                System.out.println("Exception: " + e.getMessage());
            }
    		
    	}
        
        public CustomerAccount(String cus_Name, int account_Number, double balance) {
        	this.Cus_name = cus_Name;
        	this.Acc_no = account_Number;
        	this.Balance = balance;
			
		}
        
        public boolean deposit(double amount) {
        	if(amount > 0) {
        	 this.Balance += amount;
        	 return true;
        	}
        		
        	return false;
        }
        
        public boolean withdraw (double amount) throws InsufficientBalanceException, LowBalanceException {
        	  if (amount > Balance) {
                  throw new InsufficientBalanceException("Withdraw amount exceed the balance");
              } else if (Balance - amount < 100) {
                  throw new LowBalanceException("Balance reach below 100$");
              } else {
            	  Balance -= amount;
                  System.out.println("Withdrawal successful. New balance: $" + Balance);
              }
        	  return true;
        }
       
        
        public double getBalance() {
        	return this.Balance;
        
        }
        
}
