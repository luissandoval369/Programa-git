
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Ganado ganado = new Ganado(
            1, "GA001", "Holstein", 4,
            new BigDecimal("450.50"), "Hembra", "Saludable"
        );

        Empleado empleado = new Empleado(
            1, "Carlos Pérez", "Operario", "3001234567"
        );

        Produccion produccion = new Produccion(
            1, LocalDate.now(),
            new BigDecimal("15.5"), ganado, empleado
        );

        ganado.agregarProduccion(produccion);

        System.out.println("Sistema Ganadería Arrayán");
        System.out.println("Código del ganado: " + ganado.getCodigo());
        System.out.println("Raza: " + ganado.getRaza());
        System.out.println("Sistema ejecutado correctamente.");
    }
}

