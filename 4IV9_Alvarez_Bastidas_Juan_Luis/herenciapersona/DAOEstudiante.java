/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herenciapersona;

/**
 *
 * @author demon
 */

import javax.swing.JOptionPane;

public class DAOEstudiante {
    
    //vamos a crear un programa para dar de alta 10 estudiantes
    
    //un objeto por parte de estudiante
    Estudiante obj[] = new Estudiante[10];
    int x = 0;
    
    //metodo del menu para el programa
    void menu(){
        String continuar = "si";
        
        while(continuar.equalsIgnoreCase("si")){
            
          String opciones = "Selecciona una operacion:\n"
                    + "1.- Dar de alta a nuevo estudiante. \n"
                    + "2.- Mostrar los datos de todos los estudiantes \n"
                    + "3.- Buscar estudiante por boleta \n"
                    + "4.- Modificar datos de estudiante \n"
                    + "5.- Dar de baja a estudiante";
                
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(opciones));
            
            switch (opcion) {
                case 1:
                    //metodo para registrar
                    pedirEstudiante();                    
                    
                    break;
                case 2:
                    //mostrar estudiantes
                    mostrarEstudiante();

                    break;
                case 3: 
                    buscarPorBoleta();

                    break;
                case 4: 
                    modificarEstudiante();
                    break;

                case 5: 

                    DardeBaja();

                    break;
                default:
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida intente de nuevo");
            }
            continuar = JOptionPane.showInputDialog("¿Desea repetir el programa?");
        }
    }

    public void pedirEstudiante() {
        
        int numboleta = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingresa la boleta del estudiante: "));
        String nom = JOptionPane.showInputDialog(
                "Ingresa el nombre del estudiante");
        int edad = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingresa la edad del estudiante: "));
        char gen = JOptionPane.showInputDialog(
                "Ingresa el genero del estudiante").charAt(0);
        
        obj[x] = new Estudiante(numboleta, nom, edad, gen);
        x++;
        
        
    }

    public void mostrarEstudiante() {
        //necesitamos recorrer el arreglo del tamaño que sea
        
        for(int i = 0; i < x; i++){
            //visualizar los datos
            JOptionPane.showMessageDialog(null, 
                    "La boleta del estudiante es: " + obj[i].getNumBoleta() + "\n"
                    +"El nombre del estudiante es: " + obj[i].getNombre()+ "\n"
                   +"La edad del estudiante es: " + obj[i].getEdad() + "\n"
                   +"El genero del estudiante es: " + obj[i].getGenero()+ "\n");
        }
    }

    public void buscarEstudiante() {

        int boleta = Integer.parseInt(
            JOptionPane.showInputDialog("Ingresa la boleta del estudiante a buscar:"));

          for (int i = 0; i < x; i++) {
              if (obj[i].getNumBoleta() == boleta) {
                  JOptionPane.showMessageDialog(null,
                    "Boleta: " + obj[i].getNumBoleta() + "\n"
                    + "Nombre: " + obj[i].getNombre() + "\n"
                    + "Edad: " + obj[i].getEdad() + "\n"
                    + "Genero : " + obj[i].getGenero()+ "\n");
                  return;
              }
          }
        JOptionPane.showMessageDialog(null, "No se encontro el estudiante");
    }

        public void editarEstudiante() {

            int boleta = Integer.parseInt(
                     JOptionPane.showInputDialog("Ingresa la boleta del estudiante a editar:"));

            
            for (int i = 0; i < x; i++) {
                if (obj[i].getNumBoleta() == boleta) {

                 obj[i].setNombre(
                            JOptionPane.showInputDialog("Ingresa el nuevo nombre"));

                  obj[i].setEdad(Integer.parseInt(
                            JOptionPane.showInputDialog("Ingresa la nueva edad")));

                 obj[i].setGenero(
                             JOptionPane.showInputDialog("Ingrese el nuevo genero").charAt(0));

                     JOptionPane.showMessageDialog(null, "Datos actualizados correctamente ");
                    return;
                }
            }

             JOptionPane.showMessageDialog(null, "No se encontro el estudiante");
        }

        public void eliminarEstudiante() {

            int boleta = Integer.parseInt( 
                JOptionPane.showInputDialog("Ingresa la boleta del estudiante a eliminar"));

            for (int i = 0; i < x; i++) {
                if (obj[i].getNumBoleta() == boleta) {

                    for (int j = i; j < x - 1; j++) {
                        obj[j] = obj[j + 1];

                    }

                    obj[x - 1] = null; 
                    x--;
                    JOptionPane.showMessageDialog(null, "Estudiante eliminado");
                    return;
                }
            }
             JOptionPane.showMessageDialog(null, "no se encuentra el estudiante");
        }
}
