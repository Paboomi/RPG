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
                this.fuerza = 25;
                this.defensa = 30;
                //this.concentracion = 25;
                this.espiritu = 15;
                this.PV = 100;
                break;
            case 20:
                this.fuerza = 30;
                this.defensa = 35;
                //this.concentracion = 30;
                this.espiritu = 20;
                this.PV = 120;
                break;
            case 30:
                this.fuerza = 35;
                this.defensa = 40;
                //this.concentracion = 35;
                this.espiritu = 25;
                this.PV = 130;
                break;
            case 40:
                this.fuerza = 45;
                this.defensa = 45;
                //this.concentracion = 40;
                this.espiritu = 30;
                this.PV = 135;
                break;
            case 50:
                this.fuerza = 55;
                this.defensa = 50;
                //this.concentracion = 50;
                this.espiritu = 35;
                this.PV = 150;
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
