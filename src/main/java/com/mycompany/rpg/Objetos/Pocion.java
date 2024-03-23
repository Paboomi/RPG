package com.mycompany.rpg.Objetos;

/**
 *
 * @author saien
 */
public class Pocion extends Objeto{
    private int recuperarPV;
   
    
    public Pocion(){
        nombre = "Pocion";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
