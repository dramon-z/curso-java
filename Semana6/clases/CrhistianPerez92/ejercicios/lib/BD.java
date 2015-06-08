package lib;
import java.sql.*;
import java.util.Scanner;
import java.util.Properties;

public class BD {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement prestatement = null;
	private String user = "root"; //'usuario para conexion a la base de datos'
	private String password = "280792"; // Contraseña del usuario 
	private String db = "asegurados"; // base de datos a la cual se hara la conexion
	private ResultSet ultimoResultSet = null; // Guarda el ultimo resultado de la consulta sql 

	public BD()throws SQLException{
		 getConnection();
	}

	public BD(String username, String pass)throws SQLException{
		 user = username;
		 password = password;
		 getConnection();
	}

	public BD(String username, String pass, String dbname)throws SQLException{
		 user = username;
		 password = password;
		 db = dbname;
		 getConnection();
	}

	public void getConnection() throws SQLException {
		Properties propiedades = new Properties();
		propiedades.put("user", user );
		propiedades.put("password", password);

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db, propiedades);
	}

	public void BuscarAsegurado(String bus)throws SQLException {
		String query = "select * from asegurados where  CONCAT(nombre, ' ', apellido) like '%"+bus+"%'";
		//System.out.println(query);
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
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
			if (null != statement) {
				statement.close();
			}

			if (null != connection) {
				connection.close();
			}
		}
	}

	public void GuardarAsegurado(String nombre, String apellido, String num_social, Integer edad, char sexo)throws SQLException{
		String updateQuery = "insert into asegurados(nombre, apellido, edad, sexo, numero_seguro_social)"
		+ " values(?, ?, ?, ?, ?)";

		try {
			prestatement = connection.prepareStatement(updateQuery);
			prestatement.setString(1, nombre.toUpperCase());
			prestatement.setString(2, apellido.toUpperCase());
			prestatement.setInt(3, edad);
			prestatement.setString(4, String.valueOf(sexo).toUpperCase());
			prestatement.setString(5, num_social.toUpperCase());
			int filasInsertadas = prestatement.executeUpdate();
			System.out.println("Filas insertadas: " + filasInsertadas);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != prestatement) {
				prestatement.close();
			}

			if (null != connection) {
				connection.close();
			}
		}
	}

	public void ListarAsegurado(String bus)throws SQLException {
		System.out.println("Entro 2");
		String query = "select * from asegurados where  CONCAT(nombre, ' ', apellido) like '%"+bus+"%'";
		//System.out.println(query);
		try {
			statement = connection.createStatement();
			ultimoResultSet = statement.executeQuery(query);
			ResultSet resultSet = ultimoResultSet;
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
			if (null != statement) {
				statement.close();
			}
		}
	}

	public void EliminarAsegurado(String bus)throws SQLException{
		ListarAsegurado(bus);
		System.out.println("Ingrese el No. de asegurados que desea eliminar");
		int idAsegurado = new Scanner(System.in).nextInt();

		String updateQuery = "delete from asegurados where id = ?";

		try {
			System.out.println("Esta seguro que desea eliminar el registro(si/no):");
			String esCorrecta = new Scanner(System.in).nextLine();
			if("si".equals(esCorrecta)){
				prestatement = connection.prepareStatement(updateQuery);

				prestatement.setInt(1,idAsegurado );

				prestatement.executeUpdate();
			}else{
				System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != prestatement) {
				prestatement.close();
			}

			if (null != connection) {
				connection.close();
			}
		}
	}

	public void ActulizarAsegurado(String bus) throws SQLException{
		ListarAsegurado(bus);
		System.out.println("Ingrese el No. de asegurados que desea eliminar");
		int idAsegurado = new Scanner(System.in).nextInt();
		

		try {
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
				String updateQuery = "Update asegurados set "+campo+" = ? where id = ?";
				update_valor = new Scanner(System.in).nextLine();
				System.out.println("Esta seguro que desea Actulizar el registro el registro(si/no):");
				String esCorrecta = new Scanner(System.in).nextLine();
				if("si".equals(esCorrecta)){
					prestatement = connection.prepareStatement(updateQuery);

					prestatement.setString(1,update_valor.toUpperCase() );
					prestatement.setInt(2,idAsegurado);

					prestatement.executeUpdate();
				}else{
					System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != prestatement) {
				prestatement.close();
			}

			if (null != connection) {
				connection.close();
			}
		}
	}

}


