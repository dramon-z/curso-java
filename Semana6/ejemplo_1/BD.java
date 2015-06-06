import java.sql.*;

import java.util.Properties;

public class BD {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//Class.forName("com.mysql.jdbc.Driver");

		Properties propiedades = new Properties();
		propiedades.put("user", "root");
		propiedades.put("password", "admin");

		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asegurados", propiedades);
		System.out.println("Conexion a la base de datos establecida");
	}

}