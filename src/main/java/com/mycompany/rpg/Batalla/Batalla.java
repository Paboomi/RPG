package com.mycompany.rpg.Batalla;

import com.mycompany.rpg.Magias.MagiaBlanca.Coraza;
import com.mycompany.rpg.Objetos.Freno;
import com.mycompany.rpg.Objetos.Objeto;
import com.mycompany.rpg.Objetos.PlumaFenix;
import com.mycompany.rpg.Objetos.Pocion;
import com.mycompany.rpg.Objetos.PocionMayor;
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
    private int PvOriginal;
    private int VelocidadOriginal;

    //Constructor
    public Batalla(Aliado[] aliado, Enemigo[] enemigo, Objeto[] objeto) {
        this.aliados = aliado;
        this.enemigos = enemigo;
        this.objetos = objeto;
        indiceAliadoEnTurno = 0;
        indiceEnemigoEnTurno = 0;
        PvOriginal = 0;
        VelocidadOriginal = 0;
        ordenarAliados();
        ordenarEnemigos();
        obtenerAtributosIniciales();
        IniciarPelea();
    }

    public Batalla() {

    }

    //Iniciamos la pelea
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
                if (aliados[j].getVelocidadTemp() < aliados[j + 1].getVelocidadTemp()) {
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

    public void obtenerAtributosIniciales() {
        for (Aliado aliado : aliados) {
            aliado.setPVOriginal(aliado.getPVTemp());
            aliado.setVelocidadOriginal(aliado.getVelocidadTemp());
        }
    }
//Metodo para que los aliados ataquen

    public void AtacarAliado() {
        
        int op;
        int fuerzAliado = 0;
        int velocidadAliado = 0;
        int defensaEnemigo = 0;
        int finalDamage = 0;
        int pvRevivir = 0;
        int nuevoPV = 0;
        int seleccionarAliado;
        //Obtenemos los trabajos que tiene el aliado en su inventario
        Trabajo[] trabajos = obtenerAliadoEnTurno().getTrabajo();
        System.out.println("Seleccione el trabajo que quiere usar");
        //Mostramos los trabajos
        for (int i = 0; i < trabajos.length; i++) {
            if (trabajos[i] == null) { //Verificamos si tiene alguna posicion cavia en el array
                System.out.println((i + 1) + ".- Sin trabajo asignado");
            } else {
                //System.out.println((i + 1) + ".- " + obtenerAliadoEnTurno().getTrabajo()[i]);
                System.out.println((i + 1) + ".- " + trabajos[i].getNombre());

            }
        }
        op = Integer.valueOf(sc.nextLine());
        //Verificamos que la opcion seleccionada este dentro de los limites del array y que exista
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
                    //Verificamos que la fuerza del Caballero de luz sea menor que la defensa del enemigo
                    if (fuerzAliado < defensaEnemigo) {
                        System.out.println(obtenerAliadoEnTurno().getNombre() + " no ha ocasionado daño");
                    } else {
                        //Comparamos la fuerza del Caballero de la luz con la defensa del enemigo
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
                    varios.pintarVerdeBrillante("Seleccione el objeto que desea utilizar");
                    //System.out.println("Seleccione el objeto que desea utilizar");
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
                        //Vemos que tipo de objeto ha seleccionado
                        if (objetoSeleccionado instanceof Freno) {
                            //Calculamos la nueva velocidad
                            velocidadAliado = obtenerAliadoEnTurno().getVelocidadTemp() - varios.puntosVelocidad();
                            obtenerAliadoEnTurno().setVelocidadTemp(velocidadAliado);
                            ordenarAliados();//Volvemos a ordenar el arreglo
                            //Para la pluma del fenix
                        } else if (objetoSeleccionado instanceof PlumaFenix) {
                            //Recorremos el arreglo de aliados
                            for (int i = 0; i < aliados.length; i++) {
                                if (aliados[i].getPVTemp() <= 0) {
                                    varios.pintarAmarillo("Seleccione un Caballero de la Luz para revivir:");
                                    //Mostramos los aliados exhaustos
                                    varios.pintarCyanBrillante((i + 1) + ".- " + aliados[i].getNombre());
                                    seleccionarAliado = Integer.valueOf(sc.nextLine()); // guardamos la posicion del aliado seleccionado
                                    if ((seleccionarAliado - 1) >= 1 && (seleccionarAliado - 1) <= aliados.length) {
                                        pvRevivir = varios.PlumaFenix();
                                        //aumentamos el PV del aliado seleccionado
                                        aliados[seleccionarAliado - 1].setPVTemp(pvRevivir);
                                        //System.out.println("Se ha revivido a " + aliados[seleccionarAliadoExhausto-1].getNombre() + " con " + pvRevivir + " de PV");
                                        varios.pintarVerdeBrillante("Se ha revivido a " + aliados[seleccionarAliado - 1].getNombre() + " con " + pvRevivir + " de PV");
                                    }
                                }

                            }
                            //Para la Pocion
                        } else if (objetoSeleccionado instanceof Pocion) {
                            //Recorremos el arreglo de aliados
                            for (int i = 0; i < aliados.length; i++) {
                                //Mostramos los puntos de vida de los aliados
                                varios.pintarAmarillo("Seleccione un Caballero de la Luz para recuperar vida:");
                                //Mostramos los aliados
                                varios.pintarCyanBrillante((i + 1) + ".- " + aliados[i].getNombre() + " puntos de vida: " + aliados[i].getPVTemp());
                            }
                            seleccionarAliado = Integer.valueOf(sc.nextLine()); // guardamos la posicion del aliado seleccionado
                            //Verificamos que el Caballero seleccionado este dentro del rango del array
                            if ((seleccionarAliado - 1) >= 1 && (seleccionarAliado - 1) <= aliados.length) {
                                nuevoPV = varios.Pocion();
                                //aumentamos el PV del aliado seleccionado
                                aliados[seleccionarAliado - 1].setPVTemp(nuevoPV);
                                //Verificamos si los PV recuperados son mayores que los originales
                                if (aliados[seleccionarAliado - 1].getPVOriginal() < aliados[seleccionarAliado - 1].getPVTemp()) {
                                    //Devolvemos el valor original de los PV 
                                    aliados[seleccionarAliado - 1].setPVTemp(aliados[seleccionarAliado - 1].getPVOriginal());
                                    //Mostramos informacion de la accion
                                    varios.pintarVerdeBrillante("\nSe ha recuperado a " + aliados[seleccionarAliado - 1].getNombre() + " con " + aliados[seleccionarAliado - 1].getPVTemp() + " de PV");
                                } else {
                                    //Mostramos informacion de la accion
                                    varios.pintarVerdeBrillante("\nSe ha recuperado a " + aliados[seleccionarAliado - 1].getNombre() + " con " + aliados[seleccionarAliado - 1].getPVTemp() + " de PV");
                                }
                            }
                            //Para la Pocion Mayor
                        } else if (objetoSeleccionado instanceof PocionMayor) {
                            //Recorremos el arreglo de aliados
                            for (int i = 0; i < aliados.length; i++) {
                                //Mostramos los puntos de vida de los aliados
                                varios.pintarAmarillo("Seleccione un Caballero de la Luz para recuperar vida:");
                                //Mostramos los aliados
                                varios.pintarCyanBrillante((i + 1) + ".- " + aliados[i].getPVTemp());
                            }
                            seleccionarAliado = Integer.valueOf(sc.nextLine()); // guardamos la posicion del aliado seleccionado
                            if ((seleccionarAliado - 1) >= 1 && (seleccionarAliado - 1) <= aliados.length) { //verificamos que la opcion ste dentro del rango del array
                                nuevoPV = varios.PocionMayor();
                                //aumentamos el PV del aliado seleccionado
                                aliados[seleccionarAliado - 1].setPVTemp(nuevoPV);
                                if (aliados[seleccionarAliado - 1].getPVOriginal() < aliados[seleccionarAliado - 1].getPVTemp()) {
                                    //Devolvemos el valor original de los PV 
                                    aliados[seleccionarAliado - 1].setPVTemp(aliados[seleccionarAliado - 1].getPVOriginal());
                                    varios.pintarVerdeBrillante("\nSe ha recuperado a " + aliados[seleccionarAliado - 1].getNombre() + " con " + aliados[seleccionarAliado - 1].getPVOriginal() + " de PV");
                                }
                                else{
                                    //Mostramos informacion sobre la accion realizada
                                    varios.pintarVerdeBrillante("\nSe ha recuperado a " + aliados[seleccionarAliado - 1].getNombre() + " con " + aliados[seleccionarAliado - 1].getPVTemp() + " de PV");
                                }
                            }

                        }
                    }
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
