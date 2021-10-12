/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package procesosp4;

/**
 *
 * @author eduardo
 */
public interface Encolable {
    public boolean estaVacia();
    public void vaciar();
    public int tamanio();
    public void agregar(Object dato);
    public void eliminar();
    public Object tomar();
    public java.util.Iterator iterator();
}
