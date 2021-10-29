
package procesosp4;

public class NodoLista {
    char pro_hueco;
    int basePH, limitePH;
    NodoLista siguiente;

    public NodoLista(char pro_hueco, int basePH, int limitePH) {
        this.pro_hueco=pro_hueco;
        this.basePH=basePH;
        this.limitePH=limitePH;
    }

    @Override
    public String toString() {
        return "[" +pro_hueco + "] [" + basePH + "] ["  + limitePH  +"] ---> ";
    }
   
}
