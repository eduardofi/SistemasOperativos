
package procesosp4;

public class Memoria {
    int []localidades;
    int numLocalidades;
    int ocupadas = 0;
    Marco tablaMarco [];
    int marcosDisponibles = 0;
    public Memoria(int numLocalidades){
        this.numLocalidades = numLocalidades;
        this.localidades = new int[numLocalidades];
        iniciarTablaMarcos();
        marcosDisponibles = 64;
    }
    public void iniciarTablaMarcos(){
        int inicioM = 0;
        this.tablaMarco = new Marco[numLocalidades/16];
        for(int j=0;j<64;j++) { 
            tablaMarco[j] = new Marco();
            for(int i=0;i<tablaMarco[j].localidadesMarco.length;i++){
                tablaMarco[j].localidadesMarco[i]=inicioM;
                inicioM++;
            }
        }
    }
    public void mostraTablaMarcos(){
         System.out.println("\t  Frame"  + "\t\t  Contents");
            for(int i=0; i<tablaMarco.length;i++){
                System.out.println("\t  " +(i) + "\t\t  " +tablaMarco[i].pidP );
            }
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

    public void ponerMemoriaMarco(int indiceMarco, int agregarValor) {
        tablaMarco[indiceMarco].pidP = agregarValor;
    }

    public void liberarMemoriaMarcos(Proceso p) {
        for(int i=0;i<p.tablaPagina.length;i++){
            ponerMemoriaMarco(p.tablaPagina[i], 0);
            marcosDisponibles++;
        }
        actualizarMemoria();
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
        public boolean verificarMarcosDisponibles(int cantPaginas){
        boolean bandera = false;
        if( marcosDisponibles >= cantPaginas){            
            bandera = true;
        }        
        return bandera;
    }

    public int calcVaciosMarcos(int inicio) {
        int marcosVacios = 0;
        for (int j = inicio; j < 64; j++) {
            if (tablaMarco[j].pidP == 0) {
                marcosVacios++;
            } else {
                break;
            }
        }
        return marcosVacios;
    }

    public int firstFitPaginas(Proceso proceso) {
        int bandera = -1;
        if (verificarMarcosDisponibles(proceso.tablaPagina.length)) {
            for (int j = 0; j < proceso.tablaPagina.length; j++) {
                for (int i = 0; i < 64; i++) {
                    if (tablaMarco[i].pidP == 0) {
                        tablaMarco[i].pidP = proceso.pid;
                        proceso.tablaPagina[j]=i;
                        marcosDisponibles--;
                        break;
                    }
                }
            }
            bandera =0;
        }

        actualizarMemoria();
        return bandera;
    }
    public void quitarHueco(ColaProcesos cola) {
        int limite = 0;
        int base = 0;
        //Encontrar el primer hueco
        for (int i = 0; i < tablaMarco.length; i++) { 
            if (tablaMarco[i].pidP == 0) {
                limite = calcVaciosMarcos(i);
                base = i;
                break;
            }
        }
        //Se hace el desplazamiento de lo que hay delante del hueco
        //siempre y cuando haya mas elementos adelante
        if ((base + limite)  < tablaMarco.length) {
            for (int j = base; j < tablaMarco.length; j++) {
                if (j + limite < tablaMarco.length) {
                    tablaMarco[j].pidP = tablaMarco[j+ limite].pidP;
                    if ((tablaMarco[j + limite].pidP != 0)
                            && (tablaMarco[j + limite].pidP != tablaMarco[j + limite + 1].pidP)) {
                        int pid = tablaMarco[j + limite].pidP;
                        cola.actualizaTablaPagProcesos(pid, limite);
                    }
                }
            }
            for (int j = tablaMarco.length - limite; j < tablaMarco.length; j++) {
                tablaMarco[j].pidP = 0;
            }
        }
        

    }
    
    public void desfragmentarMemoria(ColaProcesos cola){
        while(validarFragmentacion()){
            quitarHueco(cola);
        }
        actualizarMemoria();
    }
    
    public boolean validarFragmentacion(){
        int limite = 0;
        int base = 0;
        for(int i=0;i<tablaMarco.length;i++){
            if(tablaMarco[i].pidP==0){
                limite = calcVaciosMarcos(i);
                base = i;
                break;
            }
         }
         
        if ( (base + limite)  < tablaMarco.length) {
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
    
    public void actualizarMemoria(){
        for (Marco marco : tablaMarco) {
            for(int i : marco.localidadesMarco){
                localidades[i] = marco.pidP;
            }
        }
    }
    
}
