package exceptions;

public class NumberOfDocumentException extends Exception{
	
	private String numId;
	private int numDay;
	
	public NumberOfDocumentException(String nId, int day) {
		super("Recuerde que de acuerdo con la �ltima normativa del gobierno local, las personas cuyo documento tiene el pen�ltimo n�mero par, pueden salir si el d�a del mes es un n�mero impar, y viceversa. Es el dia "+day+" del mes y usted ingreso un documento que tiene el numero "+nId+" como penultimo digito");
		numId = nId;
		numDay = day;
	}
	
	public String getNumId() {
		return numId;
	}
	
	public int getNumDay() {
		return numDay; 
	}
}
