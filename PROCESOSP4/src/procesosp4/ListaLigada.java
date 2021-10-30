
package procesosp4;

public class ListaLigada {
    
    private NodoLista inicioLista, finLista;
    String Lista = "";
    int tamLista = 0;
    
    public ListaLigada(){
        inicioLista = null;
        finLista = null;
    }
    
    public void actualizarListaLigada(Memoria memoria){
        borrarListaLigada();
        int array[] = memoria.localidades;
        int inicio = 0;
        while (inicio<memoria.numLocalidades) {
            if(array[inicio]!=0){
                int limite = memoria.calcContenido(inicio);
                insertarNodo("P"+ array[inicio], inicio, limite);
                inicio +=limite;
            }else{
                 int limite = memoria.calcVacios(inicio);
                 insertarNodo("H", inicio, limite);
                inicio+=limite;
            }
        }
    }
    
     public boolean listaVacia(){
        return inicioLista == null;
    }
         //Método para insertar a la cola
    public void insertarNodo(String P_H, int base, int limite){
        NodoLista nuevo_nodo = new NodoLista(P_H,base, limite);
        nuevo_nodo.siguiente = null;
        
        if (listaVacia()) {
            inicioLista = nuevo_nodo;
            finLista = nuevo_nodo;
        } else {
            //finLista.siguiente = nuevo_nodo;
            inicioLista.siguiente = nuevo_nodo;
            inicioLista  = nuevo_nodo;
            //finLista  = nuevo_nodo;
        }
    }
        //Método para mostrar el contenido de la Lista ligada
    public void MostrarContenido(){
        
            NodoLista recorrido = finLista;

            while (recorrido != null) {
                Lista += recorrido.toString();
                recorrido = recorrido.siguiente;
            }
            System.out.println(Lista + "null");
            Lista = "";
       
    }
    
    public void borrarListaLigada(){
        inicioLista = null;
        finLista = null;
        
    }
}

