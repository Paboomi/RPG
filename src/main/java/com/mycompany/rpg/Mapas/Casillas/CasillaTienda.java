package com.mycompany.rpg.Mapas.Casillas;

/**
 *
 * @author saien
 */
public class CasillaTienda extends Casilla {
        
    public CasillaTienda(int id, String logo){
        super(id, logo);
    }
    
    public String mostrarLogo(){
        return this.getLogo();
    }
}
