import java.sql.*;
import java.util.Properties;

public class BD {

	public static void main(String[] args) throws SQLException {
		BD bd = new BD();

		Connection connection = null;
		PreparedStatement statement = null;
		String updateQuery = "update asegurados set nombre = 'Jose Luis', apellido = 'Landero Noriega' where id = 1";

		try {
			connection = bd.getConnection();
			statement = connection.prepareStatement(updateQuery);

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

	public Connection getConnection() throws SQLException {
		Properties propiedades = new Properties();
		propiedades.put("user", "root");
		propiedades.put("password", "sinostea001pa");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/asegurados", propiedades);
	}

}