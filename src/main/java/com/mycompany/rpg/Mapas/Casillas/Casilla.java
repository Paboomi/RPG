package com.mycompany.rpg.Mapas.Casillas;

/**
 *
 * @author saien
 */
public class Casilla {

    private int id;
    private String logo;

    public Casilla(int id, String logo) {
        this.id = id;
        this.logo = logo;
    }
    
    public Casilla(){
        
    }

    public String ImprimirLogo() {
        return this.logo;
    }

    public int getId() {
        return id;
    }

    public String getLogo() {

        return logo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
