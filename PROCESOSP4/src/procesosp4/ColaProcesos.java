/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesosp4;

import java.util.ArrayList;
import java.util.Iterator;

public class ColaProcesos {
    private NodoProceso inicioCola, finalCola;
    String Cola = "";
    int tamCola = 0;
    ArrayList<Proceso> listaProcesos = new ArrayList<>();
    
    public ColaProcesos(){
        inicioCola = null;
        finalCola = null;
    }
     //Método para saber si la cola esta vacia
    public boolean colaVacia(){
        if (inicioCola == null) {
            return true;
        } else {
            return false;
        }
    }
    //Método para insertar a la cola
    public void insertar(Proceso proceso){
        NodoProceso nuevo_nodo = new NodoProceso();
        nuevo_nodo.proceso = proceso;
        nuevo_nodo.siguiente = null;
        
        if (this.colaVacia()) {
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
            nuevo_nodo.proceso.updateStatus = UpdateStatus.ACTIVO.name();
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
            nuevo_nodo.proceso.updateStatus = UpdateStatus.INACTIVO.name();
        }
        tamCola++;
    }
    public Proceso getProcesoActual(){
        return inicioCola.proceso;
    }
    public void tamañoCola (){
         System.out.println("Numero de procesos en la cola: " + tamCola); 
    }
        //Método para mostrar el contenido de la cola
    public void MostrarContenido(){
        if(this.colaVacia()){
            System.out.println("Cola de procesos vacía, ingrese un proceso");
        }else{
            NodoProceso recorrido = inicioCola;

            while (recorrido != null) {
                Cola += recorrido.proceso +" " +recorrido.proceso.updateStatus + "\n";
                recorrido = recorrido.siguiente;
            }
            System.out.println(Cola);
            Cola = "";
        }
    }
    
    public void pasarSigProceso(){
        if (inicioCola.siguiente != null) {
            NodoProceso almacen1 = inicioCola;
            inicioCola = almacen1.siguiente;
            almacen1.siguiente = null;
            finalCola.siguiente = almacen1;
            finalCola = almacen1;
        }        
    }
    
    public void ejecutarProcesoAct(){
        int instruccionesFaltantes = inicioCola.proceso.numInstrucciones -
                inicioCola.proceso.numInstruccionesEjecutadas;
        if(instruccionesFaltantes > 5){
            inicioCola.proceso.numInstruccionesEjecutadas+=5;
            pasarSigProceso();
        }else{
            Proceso p = eliminarProceso();
            System.out.println(p);
            listaProcesos.add(p);
                        
        }
    }
    
    //Método para eliminar proceso terminado de la cola
    public Proceso eliminarProceso(){
        if (!colaVacia()) {
            Proceso p = inicioCola.proceso;
            
            if (inicioCola == finalCola) {
                inicioCola = null;
                finalCola = null;
            } else {
                inicioCola = inicioCola.siguiente;
            }
            p.estado = Estado.TERMINADO.name();
            return p;
        } else {
            return null;
        }
    }
    
   public void listaProcesosEliminados(){
       for(Proceso p: listaProcesos){
           System.out.println(p);
       }
   }
}
