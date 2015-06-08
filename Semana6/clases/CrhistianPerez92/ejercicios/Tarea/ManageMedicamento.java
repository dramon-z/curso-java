import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import java.sql.*;

import java.util.Properties;
import models.Medicamentos;

public class ManageMedicamento{
	private Medicamentos medicamento = null;
	private MenuPrincipal menu = null;


	public ManageMedicamento()throws SQLException{
		System.out.println("------------------------");
		System.out.println("¡Modulo de Medicamentos!");
		ImprimirMenu();
	}


	public void ImprimirMenu() throws SQLException{
			System.out.println("------------------------");
			System.out.println("Menu de opciones:");
			System.out.println("1.- Agregar Medicamento\n2.- Consultar Medicamento\n3.- Actulizar Medicamento\n4.- Eliminar Medicamento\n5.- Regresar al menu anterior\n6.- Salir");
			System.out.println("------------------------");
			System.out.println("Ingrese la opcion deseada:");
			int opcion = new Scanner(System.in).nextInt();
			OpcionesMenu(opcion);
	}

	public void OpcionesMenu(int opcion) throws SQLException{
		
		switch(opcion){
			case 1:{
				medicamento = new Medicamentos();
				medicamento.AgregarMedicamento();
				break;
			}
			case 2:{
				medicamento = new Medicamentos();
				medicamento.ConsultarMedicamento();
				break;
			}
			case 3:{
				medicamento = new Medicamentos();
				medicamento.ActualizarMedicamento();
				break;
			}
			case 4:{
				medicamento = new Medicamentos();
				medicamento.EliminarMedicamento();
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