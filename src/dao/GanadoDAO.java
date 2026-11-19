
package dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class GanadoDAO {

    // REGISTRAR GANADO
    public boolean registrar(String nombre, String raza, String sexo,
            String fechaNacimiento, double peso, String estado) {

        String sql = "INSERT INTO Ganado "
                + "(nombreAnimal, razaAnimal, sexoAnimal, fechaNacimiento, pesoAnimal, estadoAnimal) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, raza);
            ps.setString(3, sexo);
            ps.setDate(4, Date.valueOf(fechaNacimiento));
            ps.setDouble(5, peso);
            ps.setString(6, estado);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar ganado: " + e.getMessage());
            return false;
        }
    }

    // CONSULTAR GANADO
    public void consultar() {

        String sql = "SELECT * FROM Ganado";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("idAnimal")
                    + " | Nombre: " + rs.getString("nombreAnimal")
                    + " | Raza: " + rs.getString("razaAnimal")
                    + " | Sexo: " + rs.getString("sexoAnimal")
                    + " | Fecha nacimiento: " + rs.getDate("fechaNacimiento")
                    + " | Peso: " + rs.getBigDecimal("pesoAnimal")
                    + " | Estado: " + rs.getString("estadoAnimal")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar ganado: " + e.getMessage());
        }
    }

    // ACTUALIZAR GANADO
    public boolean actualizar(int id, String nombre, String raza,
            String sexo, String fechaNacimiento, double peso, String estado) {

        String sql = "UPDATE Ganado SET nombreAnimal=?, razaAnimal=?, "
                + "sexoAnimal=?, fechaNacimiento=?, pesoAnimal=?, estadoAnimal=? "
                + "WHERE idAnimal=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, raza);
            ps.setString(3, sexo);
            ps.setDate(4, Date.valueOf(fechaNacimiento));
            ps.setDouble(5, peso);
            ps.setString(6, estado);
            ps.setInt(7, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar ganado: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR GANADO
    public boolean eliminar(int id) {

        String sql = "DELETE FROM Ganado WHERE idAnimal=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar ganado: " + e.getMessage());
            return false;
        }
    }
}
