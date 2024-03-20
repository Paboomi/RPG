package com.mycompany.rpg.Personaje;

import com.mycompany.rpg.Trabajo.*;
import com.mycompany.rpg.Arma.*;

/**
 *
 * @author saien
 */
public class Aliado extends Personaje {

    private String nombre;
    private Trabajo[] trabajo;
    Arma armas[];

    public Aliado(String nom, Trabajo trabajoInicial) {
        this.nombre = nom;
        this.trabajo = new Trabajo[2];
        this.trabajo[0] = trabajoInicial;

    }

    public Aliado() {
        //Constructor para otras acciones
    }

    public void agregarTrabajo(Trabajo trabaJonuevo) {
        if (this.trabajo[1] == null) {
            this.trabajo[1] = trabaJonuevo;
            System.out.println("Se ha agregado el trabajo de: " + trabajo[1].getNombre());
        } else {
            System.out.println("No hay espacio para otro trabajo");
        }
    }

    public void cambiarTrabajo(Trabajo trabajoNuevo, int pos) {
        int posTrabajo = pos - 1;
        if (this.trabajo[posTrabajo] == null) {
            System.out.println(nombre + "No tiene ningun trabajo asignado en esta posicion");
        } else {
            System.out.println("Se ha cambiado el trabajo " + trabajo[posTrabajo].getNombre() + " por " + trabajoNuevo.getNombre());

            this.trabajo[posTrabajo] = trabajoNuevo;
        }
    }
    
    public void generarEstadisticas(){
        //nivel = 
    }

    public void mostrarTrabajos() {
        for (int i = 0; i < trabajo.length; i++) {
            if (trabajo[i] instanceof Mago_Blanco) {
                System.out.println(nombre + " tiene el trabajo de Mago Blanco");
            } else if (trabajo[i] instanceof Ninja) {
                System.out.println(nombre + " tiene el trabajo de Ninja");
            } else if (trabajo[i] instanceof Guerrero) {
                System.out.println(nombre + " tiene el trabajo de Guerrero");
            } else if (trabajo[i] instanceof Mago_Oscuro) {
                System.out.println(nombre + " tiene el trabajo de Mago Oscuro");
            } else if (trabajo[i] instanceof Mago_Rojo) {
                System.out.println(nombre + " tiene el trabajo de Mago Rojo");
            } else if (trabajo[i] instanceof Paladin) {
                System.out.println(nombre + " tiene el trabajo de Paladin");
            }

        }
    }
//GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Arma[] getArmas() {
        return armas;
    }

    public void setArmas(Arma[] armas) {
        this.armas = armas;
    }

    public Trabajo[] getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo[] trabajos) {
        this.trabajo = trabajos;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

}
