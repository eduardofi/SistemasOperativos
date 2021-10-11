package procesosp4;


import java.util.Scanner;

public class Menu {
    int contador = 1;
    Memoria memory;
    public Menu(Memoria m){
        memory = m;
    }
    public void menu(){
        boolean bandera = true;
            do{   
                System.out.println(" \t Eliga una opción: ");
            System.out.println("1. Crear proceso");
            System.out.println("2. Ver estado actual");
            System.out.println("3. Imprimir cola de procesos");
            System.out.println("4. Ver proceso actual");
            System.out.println("5. Pasar al proceso siguinte");
            System.out.println("6. Matar proceso");
            System.out.println("7. Ejecutar proceso");
            System.out.println("8. Salir");
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();
                System.out.println("Op: "+op);
                switch(op){
                    case 1 :
                        int potenciaM = (int) ((Math.random() *(9-6+1) +6));
                        System.err.println("potencia" +potenciaM);
                        int cantidadM = (int) Math.pow(2, potenciaM);
                        System.out.println("Memory: " +memory);
                        Proceso p1 = Proceso.crearProceso( "Proceso1", cantidadM,contador, memory);
                        contador++;
                        System.out.println(p1);
                        
                    break;                        
                    case 2 :
                        //
                       break; // break es opcional
                     case 3 :
                       // Declaraciones
                       break; // break es opcional
                        case 4 :
                       // Declaraciones
                       break; // break es opcional
                        case 5 :
                       // Declaraciones
                       break; // break es opcional
                        case 6 :
                       // Declaraciones
                       break; // break es opcional
                        case 7 :
                       // Declaraciones
                       break; // break es opcional
                        case 8 :
                       System.err.println("Adios!");
                        bandera = false;
                        
                       break; // break es opcional

                    default :
                        System.err.println("Error");
                }
        }while(bandera);
    }
}
