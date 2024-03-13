package com.mycompany.rpg.Mapas.Casillas;

/**
 *
 * @author saien
 */
public class CasillaPosada extends Casilla{
        
    public CasillaPosada(int id, String logo){
        super(id, logo);
    }
    
    public String mostrarLogo(){
        return this.getLogo();
    }
}
