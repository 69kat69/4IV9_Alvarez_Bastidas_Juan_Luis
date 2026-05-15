package herenciapersona;

public class Profesor extends Persona {
    
    private int numEmpleado;
    
    public Profesor() {
        
    }
    public Profesor(int numEmpleado, String nombre, int edad, char genero) {
        super(nombre, edad, genero);
        this.numEmpleado= numEmpleado;
    }
    public int getNumEmpleado(){ 
        return numEmpleado;
    }
    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }
}