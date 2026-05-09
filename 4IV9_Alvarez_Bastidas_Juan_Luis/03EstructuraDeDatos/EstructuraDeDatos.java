/*
Vamos a crear 14 programas dentro de un menu gigante para poner a prueba sus conocimientos de algoritmia
1-.Desarollar un programa para calcular el bono de un descuento por edad
2-.Convertir numeros de decimales a binarios
3-. Convertir temperaturas entre los tres principales grados c -> F y K
4-.Realizar un programa para contar numeros de positivos a negativos de una serie de numeros
5-.Desarrollar una tiendita para agregar productos y precios
6-.Desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras
7-.Desarrollar una tabla
x
9-.Vamos a hacer dibujitos
10-.Desarrollar una figura hueca
11.Realizar algunos patrones
12-.Realizar un diamante
13-.Desarrollar una calculadora basica suma, resta, multiplicacion, division
 */

import java.util.Scanner;

class EstructuraDeDatos{
    public static void main(String[] args) {
        //aqui van las variables
            int opcion;
            char letrapararepetir;  // Declaración de la variable para el ciclo
            float compra = 0;
            char socio;
            float temperatura = 0;
            float resultadotemp = 0;
            int opciondetemperatura = 0;
        //aqui van los objetos
        Scanner entrada = new Scanner(System.in);
        
        do { // Se agrega el inicio del ciclo do-while
            //aqui va el menu

            System.out.println("Bienvenido a este programa para ver cuanto saben programar a partir de algoritmos basicos");

            System.out.println("1-.Desarollar un programa para calcular el bono de un descuento por edad");
            System.out.println("2-.Convertir numeros de decimales a binarios");
            System.out.println("3-. Convertir temperaturas entre los tres principales grados c -> F y K");
            System.out.println("4-.Realizar un programa para contar numeros de positivos a negativos de una serie de numeros");
            System.out.println("5-.Desarrollar una tiendita para agregar productos y precios");
            System.out.println("6-.Desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras");
            System.out.println("7-.Desarrollar una tabla");
            System.out.println("8-.Desarrollar un programa para calcular el factorial con recursividad");
            System.out.println("9-.Vamos a hacer dibujitos");
            System.out.println("10-.Desarrollar una figura hueca");
            System.out.println("11.Realizar algunos patrones");
            System.out.println("12-.Realizar un diamante");
            System.out.println("13-.Desarrollar una calculadora basica suma, resta, multiplicacion, division");
            System.out.println("14-. Salir");

            //Entrada de datos
            opcion = entrada.nextInt();

            //ahora tengo que evaluar  la entrada
            switch (opcion) {
                case 1:
                    System.out.println("Bienvenido al programa que te descuenta por tu edad");
                    System.out.println("Ingrese su edad: ");
                        int edad = 0;
                        edad = entrada.nextInt();
                        float delbono = 100;

                if (edad > 65) {
                    delbono = delbono * 0.60f;
                        System.out.println("Tienes descuento de persona de la 3ra edad del 40%");
                        System.out.println("El precio final es: " + delbono);
                } else if(edad < 21) {
                    System.out.println("¿Tus padres son socios del club? (S/N):  ");
                  socio = entrada.next().charAt(0);

                    if (socio == 's' || socio == 'S' ) {
                        delbono = delbono * 0.55f;
                    } else {
                        delbono = delbono * 0.75f;

                    } System.out.println("precio final: " + delbono);

                } else {
                    System.out.println("precio final: " + delbono);
                }

                    
                break;
                case 2:
                
                System.out.println("Ingrese un número positivo entero que se desee convertir a binario");
                int numerobinario;
                String guardarbinario = "";
                numerobinario = entrada.nextInt();

                if(numerobinario > 0){
                    //Realizamos el modulo de dos
                    while(numerobinario > 0){
                        if (numerobinario%2 ==0){
                            guardarbinario = "0" + guardarbinario;
                        }else{
                            guardarbinario = "1" + guardarbinario;
                        }
                        numerobinario = numerobinario / 2;
                    }
                }else if (numerobinario ==0) {
                    guardarbinario = "0";
                }
                else{
                    guardarbinario = "No se puede convertir ese numero solo acepta positivos";
                }
                System.out.println("El numero convertido en binario es: " + guardarbinario);
                
                    
                break;
                case 3:
                int opciont = 0;
                float temperaturat = 0;

                System.out.println("que quieres convertir?");
                System.out.println("1 celcius a fahreinheit");
                System.out.println("2 celcius a kelvin");
                System.out.println("3 celcius a rankine");
                System.out.println("4 fahreinheit a celcius");
                System.out.println("5 fahrenheit a kelvin");
                System.out.println("6 fahrenheit a rankine");
                System.out.println("7 kelvin a celsius");
                System.out.println("8 kelvin a fahrenheit");
                System.out.println("9 kelvin a rankine");
                System.out.println("10 rankine a celcius");
                System.out.println("11 rankine a fahrenheit");
                System.out.println("12 rankine a kelvin");
                opciont = entrada.nextInt();
                System.out.println("ingresa la temperatura:");
                temperaturat = entrada.nextFloat();

                if (opciont == 1) {
                    System.out.println("resultado: " + ((temperaturat * 9/5) + 32) + "F");
                }
                 else if (opciont == 2) {
                    System.out.println("resultado: " + (temperaturat + 273.15f) + "K");
                } 
                else if (opciont == 3) {
                    System.out.println("resultado: " + ((temperaturat + 273.15f) * 9/5) + "R");
                } 
                else if (opciont == 4) {
                    System.out.println("resultado: " + ((temperaturat - 32) * 5/9) + "C");
                } 
                else if (opciont == 5) {
                    System.out.println("resultado: " + ((temperaturat - 32) * 5/9 + 273.15f) + "K");
                }
                 else if (opciont == 6) {
                    System.out.println("resultado: " + (temperaturat + 459.67f) + "R");
                }
                 else if (opciont == 7) {
                    System.out.println("resultado: " + (temperaturat - 273.15f) + "C");
                } 
                else if (opciont == 8) {
                    System.out.println("resultado: " + ((temperaturat - 273.15f) * 9/5 + 32) + "F");
                }
                 else if (opciont == 9) {
                    System.out.println("resultado: " + (temperaturat * 9/5) + "R");
                }
                 else if (opciont == 10) {
                    System.out.println("resultado: " + ((temperaturat - 491.67f) * 5/9) + "C");
                } 
                else if (opciont == 11) {
                    System.out.println("resultado: " + (temperaturat - 459.67f) + "F");
                } 
                else if (opciont == 12) {
                    System.out.println("resultado: " + (temperaturat * 5/9) + "K");
                }
                 else {
                    System.out.println("no valido");
                }
     
                break;
                case 4:
                   int positivo = 0;
                    int negativo = 0;
                    int numeros = 0;
                    char repetirss;

                     do {    
                        System.out.println("Ingresa cualquier numero");
                        numeros = entrada.nextInt();
                        if (numeros > 0) {
                            positivo++;
                        } else if (numeros < 0) {
                            negativo++;
                        }
                        System.out.println("Quiere añadir otro numero? (s/n)");
                        repetirss = entrada.next().charAt(0);
                    } 
                    while (repetirss == 's' || repetirss == 'S');

                    System.out.println("Positivos: " + positivo);
                    System.out.println("Negativos: " + negativo);

                    
                break;
                case 5:
                    System.out.println("Bienvenido a esta linda hermosa y kawaii");
                System.out.println("Por favor ingrese cuantos elementos va a comprar");
                int elementosproducto = 0;
                elementosproducto = entrada.nextInt();
                if (elementosproducto > 0 ){
                    for(int i = 1; i <= elementosproducto;i++ ){
                        System.out.println("Ingresa el nombre del producto");
                        String nombreproducto = "";
                        nombreproducto = entrada.next();
                        System.out.println("Ingrese el precio");
                        float precio = 0;
                        precio = entrada.nextFloat();
                        System.out.println("Ingrese la cantidad");
                        int cantidad = 0;
                        cantidad = entrada.nextInt();
                        float resultado = 0;
                        resultado = precio * cantidad;
                        compra = resultado + compra;
                    }
                    System.out.println("El total de la compra es: " + compra);
                }else{
                    System.out.println("Ingrese solo positivos");
                }
                break;

                    

                case 6:
                    int figura = 0;
                    float dato1 = 0;
                    float dato2 = 0;

                    System.out.println("ingrese cualquiera de las 5 figuras");
                    System.out.println("1. Circulo, 2. Cuadrado, 3. Rectangulo, 4.Triangulo, 5 Cilindro");
                    figura = entrada.nextInt();
                            if(figura == 1){
                                System.out.println("ingresa el radio");
                                dato1 = entrada.nextFloat();
                                System.out.println("area: " + (Math.PI * dato1 * dato1));
                            }
                            else if(figura ==2){
                                System.out.println("ingrese lado");
                                dato1 = entrada.nextFloat();
                                System.out.println("area: " + (dato1 * dato1));
                            }
                            else if(figura == 3){
                                System.out.println("ingrese la base: ");
                                dato1 = entrada.nextFloat();
                                System.out.println("ingrese la altura: ");
                                dato2 = entrada.nextFloat();
                                System.out.println("area: " + (dato1 * dato2));
                            }
                            else if(figura == 4){
                                System.out.println("ingrese la base");
                                dato1 = entrada.nextFloat();
                                System.out.println("ingrese la altura");
                                dato2 = entrada.nextFloat();
                                System.out.println("area: " + ((dato1 * dato2) /2));
                            }
                            else if(figura == 5){
                                System.out.println("ingrese radio:");
                                dato1 = entrada.nextFloat();
                                System.out.println("ingrese altura: ");
                                dato2 = entrada.nextFloat();
                                System.out.println("area: " + (2 * Math.PI * dato1 * dato2));
                            } 
                            else{
                                System.out.println("no valido");
                            }
                    
                break;
                case 7:
                     //quiero dejarles una tabla de multiplicar
        for(int n = 1; n <= 10; n++){
            System.out.println("|  "+ n + "  |  "+ (n*10 + "    |   " + (n*100) + "    |   " + (n*1000)));

        }

                    
                break;
                case 8:
                    System.out.println("ingresa el numero para calcular su factorial");
                    int factorial = entrada.nextInt();
                    int resultado = 1;
                        if(factorial< 0){
                            System.out.println(" no se pueden numeros negativos");
                        } else{
                            for(int a = 1; a <= factorial; a++) {
                                resultado = resultado * a;

                            }
                            System.out.println("factorial de  " + factorial + " es :" + resultado);
                        }
                    
                break;
                case 9:
                     //vamos a realizar un cuadrado magico
        System.out.println( "vamos a realizar el dibujo de un cuadrado magico");
        System.out.println( "ingrese el tamaño del cuadrado");
        int n1= entrada.nextInt();

        if(n1 >= 1 && n1 <= 20){
                //se imprime
                for(int i = 1; i <= n1; i++){
                    //recorro las columnas
                    //System.out.print( " 1 ")
                    for(int j = 1; j <= n1; j++){
                        System.out.print("  *  ");

                    }
                    System.out.println("");
                }
        }else{
            System.out.println("Por favor solo ingrese valores entre el 1 y el 20");
                }

                    
                break;
                case 10:
                  System.out.println("ingresa el tamaño del cuadrado: ");
                    int tamaño = entrada.nextInt();

                    if (tamaño < 2) {
                        System.out.println("tamaño minimo de 2");
                        break;
                    }

                    for (int a = 1; a <= tamaño; a++) {
                        for (int b = 1; b <= tamaño; b++) {
                            boolean bordes = (a == 1 || a == tamaño || b == 1 || b == tamaño);
                            if (bordes) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 11:
                   
                for ( int a = 1; a <= 8; a++){
                        if(a % 2 == 0){
                            System.out.println("********");
                        }
                        else{
                        System.out.println("*******");
                    } 
                }
                break;
                case 12:

    System.out.println("Ingresa el tamaño del diamante)");
    int num = entrada.nextInt();
    if (num < 1){
        System.out.println("tamaño minimo de 1");
        break;
    }
    for (int a = 1; a <= num; a++){
        for(int b = 1; b <= num - a; b++){
            System.out.print("  ");
        }
        for(int c = 1; c <= 2 * a - 1; c++){
            System.out.print("* ");
        }
        System.out.println();
    }
    for(int a = num - 1; a >= 1; a--){
        for(int b = 1; b <= num - a; b++){
            System.out.print("  ");
        }
        for(int c = 1; c <= 2 * a - 1; c++){
            System.out.print("* ");
        }
        System.out.println();
    }
    break;
                    
                case 13:
                    int opcioncl = 0;
                    float numero67 = 0;
                    float numero69 = 0;
                    float rescap = 0;
                    char repertircalcu;

                    do {
                        System.out.println("que operacion quieres hacer:");
                        System.out.println("1. Suma");
                        System.out.println("2. Resta");
                        System.out.println("3. Multiplicacion");
                        System.out.println("4. Division");
                        opcioncl = entrada.nextInt();

                        System.out.println("ingresa la primera cantidad:");
                        numero67 = entrada.nextFloat();
                        System.out.println("ingrese la segunda cantidad: ");
                        numero69 = entrada.nextFloat();

                        if (opcioncl == 1) {
                            rescap = numero67 + numero69;
                            System.out.println("Resultado: " + rescap);
                        } else if (opcioncl == 2) {
                            rescap = numero67 - numero69;
                            System.out.println("Resultado: " + rescap);
                        } else if (opcioncl == 3) {
                            rescap = numero67 * numero69;
                            System.out.println("Resultado: " + rescap);
                        } else if (opcioncl == 4) {
                            if (numero69 == 0) {
                                System.out.println("No se puede dividir entre 0");
                            } else {
                                rescap = numero67 / numero69;
                                System.out.println("Resultado: " + rescap);
                            }
                        } else {
                            System.out.println("no es valido");
                        }

                        System.out.println("quieres hacer otra operacion (s/n)");
                        repertircalcu = entrada.next().charAt(0);

                    } while (repertircalcu == 's' || repertircalcu == 'S');
                    break;

               case 14:
                    System.out.println("Saliendo...");
                break;
                default:
                    System.out.println("Opción no válida");
            }
            
            System.out.println("Deseas repetir el programa, escribe s o S para si");
            letrapararepetir = entrada.next().charAt(0);

        } while(letrapararepetir == 's' || letrapararepetir == 'S'); // Cierre correcto del do-while
    }
}