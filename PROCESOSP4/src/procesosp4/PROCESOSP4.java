/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesosp4;

public class PROCESOSP4 {
       
    public static void main(String[] args) {
        Memoria memoria = new Memoria(1024); 
        ColaProcesos colaP = new ColaProcesos();
        ListaLigada ligada = new ListaLigada();
        Menu menu1 = new Menu(memoria, colaP, ligada);
        menu1.menu();
        
    }
    
}
