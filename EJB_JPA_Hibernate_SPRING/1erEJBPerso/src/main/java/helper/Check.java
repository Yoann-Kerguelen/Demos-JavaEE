package helper;

public class Check {
	public static void checkRequiredField(String field, String msg) throws Exception {
		if (field != null && field.isBlank()) {
			throw new Exception("Le champs " + msg + " ne pas etre vide");
		}
	}
}
