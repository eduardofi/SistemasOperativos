package procesosp4;


import java.util.Scanner;

public class Menu {
    int contador = 1;
    Memoria memory;
    ColaProcesos colap;
    ListaLigada ligada;
    public Menu(Memoria m, ColaProcesos colap, ListaLigada ligada){
        memory = m;
        this.colap = colap;
        this.ligada=ligada;
    }
    
    public void menu(){
        boolean bandera = true;
        do{   
            System.out.println(" \t MENU ");
            System.out.println("1. Crear proceso");
            System.out.println("2. Ver estado de los procesos");
            System.out.println("3. Imprimir cola de procesos");
            System.out.println("4. Ver proceso actual");
            System.out.println("5. Pasar al proceso siguiente");
            System.out.println("6. Matar proceso");
            System.out.println("7. Ejecutar proceso");
            System.out.println("8. Ver estado de la memoria");
            System.out.println("9. Desfragmentar memoria");
            System.out.println("10. Mostrar memoria-marco");
            System.out.println("11. Salir");
            System.out.print("Elige una opción: ");
            int op = new Scanner(System.in).nextInt();
            System.out.println("**********************************************");
            System.out.println("Ha elegido la opcion: "+op);
            switch(op){
                case 1 :
                    //int potenciaM = (int) ((Math.random() *(9-6+1) +6));
                    //int cantidadM = (int) Math.pow(2, potenciaM);
                    System.out.print("Elige el tamaño del proceso (64, 128, 256, 512): ");
                    int cantidadM = new Scanner(System.in).nextInt();
                    System.out.print("Escriba el nombre del proceso: ");
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
                   colap.MostrarContenido();
                   colap.listaProcesosEliminados();
                    System.out.println("Lista ligada de Procesos - Huecos:");
                   ligada.actualizarListaLigada(memory);
                   ligada.MostrarContenido();
                   break; // break es opcional
                case 3 :
                   colap.MostrarContenido();
                   break; // break es opcional
                case 4 :
                    System.out.println(colap.getProcesoActual()); 
                    colap.getProcesoActual().mostrarTablaPaginas();
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
                  case 8:
                    ligada.actualizarListaLigada(memory);
                    ligada.MostrarContenido();
                    memory.mostraTablaMarcos();
                    break;
                case 9:
                    memory.desfragmentarMemoria(colap);
                    ligada.actualizarListaLigada(memory);
                    ligada.MostrarContenido();
                    break;
                case 10:
                    memory.mostraTablaMarcos();
                    break;
                case 11 :
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
