
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Ganado {

    // Atributos de la clase
    private int idGanado;
    private String codigo;
    private String raza;
    private int edad;
    private BigDecimal peso;
    private String sexo;
    private String estadoSalud;

    // Relaciones con otras clases
    private List<Produccion> producciones;
    private List<Vacunacion> vacunaciones;
    private List<Reproduccion> reproducciones;

    // Constructor
    public Ganado(int idGanado, String codigo, String raza,
                  int edad, BigDecimal peso, String sexo,
                  String estadoSalud) {

        this.idGanado = idGanado;
        this.codigo = codigo;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
        this.estadoSalud = estadoSalud;

        this.producciones = new ArrayList<>();
        this.vacunaciones = new ArrayList<>();
        this.reproducciones = new ArrayList<>();
    }

    // Métodos para consultar y modificar atributos
    public int getIdGanado() {
        return idGanado;
    }

    public void setIdGanado(int idGanado) {
        this.idGanado = idGanado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    // Métodos para gestionar las relaciones
    public void agregarProduccion(Produccion produccion) {
        producciones.add(produccion);
    }

    public void agregarVacunacion(Vacunacion vacunacion) {
        vacunaciones.add(vacunacion);
    }

    public void agregarReproduccion(Reproduccion reproduccion) {
        reproducciones.add(reproduccion);
    }

    public List<Produccion> getProducciones() {
        return producciones;
    }

    public List<Vacunacion> getVacunaciones() {
        return vacunaciones;
    }

    public List<Reproduccion> getReproducciones() {
        return reproducciones;
    }
}