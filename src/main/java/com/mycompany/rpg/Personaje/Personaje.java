package com.mycompany.rpg.Personaje;

/**
 *
 * @author saien
 */
public class Personaje {

    protected int nivel;
    protected int fuerza;
    protected int defensa;
    protected int concentracion;
    protected int espiritu;
    protected int velocidad;
    protected int experiencia;
    protected int PV;
    protected String nombre;
    
    
    public Personaje(int nivel){
        this.nivel = nivel;
    }
    
    public Personaje(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(int concentracion) {
        this.concentracion = concentracion;
    }

    public int getEspiritu() {
        return espiritu;
    }

    public void setEspiritu(int espiritu) {
        this.espiritu = espiritu;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }
            
    
}
