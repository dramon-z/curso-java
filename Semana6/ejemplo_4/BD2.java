import java.sql.*;
import java.util.Properties;

public class BD2 {

	public static void main(String[] args) throws SQLException {
		BD2 bd = new BD2();

		Connection connection = null;
		PreparedStatement statement = null;
		String updateQuery = "insert into asegurados(nombre, apellido, edad, sexo, numero_seguro_social)"
		+ " values(?, ?, ?, ?, ?)";

		try {
			connection = bd.getConnection();
			statement = connection.prepareStatement(updateQuery);

			statement.setString(1, "Jose Salomon");
			statement.setString(2, "Seoane Garcia");
			statement.setInt(3, 32);
			statement.setString(4, "M");
			statement.setString(5, "00293102391");

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