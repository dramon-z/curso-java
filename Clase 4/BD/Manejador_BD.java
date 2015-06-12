package BD;

import java.sql.*;
import java.util.Properties;

	public class Manejador_BD{

		public void BusquedaAsegurado(String[] args) throws SQLException {
		Manejador_BD bd = new Manejador_BD();
		

		Connection connection = null;
		Statement statement = null;
		String query = "select * from asegurados where nombre= '";

		try {
			connection = bd.getConnection();

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
		
	

	/*	public Connection getConnection() throws SQLException {
			Properties propiedades = new Properties();
			propiedades.put("user", "root");
			propiedades.put("password", "sinostea001pa");

			return DriverManager.getConnection("jdbc:mysql://localhost:3306/asegurados", propiedades);
		}
	*/

	


