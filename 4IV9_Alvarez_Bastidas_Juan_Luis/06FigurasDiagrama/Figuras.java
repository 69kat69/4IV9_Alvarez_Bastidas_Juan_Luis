
import  java.util.Scanner;

public class Figuras {

    Scanner sc = new Scanner(System.in);
    double pi = 3.1416;
    public void menu() {    
        int opcion = 0;

    do {
        System.out.println("\n----Menu---");
        System.out.println("Elija la figura que desee calcular");
        System.out.println("1. circulo");
        System.out.println("2. cuadrado");
        System.out.println("3. triangulo");
        System.out.println("4. rectangulo");
        System.out.println("5. trapecio");
        System.out.println("6. salir");
        System.out.println("Opcion: ");
        opcion = sc.nextInt();



        switch (opcion) {
            case 1: circulo(); break;
            case 2: cuadrado(); break;
            case 3: triangulo(); break;
            case 4: rectangulo(); break;
            case 5: trapecio(); break; 
            case 6: System.out.println("saliendo..."); break;
            default:
                System.out.println("Opcion Invalidada");
        } 

    } while (opcion !=6);

    
    } public void circulo() {
        double radio;
        double perimetro;
        double area;

            System.out.println("radio: ");
            radio = sc.nextDouble();
            
                perimetro = 2 * pi * radio;
                area = pi * radio * radio;

            System.out.println("Perimetro: " + perimetro);
            System.out.println("Area: " + area);
    }

    public void cuadrado() {
        double lado; 
        double perimetro; 
        double area;

            System.out.println("Lado: ");
            lado = sc.nextDouble();

                perimetro = lado * 4;
                area = lado * lado;
        
        System.out.println("Perimetro: " + perimetro);
        System.out.println("Area: " + area);
    }

    public void triangulo() {
        double lado;
        double lado2;
        double lado3;
        double base;
        double altura;
        double area;
        double perimetro;

            System.out.println("Lado 1: ");
            lado = sc.nextDouble();
            System.out.println("Lado 2: ");
            lado2 = sc.nextDouble();
            System.out.println("Lado 3: ");
            lado3 = sc.nextDouble();

            System.out.println("Base: ");
            base = sc.nextDouble();

            System.out.println("Altura: ");
            altura = sc.nextDouble();

                perimetro = lado + lado2 + lado3;
                area = (base * altura) / 2;
            
            System.out.println("Perimetro: " + perimetro);
            System.out.println("Area: " + area);
    }

    public void rectangulo() {
        double base;
        double altura;
        double perimetro;
        double area;

            System.out.println("Base: ");
            base = sc.nextDouble();

            System.out.println("Altura: ");
            altura = sc.nextDouble();

                perimetro = 2 * (base + altura);
                area = base * altura;

            System.out.println("Perimetro: ");
            perimetro = sc.nextDouble();

            System.out.println("Perimetro: " + perimetro);
            System.out.println("Area: " + area);
    }

    public void trapecio() {
        double basemayor;
        double basemenor;
        double lado;
        double lado2;
        double altura;
        double area;
        double perimetro;

            System.out.println("Base Mayor: ");
            basemayor = sc.nextDouble();
            System.out.println("Base menor: ");
            basemenor = sc.nextDouble();

            System.out.println("Lado 1: ");
            lado = sc.nextDouble();
            System.out.println("Lado 2: ");
            lado2 = sc.nextDouble();

            System.out.println("Altura");
            altura = sc.nextDouble();
    
                perimetro = basemayor + basemenor + lado + lado2;
                area = ((basemayor + basemenor) * altura) / 2;

            System.out.println("Perimetro: " + perimetro);
            System.out.println("Area: " + area);
    } 

    public static void main(String[] args) {
        Figuras f = new Figuras();
        f.menu();
    }
    }

