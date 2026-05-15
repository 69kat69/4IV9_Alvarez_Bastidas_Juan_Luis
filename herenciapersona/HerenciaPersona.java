package herenciapersona;

import javax.swing.JOptionPane;

public class HerenciaPersona {
      public static void main(String[] args) {
        
        DAOEstudiante objmenu = new DAOEstudiante();
        DAOProfesor objProfesor = new DAOProfesor();
 
        String var = "si";
        while (var.equalsIgnoreCase("si")) {
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Bienvenido al sistema\n"
                    + "¿Con que deseas trabajar?\n"
                    + "1.- CRUD de Estudiantes\n"
                    + "2.- CRUD de Profesores\n"));
            
             switch (op) {
                case 1:
                    objmenu.menu();
                    break;
                case 2:
                    objProfesor.menu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
            var = JOptionPane.showInputDialog("¿Desea continuar en el sistema?");
            if (var == null) var = "no";
        } 
        JOptionPane.showMessageDialog(null, "Adios");
      }
    
}
