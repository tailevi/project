package errors;

public class DBException extends Exception{
	


	public DBException (String stirng, Exception e) {
		
		
	}
	
	public DBException (String message) {
		super(message);
	}
	
	public DBException() {
		System.out.println("Could not connecto to the Data base");
	}

}
