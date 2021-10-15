package procesosp4;


import java.util.Scanner;

public class Menu {
    int contador = 1;
    Memoria memory;
    ColaProcesos colap;
    public Menu(Memoria m, ColaProcesos colap){
        memory = m;
        this.colap = colap;
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
                    System.out.println("Agregando a cola de procesos...");
                    try {
                        colap.insertar(p);
                        p.estado = Estado.PREPARADO.name();
                        System.out.println(p);
                    } catch (Exception e) {
                    }
                    break;                        
                case 2 :
                   colap.tamañoCola();
                   colap.listaProcesosEliminados();
                   colap.MostrarContenido();
                   memory.tablaLocalidades();
                   
                   break; // break es opcional
                case 3 :
                   colap.MostrarContenido();
                   break; // break es opcional
                case 4 :
                    System.out.println(colap.getProcesoActual()); 
                   break; // break es opcional
                case 5 :
                   colap.pasarSigProceso();
                   break; // break es opcional
                case 6 :
                    Proceso p1 = colap.eliminarProceso(memory);
                    System.out.println(p1);
                   
                    break; // break es opcional
                case 7 :
                   colap.ejecutarProcesoAct(memory);
                   break; // break es opcional
                case 8 :
                   System.out.println("Adios!");
                   System.out.println("\t Cola de procesos");
                   colap.MostrarContenido();
                   System.out.println("\t Cola de procesos eliminados");
                   colap.listaProcesosEliminados();
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
