package model;

public class Person {
	
	private String typeOfId;
	private String numId;
	
	public Person(String typeOfId, String numId) {
		this.numId = numId;
		this.typeOfId = typeOfId;
	}

	public String getTypeOfId() {
		return typeOfId;
	}

	public void setTypeOfId(String typeOfId) {
		this.typeOfId = typeOfId;
	}

	public String getNumId() {
		return numId;
	}

	public void setNumId(String numId) {
		this.numId = numId;
	}	
}
