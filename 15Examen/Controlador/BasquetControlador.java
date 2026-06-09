package Controlador;
 
import Modelo.Equipo;
import Modelo.Jugador;
import Vista.BasquetVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
 
public class BasquetControlador {
 
    private EquipoDAO equipoDAO;
    private JugadorDAO jugadorDAO;
    private BasquetVista vista;
 
    public BasquetControlador(EquipoDAO equipoDAO, JugadorDAO jugadorDAO, BasquetVista vista) {
        this.equipoDAO = equipoDAO;
        this.jugadorDAO = jugadorDAO;
        this.vista = vista;
 
        inicializarEventos();
        cargarTabla();
    }
 
    private void inicializarEventos() {
        vista.getBtnAgregar().addActionListener(e -> agregar());
        vista.getBtnActualizar().addActionListener(e -> actualizar());
        vista.getBtnEliminar().addActionListener(e -> eliminar());
        vista.getBtnBuscar().addActionListener(e -> buscar());
        vista.getBtnLimpiar().addActionListener(e -> vista.limpiarFormulario());
 
        vista.getCmbTabla().addActionListener(e -> {
            vista.getCardLayout().show(vista.getPanelCampos(), tablaActual());
            cargarTabla();
        });
 
        vista.getTablaBasquet().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarSeleccionado();
            }
        });
    }
 
    private String tablaActual() {
        return (String) vista.getCmbTabla().getSelectedItem();
    }
 
    private void agregar() {
        try {
            if (tablaActual().equals("EQUIPOS")) {
                Equipo eq = construirEquipo();
                if (eq == null) return;
                equipoDAO.agregar(eq);
            } else {
                Jugador jug = construirJugador();
                if (jug == null) return;
                jugadorDAO.agregar(jug);
            }
            cargarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Registro agregado exitosamente.");
        } catch (NumberFormatException ex) {
            vista.mostrarError("Verifique que los campos numericos sean validos.");
        } catch (Exception ex) {
            vista.mostrarError("Error al agregar: " + ex.getMessage());
        }
    }
 
    private void actualizar() {
        try {
            if (tablaActual().equals("EQUIPOS")) {
                Equipo eq = construirEquipo();
                if (eq == null) return;
                equipoDAO.actualizar(eq);
            } else {
                Jugador jug = construirJugador();
                if (jug == null) return;
                jugadorDAO.actualizar(jug);
            }
            cargarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Registro actualizado exitosamente.");
        } catch (NumberFormatException ex) {
            vista.mostrarError("Verifique que los campos numericos sean validos.");
        } catch (Exception ex) {
            vista.mostrarError("Error al actualizar: " + ex.getMessage());
        }
    }
 
    private void eliminar() {
        try {
            if (tablaActual().equals("EQUIPOS")) {
                String idStr = vista.getTxtIdEquipo().getText().trim();
                if (idStr.isEmpty()) {
                    vista.mostrarError("Ingrese el ID del equipo a eliminar.");
                    return;
                }
                int id = Integer.parseInt(idStr);
                if (vista.confirmar("¿Eliminar equipo con ID " + id + "?")) {
                    equipoDAO.eliminar(id);
                }
            } else {
                String idStr = vista.getTxtIdJugador().getText().trim();
                if (idStr.isEmpty()) {
                    vista.mostrarError("Ingrese el ID del jugador a eliminar.");
                    return;
                }
                int id = Integer.parseInt(idStr);
                if (vista.confirmar("¿Eliminar jugador con ID " + id + "?")) {
                    jugadorDAO.eliminar(id);
                }
            }
            cargarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Registro eliminado.");
        } catch (Exception ex) {
            vista.mostrarError("Error al eliminar: " + ex.getMessage());
        }
    }
 
    private void buscar() {
        try {
            if (tablaActual().equals("EQUIPOS")) {
                String idStr = vista.getTxtIdEquipo().getText().trim();
                if (idStr.isEmpty()) {
                    vista.mostrarError("Ingrese el ID del equipo a buscar.");
                    return;
                }
                Equipo eq = equipoDAO.buscarPorId(Integer.parseInt(idStr));
                if (eq != null) {
                    cargarEquipoEnFormulario(eq);
                    vista.mostrarMensaje("Equipo encontrado:\n" + eq.mostrarDetalle());
                } else {
                    vista.mostrarError("No se encontro equipo con ese ID.");
                }
            } else {
                String idStr = vista.getTxtIdJugador().getText().trim();
                if (idStr.isEmpty()) {
                    vista.mostrarError("Ingrese el ID del jugador a buscar.");
                    return;
                }
                Jugador jug = jugadorDAO.buscarPorId(Integer.parseInt(idStr));
                if (jug != null) {
                    cargarJugadorEnFormulario(jug);
                    vista.mostrarMensaje("Jugador encontrado:\n" + jug.mostrarDetalle());
                } else {
                    vista.mostrarError("No se encontro jugador con ese ID.");
                }
            }
        } catch (Exception ex) {
            vista.mostrarError("Error al buscar: " + ex.getMessage());
        }
    }
 
    private void cargarTabla() {
        DefaultTableModel modelo = vista.getModeloTabla();
        modelo.setRowCount(0);
 
        try {
            if (tablaActual().equals("EQUIPOS")) {
                modelo.setColumnIdentifiers(new String[]{
                    "ID", "Nombre", "Ciudad", "Entrenador",
                    "Conferencia", "Campeonatos", "Año Fund.", "Division"
                });
                List<Equipo> lista = equipoDAO.listarTodos();
                for (Equipo eq : lista) {
                    modelo.addRow(new Object[]{
                        eq.getIdEquipo(), eq.getNombre(), eq.getCiudad(),
                        eq.getEntrenador(), eq.getConferencia(),
                        eq.getCampeonatos(), eq.getAnioFundacion(), eq.getDivision()
                    });
                }
            } else {
                modelo.setColumnIdentifiers(new String[]{
                    "ID", "Nombre", "Posicion", "Numero",
                    "Nacionalidad", "Altura (cm)", "Peso (kg)", "ID Equipo"
                });
                List<Jugador> lista = jugadorDAO.listarTodos();
                for (Jugador jug : lista) {
                    modelo.addRow(new Object[]{
                        jug.getIdJugador(), jug.getNombre(), jug.getPosicion(),
                        jug.getNumero(), jug.getNacionalidad(),
                        jug.getAlturaCm(), jug.getPesoKg(), jug.getIdEquipo()
                    });
                }
            }
        } catch (Exception ex) {
            vista.mostrarError("Error al cargar tabla: " + ex.getMessage());
        }
    }
 
    private void cargarSeleccionado() {
        int fila = vista.getTablaBasquet().getSelectedRow();
        if (fila < 0) return;
 
        try {
            int id = (int) vista.getModeloTabla().getValueAt(fila, 0);
            if (tablaActual().equals("EQUIPOS")) {
                Equipo eq = equipoDAO.buscarPorId(id);
                if (eq != null) cargarEquipoEnFormulario(eq);
            } else {
                Jugador jug = jugadorDAO.buscarPorId(id);
                if (jug != null) cargarJugadorEnFormulario(jug);
            }
        } catch (Exception ex) {
            vista.mostrarError("Error al cargar registro: " + ex.getMessage());
        }
    }
 
    private void cargarEquipoEnFormulario(Equipo eq) {
        vista.getTxtIdEquipo().setText(String.valueOf(eq.getIdEquipo()));
        vista.getTxtNombre().setText(eq.getNombre());
        vista.getTxtCiudad().setText(eq.getCiudad());
        vista.getTxtEntrenador().setText(eq.getEntrenador());
        vista.getTxtConferencia().setText(eq.getConferencia());
        vista.getTxtCampeonatos().setText(String.valueOf(eq.getCampeonatos()));
        vista.getTxtAnioFundacion().setText(String.valueOf(eq.getAnioFundacion()));
        vista.getTxtDivision().setText(eq.getDivision());
    }
 
    private void cargarJugadorEnFormulario(Jugador jug) {
        vista.getTxtIdJugador().setText(String.valueOf(jug.getIdJugador()));
        vista.getTxtNombreJugador().setText(jug.getNombre());
        vista.getTxtPosicion().setText(jug.getPosicion());
        vista.getTxtNumero().setText(String.valueOf(jug.getNumero()));
        vista.getTxtNacionalidad().setText(jug.getNacionalidad());
        vista.getTxtAlturaCm().setText(String.valueOf(jug.getAlturaCm()));
        vista.getTxtPesoKg().setText(String.valueOf(jug.getPesoKg()));
        vista.getTxtIdEquipoJugador().setText(String.valueOf(jug.getIdEquipo()));
    }
 
    private Equipo construirEquipo() {
        if (vista.getTxtIdEquipo().getText().trim().isEmpty() ||
            vista.getTxtNombre().getText().trim().isEmpty()) {
            vista.mostrarError("ID y Nombre son obligatorios.");
            return null;
        }
        return new Equipo(
            Integer.parseInt(vista.getTxtIdEquipo().getText().trim()),
            vista.getTxtNombre().getText().trim(),
            vista.getTxtCiudad().getText().trim(),
            vista.getTxtEntrenador().getText().trim(),
            vista.getTxtConferencia().getText().trim(),
            Integer.parseInt(vista.getTxtCampeonatos().getText().trim()),
            Integer.parseInt(vista.getTxtAnioFundacion().getText().trim()),
            vista.getTxtDivision().getText().trim()
        );
    }
 
    private Jugador construirJugador() {
        if (vista.getTxtIdJugador().getText().trim().isEmpty() ||
            vista.getTxtNombreJugador().getText().trim().isEmpty()) {
            vista.mostrarError("ID y Nombre son obligatorios.");
            return null;
        }
        return new Jugador(
            Integer.parseInt(vista.getTxtIdJugador().getText().trim()),
            vista.getTxtNombreJugador().getText().trim(),
            vista.getTxtPosicion().getText().trim(),
            Integer.parseInt(vista.getTxtNumero().getText().trim()),
            vista.getTxtNacionalidad().getText().trim(),
            Integer.parseInt(vista.getTxtAlturaCm().getText().trim()),
            Integer.parseInt(vista.getTxtPesoKg().getText().trim()),
            Integer.parseInt(vista.getTxtIdEquipoJugador().getText().trim())
        );
    }
}
 