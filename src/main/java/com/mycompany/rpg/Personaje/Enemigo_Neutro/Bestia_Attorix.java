package com.mycompany.rpg.Personaje.Enemigo_Neutro;

/**
 *
 * @author saien
 */
public class Bestia_Attorix extends Enemigo_Neutro {

    private String nombre;
    private String logo = "\uD83D\uDC79";

    public Bestia_Attorix(int nivel) {
        super(nivel);
        nombre = "Bestia Attorix";
        generarEstadisticas();
    }

    private void generarEstadisticas() {
        switch (this.nivel) {
            case 10:
                this.fuerza = 10;
                this.defensa = 20;
                this.espiritu = 5;
                this.velocidad = 10;
                this.PV = 100;
                this.experiencia = 5;
                break;
            case 20:
                this.fuerza = 10;
                this.defensa = 25;
                this.espiritu = 10;
                this.velocidad = 10;
                this.PV = 110;
                this.experiencia = 10;
                break;
            case 30:
                this.fuerza = 20;
                this.defensa = 30;
                this.espiritu = 10;
                this.velocidad = 15;
                this.PV = 120;
                this.experiencia = 15;
                break;
            case 40:
                this.fuerza = 25;
                this.defensa = 35;
                this.espiritu = 15;
                this.velocidad = 15;
                this.PV = 135;
                this.experiencia = 20;
                break;
            case 50:
                this.fuerza = 30;
                this.defensa = 45;
                this.espiritu = 20;
                this.velocidad = 20;
                this.PV = 150;
                this.experiencia = 25;
                break;
            default:
                System.out.println("Nivel no disponible");
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
