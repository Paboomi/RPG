package com.mycompany.rpg.Objetos;

/**
 *
 * @author saien
 */
public class Objeto {
    private int cantidad;
    private String nombre;
    
    public int recuperarPV(){
        return 0;
    }
    
    public int aumentarVelocidad(){
        return 0;
    }
    
    public int disminuirVelocidad(){
        return 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
