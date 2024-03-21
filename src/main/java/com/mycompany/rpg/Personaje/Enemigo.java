package com.mycompany.rpg.Personaje;

/**
 *
 * @author saien
 */
public class Enemigo extends Personaje {

    protected int id;

      public Enemigo(int nivel){
          super(nivel);
      }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

 
      
  
    
}
