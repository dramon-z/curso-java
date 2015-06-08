package lib;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import java.sql.*;

import java.util.Properties;

import java.util.Scanner;
import lib.BD;

public class Asegurado{
	private String nombre = null;
	private String apellido = null;
	private String num_seguro = null;
	private Integer edad = null;
	private char sexo = ' ';
	
	public Asegurado(){
		
	}

	public void AgregarAsegurado()throws SQLException{
		System.out.println("Ingrese el nombre del Asegurado:");
		nombre = new Scanner(System.in).nextLine();
		System.out.println("Ingrese los apellidos del Asegurado:");
		apellido = new Scanner(System.in).nextLine();
		System.out.println("Ingrese el numero de seguro social del Asegurado:");
		num_seguro = new Scanner(System.in).nextLine();
		System.out.println("Ingrese la edad del Asegurado:");
		edad = new Scanner(System.in).nextInt();
		System.out.println("Ingrese un caracter del sexo del Asegurado:\n  * M = Masculino\n  * F = Femenino");
		sexo = new Scanner(System.in).next().charAt(0);
		ImprimirConfirmacion("Registrar");
		
	}
	
	public void ImprimirConfirmacion(String text)throws SQLException{
		System.out.println("------------------------\n");
		System.out.println("Datos de acuse del registro del Asegurado \n         Para "+text+ "\n");
		System.out.println("Nombre: "+ nombre.toUpperCase()+"\nApellidos:"+apellido.toUpperCase() +"\nNum de Seguro: "+ num_seguro.toUpperCase() +"\nEdad: "+edad+"\nSexo:"+String.valueOf(sexo).toUpperCase());
		System.out.println("------------------------");
		System.out.println("¿La informacion es la correcta (si/no)?");
		String esCorrecta = new Scanner(System.in).nextLine();
		if("si".equals(esCorrecta)){
			BD db = new BD();
			db.GuardarAsegurado(nombre,apellido,num_seguro,edad,sexo);
		}else{
			System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
		}
	}	

	public void ConsultarAsegurado()throws SQLException{
		System.out.println("Ingrese el nombre completo del Asegurado a buscar:");
		nombre = new Scanner(System.in).nextLine();
		BD db = new BD();
		db.BuscarAsegurado(nombre);
	}

	public void ActualizarAsegurado()throws SQLException{
		System.out.println("Ingrese el nombre del Asegurado que desea actualizar:");
		nombre = new Scanner(System.in).nextLine();
		BD db = new BD();
		db.ActulizarAsegurado(nombre);
	}

	public void EliminarAsegurado()throws SQLException{
		System.out.println("Ingrese el nombre del Asegurado a eliminar:");
		nombre = new Scanner(System.in).nextLine();
		BD db = new BD();
		db.EliminarAsegurado(nombre);
	}
}