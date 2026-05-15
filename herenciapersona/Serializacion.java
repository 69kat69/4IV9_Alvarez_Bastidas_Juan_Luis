package herenciapersona;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
 
public class Serializacion { 
      public static void guardarEstudiantes(Estudiante[] obj, int x) {
        try {
            FileWriter fw = new FileWriter("estudiantes.txt");
            BufferedWriter bw = new BufferedWriter(fw);
 
            bw.write(x + "\n");
            for (int i = 0; i < x; i++) {
                bw.write(obj[i].getNumBoleta() + "\n");
                bw.write(obj[i].getNombre() + "\n");
                bw.write(obj[i].getEdad() + "\n");
                bw.write(obj[i].getGenero() + "\n");
            }
             bw.close();
            JOptionPane.showMessageDialog(null, "Estudiantes guardados correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar estudiantes: " + e.getMessage());
        }
    }
       public static int cargarEstudiantes(Estudiante[] obj) {
        int x = 0;
        try {
            FileReader fr = new FileReader("estudiantes.txt");
            BufferedReader br = new BufferedReader(fr);
 
            x = Integer.parseInt(br.readLine());
            for (int i = 0; i < x; i++) {
                int boleta = Integer.parseInt(br.readLine());
                String nombre = br.readLine();
                int edad = Integer.parseInt(br.readLine());
                char genero = br.readLine().charAt(0);
                obj[i] = new Estudiante(boleta, nombre, edad, genero);
            }
            
            br.close();
            JOptionPane.showMessageDialog(null, "Estudiantes cargados correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontraron datos de estudiantes.");
        }
        return x;
    }
         public static void guardarProfesores(Profesor[] obj, int x) {
        try {
            FileWriter fw = new FileWriter("profesores.txt");
            BufferedWriter bw = new BufferedWriter(fw);
 
            bw.write(x + "\n");
            for (int i = 0; i < x; i++) {
                bw.write(obj[i].getNumEmpleado() + "\n");
                bw.write(obj[i].getNombre() + "\n");
                bw.write(obj[i].getEdad() + "\n");
                bw.write(obj[i].getGenero() + "\n");
            }
             bw.close();
            JOptionPane.showMessageDialog(null, "Profesores guardados correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar profesores: " + e.getMessage());
        }
    }
            public static int cargarProfesores(Profesor[] obj) {
        int x = 0;
        try {
            FileReader fr = new FileReader("profesores.txt");
            BufferedReader br = new BufferedReader(fr);
 
            x = Integer.parseInt(br.readLine());
            for (int i = 0; i < x; i++) {
                int numEmpleado = Integer.parseInt(br.readLine());
                String nombre = br.readLine();
                int edad = Integer.parseInt(br.readLine());
                char genero = br.readLine().charAt(0);
                obj[i] = new Profesor(numEmpleado, nombre, edad, genero);
            }
            br.close();
            JOptionPane.showMessageDialog(null, "Profesores cargados correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontraron datos de profesores.");
        }
        return x;
    }
}

