package assignment12;

class InputMismatchException extends Exception {
	public InputMismatchException(String message) {
		super(message);
	}
}

class UnsupportedOperationException extends Exception {
	public UnsupportedOperationException(String message) {
		super(message);
	}
}

public class ReturnNumber {

	public static void main(String[] args) {
		try {
            
			printObject("200");
			
		} catch (InputMismatchException x) {
			System.out.println("Exception: " + x.getMessage());
		} catch (UnsupportedOperationException x) {
			System.out.println("Exception: " + x.getMessage());
		}
		
		try {
            
			printObject(200);
			
		} catch (InputMismatchException x) {
			System.out.println("Exception: " + x.getMessage());
		} catch (UnsupportedOperationException x) {
			System.out.println("Exception: " + x.getMessage());
		}

	}

	public static void printObject(Object obj) throws InputMismatchException, UnsupportedOperationException {
		
		if (obj instanceof Integer) {
			int num = (int) obj;
			
			if (num < 0)
				return;
			else if (num > 1 && 100 < num) {
				throw new UnsupportedOperationException("Value : " + num + " is not in range between 1 to 100.");
			}
			else {
				System.out.println("Number: " + num);
			}
			
		}
		else {
			throw new InputMismatchException("Wrong entry of data instead of int value.");
		}
			
	}
}
