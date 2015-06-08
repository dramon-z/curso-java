import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import java.sql.*;

import java.util.Properties;

public class MenuPrincipal{
	
	public static void main(String[] args)throws SQLException{
		System.out.println("¡Bienvenido al sistema de asegurados de la secretaria de salud!");
		MenuPrincipal menu = new MenuPrincipal();
		menu.ImprimirMenu();
		
		
	}

	public void ImprimirMenu() throws SQLException{
			System.out.println("------------------------");
			System.out.println("Menu de opciones:");
			System.out.println("1.- Modulo de asegurados\n2.- Modulo de Medicos\n3.- Modulo de Medicamentos\n4.- Modulo de Consultas\n5.- Salir");
			System.out.println("------------------------");
			System.out.println("Ingrese la opcion deseada:");
			int opcion = new Scanner(System.in).nextInt();
			OpcionesMenu(opcion);
	}

	public void OpcionesMenu(int opcion) throws SQLException{
		
		switch(opcion){
			case 1:{
				ManageAsegurados asegurado = new ManageAsegurados();
				break;
			}
			case 2:{
				ManageMedico medico = new ManageMedico();
				break;
			}
			case 3:{
				ManageMedicamento medicamento = new ManageMedicamento();
				break;
			}
			case 4:{
				ManageConsulta consulta = new ManageConsulta();
				break;
			}
			case 5:{
				System.out.println("Su opcion elegida es: Salir");
				System.out.println("¡Adios vuelva pronto!");
				System.exit(0);
				break;
			}
			default:{
				System.out.println("Debe de elegir una opcion valida");
				break;
			}
		}
		System.out.println("Presione enter para regresar al menu anterior");
				new Scanner(System.in).nextLine();
		ImprimirMenu();

	}
	
}