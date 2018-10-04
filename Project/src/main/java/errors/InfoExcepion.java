package errors;

public class InfoExcepion extends Exception{
	
public InfoExcepion (String stirng, Exception e) {
		
		
	}
	
	public InfoExcepion (String message) {
		super(message);
	}
	
	public InfoExcepion() {
		System.out.println("Wrong Information or Data base Connection error");
	}

}
