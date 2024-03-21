package com.mycompany.rpg.Personaje.Enemigo_Neutro;

/**
 *
 * @author saien
 */
public class Lancero_Negro extends Enemigo_Neutro {
//Es el mas fuerte del tipo neutro
    private String nombre;

    public Lancero_Negro(int nivel) {
        super(nivel);
        nombre = "Lancero Negro";
        generarEstadisticas();
    }
    private void generarEstadisticas(){
        switch (this.nivel) {
            case 10:
                this.fuerza = 10;
                this.defensa = 15;
                this.espiritu = 10;
                this.PV = 100;
                break;
            case 20:
                this.fuerza = 15;
                this.defensa = 15;
                this.espiritu = 15;
                this.PV = 100;
                break;
            case 30:
                this.fuerza = 20;
                this.defensa = 20;
                this.espiritu = 15;
                this.PV = 120;
                break;
            case 40:
                this.fuerza = 25;
                this.defensa = 25;
                this.espiritu = 20;
                this.PV = 135;
                break;
            case 50:
                this.fuerza = 30;
                this.defensa = 30;
                this.espiritu = 25;
                this.PV = 140;
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

}
