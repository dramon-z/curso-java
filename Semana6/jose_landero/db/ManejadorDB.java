package db;

import java.sql.*;
import java.util.*;

public class ManejadorDB {

	public void buscarAsegurado(String busqueda) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		String query = "select * from asegurados where nombre = '" + busqueda + "'";

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

				System.out.println("Nombre del Asegurado: " + nombre + " " + apellido);
				System.out.println("Edad: " + edad);
				System.out.println("Sexo: " + sexo);
				System.out.println("Numero de Seguro Social: " + numeroSeguroSocial);
			}

			System.out.println("");
			System.out.print("Presione enter para continuar...");
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

	public Map<String, Object> obtenerAsegurado(String busqueda) throws SQLException {
		Map<String, Object> asegurado = new HashMap<String, Object>();

		Connection connection = null;
		Statement statement = null;
		String query = "select * from asegurados where nombre = '" + busqueda + "'";

		try {
			connection = getConnection();

			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				asegurado.put("nombre", resultSet.getString("nombre"));
				asegurado.put("apellido", resultSet.getString("apellido"));
				asegurado.put("edad", resultSet.getInt("edad"));
				asegurado.put("sexo", resultSet.getString("sexo"));
				asegurado.put("numeroSeguroSocial", resultSet.getString("numero_seguro_social"));
				asegurado.put("id", resultSet.getInt("id"));
				break;
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

		return asegurado;
	}

	public void guardarAsegurado(String nombre, String apellido, int edad, String sexo, String numeroSeguroSocial) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		String updateQuery = "insert into asegurados(nombre, apellido, edad, sexo, numero_seguro_social)"
		+ " values(?, ?, ?, ?, ?)";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(updateQuery);

			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setInt(3, edad);
			statement.setString(4, sexo);
			statement.setString(5, numeroSeguroSocial);

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

	public void actualizarAsegurado(int id, String nombre, String apellido, int edad, String sexo, String numeroSeguroSocial) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		String updateQuery = "update asegurados set nombre = ?, apellido = ?, edad = ?, sexo = ?, "
		+"numero_seguro_social = ? where id = ?";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(updateQuery);

			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setInt(3, edad);
			statement.setString(4, sexo);
			statement.setString(5, numeroSeguroSocial);
			statement.setInt(6, id);

			statement.executeUpdate();
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

	public int obtenerIdAsegurado(String nombre) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		String query = "select id from asegurados where nombre = '" + nombre + "'";
		int id = 0;

		try {
			connection = getConnection();

			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				id = resultSet.getInt("id");
				break;
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

		return id;
	}

	public void eliminarAsegurado(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		String updateQuery = "delete from asegurados where id = ?";

		try {
			connection = getConnection();
			statement = connection.prepareStatement(updateQuery);

			statement.setInt(1, id);

			statement.executeUpdate();

			System.out.println("El asegurado se ha eliminado con exito");
			System.out.println("");
			System.out.print("Presione enter para continuar...");
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
		propiedades.put("password", "admin");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/asegurados", propiedades);
	}

}