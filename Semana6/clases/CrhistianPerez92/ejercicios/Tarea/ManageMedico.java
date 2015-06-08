import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import java.sql.*;

import java.util.Properties;
import models.Medico;

public class ManageMedico{
	private Medico medico = null;
	private MenuPrincipal menu = null;

	public ManageMedico()throws SQLException{
		System.out.println("------------------------");
		System.out.println("¡Modulo de Medicos!");
		ImprimirMenu();
	}


	public void ImprimirMenu() throws SQLException{
			System.out.println("------------------------");
			System.out.println("Menu de opciones:");
			System.out.println("1.- Agregar Medico\n2.- Consultar Medico\n3.- Actulizar Medico\n4.- Eliminar Medico\n5.- Regresar al menu anterior\n6.- Salir");
			System.out.println("------------------------");
			System.out.println("Ingrese la opcion deseada:");
			int opcion = new Scanner(System.in).nextInt();
			OpcionesMenu(opcion);
	}

	public void OpcionesMenu(int opcion) throws SQLException{
		
		switch(opcion){
			case 1:{
				medico = new Medico();
				medico.AgregarMedico();
				break;
			}
			case 2:{
				medico = new Medico();
				medico.ConsultarMedico();
				break;
			}
			case 3:{
				medico = new Medico();
				medico.ActualizarMedico();
				break;
			}
			case 4:{
				medico = new Medico();
				medico.EliminarMedico();
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