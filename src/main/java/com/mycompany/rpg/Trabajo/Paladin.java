package com.mycompany.rpg.Trabajo;

import com.mycompany.rpg.Arma.Arma;

/**
 *
 * @author saien
 */
public class Paladin extends Trabajo{

    Arma[] armas;
    boolean subioNivel = false;
    
    
    public Paladin(){
        this.nombre = "Paladin";
    }
//METODOS PARA CAMBIAR ESTADISTICAS
    
    @Override
    public double AumentarDefensa(){
        return 0.25;
    }
    @Override
    public double AumentarPV(){
        return 0.15;
    }
    
    //GETTERS Y SETTERS
    public void setsubioNivel(boolean subionivel) {
        this.subioNivel = subionivel;
    }

    public boolean EstaActivo() {
        return (subioNivel) ? true : false;
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
