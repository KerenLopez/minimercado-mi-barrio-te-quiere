package model;

public class Person {
	
	private String typeOfId;
	private int numId;
	
	public Person(int typeOfId, int numId) {
		this.numId = numId;
		switch(typeOfId) {
		case 1:
			this.setTypeOfId("TI");
		case 2:
			this.setTypeOfId("CC");
		case 3:
			this.setTypeOfId("PP");
		case 4:
			this.setTypeOfId("CE");
		}
	}

	public String getTypeOfId() {
		return typeOfId;
	}

	public void setTypeOfId(String typeOfId) {
		this.typeOfId = typeOfId;
	}

	public int getNumId() {
		return numId;
	}

	public void setNumId(int numId) {
		this.numId = numId;
	}
}
