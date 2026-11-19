package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/GanaderiaArrayan";

    private static final String USUARIO = "root";
    private static final String CONTRASENA = "123456";

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(
                    URL, USUARIO, CONTRASENA
            );

            System.out.println("Conexión a MySQL exitosa.");
            return conexion;

        } catch (SQLException e) {
            System.out.println("Error al conectar con MySQL: " + e.getMessage());
            return null;
        }
    }
}
