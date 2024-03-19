package com.mycompany.rpg.Trabajo;

/**
 *
 * @author saien
 */
public class Guerrero extends Trabajo {
    boolean subioNivel =false;
    private String nombre;
    public Guerrero(){
        this.nombre = "Guerrero";
    }
    
    public void setsubioNivel(boolean subionivel){
        this.subioNivel = subionivel;
    }
    
    public boolean EstaActivo(){
      return (subioNivel) ? true:false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
