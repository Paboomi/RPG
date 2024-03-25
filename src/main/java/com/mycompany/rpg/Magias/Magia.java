package com.mycompany.rpg.Magias;

/**
 *
 * @author saien
 */
public class Magia {
    
    protected String nombre;
    
    public int recuperarPV(){
        return 0;
    }
    
    public boolean revivirPersonaje(){
        return false;
    }
    
    public int aumentarEspiritu(){ 
        return 0;
    }
    
    public int aumentarDefensa(){
        return 0;
    }
    
    public int Damage(){
        return 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean PerderTurno() {
        return false;
    }
    
    public int generarTurnos(){
        return 0;
    }
    
}
