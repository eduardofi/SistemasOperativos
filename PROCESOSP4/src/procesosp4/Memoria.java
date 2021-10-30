
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
    
        public int calcContenido(int inicio) {
        int localidadesProceso = 0;
        for (int j = inicio; j < numLocalidades; j++) {
            if (localidades[j] == localidades[inicio]) {
                localidadesProceso++;
            } else {
                break;
            }
        }
        return localidadesProceso;
        }
    
    public int firstFit(int cantMemoria, int pid) {
        int bandera = -1;
        if (verificarAlmacenamiento(cantMemoria)) {
            int inicio = 0;
            while (inicio < numLocalidades) {
                if (localidades[inicio] == 0) {
                    int localidadesVacias = calcVacios(inicio);
                    if (localidadesVacias >= cantMemoria) {
                        System.out.println("Base: " + inicio + " Cant. memoria"
                                + cantMemoria + " Limite"
                                + (inicio + cantMemoria));
                        ponerMemoria(inicio, cantMemoria, pid);
                        bandera = inicio;
                        return bandera;
                    } else {

                        inicio += (localidadesVacias + 2);
                    }
                } else {
                    inicio++;
                }
            }
        }
        
        System.out.println(bandera);
        return bandera;
    }
    public void ponerMemoria(int base, int limite, int agregarValor) {
        for (int k = base; k < base + limite; k++) {
            localidades[k] = agregarValor;
        }
    }
    public void liberarMemoria(int base, int limite) {
        ponerMemoria(base, limite, 0);
    }
    public int getLocalDesoc(){
        return this.numLocalidades - this.ocupadas;
    }
    
    public boolean verificarAlmacenamiento(int cantMemoria){
        boolean bandera = false;
        int deso = this.getLocalDesoc();
        if( deso >= cantMemoria){            
            bandera = true;
        }
        return bandera;
    }
    public void quitarHueco(ColaProcesos cola) {
        int limite = 0;
        int base = 0;
        for (int i = 0; i < numLocalidades; i++) {
            if (localidades[i] == 0) {
                limite = calcVacios(i);
                base = i;
                break;
            }
        }
        if ((base + limite)  < numLocalidades) {
            for (int j = base; j < numLocalidades; j++) {
                if (j + limite < numLocalidades) {
                    localidades[j] = localidades[j + limite];
                    if ((localidades[j + limite] != 0) && (localidades[j + limite] != localidades[j + limite + 1])) {
                        int pid = localidades[j + limite];
                        cola.actualizaBaseProceso(pid, limite);
                    }
                }
            }
            for (int j = numLocalidades - limite; j < numLocalidades; j++) {
                localidades[j] = 0;
            }
        }
        

    }
    
    public void desfragmentarMemoria(ColaProcesos cola){
        while(validarFragmentacion()){
            quitarHueco(cola);
        }
    }
    
    public boolean validarFragmentacion(){
        int limite = 0;
        int base = 0;
        for(int i=0;i<numLocalidades;i++){
            if(localidades[i]==0){
                limite = calcVacios(i);
                base = i;
                break;
            }
         }
         
        if ( (base + limite)  < numLocalidades) {
            return true;
        } else {
            return false;
        }
    }   

    @Override
    public String toString() {
        return "Memoria - Num. localidades " + this.numLocalidades 
                + " Local. ocupadas: "+ this.ocupadas +" Desocupadas " 
                + this.getLocalDesoc();
    }
}
