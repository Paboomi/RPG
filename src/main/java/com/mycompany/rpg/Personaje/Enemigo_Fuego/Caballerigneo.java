package com.mycompany.rpg.Personaje.Enemigo_Fuego;

/**
 *
 * @author saien
 */
public class Caballerigneo extends Enemigo_Fuego {

//El ataque fisico de Caballerigneo es mayor que su ataque magico 
    private String nombre;

    //Constructor
    public Caballerigneo(int nivel) {
        super(nivel);
        nombre = "Caballerigneo";
        generarEstadisticas();
    }

    private void generarEstadisticas() {
        switch (this.nivel) {
            case 10:
                this.fuerza = 10;
                this.defensa = 10;
                this.concentracion = 15;
                this.espiritu = 5;
                this.PV = 100;
                break;
            case 20:
                this.fuerza = 15;
                this.defensa = 10;
                this.concentracion = 15;
                this.espiritu = 5;
                this.PV = 110;
                break;
            case 30:
                this.fuerza = 20;
                this.defensa = 15;
                this.concentracion = 15;
                this.espiritu = 10;
                this.PV = 120;
                break;
            case 40:
                this.fuerza = 20;
                this.defensa = 20;
                this.concentracion = 15;
                this.espiritu = 10;
                this.PV = 135;
                break;
            case 50:
                this.fuerza = 25;
                this.defensa = 25;
                this.concentracion = 20;
                this.espiritu = 15;
                this.PV = 150;
                break;
            default:
                throw new AssertionError();
        }
    }

    //Getters y Setters locales
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

    /**
     *
     *
     * SEPARADOR
     *
     *
     *
     *
     */
    //Getters y Setters globales
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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
