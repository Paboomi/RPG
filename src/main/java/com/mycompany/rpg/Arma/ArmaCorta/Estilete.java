package com.mycompany.rpg.Arma.ArmaCorta;

/**
 *
 * @author saien
 */
public class Estilete extends ArmaCorta{
    private final int aumentarVelocidad=10;
    
    public Estilete() {
        nombre = "Estilete";
    }
@Override
    public int AumentarVelocidad() {
        return aumentarVelocidad;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
