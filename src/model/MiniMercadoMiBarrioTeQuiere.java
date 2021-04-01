package model;

import java.util.ArrayList;
import exceptions.NumberOfDocumentException;
import exceptions.TypeOfDocumentException;

public class MiniMercadoMiBarrioTeQuiere {

	private ArrayList<Person> people;
	private int numPeopleTriedToEnter;
	
	public MiniMercadoMiBarrioTeQuiere() {
		people = new ArrayList<Person>();
		numPeopleTriedToEnter = 0;
	}
	
	public boolean registerPerson(String typeOfId, String numId, int day) throws TypeOfDocumentException, NumberOfDocumentException{
		boolean added = false;
		setNumPeopleTriedToEnter(getNumPeopleTriedToEnter()+1);
		if(typeOfId.equals("TI")) {
			throw new TypeOfDocumentException(typeOfId);
		}
		char number = 0;
		boolean stop = true;
		for(int k=0;k<numId.length() && stop;k++){
			if(k==numId.length()-2) {
				number = numId.charAt(k);
				stop = false;
			} 				
		}
		int penultimate = Character.getNumericValue(number);
		if((penultimate%2==0 && day%2==0)||(penultimate%2!=0 && day%2!=0)) {
			throw new NumberOfDocumentException(penultimate, day);
		}
		addPerson(typeOfId, numId);
		added = true;
		return added;
	}
	
	public void addPerson(String typeOfId, String numId) {
		Person p = new Person(typeOfId, numId);
		people.add(p);
	}
	
	public String showNumOfPeople() {
		String message = "Cantidad total: "+getNumPeopleTriedToEnter()+"\n"+"Cantidad de personas cuyo registro fue exitoso: "+people.size()+"\n"+"Cantidad de personas cuyo registro no fue exitoso: "+((getNumPeopleTriedToEnter())-(people.size()));
		return message;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}

	public int getNumPeopleTriedToEnter() {
		return numPeopleTriedToEnter;
	}

	public void setNumPeopleTriedToEnter(int numPeopleTriedToEnter) {
		this.numPeopleTriedToEnter = numPeopleTriedToEnter;
	}
}
