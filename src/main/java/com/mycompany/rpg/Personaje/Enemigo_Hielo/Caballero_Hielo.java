package com.mycompany.rpg.Personaje.Enemigo_Hielo;

/**
 *
 * @author saien
 */
public class Caballero_Hielo extends Enemigo_Hielo {
//El ataque fisico es mayor que su ataque magico
    private String nombre;

    public Caballero_Hielo(int nivel) {
        super(nivel);
        nombre = "Caballero Hielo";
        generarEstadisticas();
    }

    private void generarEstadisticas() {
        switch (this.nivel) {
            case 10:
                this.fuerza = 10;
                this.defensa = 10;
                this.concentracion = 15;
                this.espiritu = 5;
                this.velocidad = 10;
                this.PV = 100;
                break;
            case 20:
                this.fuerza = 15;
                this.defensa = 15;
                this.concentracion = 20;
                this.espiritu = 10;
                this.velocidad = 10;
                this.PV = 100;
                break;
            case 30:
                this.fuerza = 20;
                this.defensa = 20;
                this.concentracion = 25;
                this.espiritu = 15;
                this.velocidad = 15;
                this.PV = 110;
                break;
            case 40:
                this.fuerza = 25;
                this.defensa = 25;
                this.concentracion = 25;
                this.espiritu = 25;
                this.velocidad = 15;
                this.PV = 115;
                break;
            case 50:
                this.fuerza = 30;
                this.defensa = 30;
                this.concentracion = 30;
                this.espiritu = 35;
                this.velocidad = 20;
                this.PV = 120;
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
    public int getVelocidad() {
        return velocidad;
    }
    @Override
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    

}
