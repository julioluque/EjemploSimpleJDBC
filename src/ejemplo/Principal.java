package ejemplo;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Principal {

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/mibasededatosejemplo";
		String userName = "root";
		String password = "1234";
		Connection connection = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, userName, password);
			PreparedStatement commandoSQL = connection.prepareStatement("select idPersona, nombre, apellido from personas");
			ResultSet resultado = commandoSQL.executeQuery();
			while (resultado.next()) {
				System.out.println("Id: " + resultado.getLong("idPersona"));
				System.out.println("Nombre: " + resultado.getString("nombre"));
				System.out.println("Apellido " + resultado.getString("apellido"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
			}
		}
	}
}
