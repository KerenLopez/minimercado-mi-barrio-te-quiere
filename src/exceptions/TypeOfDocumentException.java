package exceptions;

public class TypeOfDocumentException extends Exception{

	private static final long serialVersionUID = 1;
	private String typeId;
	
	public TypeOfDocumentException(String tpId) {
		super("Error: el tipo de documento de identidad requerido para ingresar no puede ser Tarjeta de Identidad. Usted escogio la opcion "+tpId+".");
		typeId = tpId;
	}
	
	public String getTypeOfId() {
		return typeId;
	}
}
