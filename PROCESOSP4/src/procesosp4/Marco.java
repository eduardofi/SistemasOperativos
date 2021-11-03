
package procesosp4;

public class Marco {
    int localidadesMarco [];
    int pidP;
     public Marco(){
        this.localidadesMarco=new int [16];
    }
    public Marco(int pidP){
        this.pidP = pidP;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int x = 0; x < localidadesMarco.length; x++) {
            cadena = cadena + localidadesMarco[x] + " ";
        }
        return cadena;
    }

}
