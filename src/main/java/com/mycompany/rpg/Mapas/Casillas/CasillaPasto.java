package com.mycompany.rpg.Mapas.Casillas;

/**
 *
 * @author saien
 */
public class CasillaPasto extends Casilla {

    public CasillaPasto(int id, String logo) {
        super(id, logo);
    }

    public CasillaPasto() {

    }

    public String mostrarLogo() {
        return this.getLogo();
    }
}
