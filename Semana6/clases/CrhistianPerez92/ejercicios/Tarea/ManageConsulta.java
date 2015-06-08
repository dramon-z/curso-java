import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import java.sql.*;

import java.util.Properties;
import models.Consulta;

public class ManageConsulta{
	private Consulta consulta = null;
	private MenuPrincipal menu = null;

	public ManageConsulta()throws SQLException{
		System.out.println("------------------------");
		System.out.println("¡Modulo de Consultas Medicas!");
		ImprimirMenu();
	}


	public void ImprimirMenu() throws SQLException{
			System.out.println("------------------------");
			System.out.println("Menu de opciones:");
			System.out.println("1.- Agregar Consuta\n2.- Bucar Consuta\n3.- Eliminar Consuta\n4.- Regresar al menu anterior\n5.- Salir");
			System.out.println("------------------------");
			System.out.println("Ingrese la opcion deseada:");
			int opcion = new Scanner(System.in).nextInt();
			OpcionesMenu(opcion);
	}

	public void OpcionesMenu(int opcion) throws SQLException{
		
		switch(opcion){
			case 1:{
				consulta = new Consulta();
				consulta.AgregarConsulta();
				break;
			}
			case 2:{
				
				break;
			}
			case 3:{
				
				break;
			}
			case 4:{
				menu = new MenuPrincipal();
				menu.main(null);
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