package models;
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
	private int edad = 0;
	private char sexo = ' ';
	private BD db = null;
	private boolean existe = false;
	private String[] asegurado = new String[5];
	
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
	
	public void ListarAsegurado(String bus)throws SQLException {
		String query = "select * from asegurados where  CONCAT(nombre, ' ', apellido) like '%"+bus+"%'";
		//System.out.println(query);
		try {
			db = new BD();
			ResultSet resultSet = db.SqlConsultas(query);
			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				int edad = resultSet.getInt("edad");
				String sexo = resultSet.getString("sexo");
				String numeroSeguroSocial = resultSet.getString("numero_seguro_social");

				System.out.println("--------------");
				System.out.println("No.Asegurado: " + resultSet.getInt("id"));
				System.out.print("Nombre del Asegurado: " + nombre + " " + apellido);
				System.out.print(" Edad: " + edad);
				System.out.print(" Sexo: " + sexo);
				System.out.println(" Numero de Seguro Social: " + numeroSeguroSocial);
				System.out.println("--------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.CloseConection();
		}
	}

	public void ImprimirConfirmacion(String text)throws SQLException{
		System.out.println("------------------------\n");
		System.out.println("Datos de acuse del registro del Asegurado \n         Para "+text+ "\n");
		System.out.println("Nombre: "+ nombre.toUpperCase()+"\nApellidos:"+apellido.toUpperCase() +"\nNum de Seguro: "+ num_seguro.toUpperCase() +"\nEdad: "+edad+"\nSexo:"+String.valueOf(sexo).toUpperCase());
		System.out.println("------------------------");
		System.out.println("¿La informacion es la correcta (si/no)?");
		String esCorrecta = new Scanner(System.in).nextLine();
		if("si".equals(esCorrecta)){
			asegurado[0] = nombre;
			asegurado[1] = apellido;
			asegurado[2] = String.valueOf(edad);
			asegurado[3] = String.valueOf(sexo);
			asegurado[4] = num_seguro;
			String updateQuery = "insert into asegurados(nombre, apellido, edad, sexo, numero_seguro_social) values(?, ?, ?, ?, ?)";
			db = new BD();
			db.SqlInsertRegistros(updateQuery,asegurado);
		}else{
			System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
		}
	}	

	public void ConsultarAsegurado()throws SQLException{
		System.out.println("Ingrese el nombre completo del Asegurado a buscar:");
		nombre = new Scanner(System.in).nextLine();
		String query = "select * from asegurados where  CONCAT(nombre, ' ', apellido) like '%"+nombre+"%'";
		//System.out.println(query);
		try {
			db = new BD();
			ResultSet resultSet = db.SqlConsultas(query);
			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				int edad = resultSet.getInt("edad");
				String sexo = resultSet.getString("sexo");
				String numeroSeguroSocial = resultSet.getString("numero_seguro_social");

				System.out.println("--------------");
				System.out.println("Nombre del Asegurado: " + nombre + " " + apellido);
				System.out.println("Edad: " + edad);
				System.out.println("Sexo: " + sexo);
				System.out.println("Numero de Seguro Social: " + numeroSeguroSocial);
				System.out.println("--------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.CloseConection();
		}
	}

	public void ActualizarAsegurado()throws SQLException{
		System.out.println("Ingrese el nombre del Asegurado que desea actualizar:");
		nombre = new Scanner(System.in).nextLine();
		ListarAsegurado(nombre);
		System.out.println("Ingrese el No. de asegurados que desea actualizar");
		int idAsegurado = new Scanner(System.in).nextInt();
		String campo = "";
		String update_valor = "";
		System.out.println("--------------------------------");
		System.out.println("Opciones de campos:");
		System.out.println("1.- Nombre\n2.- Apellidos\n3.- edad\n4.- No. Seguro Social\n5.- Sexo");
		System.out.println("--------------------------------");
		System.out.println("Ingrese el nombre del campo que desea actulizar del Asegurado:");
		int opcion_edit = new Scanner(System.in).nextInt();
		switch(opcion_edit){
			case 1:{
				campo = "nombre";
				break;
			}
			case 2:{
				campo = "apellido";
				break;
			}case 3:{
				campo = "edad";
				break;
			}case 4:{
				campo = "numero_seguro_social";
				break;
			}case 5:{
				campo = "sexo";
				break;
			}default:{
				System.out.println("El campo ingresado no existe");
				break;
			}
		}
		if(campo != ""){
			if (opcion_edit==5){
				System.out.println("Ingrese un caracter del sexo del Asegurado:\n  * M = Masculino\n  * F = Femenino");
			}else{
				System.out.println("Ingrese "+campo.toUpperCase()+" del Asegurado:");
			}
			update_valor = new Scanner(System.in).nextLine();
			System.out.println("Esta seguro que desea Actulizar el registro el registro(si/no):");
			String esCorrecta = new Scanner(System.in).nextLine();
			if("si".equals(esCorrecta)){
				asegurado = new String[2];
				String updateQuery = "Update asegurados set "+campo+" = ? where id = ?";
				asegurado[0] = update_valor.toUpperCase();
				asegurado[1] = String.valueOf(idAsegurado);
				db = new BD();
				db.SqlUpdateRegistros(updateQuery, asegurado);
			}else{
				System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
			}
		}
	}

	public void EliminarAsegurado()throws SQLException{
		System.out.println("Ingrese el nombre del Asegurado a eliminar:");
		nombre = new Scanner(System.in).nextLine();
		ListarAsegurado(nombre);
		System.out.println("Ingrese el No. de asegurados que desea eliminar");
		int idAsegurado = new Scanner(System.in).nextInt();
		System.out.println("Esta seguro que desea eliminar el registro(si/no):");
		String esCorrecta = new Scanner(System.in).nextLine();
		if("si".equals(esCorrecta)){
			String updateQuery = "delete from asegurados where id = ?";
			String value = String.valueOf(idAsegurado);
			db = new BD();
			db.SqlDeleteRegistro(updateQuery, value);
		}else{
			System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
		}
	}

	public boolean getExiste(int idAse)throws SQLException{
		String query = "select * from asegurados where  id = "+String.valueOf(idAse);
		existe = false; 
		try {
			db = new BD();
			ResultSet resultSet = db.SqlConsultas(query);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.CloseConection();
		}
		return existe;
	}
}