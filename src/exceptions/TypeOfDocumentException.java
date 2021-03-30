package exceptions;

public class TypeOfDocumentException extends Exception{

	private String typeId;
	
	public TypeOfDocumentException(String tpId) {
		super("El tipo de documento de identidad requerido para ingresar no puede ser Tarjeta de Identidad. Usted escogio la opcion: "+tpId);
		typeId = tpId;
	}
	
	public String getTypeOfId() {
		return typeId;
	}
}
