/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesosp4;

public class PROCESOSP4 {
       
    public static void main(String[] args) {
        Memoria memoria = new Memoria(2048); 
        ColaProcesos colaP = new ColaProcesos();
        Menu menu1 = new Menu(memoria, colaP);
       
        menu1.menu();
    }
    
}
