package ui;

import java.time.LocalDate;
import java.util.Scanner;
import exceptions.NumberOfDocumentException;
import exceptions.TypeOfDocumentException;
import model.MiniMercadoMiBarrioTeQuiere;

public class Main {

	public Scanner lector;
	private MiniMercadoMiBarrioTeQuiere mainMinimercado;

	public Main(){
		lector = new Scanner(System.in);
		mainMinimercado = new MiniMercadoMiBarrioTeQuiere();
	}

	public static void main(String[] args){
		System.out.println(
			"\n**********************************************************************************\n"+
			"             Bienvenido al sistema del minimercado Mi Barrio Te Quiere"
		);
		Main objMain = new Main();
		int option = 0;
		do{
			option = objMain.menu();
		} while(option!= 3);
	}

	public int menu(){
		int option = 0;
		boolean menu = true;
		boolean pass = true;
		do {
			try {
				while(menu){
					System.out.println(
						"\n**********************************************************************************\n"+
						"                         Seleccione una opcion para continuar"+
						"\n**********************************************************************************\n"+
						"      1. Registrar una nueva persona que ingresa al minimercado\n"+
						"      2. Conocer la cantidad de personas que han intentado ingresar al minimercado\n"+
						"      3. Finalizar el programa\n"
					);
					option = Integer.parseInt(lector.nextLine());
					switch(option){
						case 1:
							addPerson();
							menu = false;
							pass = false;
							break;
						case 2:
							displayNumOfPeople();
							menu = false;
							pass = false;
							break;
						case 3:
							System.out.println("\n**********************************************************************************\n"+"Gracias por utilizar el sistema"+"\n**********************************************************************************\n");
							menu = false;
							pass = false;
							break;
						default:
							System.out.println("Ingrese una opcion valida");
							menu = false;
							pass = false;
							break;	
					}		
				} 
			}catch(NumberFormatException num) {
				System.out.println("Debe ingresar un numero entero que corresponda con las opciones presentadas.");
			}
		}while(pass);
		return option;
	}
	
	public void addPerson(){
		int typeOfId = 0;
		String tpId = "", numId = "";
		System.out.println(
				"**********************************************************************************\n"+
				"                         Registrar el ingreso de una persona"+
				"\n**********************************************************************************");
		do{
			System.out.println(
					"\nSeleccione el tipo de documento de identidad que posee la persona a registrar: "+
							"\n    1. TI - Tarjeta de identidad"+
							"\n    2. CC - Cedula de ciudadania"+
							"\n    3. PP - Pasaporte"+
							"\n    4. CE - Cedula de Extranjeria\n"
					);
			typeOfId = Integer.parseInt(lector.nextLine());
			if(typeOfId!=1 && typeOfId!=2 && typeOfId!=3 && typeOfId!=4){
				System.out.println("\nIngrese una opcion correcta");
			}
		} while(typeOfId!=1 && typeOfId!=2 && typeOfId!=3 && typeOfId!=4);
		switch(typeOfId) {
		case 1:
			tpId = "TI";
			break;
		case 2:
			tpId = "CC";
			break;
		case 3:
			tpId = "PP";
			break;
		case 4:
			tpId = "CE";
			break;
		}

		System.out.print("\nDigite el numero de documento de identidad que posee la persona a registrar: ");
		numId = lector.nextLine();
		
		int day = LocalDate.now().getDayOfMonth();
		
		try {
			boolean added = mainMinimercado.registerPerson(tpId, numId, day);
			if(added==true) {
				String msg = "La persona puede ingresar al minimercado ya que cumple con las condiciones, el registro fue exitoso.";
				System.out.println(msg);
			}
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
