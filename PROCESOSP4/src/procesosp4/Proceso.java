
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
    int tablaPagina [];
    public Proceso(){}
    public Proceso(String nomProceso, int cantMemoria){
        this.nomProceso = nomProceso;
        this.cantMemoria = cantMemoria;
        this.estado = Estado.NUEVO.name();
        this.numInstrucciones = (int) ((Math.random() * (30-10+1)+10));
        this.tablaPagina = new int[cantMemoria/16];
    }
    
    static public Proceso crearProceso(String nombre, int cantMemoria, 
        int contador, Memoria memoria){
        System.out.println("contador: "+contador);
        Proceso p = new Proceso(nombre, cantMemoria);
        System.out.println("cant. memoria: "+cantMemoria);
         p.pid = contador;
        int ban = memoria.firstFitPaginas(p);
        if(ban != -1){
            System.out.println("Creando proceso ...");
            memoria.ocupadas +=cantMemoria;
            p.base=ban;
            return p;
        }else{
            System.out.println("Memoria llena, proceso "+ nombre 
                    + "no creado, es necesario ejecutar o matar otros"
                    + " procesos.");
        }
        return null;
    }
    
    public void mostrarTablaPaginas() {
        System.out.println("\t Page \t Frame");
        for (int i = 0; i < tablaPagina.length; i++) {
            System.out.println("\t  " + (i) + "\t\t  " + tablaPagina[i]);
        }
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
