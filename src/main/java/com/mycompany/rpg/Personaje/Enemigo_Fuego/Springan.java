package com.mycompany.rpg.Personaje.Enemigo_Fuego;
//import com.mycompany.rpg.Personaje.*;

/**
 *
 * @author saien
 */
public class Springan extends Enemigo_Fuego {

    private String nombre;
    private String logo = "\uD83D\uDC79";

    public Springan(int nivel) {
        super(nivel);
        nombre = "Springan";
        generarEstadisticas();
    }

    private void generarEstadisticas() {
        switch (this.nivel) {
            case 10:
                this.fuerza = 25;
                this.defensa = 20;
                this.concentracion = 10;
                this.espiritu = 15;
                this.velocidad = 5;
                this.PV = 100;
                this.experiencia = 25;
                break;
            case 20:
                this.fuerza = 35;
                this.defensa = 30;
                this.concentracion = 10;
                this.espiritu = 25;
                this.velocidad = 5;
                this.PV = 110;
                this.experiencia = 35;
                break;
            case 30:
                this.fuerza = 40;
                this.defensa = 35;
                this.concentracion = 10;
                this.espiritu = 30;
                this.velocidad = 10;
                this.PV = 120;
                this.experiencia = 35;
                break;
            case 40:
                this.fuerza = 55;
                this.defensa = 40;
                this.concentracion = 15;
                this.espiritu = 35;
                this.velocidad = 10;
                this.PV = 130;
                this.experiencia = 45;
                break;
            case 50:
                this.fuerza = 60;
                this.defensa = 45;
                this.concentracion = 20;
                this.espiritu = 35;
                this.velocidad = 15;
                this.PV = 135;
                this.experiencia = 55;
                break;
            default:
                System.out.println("nivel no disponible");
        }
    }

    //GETTERS Y SETTERS LOCALES

    @Override
    public int getExperiencia() {
        return experiencia;
    }

    @Override
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    //GETTERS Y SETTERS GLOBALES
    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return logo +" "+nombre+" "+ logo + "\n"
                + "Nivel: " + nivel + "\n"
                + "PV: " + PV + "\n"
                + "Fuerza: " + fuerza + "\n"
                + "Defensa: " + defensa + "\n"
                + "Concentración: " + concentracion + "\n"
                + "Espíritu: " + espiritu + "\n";
    }

}
