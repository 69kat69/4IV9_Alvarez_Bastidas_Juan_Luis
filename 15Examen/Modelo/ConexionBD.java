package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = 
            "jdbc:mysql://localhost:3306/hobby_basquet?serverTimezone=America/Mexico_City";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "Mn7kaq18lm.";
    
    public static Connection getConexion() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver no encontrado");
        }
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }   
    
    public static boolean probarConexion() throws Exception {
        try {
            Connection con = getConexion();
            System.out.println("Si se conecto");
            return con != null && !con.isClosed();
        } catch (SQLException e) {
            System.out.println("Error de conexion : " + e.getMessage());
            return false;
        }
    }
}
