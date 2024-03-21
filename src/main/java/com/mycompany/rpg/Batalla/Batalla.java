package com.mycompany.rpg.Batalla;

import com.mycompany.rpg.Objetos.Objeto;
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
    Objeto[] objetos;

    private int indiceEnemigoEnTurno;
    private int indiceAliadoEnTurno;

    public Batalla(Aliado[] aliado, Enemigo[] enemigo, Objeto[] objeto) {
        this.aliados = aliado;
        this.enemigos = enemigo;
        this.objetos = objeto;
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
                if (obtenerAliadoEnTurno().getPV() <= 0) {
                    System.out.println(obtenerAliadoEnTurno().getNombre() + " esta exhausto");
                    cambiarTurnoAliados();
                }
                imprimirAliadoEnTurno();
                System.out.println(obtenerAliadoEnTurno().getNivel());
                System.out.println(obtenerEnemigoEnTurno().getNivel());
                mostrarEstadisticas();
                accionesAliado();
                AtacarAliado();
                cambiarTurnoAliados();
                cambiarTurnoEnemigos();
                turnoJugador++;
            } while (turnoJugador < 3);

        } else {
            System.out.println("El equipo enemigo inicia\n");
            do {

                //imprimirAliadoEnTurno();
                if (obtenerEnemigoEnTurno().getPV() <= 0) {
                    cambiarTurnoEnemigos();
                }
                imprimirEnemigoEnTurno();
                System.out.println(obtenerAliadoEnTurno().getNivel());
                System.out.println(obtenerEnemigoEnTurno().getNivel());
                mostrarEstadisticas();
                accionesEnemigo();
                AtacarAliado();
                cambiarTurnoEnemigos();
                cambiarTurnoAliados();
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

    public void imprimirInventario() {
        for (int i = 0; i < objetos.length; i++) {
            System.out.println(objetos[i].getNombre());

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
        int fuerzAliado = 0;
        int defensaEnemigo = 0;
        int finalDamage = 0;
        Trabajo[] trabajos = obtenerAliadoEnTurno().getTrabajo();
        System.out.println("Seleccione el trabajo que quiere usar");
        for (int i = 0; i < trabajos.length; i++) {
            if (trabajos[i] == null) {
                System.out.println((i + 1) + ".- Sin trabajo asignado");
            } else {
                //System.out.println((i + 1) + ".- " + obtenerAliadoEnTurno().getTrabajo()[i]);
                System.out.println((i + 1) + ".- " + trabajos[i].getNombre());

            }
        }
        op = Integer.valueOf(sc.nextLine());
        if (op < 1 || op > trabajos.length || trabajos[op - 1] == null) {
            System.out.println("Opción inválida. Seleccione nuevamente.");
            return; // Permite que el usuario seleccione nuevamente
        }
        //Asignamos el trabajo seleccionado a nuestra variable de tipo Trabajo
        Trabajo trabajoSeleccionado = trabajos[op - 1];
        //CAMBIAMOS LAS ESTADISTICAS DEL ALIADO SEGUN EL TRABAJO ELEGIDO PARA LA PELEA
        obtenerAliadoEnTurno().cambiarEstadisticasTemporal(trabajoSeleccionado);
        //Verificamos si el trabajo seleccionado es un mago
        if ((trabajoSeleccionado instanceof Mago_Blanco) || (trabajoSeleccionado instanceof Mago_Rojo) || (trabajoSeleccionado instanceof Mago_Oscuro)) {
            varios.menuMago(); //Mostramos las opciones para el mago
            op = Integer.valueOf(sc.nextLine());
            switch (op) {
                case 1:
                    //Si quiere atacar con baculo
                    fuerzAliado = (int) (obtenerAliadoEnTurno().getFuerzaTemp());
                    defensaEnemigo = obtenerEnemigoEnTurno().getDefensa();
                    if (fuerzAliado < defensaEnemigo) {
                        System.out.println(obtenerAliadoEnTurno().getNombre() + " no ha ocasionado daño");
                    } else {

                        finalDamage = fuerzAliado - defensaEnemigo;
                        System.out.println("El " + obtenerAliadoEnTurno().getNombre() + " ha hecho: " + finalDamage + " puntos de daño");
                        int nuevoPVenemigo = obtenerEnemigoEnTurno().getPV() - finalDamage;
                        obtenerEnemigoEnTurno().setPV(nuevoPVenemigo);
                        mostrarEstadisticas();
                    }

                    break;
                case 2:
                    //Si quiere usar Objetos
                    Objeto objetoSeleccionado;
                    System.out.println("Seleccione el objeto que desea utilizar");
                    for (int i = 0; i < objetos.length; i++) {
                        if (objetos[i] == null) {
                            break; //Salimos del ciclo si encuentra una casilla sin objetos
                        } else {

                            System.out.println((i + 1) + ".- " + objetos[i].getNombre());
                        }
                    }
                    op = Integer.valueOf(sc.nextLine());
                    if (op >= 1 && op <= objetos.length) {

                    } else {

                        objetoSeleccionado = objetos[op - 1];
                    }
//                    if (objetoSeleccionado instanceof MagiaBlanca) {
//                        
//                    }
                    break;
                case 3:
                    //Si quiere usar magias

                    break;
                case 4:
                    //Si quiere atacar con baculo
                    //int fuerzAliado = obtenerAliadoEnTurno().getFuerza();
                    //int defensaEnemigo = obtenerEnemigoEnTurno().getDefensa();

                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    public void mostrarEstadisticas() {
        System.out.println("Puntos de vida de " + obtenerAliadoEnTurno().getNombre() + ": " + obtenerAliadoEnTurno().getPV());
        System.out.println("Puntos de vida de " + obtenerEnemigoEnTurno().getNombre() + ": " + obtenerEnemigoEnTurno().getPV());

    }

    public int obtenerPVAliados() {
        int pvAliados = 0;
        for (Aliado aliado : aliados) {
            pvAliados = pvAliados + aliado.getPV();
        }
        return pvAliados;
    }

    public int obtenerPVEnemigos() {
        int pvEnemigos = 0;
        for (Enemigo enemigo : enemigos) {
            pvEnemigos = pvEnemigos + enemigo.getPV();
        }
        return pvEnemigos;
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
