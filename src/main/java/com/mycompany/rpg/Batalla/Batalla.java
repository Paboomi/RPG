package com.mycompany.rpg.Batalla;

import com.mycompany.rpg.Personaje.Aliado;
import com.mycompany.rpg.Personaje.Enemigo;
import com.mycompany.rpg.Personaje.Personaje;
import java.util.Random;

/**
 *
 * @author saien
 */
public class Batalla {

    Random rand = new Random();
    Aliado aliados[];
    Enemigo enemigos[];
     Aliado aliadoEnTurno;
    
    private int indiceEnemigoEnTurno;
    private int indiceAliadoEnTurno;

    public Batalla(Aliado[] aliado, Enemigo[] enemigo) {
        this.aliados = aliado;
        this.enemigos = enemigo;
        indiceAliadoEnTurno=0;
        indiceEnemigoEnTurno=0;
        ordenarAliados();
        ordenarEnemigos();
        IniciarPelea();
    }

    public Batalla() {

    }

    public void IniciarPelea() {
        int turnoJugador = 0;
        int turnoEnemigo = 0;
        boolean turnoInicial = rand.nextBoolean();

        System.out.println("La batalla empezara");

        if (turnoInicial) {
            turnoJugador++;
            System.out.println("El equipo aliado inicia");
            imprimirAliadoEnTurno();
            
            cambiarTurnoAliados();

        } else {
            turnoEnemigo++;
            System.out.println("El equipo enemigo inicia");
            imprimirEnemigoEnTurno();
            cambiarTurnoEnemigos();
        }

    }

    public void verNivelEnemigo() {
        for (int i = 0; i < enemigos.length; i++) {
            System.out.println(enemigos[i].getNivel());

        }
    }

    public void ordenarAliados() {
        for (int i = 0; i < aliados.length - 1; i++) {
            for (int j = 0; j < aliados.length - i - 1; j++) {
                if (aliados[j].getVelocidad() < aliados[j + 1].getVelocidad()) {
                    // Intercambia los elementos si el anterior tiene menos velocidad que el siguiente
                    Aliado temp = aliados[j];
                    aliados[j] = aliados[j + 1];
                    aliados[j + 1] = temp;
                }
            }
        }
    }

    public void ordenarEnemigos() {
        for (int i = 0; i < enemigos.length - 1; i++) {
            for (int j = 0; j < enemigos.length - i - 1; j++) {
                if (enemigos[j].getVelocidad() < enemigos[j + 1].getVelocidad()) {
                    // Intercambia los elementos si el anterior tiene menos velocidad que el siguiente
                    Enemigo temp = enemigos[j];
                    enemigos[j] = enemigos[j + 1];
                    enemigos[j + 1] = temp;
                }
            }
        }
    }

    private void cambiarTurnoAliados() {
        if (indiceAliadoEnTurno < aliados.length - 1) {
            indiceAliadoEnTurno++;
        } else {
            indiceAliadoEnTurno = 0;
        }
    }
    private void cambiarTurnoEnemigos() {
        if (indiceEnemigoEnTurno < enemigos.length - 1) {
            indiceEnemigoEnTurno++;
        } else {
            indiceEnemigoEnTurno = 0;
        }
    }
    
    private void imprimirAliadoEnTurno() {
        aliadoEnTurno = aliados[indiceAliadoEnTurno];
        
        System.out.println("Jugador en turno: " + aliadoEnTurno.getNombre());

    }
    private void imprimirEnemigoEnTurno() {
        Enemigo enemigoEnTurno = enemigos[indiceEnemigoEnTurno];
        
        System.out.println("Jugador en turno: " + enemigoEnTurno.getNombre());
        
    }
    
    
    //GETTERS Y SETTERS

    public Aliado[] getAliados() {
        return aliados;
    }

    public void setAliados(Aliado[] aliados) {
        this.aliados = aliados;
    }

    public Enemigo[] getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(Enemigo[] enemigos) {
        this.enemigos = enemigos;
    }

}
