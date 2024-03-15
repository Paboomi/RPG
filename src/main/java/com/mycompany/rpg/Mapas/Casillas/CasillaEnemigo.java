package com.mycompany.rpg.Mapas.Casillas;

/**
 *
 * @author saien
 */
public class CasillaEnemigo extends Casilla{
    
    
    public CasillaEnemigo(int id, String logo) {
        super(id, logo);
    }

    public CasillaEnemigo() {

    }

    public String mostrarLogo() {
        return this.getLogo();
    }
    
}
