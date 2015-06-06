import java.sql.*;
import java.util.Properties;

public class BD2 {

	public static void main(String[] args) throws SQLException {
		BD2 bd = new BD2();

		Connection connection = null;
		PreparedStatement statement = null;
		String updateQuery = "update asegurados set nombre = ?, apellido = ? where id = ?";

		try {
			connection = bd.getConnection();
			statement = connection.prepareStatement(updateQuery);

			statement.setString(1, "Jose Luis");
			statement.setString(2, "Landero Noriega");
			statement.setInt(3, 1);

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
		propiedades.put("password", "admin");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/asegurados", propiedades);
	}

}