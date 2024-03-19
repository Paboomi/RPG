package com.mycompany.rpg.Personaje.Enemigo_Hielo;

/**
 *
 * @author saien
 */
public class Reina_Hielo extends Enemigo_Hielo {
//Es la mas equilibrida de los enemigos de tipo hielo y es la mas fuerte
    private String nombre;

    public Reina_Hielo(int nivel) {
        super(nivel);
        nombre = "Reina Hielo";
        generarEstadisticas();
    }
    private void generarEstadisticas(){
        switch (this.nivel) {
            case 10:
                this.fuerza = 25;
                this.defensa = 30;
                this.concentracion = 20;
                this.espiritu = 15;
                this.PV = 100;
                break;
            case 20:
                this.fuerza = 30;
                this.defensa = 35;
                this.concentracion = 25;
                this.espiritu = 20;
                this.PV = 110;
                break;
            case 30:
                this.fuerza = 35;
                this.defensa = 40;
                this.concentracion = 25;
                this.espiritu = 25;
                this.PV = 120;
                break;
            case 40:
                this.fuerza = 40;
                this.defensa = 40;
                this.concentracion = 30;
                this.espiritu = 25;
                this.PV = 135;
                break;
            case 50:
                this.fuerza = 50;
                this.defensa = 45;
                this.concentracion = 35;
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
