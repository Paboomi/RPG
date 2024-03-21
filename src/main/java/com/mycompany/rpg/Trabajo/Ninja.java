package com.mycompany.rpg.Trabajo;

import com.mycompany.rpg.Arma.Arma;

/**
 *
 * @author saien
 */
public class Ninja extends Trabajo{
    
    Arma[] arma;
    boolean subioNivel = false;
   
    
    public Ninja(){
        this.nombre = "Ninja";
    }
    
    //Metodos para aumentar estadisticas
    @Override
    public double AumentarVelocidad(){
        return 0.35;
    }
    @Override
    public double DisminuirDefensa(){
        return 0.20;
    }
    
    //GETTERS Y SETTERS
    public void setsubioNivel(boolean subionivel) {
        this.subioNivel = subionivel;
    }

    public boolean EstaActivo() {
        return (subioNivel) ? true : false;
    }
    
    public int cantArmas(){
        return 2;
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
