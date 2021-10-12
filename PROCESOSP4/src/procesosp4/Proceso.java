
package procesosp4;

public class Proceso {
    String nomProceso = "";
    int cantMemoria = 0;
    int pid;//ID_proceso
    String estado = "";
    int numInstrucciones;
    public Proceso(){}
    public Proceso(String nomProceso, int cantMemoria){
        this.nomProceso = nomProceso;
        this.cantMemoria = cantMemoria;
        this.estado = Estado.NUEVO.name();
        this.numInstrucciones = (int) ((Math.random() * (30-10+1)+10));
    }
    
    static public Proceso crearProceso(String nombre, int cantMemoria, 
            int contador, Memoria memoria){
        boolean ban = memoria.verificarAlmacenamiento(cantMemoria);
        if(ban == true){
            System.out.println("Creando proceso ...");
            memoria.ocupadas +=cantMemoria;
            Proceso p1 = new Proceso(nombre, cantMemoria);
            p1.pid = contador;
            return p1;
        }else{
            System.err.println("Memoria llena, proceso "+ nombre 
                    + "no creado, es necesario ejecutar o matar otros procesos.");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Proceso - Nombre: " + this.nomProceso + " PID: "+ this.pid 
                +" Estado " + this.estado + " Cant. Memoria " + this.cantMemoria 
                + " Num. instrucciones: "+ this.numInstrucciones;
    }
    
}
