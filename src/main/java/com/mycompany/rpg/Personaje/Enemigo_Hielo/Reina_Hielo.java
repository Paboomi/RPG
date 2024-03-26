package com.mycompany.rpg.Personaje.Enemigo_Hielo;

/**
 *
 * @author saien
 */
public class Reina_Hielo extends Enemigo_Hielo {
//Es la mas equilibrida de los enemigos de tipo hielo y es la mas fuerte

    private String nombre;
    private String logo = "\uD83D\uDC79";

    public Reina_Hielo(int nivel) {
        super(nivel);
        nombre = "Reina Hielo";
        generarEstadisticas();
    }

    private void generarEstadisticas() {
        switch (this.nivel) {
            case 10:
                this.fuerza = 10;
                this.defensa = 10;
                this.concentracion = 20;
                this.espiritu = 15;
                this.velocidad = 5;
                this.PV = 100;
                this.experiencia = 5;
                break;
            case 20:
                this.fuerza = 20;
                this.defensa = 25;
                this.concentracion = 25;
                this.espiritu = 20;
                this.velocidad = 10;
                this.PV = 110;
                this.experiencia = 10;
                break;
            case 30:
                this.fuerza = 35;
                this.defensa = 30;
                this.concentracion = 25;
                this.espiritu = 30;
                this.velocidad = 15;
                this.PV = 130;
                this.experiencia = 20;
                break;
            case 40:
                this.fuerza = 45;
                this.defensa = 35;
                this.concentracion = 30;
                this.espiritu = 35;
                this.velocidad = 20;
                this.PV = 145;
                this.experiencia = 25;
                break;
            case 50:
                this.fuerza = 55;
                this.defensa = 45;
                this.concentracion = 35;
                this.espiritu = 40;
                this.velocidad = 25;
                this.PV = 150;
                this.experiencia = 30;
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
                + "Concentración: " + concentracion + "\n"
                + "Espíritu: " + espiritu + "\n";
    }

}
