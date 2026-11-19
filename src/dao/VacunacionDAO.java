
package dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class VacunacionDAO {

    // REGISTRAR VACUNACION
    public boolean registrar(int idAnimal, int idVeterinario,
            String tipoVacuna, String fechaVacunacion, String observacion) {

        String sql = "INSERT INTO Vacunacion "
                + "(idAnimal, idVeterinario, tipoVacuna, fechaVacunacion, observacion) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idAnimal);
            ps.setInt(2, idVeterinario);
            ps.setString(3, tipoVacuna);
            ps.setDate(4, Date.valueOf(fechaVacunacion));
            ps.setString(5, observacion);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar vacunación: " + e.getMessage());
            return false;
        }
    }

    // CONSULTAR VACUNACIONES
    public void consultar() {

        String sql = "SELECT * FROM Vacunacion";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                    "ID vacunación: " + rs.getInt("idVacunacion")
                    + " | ID animal: " + rs.getInt("idAnimal")
                    + " | ID veterinario: " + rs.getInt("idVeterinario")
                    + " | Vacuna: " + rs.getString("tipoVacuna")
                    + " | Fecha: " + rs.getDate("fechaVacunacion")
                    + " | Observación: " + rs.getString("observacion")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar vacunaciones: " + e.getMessage());
        }
    }

    // ACTUALIZAR VACUNACION
    public boolean actualizar(int id, int idAnimal, int idVeterinario,
            String tipoVacuna, String fechaVacunacion, String observacion) {

        String sql = "UPDATE Vacunacion SET idAnimal=?, idVeterinario=?, "
                + "tipoVacuna=?, fechaVacunacion=?, observacion=? "
                + "WHERE idVacunacion=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idAnimal);
            ps.setInt(2, idVeterinario);
            ps.setString(3, tipoVacuna);
            ps.setDate(4, Date.valueOf(fechaVacunacion));
            ps.setString(5, observacion);
            ps.setInt(6, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar vacunación: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR VACUNACION
    public boolean eliminar(int id) {

        String sql = "DELETE FROM Vacunacion WHERE idVacunacion=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar vacunación: " + e.getMessage());
            return false;
        }
    }
}
