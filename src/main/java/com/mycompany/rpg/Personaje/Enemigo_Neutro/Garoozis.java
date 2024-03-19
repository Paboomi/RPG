package com.mycompany.rpg.Personaje.Enemigo_Neutro;

/**
 *
 * @author saien
 */
public class Garoozis extends Enemigo_Neutro {

    private String nombre;

    public Garoozis(int nivel) {
        super(nivel);
        nombre = "Garoozis";
        generarEstadisticas();
    }
    private void generarEstadisticas(){
        switch (this.nivel) {
            case 10:
                this.fuerza = 15;
                this.defensa = 20;
                this.concentracion = 10;
                //this.espiritu = 15;
                this.PV = 100;
                break;
            case 20:
                this.fuerza = 20;
                this.defensa = 25;
                //this.concentracion = 30;
                this.espiritu = 20;
                this.PV = 110;
                break;
            case 30:
                this.fuerza = 25;
                this.defensa = 30;
                //this.concentracion = 35;
                this.espiritu = 20;
                this.PV = 110;
                break;
            case 40:
                this.fuerza = 30;
                this.defensa = 35;
                //this.concentracion = 40;
                this.espiritu = 25;
                this.PV = 125;
                break;
            case 50:
                this.fuerza = 35;
                this.defensa = 40;
                //this.concentracion = 50;
                this.espiritu = 30;
                this.PV = 130;
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
