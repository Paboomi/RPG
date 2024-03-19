package com.mycompany.rpg.Trabajo;

/**
 *
 * @author saien
 */
public class Paladin extends Trabajo{

    boolean subioNivel = false;
    private String nombre;
    
    public Paladin(){
        this.nombre = "Paladin";
    }

    public void setsubioNivel(boolean subionivel) {
        this.subioNivel = subionivel;
    }

    public boolean EstaActivo() {
        return (subioNivel) ? true : false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
