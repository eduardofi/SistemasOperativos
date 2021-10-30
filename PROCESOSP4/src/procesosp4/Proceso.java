
package procesosp4;

public class Proceso {
    String nomProceso = "";
    int cantMemoria = 0;
    int pid;
    String estado = "";
    int numInstrucciones;
    int numInstruccionesEjecutadas=0;
    String updateStatus;
    int base;
    public Proceso(){}
    public Proceso(String nomProceso, int cantMemoria){
        this.nomProceso = nomProceso;
        this.cantMemoria = cantMemoria;
        this.estado = Estado.NUEVO.name();
        this.numInstrucciones = (int) ((Math.random() * (30-10+1)+10));
    }
    
    static public Proceso crearProceso(String nombre, int cantMemoria, 
        int contador, Memoria memoria){
        System.out.println("cant. memoria: "+cantMemoria);
        int ban = memoria.firstFit(cantMemoria, contador);
        if(ban != -1){
            System.out.println("Creando proceso ...");
            memoria.ocupadas +=cantMemoria;
            Proceso p1 = new Proceso(nombre, cantMemoria);
            p1.base=ban;
            p1.pid = contador;
            return p1;
        }else{
            System.out.println("Memoria llena, proceso "+ nombre 
                    + "no creado, es necesario ejecutar o matar otros"
                    + " procesos.");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Proceso - Nombre: " + this.nomProceso + " PID: "+ this.pid 
                +" Estado " + this.estado + " Cant. Memoria "
                + this.cantMemoria 
                + " Num. instrucciones: "+ this.numInstrucciones 
                + " Nun. instrucciones ejecutadas: "
                + this.numInstruccionesEjecutadas + " Base: " +base;
    }
    
}
