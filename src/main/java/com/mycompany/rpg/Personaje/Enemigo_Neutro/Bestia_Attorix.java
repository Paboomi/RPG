package com.mycompany.rpg.Personaje.Enemigo_Neutro;

/**
 *
 * @author saien
 */
public class Bestia_Attorix extends Enemigo_Neutro {
    private String nombre;

    public Bestia_Attorix(int nivel) {
        super(nivel);
        nombre = "Bestia Attorix";
        generarEstadisticas();
    }
    
    private void generarEstadisticas() {
        switch (this.nivel) {
            case 10:
                this.fuerza = 10;
                this.defensa = 10;
                this.espiritu = 5;
                this.PV = 100;
                break;
            case 20:
                this.fuerza = 10;
                this.defensa = 15;
                this.espiritu = 10;
                this.PV = 110;
                break;
            case 30:
                this.fuerza = 15;
                this.defensa = 15;
                this.espiritu = 10;
                this.PV = 120;
                break;
            case 40:
                this.fuerza = 20;
                this.defensa = 20;
                this.espiritu = 15;
                this.PV = 125;
                break;
            case 50:
                this.fuerza = 20;
                this.defensa = 25;
                this.espiritu = 20;
                this.PV = 130;
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

}
