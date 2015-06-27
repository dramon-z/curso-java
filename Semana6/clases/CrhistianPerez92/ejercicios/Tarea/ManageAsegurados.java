
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import java.sql.*;

import java.util.Properties;
import models.Asegurado;


public class ManageAsegurados{
	private Asegurado asegurado = new Asegurado();
	private MenuPrincipal menu = null;

	public ManageAsegurados()throws SQLException{
		System.out.println("------------------------");
		System.out.println("¡Modulo de Asegurados!");
		ImprimirMenu();
	}


	public void ImprimirMenu() throws SQLException{
			System.out.println("------------------------");
			System.out.println("Menu de opciones:");
			System.out.println("1.- Agregar asegurados\n2.- Consultar asegurados\n3.- Actulizar asegurados\n4.- Eliminar asegurados\n5.- Regresar al menu anterior\n6.- Salir");
			System.out.println("------------------------");
			System.out.println("Ingrese la opcion deseada:");
			int opcion = new Scanner(System.in).nextInt();
			OpcionesMenu(opcion);
	}

	public void OpcionesMenu(int opcion) throws SQLException{
		
		switch(opcion){
			case 1:{
				asegurado = new Asegurado();
				asegurado.AgregarAsegurado();
				break;
			}
			case 2:{
				asegurado = new Asegurado();
				asegurado.ConsultarAsegurado();
				break;
			}
			case 3:{
				asegurado = new Asegurado();
				asegurado.ActualizarAsegurado();
				break;
			}
			case 4:{
				asegurado = new Asegurado();
				asegurado.EliminarAsegurado();
				break;
			}
			case 5:{
				menu = new MenuPrincipal();
				menu.main(null);
				break;
			}
			case 6:{
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