package Controlador;

import Modelo.ConexionBD;
import Modelo.Jugador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {

    public void agregar(Jugador jugador) throws Exception {
        String sql = "INSERT INTO jugadores (id_jugador, nombre, posicion, numero, " +
                     "nacionalidad, altura_cm, peso_kg, id_equipo) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, jugador.getIdJugador());
            ps.setString(2, jugador.getNombre());
            ps.setString(3, jugador.getPosicion());
            ps.setInt(4, jugador.getNumero());
            ps.setString(5, jugador.getNacionalidad());
            ps.setInt(6, jugador.getAlturaCm());
            ps.setInt(7, jugador.getPesoKg());
            ps.setInt(8, jugador.getIdEquipo());
            ps.executeUpdate();
        }
    }

    public Jugador buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM jugadores WHERE id_jugador = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return construirJugador(rs);
                }
            }
        }
        return null;
    }

    public List<Jugador> listarTodos() throws Exception {
        List<Jugador> lista = new ArrayList<>();
        String sql = "SELECT * FROM jugadores";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(construirJugador(rs));
            }
        }
        return lista;
    }

    public void actualizar(Jugador jugador) throws Exception {
        String sql = "UPDATE jugadores SET nombre=?, posicion=?, numero=?, " +
                     "nacionalidad=?, altura_cm=?, peso_kg=?, id_equipo=? " +
                     "WHERE id_jugador=?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, jugador.getNombre());
            ps.setString(2, jugador.getPosicion());
            ps.setInt(3, jugador.getNumero());
            ps.setString(4, jugador.getNacionalidad());
            ps.setInt(5, jugador.getAlturaCm());
            ps.setInt(6, jugador.getPesoKg());
            ps.setInt(7, jugador.getIdEquipo());
            ps.setInt(8, jugador.getIdJugador());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM jugadores WHERE id_jugador = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Jugador construirJugador(ResultSet rs) throws SQLException {
        return new Jugador(
            rs.getInt("id_jugador"),
            rs.getString("nombre"),
            rs.getString("posicion"),
            rs.getInt("numero"),
            rs.getString("nacionalidad"),
            rs.getInt("altura_cm"),
            rs.getInt("peso_kg"),
            rs.getInt("id_equipo")
        );
    }
}