package com.mycompany.rpg.Trabajo;

/**
 *
 * @author saien
 */
public class Ninja extends Trabajo{

    boolean subioNivel = false;
    private String nombre;
    
    public Ninja(){
        this.nombre = "Ninja";
    }

    public void setsubioNivel(boolean subionivel) {
        this.subioNivel = subionivel;
    }

    public boolean EstaActivo() {
        return (subioNivel) ? true : false;
    }
    
    public int cantArmas(){
        return 2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
