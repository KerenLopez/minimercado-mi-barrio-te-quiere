package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import exceptions.NumberOfDocumentException;
import exceptions.TypeOfDocumentException;

public class MiniMercadoMiBarrioTeQuiereTest {

	private MiniMercadoMiBarrioTeQuiere minimercado;
	
	public void setupScenary1() {
		minimercado = new MiniMercadoMiBarrioTeQuiere();
	}
	
	public void setupScenary2() {
		minimercado = new MiniMercadoMiBarrioTeQuiere();
		minimercado.addPerson("CC", "31960334");
		minimercado.addPerson("PP", "5229447");
		minimercado.addPerson("CE", "61238076");
		minimercado.addPerson("CC", "41152226");
		minimercado.setNumPeopleTriedToEnter(4);
	}

	@Test
	public void testRegisterPerson1(){
		setupScenary1();
		int day = LocalDate.now().getDayOfMonth();
		String typeOfId = "CC";
		String numId = "31929229";
		boolean added = false;
		try {
			added = minimercado.registerPerson(typeOfId, numId, day);
		}catch(TypeOfDocumentException tde){
			added = false;
		}catch(NumberOfDocumentException nde){
			added = false;
		}
		if(day%2!=0) {
			assertTrue(added);
			assertEquals(1,minimercado.getPeople().size());
			assertEquals(typeOfId,minimercado.getPeople().get(0).getTypeOfId());
			assertEquals(numId,minimercado.getPeople().get(0).getNumId());
			assertEquals(1,minimercado.getNumPeopleTriedToEnter());
		}else {
			assertFalse(added);
			assertEquals(1,minimercado.getNumPeopleTriedToEnter());
		}
	}
	
	@Test
	public void testRegisterPerson2() {
		setupScenary2();
		int day = LocalDate.now().getDayOfMonth();
		String typeOfId = "CC";
		String numId = "31929229";
		boolean added = false;
		try {
			added = minimercado.registerPerson(typeOfId, numId, day);
		}catch(TypeOfDocumentException tde){
			added = false;
		}catch(NumberOfDocumentException nde){
			added = false;
		}
		if(day%2!=0) {
			assertTrue(added);
			assertEquals(5,minimercado.getPeople().size());
			assertEquals(typeOfId,minimercado.getPeople().get(4).getTypeOfId());
			assertEquals(numId,minimercado.getPeople().get(4).getNumId());
			assertEquals(5,minimercado.getNumPeopleTriedToEnter());
		}else {
			assertFalse(added);
			assertEquals(5,minimercado.getNumPeopleTriedToEnter());
		}
	}
	
	@Test
	public void testRegisterPerson3() {
		setupScenary1();
		int day = LocalDate.now().getDayOfMonth();
		String typeOfId = "CC";
		String numId = "71113673";
		boolean added = false;
		try {
			added = minimercado.registerPerson(typeOfId, numId, day);
		}catch(TypeOfDocumentException tde){
			added = false;
		}catch(NumberOfDocumentException nde){
			added = false;
		}
		if(day%2==0) {
			assertTrue(added);
			assertEquals(1,minimercado.getPeople().size());
			assertEquals(typeOfId,minimercado.getPeople().get(0).getTypeOfId());
			assertEquals(numId,minimercado.getPeople().get(0).getNumId());
			assertEquals(1,minimercado.getNumPeopleTriedToEnter());
		}else {
			assertFalse(added);
			assertEquals(1,minimercado.getNumPeopleTriedToEnter());
		}
	}
	
	@Test
	public void testRegisterPerson4(){
		setupScenary2();
		int day = LocalDate.now().getDayOfMonth();
		String typeOfId = "CC";
		String numId = "71113673";
		boolean added = false;
		try {
			added = minimercado.registerPerson(typeOfId, numId, day);
		}catch(TypeOfDocumentException tde){
			added = false;
		}catch(NumberOfDocumentException nde){
			added = false;
		}
		if(day%2==0) {
			assertTrue(added);
			assertEquals(5,minimercado.getPeople().size());
			assertEquals(typeOfId,minimercado.getPeople().get(4).getTypeOfId());
			assertEquals(numId,minimercado.getPeople().get(4).getNumId());
			assertEquals(5,minimercado.getNumPeopleTriedToEnter());
		}else {
			assertFalse(added);
			assertEquals(5,minimercado.getNumPeopleTriedToEnter());
		}
	}
	
	@Test
	public void testRegisterPerson5() throws TypeOfDocumentException, NumberOfDocumentException {
		setupScenary1();
		int day = LocalDate.now().getDayOfMonth();
		String typeOfId = "TI";
		String numId = "1111538056";
		boolean added = false;
		try {
			added = minimercado.registerPerson(typeOfId, numId, day);
		}catch(TypeOfDocumentException tde){
			added = false;
		}catch(NumberOfDocumentException nde){
			added = false;
		}
		assertFalse(added);
		assertEquals(1,minimercado.getNumPeopleTriedToEnter());
	}

	@Test
	public void testRegisterPerson6() throws TypeOfDocumentException, NumberOfDocumentException {
		setupScenary2();
		int day = LocalDate.now().getDayOfMonth();
		String typeOfId = "TI";
		String numId = "1111538056";
		boolean added = false;
		try {
			added = minimercado.registerPerson(typeOfId, numId, day);
		}catch(TypeOfDocumentException tde){
			added = false;
		}catch(NumberOfDocumentException nde){
			added = false;
		}
		assertFalse(added);
		assertEquals(5,minimercado.getNumPeopleTriedToEnter());
	}
}
