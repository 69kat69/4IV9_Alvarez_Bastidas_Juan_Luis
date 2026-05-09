import java.util.Scanner;

public class Examen {
    
    public static void main(String[] args) {

            Scanner entrada = new Scanner(System.in);

                String nombrecp = "";
                String apellidoP = "";
                String apellidoM = "";
                String nacimiento = "";
                String direccion = "";

                int opcion = 0;

                do{
                    System.out.println("-----------------------");
                    System.out.println("          Menu         ");
                    System.out.println("-----------------------");
                    System.out.println("1. Datos del comprador");
                    System.out.println("2. Catalogo de pisos");
                    System.out.println("3. Cotizacion");
                    System.out.println("4. Salir");
                    opcion = entrada.nextInt();
                    entrada.nextLine();



                    if(opcion == 1) {
                        System.out.println("Ingrese los datos solicitados");
                        System.out.println("Nombre: ");
                        nombrecp = entrada.nextLine();
                        System.out.println("apellido paterno: ");
                        apellidoP = entrada.nextLine();
                        System.out.println("Apellido Materno");
                        apellidoM = entrada.nextLine();
                        System.out.println("Fecha de nacimiento (DIA/MES/AÑO)");
                        nacimiento = entrada.nextLine();
                        System.out.println("direccion: ");
                        direccion = entrada.nextLine();
                        System.out.println("Datos guardados correctamente...");
                    } else if(opcion == 2){
                        System.out.println("Tipos de pisos en sucursal: ");
                        System.out.println("1. Porcelanato  $22.35/m2   con IVA: $25.93");
                        System.out.println("2. Marmoleado   $34.27/m2   con IVA: $39.75");
                        System.out.println("\"3. Acrilico     $22.94/m2   con IVA: $26.61\"");
                        System.out.println("\nPresione ENTER para volver al menú...");
                            entrada.nextLine();
                    } else if(opcion == 3) {
                        if(nombrecp.equals("")) {
                            System.out.println("Primero llene los datos del comprador (Con opcion 1)");
                        } else {
                            int numerodcuartos = 0;
                            System.out.print("\nCuantos cuartos tiene el inmueble (entre 2 y 4): ");
                            numerodcuartos = entrada.nextInt();
                            entrada.nextLine();



                            while(numerodcuartos < 2 || numerodcuartos > 4) {
                                System.out.println("Deben de ser entre 2 y 4");
                                System.out.println("Ingrese de nuevo: ");
                                numerodcuartos = entrada.nextInt();
                                entrada.nextLine();
                                }
                                float totaldetodo = 0;
                                

                                System.out.println("Comprador: " + nombrecp + " " + apellidoP + " " + apellidoM);
                                System.out.println("Nacimiento: " + nacimiento);
                                System.out.println("Direccion: " + direccion);


                                for(int i = 0; i < numerodcuartos; i++) {
                                    System.out.println("\nCuarto " + (i+1) + ":");
                                    System.out.println(" Largo en metros: ");
                                    float largo = entrada.nextFloat();
                                    entrada.nextLine();

                                    System.out.println("ancho en metros");
                                    float ancho = entrada.nextFloat();
                                    entrada.nextLine();
                                     System.out.println("  Tipo de piso:");
                                     System.out.println("    1. Porcelanato  $22.35/m2");
                                     System.out.println("    2. Marmoleado   $34.27/m2");
                                     System.out.println("    3. Acrilico     $22.94/m2");
                                     System.out.print("  Elija (1-3): ");
                                     int tipo = entrada.nextInt();
                                     entrada.nextLine();    


                                     while (tipo < 1 || tipo > 3) { 
                                        System.out.println(" Opcion no valida, ingrese 1, 2 o 3: ");
                                        tipo = entrada.nextInt();
                                        entrada.nextLine(); 
                                     }
                                     float preciom2 = 0;
                                     String Nombredpiso = "";
                                     if(tipo == 1 ) {
                                        preciom2 = 22.35f;
                                        Nombredpiso = "Porcelanato";
                                     } else if(tipo == 2) {
                                        preciom2 = 34.27f;
                                        Nombredpiso = "Marmoleado";
                                     } else {
                                        preciom2 = 22.94f;
                                        Nombredpiso = "Acrilico";
                                     }

                                     float metros = largo * ancho;
                                     float subtotal = metros * preciom2;
                                     float iva = subtotal * 0.16f;
                                     float totalCuarto = subtotal + iva;
                                     totaldetodo = totaldetodo + totalCuarto;
                                     
                                        System.out.println("\n Cuarto " + (i+1) + " - " + Nombredpiso);
                                        System.out.println(" Medidas: " + largo + "m x" + ancho + "m = " + metros + "m2");
                                        System.out.println(" Subtotal: $" + subtotal);
                                        System.out.println(" IVA (16%): $ " + iva );
                                        System.out.println(" Total: $" + totalCuarto);
                                } 
                                System.out.println("\n------------------------------------------");
                                System.out.println("TOTAL GENERAL (con IVA): $" + totaldetodo);
                                System.out.println("==========================================");
                                    System.out.println("\nDesea realizar la compra? s/n: ");
                                     char resp = entrada.nextLine().charAt(0);


                                if(resp == 's' || resp == 'S') {
                                    float descuento = totaldetodo * 0.0795f;
                                    float totalfinal = totaldetodo - descuento;
                                    System.out.println("Descuento del 7.95%: -$" + descuento);
                                    System.out.println("TOTAL A PAGAR: $" + totalfinal);
                                    System.out.println("Compra realizada, gracias!");
                                } else {
                                    System.out.println("Compra cancelada.");

                                }
                                }
                        } else if(opcion != 4) {
                            System.out.println("Opcion invalida");
                        }

                    } while (opcion != 4);
                    
                    entrada.close();

                    }
                        
                    }


                
    
