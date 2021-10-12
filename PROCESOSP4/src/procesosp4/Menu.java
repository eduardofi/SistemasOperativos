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
            System.out.println(" \t MENU ");
            System.out.println("1. Crear proceso");
            System.out.println("2. Ver estado actual");
            System.out.println("3. Imprimir cola de procesos");
            System.out.println("4. Ver proceso actual");
            System.out.println("5. Pasar al proceso siguinte");
            System.out.println("6. Matar proceso");
            System.out.println("7. Ejecutar proceso");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            int op = new Scanner(System.in).nextInt();
            System.out.println("**********************************************");
            System.out.println("Ha elegido la opcion: "+op);
            switch(op){
                case 1 :
                    int potenciaM = (int) ((Math.random() *(9-6+1) +6));
                    int cantidadM = (int) Math.pow(2, potenciaM);
                    System.out.print("Escriba el nombre del Proceso: ");
                    String nombreProceso = new Scanner(System.in).nextLine();
                    System.out.println(memory);
                    Proceso p = Proceso.crearProceso(nombreProceso, cantidadM,
                            contador++, memory);
                    System.out.println(p);
                    System.out.println(memory);
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
                   System.out.println("Adios!");
                   bandera = false;
                   break; // break es opcional
                default:
                    System.out.println("Error");
                    bandera = false;
            }
            System.out.println("**********************************************");
        }while(bandera);
    }
}
