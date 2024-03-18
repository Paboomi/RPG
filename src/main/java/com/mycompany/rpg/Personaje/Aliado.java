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
        } else {
            System.out.println("No hay espacio para otro trabajo");
        }
    }

    public void mostrarTrabajos() {
        for (int i = 0; i < trabajo.length; i++) {
            if (trabajo[i] instanceof Mago_Blanco) {
                System.out.println(nombre + " tiene el trabajo de Mago Blanco");
            } else if (trabajo[i] instanceof Ninja) {
                System.out.println(nombre + " tiene el trabajo de Ninja");
            } else if (trabajo[i] instanceof Guerrero) {
                System.out.println(nombre + " tiene el trabajo de Guerrero");
            }else if (trabajo[i] instanceof Mago_Oscuro){
                System.out.println(nombre + " tiene el trabajo de Mago Oscuro");
            }

        }
    }

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

}
