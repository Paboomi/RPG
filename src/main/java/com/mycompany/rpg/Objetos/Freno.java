package com.mycompany.rpg.Objetos;

/**
 *
 * @author saien
 */
public class Freno extends Objeto{
    private int disminuirVelocidad;
   
    
    public Freno(){
        nombre="Freno";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
