import java.sql.*;
import java.util.Properties;

public class BD {

	public static void main(String[] args) throws SQLException {
		BD bd = new BD();

		Connection connection = null;
		PreparedStatement statement = null;
		String updateQuery = "insert into asegurados(nombre, apellido, edad, sexo, numero_seguro_social)"
		+ " values('Jose Salomon', 'Seone Garcia', 32, 'M', '12300021')";

		try {
			connection = bd.getConnection();
			statement = connection.prepareStatement(updateQuery);

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

	public Connection getConnection() throws SQLException {
		Properties propiedades = new Properties();
		propiedades.put("user", "root");
		propiedades.put("password", "admin");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/asegurados", propiedades);
	}

}