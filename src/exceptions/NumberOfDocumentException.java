package exceptions;

public class NumberOfDocumentException extends Exception{
	
	private static final long serialVersionUID = 1;
	private int numId;
	private int numDay;
	
	public NumberOfDocumentException(int nId, int day) {
		super("Error: recuerde que de acuerdo con la �ltima normativa del gobierno local, las personas cuyo documento tiene el pen�ltimo n�mero par, pueden salir si el d�a del mes es un n�mero impar, y viceversa. Es el dia "+day+" del mes y usted ingreso un documento que tiene el numero "+nId+" como penultimo digito.");
		setNumId(nId);
		setNumDay(day);
	}

	public int getNumId() {
		return numId;
	}

	public void setNumId(int numId) {
		this.numId = numId;
	}

	public int getNumDay() {
		return numDay;
	}

	public void setNumDay(int numDay) {
		this.numDay = numDay;
	}
	
	
}
