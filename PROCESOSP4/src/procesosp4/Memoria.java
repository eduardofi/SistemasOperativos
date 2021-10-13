
package procesosp4;

public class Memoria {
    int []localidades;
    int numLocalidades;
    int ocupadas = 0;
    
    public Memoria(int numLocalidades){
        this.numLocalidades = numLocalidades;
        this.localidades = new int[numLocalidades];
    }
    
    public void tablaLocalidades(){
        if(ocupadas == 0){
            System.out.println("La tabla de memoria está vacía...");
            System.out.println("\t Localidad \t Proceso");
            for(int i=0; i<numLocalidades;i++){
                System.out.println("\t  " +(i) + "\t\t  " +localidades[i] );
            }
        }else{
            System.out.println("\t Localidad \t Proceso");
            for(int i=0; i<numLocalidades;i++){
                System.out.println("\t  " +(i) + "\t\t " +localidades[i] );
            }
        }
    }
    public int calcVacios(int inicio) {
        int localidadesVacias = 0;
        for (int j = inicio; j < numLocalidades; j++) {
            if (localidades[j] == 0) {
                localidadesVacias++;
            } else {
                break;
            }
        }
        return localidadesVacias;
        }
    
    public boolean firstFit(int cantMemoria, int pid) {
        boolean bandera = false;
        int inicio = 0;
        while (inicio < numLocalidades) {
            if (localidades[inicio] == 0) {
                int localidadesVacias = calcVacios(inicio);
                if (localidadesVacias >= cantMemoria) {
                    System.out.println("Base: " +inicio +" Cant. memoria" 
                            + cantMemoria +" Limite"
                            + (inicio + cantMemoria));
                    for (int k = inicio; k <inicio + cantMemoria; k++) {
                        localidades[k] = pid;
                        
                    }
                    bandera = true;
                    return bandera;
                }else{
                    
                    inicio += (localidadesVacias+2);
                    //inicio++;
                }
            }else{
                inicio++;
            }
        }
        return bandera;
    }
    
    public int getLocalDesoc(){
        return this.numLocalidades - this.ocupadas;
    }
    
    /*public boolean verificarAlmacenamiento(int cantMemoria){
        boolean bandera = false;
        int deso = this.getLocalDesoc();
        if( deso > cantMemoria){            
            bandera = true;
        }
        return bandera;
    }*/
    
    @Override
    public String toString() {
        return "Memoria - Num. localidades " + this.numLocalidades 
                + " Local. ocupadas: "+ this.ocupadas +" Desocupadas " 
                + this.getLocalDesoc();
    }
}
