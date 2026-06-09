package Vista;
 
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class BasquetVista extends JFrame {
 
    private JTable tablaBasquet;
    private DefaultTableModel modeloTabla;
    private JComboBox<String> cmbTabla;
 
    private JTextField txtIdEquipo, txtNombre, txtCiudad, txtEntrenador;
    private JTextField txtConferencia, txtCampeonatos, txtAnioFundacion, txtDivision;
 
    private JTextField txtIdJugador, txtNombreJugador, txtPosicion, txtNumero;
    private JTextField txtNacionalidad, txtAlturaCm, txtPesoKg, txtIdEquipoJugador;
 
    private JButton btnAgregar, btnActualizar, btnEliminar, btnBuscar, btnLimpiar;
 
    private JPanel panelCampos;
    private CardLayout cardLayout;
 
    public BasquetVista() {
        setTitle("Hobby Basquet — CRUD NBA");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }
 
    private void inicializarComponentes() {
        setLayout(new BorderLayout(10, 10));
 
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(23, 64, 139));
        JLabel lblTitulo = new JLabel("Sistema de Gestión — Hobby Basquetbol NBA");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);
 
        modeloTabla = new DefaultTableModel(new String[]{}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
 
        tablaBasquet = new JTable(modeloTabla);
        tablaBasquet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaBasquet.setRowHeight(25);
 
        JScrollPane scrollTabla = new JScrollPane(tablaBasquet);
        scrollTabla.setPreferredSize(new Dimension(950, 250));
        add(scrollTabla, BorderLayout.CENTER);
 
        JPanel panelInferior = new JPanel(new BorderLayout(5, 5));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panelInferior.add(crearPanelFormulario(), BorderLayout.CENTER);
        panelInferior.add(crearPanelBotones(), BorderLayout.SOUTH);
        add(panelInferior, BorderLayout.SOUTH);
    }
 
    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Datos"));
 
        JPanel panelSelector = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSelector.add(new JLabel("Ver tabla:"));
        cmbTabla = new JComboBox<>(new String[]{"EQUIPOS", "JUGADORES"});
        panelSelector.add(cmbTabla);
        panel.add(panelSelector, BorderLayout.NORTH);
 
        cardLayout = new CardLayout();
        panelCampos = new JPanel(cardLayout);
        panelCampos.setBorder(BorderFactory.createTitledBorder("Campos"));
 
        JPanel panelEquipo = new JPanel(new GridLayout(2, 8, 5, 5));
        panelEquipo.add(new JLabel("ID:"));
        txtIdEquipo = new JTextField();
        panelEquipo.add(txtIdEquipo);
        panelEquipo.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelEquipo.add(txtNombre);
        panelEquipo.add(new JLabel("Ciudad:"));
        txtCiudad = new JTextField();
        panelEquipo.add(txtCiudad);
        panelEquipo.add(new JLabel("Entrenador:"));
        txtEntrenador = new JTextField();
        panelEquipo.add(txtEntrenador);
        panelEquipo.add(new JLabel("Conferencia:"));
        txtConferencia = new JTextField();
        panelEquipo.add(txtConferencia);
        panelEquipo.add(new JLabel("Campeonatos:"));
        txtCampeonatos = new JTextField();
        panelEquipo.add(txtCampeonatos);
        panelEquipo.add(new JLabel("Año Fundacion:"));
        txtAnioFundacion = new JTextField();
        panelEquipo.add(txtAnioFundacion);
        panelEquipo.add(new JLabel("Division:"));
        txtDivision = new JTextField();
        panelEquipo.add(txtDivision);
        panelCampos.add(panelEquipo, "EQUIPOS");
 
        JPanel panelJugador = new JPanel(new GridLayout(2, 8, 5, 5));
        panelJugador.add(new JLabel("ID:"));
        txtIdJugador = new JTextField();
        panelJugador.add(txtIdJugador);
        panelJugador.add(new JLabel("Nombre:"));
        txtNombreJugador = new JTextField();
        panelJugador.add(txtNombreJugador);
        panelJugador.add(new JLabel("Posicion:"));
        txtPosicion = new JTextField();
        panelJugador.add(txtPosicion);
        panelJugador.add(new JLabel("Numero:"));
        txtNumero = new JTextField();
        panelJugador.add(txtNumero);
        panelJugador.add(new JLabel("Nacionalidad:"));
        txtNacionalidad = new JTextField();
        panelJugador.add(txtNacionalidad);
        panelJugador.add(new JLabel("Altura (cm):"));
        txtAlturaCm = new JTextField();
        panelJugador.add(txtAlturaCm);
        panelJugador.add(new JLabel("Peso (kg):"));
        txtPesoKg = new JTextField();
        panelJugador.add(txtPesoKg);
        panelJugador.add(new JLabel("ID Equipo:"));
        txtIdEquipoJugador = new JTextField();
        panelJugador.add(txtIdEquipoJugador);
        panelCampos.add(panelJugador, "JUGADORES");
 
        panel.add(panelCampos, BorderLayout.CENTER);
        return panel;
    }
 
    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
 
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar por ID");
        btnLimpiar = new JButton("Limpiar");
 
        Color colorBtn = new Color(23, 64, 139);
        Color colorEliminar = new Color(140, 20, 20);
 
        for (JButton btn : new JButton[]{btnAgregar, btnActualizar, btnBuscar, btnLimpiar}) {
            btn.setBackground(colorBtn);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setOpaque(true);
            btn.setBorderPainted(false);
        }
        btnEliminar.setBackground(colorEliminar);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setOpaque(true);
        btnEliminar.setBorderPainted(false);
 
        panel.add(btnAgregar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnBuscar);
        panel.add(btnLimpiar);
 
        return panel;
    }
 
    public JTable getTablaBasquet() { return tablaBasquet; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }
    public JComboBox<String> getCmbTabla() { return cmbTabla; }
    public CardLayout getCardLayout() { return cardLayout; }
    public JPanel getPanelCampos() { return panelCampos; }
 
    public JTextField getTxtIdEquipo() { return txtIdEquipo; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtCiudad() { return txtCiudad; }
    public JTextField getTxtEntrenador() { return txtEntrenador; }
    public JTextField getTxtConferencia() { return txtConferencia; }
    public JTextField getTxtCampeonatos() { return txtCampeonatos; }
    public JTextField getTxtAnioFundacion() { return txtAnioFundacion; }
    public JTextField getTxtDivision() { return txtDivision; }
 
    public JTextField getTxtIdJugador() { return txtIdJugador; }
    public JTextField getTxtNombreJugador() { return txtNombreJugador; }
    public JTextField getTxtPosicion() { return txtPosicion; }
    public JTextField getTxtNumero() { return txtNumero; }
    public JTextField getTxtNacionalidad() { return txtNacionalidad; }
    public JTextField getTxtAlturaCm() { return txtAlturaCm; }
    public JTextField getTxtPesoKg() { return txtPesoKg; }
    public JTextField getTxtIdEquipoJugador() { return txtIdEquipoJugador; }
 
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnActualizar() { return btnActualizar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnBuscar() { return btnBuscar; }
    public JButton getBtnLimpiar() { return btnLimpiar; }
 
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
 
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
 
    public boolean confirmar(String mensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje,
            "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
 
    public void limpiarFormulario() {
        txtIdEquipo.setText(""); txtNombre.setText("");
        txtCiudad.setText(""); txtEntrenador.setText("");
        txtConferencia.setText(""); txtCampeonatos.setText("");
        txtAnioFundacion.setText(""); txtDivision.setText("");
        txtIdJugador.setText(""); txtNombreJugador.setText("");
        txtPosicion.setText(""); txtNumero.setText("");
        txtNacionalidad.setText(""); txtAlturaCm.setText("");
        txtPesoKg.setText(""); txtIdEquipoJugador.setText("");
        tablaBasquet.clearSelection();
    }
}