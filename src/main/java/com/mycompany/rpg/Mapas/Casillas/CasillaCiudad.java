package com.mycompany.rpg.Mapas.Casillas;

/**
 *
 * @author saien
 */
public class CasillaCiudad extends Casilla {
    
    public CasillaCiudad(int id, String logo){
        super(id, logo);
    }
    
    public String mostrarLogo(){
        return this.getLogo();
    }
}
