package procesosp4;


import java.util.Scanner;

public class Menu {
    int contador = 1;
    public void menu(){
        boolean bandera = true;
            do{   
                System.err.println(" \t Eliga una opción: ");
            System.err.println("1. Crear proceso");
            System.err.println("2. Ver estado actual");
            System.err.println("3. Imprimir cola de procesos");
            System.err.println("4. Ver proceso actual");
            System.err.println("5. Pasar al proceso siguinte");
            System.err.println("6. Matar proceso");
            System.err.println("7. Ejecutar proceso");
            System.err.println("8. Salir");
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();
                System.out.println("Op: "+op);
                switch(op){
                    case 1 :
                        Proceso p = new Proceso();
                        System.out.println("Memoria " +p.memoria);
                        Proceso p1 = p.crearProceso( "Proceso1",48, contador);
                        contador++;
                        System.out.println("Memoria " +p1.memoria+ " PID: "+p1.pid);
                        
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
