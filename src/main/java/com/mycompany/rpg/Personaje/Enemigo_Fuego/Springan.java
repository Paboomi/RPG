package com.mycompany.rpg.Personaje.Enemigo_Fuego;
//import com.mycompany.rpg.Personaje.*;

/**
 *
 * @author saien
 */
public class Springan extends Enemigo_Fuego {

    //Es el que mas ataque fisico tiene
    private String nombre;

    public Springan(int nivel) {
        super(nivel);
        nombre = "Springan";
        generarEstadisticas();
    }

    private void generarEstadisticas() {
        switch (this.nivel) {
            case 10:
                this.fuerza = 15;
                this.defensa = 10;
                this.concentracion = 10;
                this.espiritu = 5;
                this.velocidad = 5;
                this.PV = 100;
                break;
            case 20:
                this.fuerza = 15;
                this.defensa = 10;
                this.concentracion = 10;
                this.espiritu = 5;
                this.velocidad =5;
                this.PV = 110;
                break;
            case 30:
                this.fuerza = 20;
                this.defensa = 15;
                this.concentracion = 10;
                this.espiritu = 10;
                this.velocidad = 10;
                this.PV = 120;
                break;
            case 40:
                this.fuerza = 25;
                this.defensa = 20;
                this.concentracion = 15;
                this.espiritu = 15;
                this.velocidad = 10;
                this.PV = 130;
                break;
            case 50:
                this.fuerza = 30;
                this.defensa = 25;
                this.concentracion = 20;
                this.espiritu = 15;
                this.velocidad = 15;
                this.PV = 135;
                break;
            default:
                System.out.println("nivel no disponible");
        }
    }

    //GETTERS Y SETTERS LOCALES
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

}
