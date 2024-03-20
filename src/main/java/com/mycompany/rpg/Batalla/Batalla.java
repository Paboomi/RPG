package com.mycompany.rpg.Batalla;

import com.mycompany.rpg.Personaje.Aliado;
import com.mycompany.rpg.Personaje.Enemigo;
import com.mycompany.rpg.Personaje.Personaje;
import com.mycompany.rpg.Trabajo.Mago_Blanco;
import com.mycompany.rpg.Trabajo.Mago_Oscuro;
import com.mycompany.rpg.Trabajo.Mago_Rojo;
import com.mycompany.rpg.Trabajo.Trabajo;
import com.mycompany.rpg.Varios;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author saien
 */
public class Batalla {

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    Varios varios = new Varios();
    Aliado aliados[];
    Enemigo enemigos[];
    Aliado aliadoEnTurno;
    Enemigo enemigoEnTurno;

    private int indiceEnemigoEnTurno;
    private int indiceAliadoEnTurno;

    public Batalla(Aliado[] aliado, Enemigo[] enemigo) {
        this.aliados = aliado;
        this.enemigos = enemigo;
        indiceAliadoEnTurno = 0;
        indiceEnemigoEnTurno = 0;
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
            System.out.println("El equipo aliado inicia\n");
            do {

                //imprimirAliadoEnTurno();
                imprimirAliadoEnTurno();
                accionesAliado();
                cambiarTurnoAliados();
                turnoJugador++;
            } while (turnoJugador < 3);

        } else {
            System.out.println("El equipo enemigo inicia\n");
            do {

                //imprimirAliadoEnTurno();
                imprimirEnemigoEnTurno();
                accionesEnemigo();
                cambiarTurnoEnemigos();
                turnoEnemigo++;
            } while (turnoEnemigo < 3);

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

        System.out.println("Jugador en turno: " + obtenerAliadoEnTurno().getNombre());

    }

    private void imprimirEnemigoEnTurno() {

        System.out.println("Jugador en turno: " + obtenerEnemigoEnTurno().getNombre());

    }

    public void accionesAliado() {

        System.out.println(obtenerAliadoEnTurno().getNombre() + " pelea");
    }

    public void accionesEnemigo() {

        System.out.println(obtenerEnemigoEnTurno().getNombre() + " pelea");
    }

    public void AtacarAliado() {
        int op;
        Trabajo[] trabajos = obtenerAliadoEnTurno().getTrabajo();
        System.out.println("Seleccione el trabajo que quiere usar");
        for (int i = 0; i < trabajos.length; i++) {
            if (trabajos[i] == null) {
                System.out.println("Sin trabajo asignado");
            }
            System.out.println((i + 1) + ".- " + obtenerAliadoEnTurno().getTrabajo()[i]);

        }
        op = Integer.valueOf(sc.nextLine());
        if (op < 1 || op > trabajos.length || trabajos[op - 1] == null) {
            System.out.println("Opción inválida. Seleccione nuevamente.");
            return; // Permite que el usuario seleccione nuevamente
        }
        Trabajo trabajoSeleccionado = trabajos[op - 1];
        if ((trabajoSeleccionado instanceof Mago_Blanco) || (trabajoSeleccionado instanceof Mago_Rojo) || (trabajoSeleccionado instanceof Mago_Oscuro)) {
            varios.menuMago();
            op = Integer.valueOf(sc.nextLine());
            switch (op) {
                case 1:
                    //Si quiere atacar con baculo
                    int fuerzAliado = obtenerAliadoEnTurno().getFuerza();
                    int defensaEnemigo = obtenerEnemigoEnTurno().getDefensa();

                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    //GETTERS Y SETTERS
    private Aliado obtenerAliadoEnTurno() {
        return aliados[indiceAliadoEnTurno];
    }

    private Enemigo obtenerEnemigoEnTurno() {
        return enemigos[indiceEnemigoEnTurno];
    }

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
