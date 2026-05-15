package herenciapersona;

import javax.swing.JOptionPane;

public class DAOProfesor {
    
    Profesor obj[] = new Profesor[10];
    int x = 0;
    
    void menu() {
        String var = "si";
        String mensaje = "";
     while (var.equalsIgnoreCase("si")) {
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                 "Ingresa la opcion deseada : \n"
                    + "1.- Dar de alta a nuevo profesor \n"
                    + "2.- Mostrar los datos de los profesores \n"
                    + "3.- Buscar profesor \n"
                    + "4.- Editar profesor \n"
                    + "5.- Eliminar profesor \n"));
            switch (op) {
                case 1:
                    pedirProfesor();
                    break;
                case 2:
                    mostrarProfesor();
                    break;
                case 3:
                    buscarProfesor();
                    break;
                case 4:
                    editarProfesor();
                    break;
                case 5:
                    eliminarProfesor();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
             mensaje = JOptionPane.showInputDialog("¿Desea repetir el programa?");
            if (mensaje == null) mensaje = "no";
            var = mensaje;
        }
    }
      public void pedirProfesor() {
        int numEmpleado = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa el numero de empleado del profesor: "));
        String nom = JOptionPane.showInputDialog("Ingresa el nombre del profesor");
        int edad = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa la edad del profesor: "));
        char gen = JOptionPane.showInputDialog("Ingresa el genero del profesor").charAt(0);
        
        obj[x] = new Profesor(numEmpleado, nom, edad, gen);
        x++;
         }
    
    public void mostrarProfesor() {
        for (int i = 0; i < x; i++) {
            JOptionPane.showMessageDialog(null,
                    "El numero de empleado es: " + obj[i].getNumEmpleado() + "\n"
                    + "El nombre del profesor es: " + obj[i].getNombre() + "\n"
                    + "La edad del profesor es: " + obj[i].getEdad() + "\n"
                    + "El genero del profesor es: " + obj[i].getGenero() + "\n");
        }
         }
    
    public void buscarProfesor() {
        int numEmpleado = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa el numero del empleado: "));
        
        for (int i = 0; i < x; i++) {
            if (obj[i].getNumEmpleado() == numEmpleado) {
                JOptionPane.showMessageDialog(null,
                        "Numero de empleado: " + obj[i].getNumEmpleado() + "\n"
                        + "Nombre: " + obj[i].getNombre() + "\n"
                        + "Edad: " + obj[i].getEdad() + "\n"
                        + "Genero: " + obj[i].getGenero());
                return;
            }
             }
        JOptionPane.showMessageDialog(null, "Profesor no encontrado");
    }
    
    public void editarProfesor() {
        int numEmpleado = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa el numero de empleado del profesor a editar: "));
        
        for (int i = 0; i < x; i++) {
            if (obj[i].getNumEmpleado() == numEmpleado) {
                obj[i].setNombre(
                        JOptionPane.showInputDialog("Ingresa el nuevo nombre: "));
                obj[i].setEdad(Integer.parseInt(
                        JOptionPane.showInputDialog("Ingresa la nueva edad:")));
                obj[i].setGenero(
                        JOptionPane.showInputDialog("Ingresa el nuevo genero:").charAt(0));
                JOptionPane.showMessageDialog(null, "Datos cambiados");
                return;
            }
             }
        JOptionPane.showMessageDialog(null, "Profesor no encontrado");
    }
    
    public void eliminarProfesor() {
        int numEmpleado = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa el numero de profesor a eliminar: "));
        
        for (int i = 0; i < x; i++) {
            if (obj[i].getNumEmpleado() == numEmpleado) {
                for (int j = i; j < x - 1; j++) {
                    obj[j] = obj[j + 1];
                }
                obj[x - 1] = null;
                x--;
                JOptionPane.showMessageDialog(null, "Profesor eliminado");
                return;
            }
              }
        JOptionPane.showMessageDialog(null, "Profesor no encontrado");
    }
}
