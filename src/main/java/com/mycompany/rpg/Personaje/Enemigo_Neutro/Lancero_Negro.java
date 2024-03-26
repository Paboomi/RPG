package com.mycompany.rpg.Personaje.Enemigo_Neutro;

/**
 *
 * @author saien
 */
public class Lancero_Negro extends Enemigo_Neutro {
//Es el mas fuerte del tipo neutro

    private String nombre;
    private String logo = "\uD83D\uDC79";

    public Lancero_Negro(int nivel) {
        super(nivel);
        nombre = "Lancero Negro";
        generarEstadisticas();
    }

    private void generarEstadisticas() {
        switch (this.nivel) {
            case 10:
                this.fuerza = 15;
                this.defensa = 15;
                this.espiritu = 10;
                this.velocidad = 5;
                this.PV = 100;
                this.experiencia = 5;
                break;
            case 20:
                this.fuerza = 25;
                this.defensa = 25;
                this.espiritu = 15;
                this.velocidad = 10;
                this.PV = 110;
                this.experiencia = 5;
                break;
            case 30:
                this.fuerza = 30;
                this.defensa = 35;
                this.espiritu = 15;
                this.velocidad = 15;
                this.PV = 130;
                this.experiencia = 15;
                break;
            case 40:
                this.fuerza = 45;
                this.defensa = 40;
                this.espiritu = 25;
                this.velocidad = 20;
                this.PV = 145;
                this.experiencia = 20;
                break;
            case 50:
                this.fuerza = 50;
                this.defensa = 50;
                this.espiritu = 35;
                this.velocidad = 25;
                this.PV = 150;
                this.experiencia = 25;
                break;
            default:
                throw new AssertionError();
        }
    }

    //GETTERS Y SETTERS
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

    @Override
    public int getExperiencia() {
        return experiencia;
    }

    @Override
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return logo +" "+nombre+" "+ logo + "\n"
                + "Nivel: " + nivel + "\n"
                + "PV: " + PV + "\n"
                + "Fuerza: " + fuerza + "\n"
                + "Defensa: " + defensa + "\n"
                + "Espíritu: " + espiritu + "\n";
    }
}
