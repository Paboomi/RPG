package com.mycompany.rpg.Objetos;

/**
 *
 * @author saien
 */
public class PocionMayor extends Objeto{
    private int recuperarPV;
    private String nombre;
    
    public PocionMayor(){
        nombre="Pocion Mayor";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
