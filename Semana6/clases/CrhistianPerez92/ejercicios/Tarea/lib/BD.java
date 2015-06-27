/* lib develop by Crhistian Antonio Perez Arias */

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
	private ResultSet resultSet = null;
	
	public BD()throws SQLException{
		 getConnection();
	}

	public BD(String username, String pass, String dbname)throws SQLException{
		user = username;
		password = pass;
		db = dbname;
		getConnection();
	}

	public BD(String username, String pass)throws SQLException{
		user = username;
		password = pass;
		db = dbname;
		getConnection();
	}

	public void getConnection() throws SQLException {
		Properties propiedades = new Properties();
		propiedades.put("user", user );
		propiedades.put("password", password);

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db, propiedades);
	}

	public void CloseConection() throws SQLException{
		if (null != statement) {
			statement.close();
		}
		if (null != prestatement) {
			prestatement.close();
		}

		if (null != connection) {
			connection.close();
		}
	}

	public ResultSet SqlConsultas(String sql) throws SQLException{
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return resultSet;
	}

	public void SqlInsertRegistros(String sql, String[] values) throws SQLException{
		try {
			prestatement = connection.prepareStatement(sql);
			for(int x=0;x<values.length; x++){
				int posicion = x+1;
				String valor_mayu = String.valueOf(values[x]).toUpperCase();
				prestatement.setString(posicion, valor_mayu);
			}
			int filasInsertadas = prestatement.executeUpdate();
			System.out.println("Registros Ingresados: " + filasInsertadas);
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

	public void SqlUpdateRegistros(String sql, String[] values) throws SQLException{
		try {
			prestatement = connection.prepareStatement(sql);
			for(int x=0;x<values.length; x++){
				int posicion = x+1;
				String valor_mayu = String.valueOf(values[x]).toUpperCase();
				prestatement.setString(posicion, valor_mayu);
			}
			int filasInsertadas = prestatement.executeUpdate();
			System.out.println("Registros Actualizados: " + filasInsertadas);
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

	public void SqlDeleteRegistro(String sql, String value) throws SQLException{
		try {
			prestatement = connection.prepareStatement(sql);
			prestatement.setString(1, value);
			int filasInsertadas = prestatement.executeUpdate();
			System.out.println("Registros Eliminados: " + filasInsertadas);
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

	public int SqlInsertRegistrosWithId(String sql, String[] values) throws SQLException{
		int insert_id = 0;
		try {
			prestatement = connection.prepareStatement(sql);
			for(int x=0;x<values.length; x++){
				int posicion = x+1;
				String valor_mayu = String.valueOf(values[x]).toUpperCase();
				prestatement.setString(posicion, valor_mayu);
			}
			int filasInsertadas = prestatement.executeUpdate();
			System.out.println("Registros Ingresados: " + filasInsertadas);
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
		return insert_id;
	}
}