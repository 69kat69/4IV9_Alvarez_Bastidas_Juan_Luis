package Modelo;
 
public class Jugador {
 
    private int idJugador;
    private String nombre;
    private String posicion;
    private int numero;
    private String nacionalidad;
    private int alturaCm;
    private int pesoKg;
    private int idEquipo;
 
    public Jugador() {
        this.idJugador = 0;
        this.nombre = "";
        this.posicion = "";
        this.numero = 0;
        this.nacionalidad = "";
        this.alturaCm = 0;
        this.pesoKg = 0;
        this.idEquipo = 0;
    }
 
    public Jugador(int idJugador, String nombre, String posicion,
                   int numero, String nacionalidad, int alturaCm,
                   int pesoKg, int idEquipo) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.posicion = posicion;
        this.numero = numero;
        this.nacionalidad = nacionalidad;
        this.alturaCm = alturaCm;
        this.pesoKg = pesoKg;
        this.idEquipo = idEquipo;
    }
 
    public int getIdJugador() { return idJugador; }
    public void setIdJugador(int idJugador) { this.idJugador = idJugador; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    public int getAlturaCm() { return alturaCm; }
    public void setAlturaCm(int alturaCm) { this.alturaCm = alturaCm; }
    public int getPesoKg() { return pesoKg; }
    public void setPesoKg(int pesoKg) { this.pesoKg = pesoKg; }
    public int getIdEquipo() { return idEquipo; }
    public void setIdEquipo(int idEquipo) { this.idEquipo = idEquipo; }
 
    public String mostrarDetalle() {
        return String.format(
            "ID: %d | %s | %s | #%d | %s | %d cm | %d kg | Equipo ID: %d",
            idJugador, nombre, posicion, numero,
            nacionalidad, alturaCm, pesoKg, idEquipo);
    }
 
    @Override
    public String toString() { return mostrarDetalle(); }
}
 