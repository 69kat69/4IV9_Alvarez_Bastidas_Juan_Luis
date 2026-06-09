package Modelo;
 
public class Equipo {
 
    private int idEquipo;
    private String nombre;
    private String ciudad;
    private String entrenador;
    private String conferencia;
    private int campeonatos;
    private int fundacion;
    private String division;
 
    public Equipo() {
        this.idEquipo = 0;
        this.nombre = "";
        this.ciudad = "";
        this.entrenador = "";
        this.conferencia = "";
        this.campeonatos = 0;
        this.fundacion = 0;
        this.division = "";
    }
 
    public Equipo(int idEquipo, String nombre, String ciudad,
                  String entrenador, String conferencia,
                  int campeonatos, int fundacion, String division) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.entrenador = entrenador;
        this.conferencia = conferencia;
        this.campeonatos = campeonatos;
        this.fundacion = fundacion;
        this.division = division;
    }
 
    public int getIdEquipo() { return idEquipo; }
    public void setIdEquipo(int idEquipo) { this.idEquipo = idEquipo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getEntrenador() { return entrenador; }
    public void setEntrenador(String entrenador) { this.entrenador = entrenador; }
    public String getConferencia() { return conferencia; }
    public void setConferencia(String conferencia) { this.conferencia = conferencia; }
    public int getCampeonatos() { return campeonatos; }
    public void setCampeonatos(int campeonatos) { this.campeonatos = campeonatos; }
    public int getAnioFundacion() { return fundacion; }
    public void setAnioFundacion(int fundacion) { this.fundacion = fundacion; }
    public String getDivision() { return division; }
    public void setDivision(String division) { this.division = division; }
 
    public String mostrarDetalle() {
        return String.format(
            "ID: %d | %s | %s | Entrenador: %s | Conf: %s | Campeonatos: %d | Fundado: %d | %s",
            idEquipo, nombre, ciudad, entrenador,
            conferencia, campeonatos, fundacion, division);
    }
 
    @Override
    public String toString() { return mostrarDetalle(); }
}