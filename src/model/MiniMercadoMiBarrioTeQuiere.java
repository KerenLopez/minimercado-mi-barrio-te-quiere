package model;

import java.util.ArrayList;

public class MiniMercadoMiBarrioTeQuiere {

	private ArrayList<Person> people; 
	
	public MiniMercadoMiBarrioTeQuiere() {
		setPeople(new ArrayList<Person>());
	}
	
	public boolean addPerson(int typeOfId, int numId) {
		boolean correct = false;
		return correct;
	}
	
	public int showNumOfPeople() {
		int numOfPeople = 0;
		return numOfPeople;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}
}
