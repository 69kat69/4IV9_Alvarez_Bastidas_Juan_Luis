package Controlador;
 
import Modelo.ConexionBD;
import Modelo.Equipo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
public class EquipoDAO {
 
    public void agregar(Equipo equipo) throws Exception {
        String sql = "INSERT INTO equipos (id_equipo, nombre, ciudad, entrenador, " +
                     "conferencia, campeonatos, fundacion, division) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
 
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setInt(1, equipo.getIdEquipo());
            ps.setString(2, equipo.getNombre());
            ps.setString(3, equipo.getCiudad());
            ps.setString(4, equipo.getEntrenador());
            ps.setString(5, equipo.getConferencia());
            ps.setInt(6, equipo.getCampeonatos());
            ps.setInt(7, equipo.getAnioFundacion());
            ps.setString(8, equipo.getDivision());
            ps.executeUpdate();
        }
    }
 
    public Equipo buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM equipos WHERE id_equipo = ?";
 
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return construirEquipo(rs);
                }
            }
        }
        return null;
    }
 
    public List<Equipo> listarTodos() throws Exception {
        List<Equipo> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipos";
 
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
 
            while (rs.next()) {
                lista.add(construirEquipo(rs));
            }
        }
        return lista;
    }
 
    public void actualizar(Equipo equipo) throws Exception {
        String sql = "UPDATE equipos SET nombre=?, ciudad=?, entrenador=?, " +
                     "conferencia=?, campeonatos=?, fundacion=?, division=? " +
                     "WHERE id_equipo=?";
 
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setString(1, equipo.getNombre());
            ps.setString(2, equipo.getCiudad());
            ps.setString(3, equipo.getEntrenador());
            ps.setString(4, equipo.getConferencia());
            ps.setInt(5, equipo.getCampeonatos());
            ps.setInt(6, equipo.getAnioFundacion());
            ps.setString(7, equipo.getDivision());
            ps.setInt(8, equipo.getIdEquipo());
            ps.executeUpdate();
        }
    }
 
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM equipos WHERE id_equipo = ?";
 
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
 
    private Equipo construirEquipo(ResultSet rs) throws SQLException {
        return new Equipo(
            rs.getInt("id_equipo"),
            rs.getString("nombre"),
            rs.getString("ciudad"),
            rs.getString("entrenador"),
            rs.getString("conferencia"),
            rs.getInt("campeonatos"),
            rs.getInt("fundacion"),
            rs.getString("division")
        );
    }
}
 