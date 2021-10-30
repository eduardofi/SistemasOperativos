
package procesosp4;

import java.util.ArrayList;

public class ColaProcesos {
    private NodoProceso inicioCola, finalCola;
    String Cola = "";
    int tamCola = 0;
    ArrayList<Proceso> listaProcesosEliminados = new ArrayList<>();
    
    public ColaProcesos(){
        inicioCola = null;
        finalCola = null;
    }
     //Método para saber si la cola esta vacia
    public boolean colaVacia(){
        return inicioCola == null;
    }
    //Método para insertar a la cola
    public void insertar(Proceso proceso) {
        System.out.println(proceso != null);
        if (proceso != null) {
            NodoProceso nuevo_nodo = new NodoProceso();
            nuevo_nodo.proceso = proceso;
            nuevo_nodo.siguiente = null;

            if (colaVacia()) {
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
    }
       
    public Proceso getProcesoActual(){
        return inicioCola.proceso;
    }
    public void tamañoCola (){
         System.out.println("Numero de procesos en la cola: " + tamCola); 
    }
    
    //Método para mostrar el contenido de la cola
    public void MostrarContenido(){
        if(colaVacia()){
            System.out.println("Cola de procesos vacía :(");
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
            almacen1.proceso.updateStatus = UpdateStatus.INACTIVO.name();
            inicioCola = almacen1.siguiente;
            inicioCola.proceso.updateStatus = UpdateStatus.ACTIVO.name();
            almacen1.siguiente = null;
            finalCola.siguiente = almacen1;
            finalCola = almacen1;
        }        
    }
    
    public void ejecutarProcesoAct(Memoria memory){
        if(colaVacia()){
           System.out.println("Cola de procesos vacía :("); 
        }else{
            int instruccionesFaltantes = inicioCola.proceso.numInstrucciones -
                    inicioCola.proceso.numInstruccionesEjecutadas;
            if(instruccionesFaltantes > 5){
                inicioCola.proceso.numInstruccionesEjecutadas+=5;
                System.out.println(inicioCola.proceso);
                pasarSigProceso();
            }else{
                Proceso p = eliminarProceso(memory);
                p.numInstruccionesEjecutadas = p.numInstrucciones;
                System.out.println(p);
            }
        }
    }
    
    //Método para eliminar proceso terminado de la cola
    public Proceso eliminarProceso(Memoria memory){
        if (!colaVacia()) {
            Proceso p = inicioCola.proceso;
            
            if (inicioCola == finalCola) {
                inicioCola = null;
                finalCola = null;
            } else {
                inicioCola = inicioCola.siguiente;
                inicioCola.proceso.updateStatus = UpdateStatus.ACTIVO.name();
            }
             memory.liberarMemoria(p.base, p.cantMemoria);
            tamCola--;
            p.estado = Estado.TERMINADO.name();
            p.base = -1;
            listaProcesosEliminados.add(p);
            memory.ocupadas -= p.cantMemoria;
            return p;
        } else {
            return null;
        }
    }
    
   public void listaProcesosEliminados(){
       for(Proceso p: listaProcesosEliminados){
           System.out.println(p);
       }
   }
   
   public void actualizaBaseProceso(int pid, int desplazamiento){
        if(colaVacia()){
            System.out.println("Cola de procesos vacía :(");
        }else{
            NodoProceso recorrido = inicioCola;
            while (recorrido != null) {
                if(pid==recorrido.proceso.pid){
                    recorrido.proceso.base-=desplazamiento;
                    break;
                }
                recorrido = recorrido.siguiente;
            }
        }
   }
}
