package models;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import java.sql.*;

import java.util.Properties;

import java.util.Scanner;
import lib.BD;

public class Medico{
	private String nombre = null;
	private String apellido = null;
	private String cedula = null;
	private String especialidad = null;
	private String[] medico = null;
	private BD db = null;
	private boolean existe = false;

	public Medico(){

	}

	public void ListarMedico(String bus)throws SQLException {
		String query = "select * from medicos where  CONCAT(nombre, ' ', apellido) like '%"+bus+"%'";
		//System.out.println(query);
		try {
			db = new BD();
			ResultSet resultSet = db.SqlConsultas(query);
			while (resultSet.next()) {
				nombre = resultSet.getString("nombre");
				apellido = resultSet.getString("apellido");
				cedula = resultSet.getString("cedula");
				especialidad = resultSet.getString("espcialidad");
				System.out.println("--------------");
				System.out.println("No. Medico: " + resultSet.getInt("id"));
				System.out.print("Nombre del Medico: " + nombre + " " + apellido);
				System.out.print(" Cedula: " + cedula);
				System.out.print(" Especialidad: " + especialidad);
				System.out.println("--------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.CloseConection();
		}
	}

	public void AgregarMedico()throws SQLException{
		System.out.println("Ingrese el nombre del Medico:");
		nombre = new Scanner(System.in).nextLine();
		System.out.println("Ingrese los apellidos del Medico:");
		apellido = new Scanner(System.in).nextLine();
		System.out.println("Ingrese cedula del Medico:");
		cedula = new Scanner(System.in).nextLine();
		System.out.println("Ingrese la especialidad del Medico:");
		especialidad = new Scanner(System.in).nextLine();
		ImprimirConfirmacion();
		
	}

	public void ImprimirConfirmacion()throws SQLException{
		System.out.println("------------------------\n");
		System.out.println("Acuse del registro del Medico \n");
		System.out.println("Nombre: "+ nombre.toUpperCase()+"\nApellidos:"+apellido.toUpperCase() +"\nCedula: "+ cedula.toUpperCase() +"\nEdad: "+especialidad.toUpperCase());
		System.out.println("------------------------");
		System.out.println("¿La informacion es la correcta (si/no)?");
		String esCorrecta = new Scanner(System.in).nextLine();
		if("si".equals(esCorrecta)){
			medico = new String[4];
			medico[0] = nombre;
			medico[1] = apellido;
			medico[2] = cedula;
			medico[3] = especialidad;
			String updateQuery = "insert into medicos(nombre, apellido, cedula, espcialidad) values(?, ?, ?, ?)";
			db = new BD();
			db.SqlInsertRegistros(updateQuery, medico);
		}else{
			System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
		}
	}

	public void ConsultarMedico()throws SQLException{
		System.out.println("Ingrese el nombre completo del Medico a buscar:");
		nombre = new Scanner(System.in).nextLine();
		String query = "select * from medicos where  CONCAT(nombre, ' ', apellido) like '%"+nombre+"%'";
		//System.out.println(query);
		try {
			db = new BD();
			ResultSet resultSet = db.SqlConsultas(query);
			while (resultSet.next()) {
				nombre = resultSet.getString("nombre");
				apellido = resultSet.getString("apellido");
				cedula = resultSet.getString("cedula");
				especialidad = resultSet.getString("espcialidad");

				System.out.println("--------------");
				System.out.println("Nombre del Asegurado: " + nombre + " " + apellido);
				System.out.println("Cedula: " + cedula);
				System.out.println("Especialidad: " + especialidad);
				System.out.println("--------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.CloseConection();
		}
	}

	public void ActualizarMedico()throws SQLException{
		System.out.println("Ingrese el nombre del Medico que desea actualizar:");
		nombre = new Scanner(System.in).nextLine();
		ListarMedico(nombre);
		System.out.println("Ingrese el No. de Medico que desea Actulizar");
		int idMedico = new Scanner(System.in).nextInt();
		String campo = "";
		String update_valor = "";
		System.out.println("--------------------------------");
		System.out.println("Opciones de campos:");
		System.out.println("1.- Nombre\n2.- Apellidos\n3.- Cedula\n4.- Especialidad");
		System.out.println("--------------------------------");
		System.out.println("Ingrese la opcion del campo que desea actulizar del Medico:");
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
				campo = "cedula";
				break;
			}case 4:{
				campo = "espcialidad";
				break;
			}default:{
				System.out.println("El campo ingresado no existe");
				break;
			}
		}
		if(campo != ""){
			
			System.out.println("Ingrese "+campo.toUpperCase()+" del Asegurado:");
			update_valor = new Scanner(System.in).nextLine();
			System.out.println("Esta seguro que desea Actulizar el registro el registro(si/no):");
			String esCorrecta = new Scanner(System.in).nextLine();
			if("SI".equals(esCorrecta.toUpperCase())){
				medico = new String[2];
				String updateQuery = "Update medicos set "+campo+" = ? where id = ?";
				medico[0] = update_valor.toUpperCase();
				medico[1] = String.valueOf(idMedico);
				db = new BD();
				db.SqlUpdateRegistros(updateQuery, medico);
			}else{
				System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
			}
		}
	}

	public void EliminarMedico()throws SQLException{
		System.out.println("Ingrese el nombre del Medico a eliminar:");
		nombre = new Scanner(System.in).nextLine();
		ListarMedico(nombre);
		System.out.println("Ingrese el No. del Medico que desea eliminar");
		int idMedico = new Scanner(System.in).nextInt();
		System.out.println("Esta seguro que desea eliminar el registro(si/no):");
		String esCorrecta = new Scanner(System.in).nextLine();
		if("si".equals(esCorrecta)){
			String updateQuery = "delete from medicos where id = ?";
			String value = String.valueOf(idMedico);
			db = new BD();
			db.SqlDeleteRegistro(updateQuery, value);
		}else{
			System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
		}
	}

	public boolean getExiste(int idAse)throws SQLException{
		String query = "select * from medicos where  id = "+String.valueOf(idAse);
		existe = false; 
		try {
			db = new BD();
			ResultSet resultSet = db.SqlConsultas(query);
			if(resultSet.next()){
				existe = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.CloseConection();
		}
		return existe;
	}
}