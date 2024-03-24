package com.mycompany.rpg.Arma.ArmaUnaMano;

/**
 *
 * @author saien
 */
public class Hacha extends ArmaUnaMano{
    private final int aumentarFuerza = 10;
    
    public Hacha() {
        nombre = "Hacha";
    }
@Override
    public int AumentarFuerza(){
        return aumentarFuerza;
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
