package com.mycompany.rpg.Trabajo;

/**
 *
 * @author saien
 */
public class Mago_Blanco extends Trabajo{

    boolean subioNivel = false;
    private String nombre;
    
    public Mago_Blanco(){
        this.nombre = "Mago Blanco";
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
