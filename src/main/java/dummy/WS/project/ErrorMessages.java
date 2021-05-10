package dummy.WS.project;

public class ErrorMessages {

	public static String error(int statusCode) {
		String inputError = "Invalid input, select admissable values and try again!";
		String logicalError = "Something went wrong, select different values and try again!";
		
		return statusCode == 1 ? inputError : logicalError;
	}
}
