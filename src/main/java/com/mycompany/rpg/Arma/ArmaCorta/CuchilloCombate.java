package com.mycompany.rpg.Arma.ArmaCorta;

/**
 *
 * @author saien
 */
public class CuchilloCombate extends ArmaCorta {

    private final int aumentarVelocidad = 20;

    public CuchilloCombate() {
        nombre = "Cuchillo de Combate";
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
