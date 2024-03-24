package com.mycompany.rpg.Arma.ArmaDosManos;

/**
 *
 * @author saien
 */
public class EspadaLarga extends ArmaDosManos {

    private final int aumentarFuerza = 30;
    private final int disminuirVelocidad = 20;

    public EspadaLarga() {
        nombre = "Espada Larga";
    }

    @Override
    public int DisminuirVelocidad() {
        return disminuirVelocidad;
    }

    @Override
    public int AumentarFuerza() {
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
