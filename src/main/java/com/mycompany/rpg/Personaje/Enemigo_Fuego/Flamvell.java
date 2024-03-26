package com.mycompany.rpg.Personaje.Enemigo_Fuego;

/**
 *
 * @author saien
 */
public class Flamvell extends Enemigo_Fuego {

    //El ataque fisico de Flamvell es menor que su ataque magico
    private String nombre;
    private String logo = "\uD83D\uDC79";

    public Flamvell(int nivel) {
        super(nivel);
        nombre = "Flamvell";
        generarEstadisticas();
    }

    private void generarEstadisticas() {
        switch (this.nivel) {
            case 10:
                this.fuerza = 10;
                this.defensa = 10;
                this.concentracion = 15;
                this.espiritu = 10;
                this.velocidad = 5;
                this.PV = 100;
                break;
            case 20:
                this.fuerza = 10;
                this.defensa = 15;
                this.concentracion = 15;
                this.espiritu = 15;
                this.velocidad = 10;
                this.PV = 110;
                break;
            case 30:
                this.fuerza = 15;
                this.defensa = 15;
                this.concentracion = 20;
                this.espiritu = 15;
                this.velocidad = 15;
                this.PV = 110;
                break;
            case 40:
                this.fuerza = 20;
                this.defensa = 20;
                this.concentracion = 20;
                this.espiritu = 20;
                this.velocidad = 20;
                this.PV = 125;
                break;
            case 50:
                this.fuerza = 25;
                this.defensa = 30;
                this.concentracion = 25;
                this.espiritu = 25;
                this.velocidad = 25;
                this.PV = 130;
                break;
            default:
                throw new AssertionError();
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

//Getters y Setters globales
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
