
package procesosp4;

public class Memoria {
    int localidades[];
    int numLocalidades;
    int ocupadas = 0;
    
    public Memoria(int localidades){
        this.numLocalidades = localidades;
    }
    
    public int getLocalDesoc(){
        return this.numLocalidades - this.ocupadas;
    }
    
    public boolean verificarAlmacenamiento(int cantMemoria){
        boolean bandera = false;
        int deso = this.getLocalDesoc();
        if( deso > cantMemoria){            
            bandera = true;
        }
        return bandera;
    }
    
    @Override
    public String toString() {
        return "Memoria - Num. localidades " + this.numLocalidades 
                + " Local. ocupadas: "+ this.ocupadas +" Desocupadas " 
                + this.getLocalDesoc();
    }
}
