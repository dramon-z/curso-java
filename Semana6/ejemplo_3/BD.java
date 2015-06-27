import java.sql.*;
import java.util.Properties;

public class BD {

	public static void main(String[] args) throws SQLException {
		BD bd = new BD();

		Connection connection = null;
		Statement statement = null;
		String query = "select * from asegurados";

		try {
			connection = bd.getConnection();

			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				resultSet.updateString("nombre", "Jose Luis");
				resultSet.updateString("apellido", "Landero Noriega");

				resultSet.updateRow();
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
		propiedades.put("password", "admin");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/asegurados", propiedades);
	}

}