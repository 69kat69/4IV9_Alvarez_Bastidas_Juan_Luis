package nointernet;

import Controlador.BasquetControlador;
import Controlador.EquipoDAO;
import Controlador.JugadorDAO;
import Vista.BasquetVista;
import Modelo.ConexionBD;
import javax.swing.JOptionPane;

public class NoInternet {

    public static void main(String[] args) throws Exception {
        if (!ConexionBD.probarConexion()) {
            JOptionPane.showMessageDialog(
                null, "No se pudo conectar a la base de datos.");
            return;
        }

        EquipoDAO equipoDAO = new EquipoDAO();
        JugadorDAO jugadorDAO = new JugadorDAO();
        BasquetVista vista = new BasquetVista();

        new BasquetControlador(equipoDAO, jugadorDAO, vista);

        vista.setVisible(true);
    }
}
