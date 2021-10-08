
package procesosp4;

public class Proceso {
    String nomProceso = "";
    int cantMemoria = 0;
    static int memoria = 2048;
    int pid;//ID_proceso
    String estado = "";
    public Proceso(){}
    public Proceso(String nomProceso, int cantMemoria){
        this.nomProceso = nomProceso;
        this.cantMemoria = cantMemoria;
        this.estado = "nuevo";
    }
    public boolean verificarAlmacenamiento(int memoria){
        boolean bandera = false;
        if(memoria > cantMemoria){
            bandera = true;
        }
        return bandera;
        }
    public Proceso crearProceso(String nombre, int cantMemoria, int contador){
        boolean ban = verificarAlmacenamiento(this.memoria);
        if(ban == true){
            System.err.println("Creando proceso");
            this.memoria -=cantMemoria;
            Proceso p1 = new Proceso(nombre, cantMemoria);
            p1.pid = contador;
            return p1;
        }else{
            System.err.println("Memoria llena, proceso "+ nombre + "no creado, es necesario ejecutar o matar otros procesos.");
        }
        return null;
    }
    
}
