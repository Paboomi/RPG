package com.mycompany.rpg.Personaje.Enemigo_Neutro;

/**
 *
 * @author saien
 */
public class Garoozis extends Enemigo_Neutro {

    private String nombre;
    private String logo = "\uD83D\uDC79";

    public Garoozis(int nivel) {
        super(nivel);
        nombre = "Garoozis";
        generarEstadisticas();
    }

    private void generarEstadisticas() {
        switch (this.nivel) {
            case 10:
                this.fuerza = 10;
                this.defensa = 10;
                this.espiritu = 10;
                this.velocidad = 5;
                this.PV = 100;
                this.experiencia = 5;
                break;
            case 20:
                this.fuerza = 10;
                this.defensa = 15;
                this.espiritu = 10;
                this.velocidad = 10;
                this.PV = 110;
                this.experiencia = 15;
                break;
            case 30:
                this.fuerza = 20;
                this.defensa = 15;
                this.espiritu = 15;
                this.velocidad = 10;
                this.PV = 110;
                this.experiencia = 15;
                break;
            case 40:
                this.fuerza = 25;
                this.defensa = 20;
                this.espiritu = 25;
                this.velocidad = 15;
                this.PV = 125;
                this.experiencia = 20;
                break;
            case 50:
                this.fuerza = 30;
                this.defensa = 25;
                this.espiritu = 30;
                this.velocidad = 20;
                this.PV = 130;
                this.experiencia = 20;
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
    public String toString() {
        return logo +" "+nombre+" "+ logo + "\n"
                + "Nivel: " + nivel + "\n"
                + "PV: " + PV + "\n"
                + "Fuerza: " + fuerza + "\n"
                + "Defensa: " + defensa + "\n"
                + "Espíritu: " + espiritu + "\n";
    }
}
