package com.mycompany.rpg.Trabajo;

/**
 *
 * @author saien
 */
public class Mago_Oscuro extends Trabajo{

    boolean subioNivel = false;
    private String nombre;
    public Mago_Oscuro(){
        this.nombre = "Mago Oscuro";
    }

    public void setsubioNivel(boolean subionivel) {
        this.subioNivel = subionivel;
    }

    public boolean EstaActivo() {
        return (subioNivel) ? true : false;
    }
    
    public int cantArmas(){
        return 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
