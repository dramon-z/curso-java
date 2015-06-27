package seguro;
import java.util.Scanner;
import java.sql.*;
import java.util.Properties;

public class BD {
	public BD(int opcion){
		switch(opcion){
			case 1:
				try{
						agregar_asegurado();
				}catch (Exception e) {
						e.printStackTrace();
				}
				break;
			case 2:
				try{
						consulta_sql();
				}catch (Exception e) {
						e.printStackTrace();
				}			
				break;
			case 3:
				try{
						eliminar_asegurado();
				}catch (Exception e) {
						e.printStackTrace();
				}			
				break;		
		}
	}		

	public void eliminar_asegurado() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa el Nombre: ");
		String nom = scanner.next();
		Connection connection = null;
		Statement statement = null;
		String query = "select * from asegurados where nombre like'"+nom+"%'";

		try {
			connection = getConnection();
//Variables de la busqueda
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

//Variables de borrar
			PreparedStatement statement2 = null;
			String updateQuery = "delete from asegurados where id = ?";

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				int edad = resultSet.getInt("edad");
				String sexo = resultSet.getString("sexo");
				String numeroSeguroSocial = resultSet.getString("numero_seguro_social");

				System.out.println("Nombre del Asegurado: " + nombre + " " + apellido);
				System.out.println("Edad: " + edad);
				System.out.println("Sexo: " + sexo);
				System.out.println("Numero de Seguro Social: " + numeroSeguroSocial);
				System.out.println("Esta seguro que desea eliminar este beneficiario? 1. Si, 2. No");
				int op = scanner.nextInt();
				if(op==1){
					

					try {
						connection = getConnection();
						statement2 = connection.prepareStatement(updateQuery);

						statement2.setInt(1, id);
						statement2.executeUpdate();

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (null != statement) {
							statement2.close();
						}
					}
					System.out.println("Se ha eliminado 1 fila.");
					
				}
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
	
	public void agregar_asegurado() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa el Nombre: ");
		String nombre = scanner.next();
		System.out.print("Ingresa el Apellido: ");
		String apellido = scanner.next();
		System.out.print("Ingresa la Edad: ");
		String edad = scanner.next();
		System.out.print("Ingresa el Sexo(M,F): ");
		String sexo = scanner.next();
		System.out.print("Ingresa el Numero de Seguridad Social: ");
		String numero = scanner.next();
		
		System.out.println("\nNombre\tApellido\tEdad\tSexo\t");
		System.out.println(nombre+"\t"+apellido+"\t"+edad+"\t"+sexo+"\t"+numero);
		System.out.println("\nEsta seguro que desea agregar el beneficiario? 1. Si     2. No");
		int op = scanner.nextInt();
		if(op==1){

			Connection connection = null;
			PreparedStatement statement = null;
			String updateQuery = "insert into asegurados(nombre, apellido, edad, sexo, numero_seguro_social)"
			+ " values(?, ?, ?, ?, ?)";

			try {
				connection = getConnection();
				statement = connection.prepareStatement(updateQuery);

				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setString(3, edad);
				statement.setString(4, sexo);
				statement.setString(5, numero);

				int filasInsertadas = statement.executeUpdate();

				System.out.println("Filas insertadas: " + filasInsertadas);
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
	}
	



	public void consulta_sql() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa el Nombre: ");
		String nom = scanner.next();
		Connection connection = null;
		Statement statement = null;
		String query = "select * from asegurados where nombre like'"+nom+"%'";

		try {
			connection = getConnection();

			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				int edad = resultSet.getInt("edad");
				String sexo = resultSet.getString("sexo");
				String numeroSeguroSocial = resultSet.getString("numero_seguro_social");

				System.out.println("\n\n\nNombre del Asegurado: " + nombre + " " + apellido);
				System.out.println("Edad: " + edad);
				System.out.println("Sexo: " + sexo);
				System.out.println("Numero de Seguro Social: " + numeroSeguroSocial);
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

	public Connection getConnection() throws SQLException {
		Properties propiedades = new Properties();
		propiedades.put("user", "root");
		propiedades.put("password", "root");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/asegurados", propiedades);
	}
}
