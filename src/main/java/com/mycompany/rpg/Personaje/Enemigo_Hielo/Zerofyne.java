package com.mycompany.rpg.Personaje.Enemigo_Hielo;

/**
 *
 * @author saien
 */
public class Zerofyne extends Enemigo_Hielo {
//Es debil respecto a ataque fisico y resistencia pero fuerte en el uso de las magias

    private String nombre;
    private String logo = "\uD83D\uDC79";

    public Zerofyne(int nivel) {
        super(nivel);
        nombre = "Zerofyne";
        generarEstadisticas();
    }

    private void generarEstadisticas() {
        switch (this.nivel) {
            case 10:
                this.fuerza = 10;
                this.defensa = 10;
                this.concentracion = 15;
                this.espiritu = 15;
                this.velocidad = 10;
                this.PV = 100;
                this.experiencia = 5;
                break;
            case 20:
                this.fuerza = 15;
                this.defensa = 20;
                this.concentracion = 25;
                this.espiritu = 20;
                this.velocidad = 10;
                this.PV = 110;
                this.experiencia = 10;
                break;
            case 30:
                this.fuerza = 20;
                this.defensa = 25;
                this.concentracion = 25;
                this.espiritu = 20;
                this.velocidad = 15;
                this.PV = 120;
                this.experiencia = 15;
                break;
            case 40:
                this.fuerza = 30;
                this.defensa = 35;
                this.concentracion = 30;
                this.espiritu = 25;
                this.velocidad = 15;
                this.PV = 125;
                this.experiencia = 20;
                break;
            case 50:
                this.fuerza = 35;
                this.defensa = 40;
                this.concentracion = 35;
                this.espiritu = 35;
                this.velocidad = 20;
                this.PV = 130;
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
