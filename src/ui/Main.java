package ui;

import java.time.LocalDate;
import java.util.Scanner;
import exceptions.NumberOfDocumentException;
import exceptions.TypeOfDocumentException;
import model.MiniMercadoMiBarrioTeQuiere;

public class Main {

	public Scanner lector;
	private MiniMercadoMiBarrioTeQuiere mainMinimercado;

	//Builder Method
	public Main(){
		lector = new Scanner(System.in);
		mainMinimercado = new MiniMercadoMiBarrioTeQuiere();
	}
	//End Builder	

	public static void main(String[] args){
		System.out.println(
			"\n**********************************************************************************\n"+
			"             Bienvenido al sistema del minimercado Mi Barrio Te Quiere"
		);
		Main objMain = new Main();
		int option = 0;
		do{
			option = objMain.menu();
		} while(option!= 5);
	}

	public int menu(){
		int option = 0;
		boolean menu = true;
		while(menu){
			System.out.println(
				"\n**********************************************************************************\n"+
				"                         Seleccione una opcion para continuar"+
				"\n**********************************************************************************\n"+
				"      1. Registrar un nueva persona que ingresa al minimercado\n"+
				"      2. Conocer la cantidad de personas que han intentado ingresar al minimercado\n"+
				"      3. Finalizar el programa\n"
			);
			option = Integer.parseInt(lector.nextLine());
			switch(option){
				case 1:
					registerPerson();
					menu = false;
					break;
				case 2:
					displayNumOfPeople();
					menu = false;
					break;
				case 3:
					System.out.println("\n**********************************************************************************\n"+"Gracias por utilizar el sistema"+"\n**********************************************************************************\n");
					menu = false;
					break;
				default:
					System.out.println("Ingrese una opcion valida");
					menu = false;
					break;	
			}		
		} return option;
	}
	
	public void registerPerson(){
		int typeOfId = 0;
		String tpId = "", numId = "";
		System.out.println(
				"\n**********************************************************************************\n"+
				"                         Registrar el ingreso de una persona"+
				"\n**********************************************************************************");
		do{
			System.out.println(
					"\nSeleccione el tipo de documento de identidad que posee la persona a registrar: "+
							"\n    1. TI - Tarjeta de identidad"+
							"\n    2. CC - Cedula de ciudadania"+
							"\n    3. PP - Pasaporte"+
							"\n    4. CE - Cedula de Extranjeria"
					);
			typeOfId = Integer.parseInt(lector.nextLine());
			if(typeOfId!=1 && typeOfId!=2 && typeOfId!=3 && typeOfId!=4){
				System.out.println("\nIngrese una opcion correcta");
			}
		} while(typeOfId!=1 && typeOfId!=2 && typeOfId!=3 && typeOfId!=4);
		
		switch(typeOfId) {
		case 1:
			tpId = "TI";
		case 2:
			tpId = "CC";
		case 3:
			tpId = "PP";
		case 4:
			tpId = "CE";
		}
		
		System.out.print("Digite el numero de documento de identidad que posee la persona a registrar: ");
		numId = lector.nextLine();
		
		int day = LocalDate.now().getDayOfMonth();
		
		try {
			mainMinimercado.addPerson(tpId, numId, day);
			 
		}catch(TypeOfDocumentException tde) {
			System.err.println(tde.getMessage());
		}catch(NumberOfDocumentException nde) {
			System.err.println(nde.getMessage());
		}
	}

	public void displayNumOfPeople(){
		String message = mainMinimercado.showNumOfPeople();
		System.out.println(
			"\n**********************************************************************************\n"+
			"            Numero de personas que intentaron ingresar al minimercado"+
			"\n**********************************************************************************"
		);
		System.out.println(message);
	}
}
