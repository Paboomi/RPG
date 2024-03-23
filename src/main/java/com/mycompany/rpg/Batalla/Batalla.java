package com.mycompany.rpg.Batalla;

import com.mycompany.rpg.Magias.MagiaBlanca.Coraza;
import com.mycompany.rpg.Objetos.Freno;
import com.mycompany.rpg.Objetos.Objeto;
import com.mycompany.rpg.Objetos.PlumaFenix;
import com.mycompany.rpg.Objetos.Pocion;
import com.mycompany.rpg.Objetos.PocionMayor;
import com.mycompany.rpg.Objetos.TiendaAcampar;
import com.mycompany.rpg.Objetos.Velocidad;
import com.mycompany.rpg.Personaje.Aliado;
import com.mycompany.rpg.Personaje.Enemigo;
import com.mycompany.rpg.Personaje.Jugador;
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
    Jugador jugador;

    private int indiceEnemigoEnTurno;
    private int indiceAliadoEnTurno;
    //private int PvOriginal;
    //private int VelocidadOriginal;
    private int op;
    private int fuerzAliado = 0;
    private int velocidadAliado = 0;
    private int defensaEnemigo = 0;
    private int finalDamage = 0;
    private int pvRevivir = 0;
    private int nuevoPV = 0;
    private int seleccionarAliado = 0;
    private String limpiarPantalla = "\033c";

    //Constructor
    public Batalla(Aliado[] aliado, Enemigo[] enemigo, Objeto[] objeto) {
        jugador = Jugador.getInstance();
        this.aliados = aliado;
        this.enemigos = enemigo;
        this.objetos = objeto;
        indiceAliadoEnTurno = 0;
        indiceEnemigoEnTurno = 0;
        //PvOriginal = 0;
        //VelocidadOriginal = 0;
        ordenarAliados();
        ordenarEnemigos();
        IniciarPelea();
    }

    public Batalla() {

    }

    //Iniciamos la pelea
    public void IniciarPelea() {
        int turnoJugador = 0;
        int turnoEnemigo = 0;
        boolean turnoInicial = rand.nextBoolean();

        varios.pintarBlanco(limpiarPantalla + "\n\n\nLa batalla empezara");

        if (turnoInicial) {
            varios.pintarBlanco("\n\nLoas Caballeros de Luz inician");
            do {

                //imprimirAliadoEnTurno();
                if (obtenerAliadoEnTurno().getPV() <= 0) {
                    varios.pintarRojoBrillante(obtenerAliadoEnTurno().getNombre() + " esta exhausto");
                    cambiarTurnoAliados();
                }
                imprimirAliadoEnTurno();
                mostrarEstadisticas();
                accionesAliado();
                AtacarAliado();
                cambiarTurnoAliados();
                cambiarTurnoEnemigos();
                turnoJugador++;
            } while (turnoJugador < 3);

        } else {
            varios.pintarBlanco("\n\nEl equipo enemigo inicia");
            do {

                //imprimirAliadoEnTurno();
                if (obtenerEnemigoEnTurno().getPV() <= 0) {
                    cambiarTurnoEnemigos();
                }
                imprimirEnemigoEnTurno();
                mostrarEstadisticas();
                accionesEnemigo();
                AtacarAliado();
                cambiarTurnoEnemigos();
                cambiarTurnoAliados();
                turnoEnemigo++;
            } while (turnoEnemigo < 3);

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

    private void imprimirAliadoEnTurno() {

        varios.pintarPurpura("\nJugador en turno: " + obtenerAliadoEnTurno().getNombre());

    }

    private void imprimirEnemigoEnTurno() {

        varios.pintarPurpura("\nEnemigo en turno: " + obtenerEnemigoEnTurno().getNombre());

    }

    public void accionesAliado() {

        varios.pintarVerdeBrillante(obtenerAliadoEnTurno().getNombre() + " pelea");
    }

    public void accionesEnemigo() {

        varios.pintarVerdeBrillante(obtenerEnemigoEnTurno().getNombre() + " pelea");
    }

//Obtenemos los valores de los atributos originales de los Caballeros Luz
    public void obtenerAtributosIniciales() {
        obtenerAliadoEnTurno().setPVOriginal(obtenerAliadoEnTurno().getPVTemp());
        obtenerAliadoEnTurno().setVelocidadOriginal(obtenerAliadoEnTurno().getVelocidadTemp());
    }

    //Metodo para que los aliados ataquen
    public void AtacarAliado() {

        //Obtenemos los trabajos que tiene el aliado en su inventario
        Trabajo[] trabajos = obtenerAliadoEnTurno().getTrabajo();
        varios.pintarAmarilloBrillante("Seleccione el trabajo que quiere usar");
        //Mostramos los trabajos
        for (int i = 0; i < trabajos.length; i++) {
            if (trabajos[i] == null) { //Verificamos si tiene alguna posicion cavia en el array
                varios.pintarRojoBrillante((i + 1) + ".- Sin trabajo asignado");
            } else {

                varios.pintarVerdeBrillante((i + 1) + ".- " + trabajos[i].getNombre());

            }
        }
        op = Integer.parseInt(sc.nextLine());
        //Verificamos que la opcion seleccionada este dentro de los limites del array y que exista
        if (op < 1 || op > trabajos.length || trabajos[op - 1] == null) {
            varios.pintarRojoBrillante("Opción inválida. Seleccione nuevamente.");
            return; // Permite que el usuario seleccione nuevamente
        }
        //Asignamos el trabajo seleccionado a nuestra variable de tipo Trabajo
        Trabajo trabajoSeleccionado = trabajos[(op - 1)];
        //CAMBIAMOS LAS ESTADISTICAS DEL ALIADO SEGUN EL TRABAJO ELEGIDO PARA LA PELEA
        obtenerAliadoEnTurno().cambiarEstadisticasTemporal(trabajoSeleccionado);
        //Obtenemos los atributos del Caballero para usar los objetos
        obtenerAtributosIniciales();
        //Verificamos si el trabajo seleccionado es un mago
        if ((trabajoSeleccionado instanceof Mago_Blanco) || (trabajoSeleccionado instanceof Mago_Rojo) || (trabajoSeleccionado instanceof Mago_Oscuro)) {
            //Mostramos las opciones para el mago
            varios.menuMago();
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1:
                    //Si quiere atacar con baculo
                    fuerzAliado = (int) (obtenerAliadoEnTurno().getFuerzaTemp());
                    defensaEnemigo = obtenerEnemigoEnTurno().getDefensa();
                    //Verificamos que la fuerza del Caballero de luz sea menor que la defensa del enemigo
                    if (fuerzAliado < defensaEnemigo) {
                        varios.pintarVerdeBrillante(obtenerAliadoEnTurno().getNombre() + " no ha ocasionado daño");
                    } else {
                        //Comparamos la fuerza del Caballero de la luz con la defensa del enemigo
                        finalDamage = fuerzAliado - defensaEnemigo;
                        varios.pintarVerdeBrillante("El " + obtenerAliadoEnTurno().getNombre() + " ha hecho: " + finalDamage + " puntos de daño");
                        int nuevoPVenemigo = obtenerEnemigoEnTurno().getPV() - finalDamage;
                        obtenerEnemigoEnTurno().setPV(nuevoPVenemigo);
                        mostrarEstadisticas();
                    }

                    break;
                case 2:
                    UsarObjetos();
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
//Metodo para usar los objetos del inventario del Jugador

    public void UsarObjetos() {
        Objeto objetoSeleccionado;
        boolean objetoEncontrado = true;
        do {
            varios.menuObjetos();
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    for (int i = 0; i < objetos.length; i++) {
                        if (objetos[i] instanceof Pocion) {
                            objetoSeleccionado = objetos[i];
                            SeleccionarAliadoParaRecuperarVida(aliados);
                            if (seleccionarAliado == 0) {
                                varios.pintarCyanBrillante("No se ha utilizado el objeto");
                                return;
                            } else {
                                usarPocion(objetoSeleccionado, seleccionarAliado);
                                jugador.usarObjeto(objetoSeleccionado);
                                return;
                            }
                        }
                    }
                    varios.pintarRojoBrillante("Este objeto no esta en tu inventario. Elije otro");
                    objetoEncontrado = false;
                    break;
                case 2:
                    for (int i = 0; i < objetos.length; i++) {
                        if (objetos[i] instanceof PlumaFenix) {
                            objetoSeleccionado = objetos[i];
                            SeleccionarAliadoParaRecuperarVida(aliados);
                            if (seleccionarAliado == 0) {
                                varios.pintarCyanBrillante("No se ha utilizado el objeto");
                                return;
                            } else {
                                usarPocion(objetoSeleccionado, seleccionarAliado);
                                jugador.usarObjeto(objetoSeleccionado);
                                return;
                            }
                            varios.pintarAmarillo("Seleccione un Caballero de la Luz para recuperar vida:");
                            //Recorremos el arreglo de aliados
                            for (int j = 0; j < aliados.length; j++) {
                                //Mostramos los aliados
                                varios.pintarCyanBrillante((j + 1) + ".- " + aliados[j].getNombre() + " puntos de vida: " + aliados[j].getPVTemp());
                            }
                            seleccionarAliado = Integer.parseInt(sc.nextLine());
                            objetoSeleccionado = objetos[i];
                            //Obtenemos el PV recuperado
                            pvRevivir = varios.Pocion();
                            //Modificamos el PV del aliado
                            aliados[seleccionarAliado - 1].setPVTemp(pvRevivir);
                            //Mostramos informacion sobre el aliado revivido
                            varios.pintarCyanBrillante(aliados[seleccionarAliado - 1].getNombre() + " ha revivido con" + pvRevivir + " puntos de vida");
                            //Restamos el objeto del inventario del Jugador
                            jugador.usarObjeto(objetoSeleccionado);
                            return;
                        } else {
                            varios.pintarRojoBrillante("Este objeto no esta en tu inventario. Elije otro");
                            objetoEncontrado = false;
                        }
                    }

                    break;
                case 3:
                    for (int i = 0; i < objetos.length; i++) {
                        if (objetos[i] instanceof TiendaAcampar) {
                            objetoSeleccionado = objetos[i];
                            for (int j = 0; j < aliados.length; j++) {
                                aliados[j].setPVTemp(aliados[j].getPVOriginal());
                            }
                            varios.pintarCyanBrillante("Todos los Caballeros de Luz han recobrado sus puntos de vida");
                            //Restamos el objeto del inventario del Jugador
                            jugador.usarObjeto(objetoSeleccionado);
                            return;
                        } else {
                            varios.pintarRojoBrillante("Este objeto no esta en tu inventario. Elije otro");
                            objetoEncontrado = false;
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < objetos.length; i++) {
                        if (objetos[i] instanceof Freno) {
                            varios.pintarAmarillo("Seleccione un Caballero de la Luz para disminuir velocidad:");
                            //Recorremos el arreglo de aliados
                            for (int j = 0; j < aliados.length; j++) {

                                //Mostramos la velocidad de los aliados
                                varios.pintarCyanBrillante((j + 1) + ".- " + aliados[j].getNombre() + " velocidad: " + aliados[j].getVelocidadTemp());
                            }
                            seleccionarAliado = Integer.parseInt(sc.nextLine());
                            objetoSeleccionado = objetos[i];
                            //Restamos la velocidad del Caballero Luz con el valor del metod Freno
                            velocidadAliado = aliados[seleccionarAliado - 1].getVelocidadTemp() - varios.Freno();
                            //Modificamos la velocidad del Caballero
                            aliados[seleccionarAliado - 1].setVelocidadTemp(velocidadAliado);
                            //Mostramos informacion sobre la velocidad modificada
                            varios.pintarCyanBrillante("Velocidad de " + aliados[seleccionarAliado - 1].getNombre() + " ha : " + aliados[seleccionarAliado - 1].getVelocidadTemp());
                            //Volvemos a reordenar los Caballeros Luz por su velocidad
                            ordenarAliados();
                            //Restamos el objeto del inventario del Jugador
                            jugador.usarObjeto(objetoSeleccionado);
                            return;
                        } else {
                            varios.pintarRojoBrillante("Este objeto no esta en tu inventario. Elije otro");
                            objetoEncontrado = false;
                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < objetos.length; i++) {
                        if (objetos[i] instanceof PocionMayor) {
                            varios.pintarAmarillo("Seleccione un Caballero de la Luz para recuperar vida:");

                            //Recorremos el arreglo de aliados
                            for (int j = 0; j < aliados.length; j++) {
                                //Mostramos los puntos de vida de los aliados
                                varios.pintarCyanBrillante((j + 1) + ".- " + aliados[j].getNombre() + " puntos de vida: " + aliados[j].getPVTemp());
                            }
                            seleccionarAliado = Integer.parseInt(sc.nextLine());
                            objetoSeleccionado = objetos[i];
                            //Obtenemos el PV recuperado
                            nuevoPV = varios.PocionMayor();
                            //Modificamos el PV del aliado
                            aliados[seleccionarAliado - 1].setPVTemp(nuevoPV);
                            if (aliados[seleccionarAliado - 1].getPVOriginal() < aliados[seleccionarAliado - 1].getPVTemp()) {
                                //Recuperamos los PV originales del Caballero Luz
                                aliados[seleccionarAliado - 1].setPVTemp(aliados[seleccionarAliado - 1].getPVOriginal());
                            }
                            //Mostramos informacion al jugador
                            varios.pintarCyanBrillante(aliados[seleccionarAliado - 1] + "Ha recuperado " + nuevoPV + " puntos de vida");
                            //Restamos el objeto del inventario del Jugador
                            jugador.usarObjeto(objetoSeleccionado);
                            return;
                        } else {
                            varios.pintarRojoBrillante("Este objeto no esta en tu inventario. Elije otro");
                            objetoEncontrado = false;
                        }
                    }

                    break;
                case 6:
                    for (int i = 0; i < objetos.length; i++) {
                        if (objetos[i] instanceof Velocidad) {
                            varios.pintarAmarillo("Seleccione un Caballero de la Luz para aumentar velocidad:");
                            //Recorremos el arreglo de aliados
                            for (int j = 0; j < aliados.length; j++) {
                                //Mostramos los aliados
                                varios.pintarCyanBrillante((j + 1) + ".- " + aliados[j].getNombre() + " velocidad: " + aliados[j].getVelocidadTemp());
                            }
                            seleccionarAliado = Integer.parseInt(sc.nextLine());
                            objetoSeleccionado = objetos[i];
                            //Sumamos la velocidad del Caballero Luz con el valor del metod Velocidad
                            velocidadAliado = aliados[seleccionarAliado - 1].getVelocidadTemp() + varios.Velocidad();
                            //Modificamos la velocidad del Caballero
                            aliados[seleccionarAliado - 1].setVelocidadTemp(velocidadAliado);
                            //Mostramos informacion sobre la velocidad modificada
                            varios.pintarCyanBrillante("Velocidad de " + aliados[seleccionarAliado - 1].getNombre() + ": " + aliados[seleccionarAliado - 1].getVelocidadTemp());
                            //Volvemos a reordenar los Caballeros Luz por su velocidad
                            ordenarAliados();
                            //Restamos el objeto del inventario del Jugador
                            jugador.usarObjeto(objetoSeleccionado);
                            return;
                        } else {
                            varios.pintarRojoBrillante("Este objeto no esta en tu inventario. Elije otro");
                            objetoEncontrado = false;
                            continue;
                        }
                    }
                    break;

                default:
                    varios.pintarRojoBrillante("Opcion no valida");
            }
        } while (!objetoEncontrado);

    }

    //Metodo para mostrar los aliados en los menus
    private int SeleccionarAliadoParaRecuperarVida(Aliado[] aliados) {
        varios.pintarAmarillo("Seleccione un Caballero de la Luz para recuperar vida:");
        //Recorremos el arreglo de aliados
        for (int j = 0; j < aliados.length; j++) {
            //Mostramos los puntos de vida de los aliados
            varios.pintarCyanBrillante((j + 1) + ".- " + aliados[j].getNombre() + " puntos de vida: " + aliados[j].getPVTemp());
        }
        varios.pintarAmarilloBrillante("Si desea salir presione 0");
        seleccionarAliado = Integer.parseInt(sc.nextLine());
        if (seleccionarAliado == 0) {
            return -1;
        }
        seleccionarAliado = Integer.parseInt(sc.nextLine());
        seleccionarAliado--; //Disminuimos en 1 la opcion seleccionada
        return seleccionarAliado;
    }

    //Metodo para usar la Pocion
    private void usarPocion(Objeto objeto, int seleccionarAliado) {

        //Variable para saber si se ha seleccionado un Caballero Luz con poca vida
        boolean aliadoValido = false;
        this.seleccionarAliado = SeleccionarAliadoParaRecuperarVida(aliados);
        while (!aliadoValido) {

            if (this.seleccionarAliado == -1) {
                return;
            }
            if (aliados[seleccionarAliado].getPVOriginal() == aliados[seleccionarAliado].getPVTemp()) {
                varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " No ha perdido vida seleccione otro personaje");
                continue;
            } else {
                //Obtenemos el PV recuperado
                nuevoPV = varios.Pocion();
                //Modificamos el PV del aliado
                aliados[seleccionarAliado].setPVTemp(aliados[seleccionarAliado].getPVTemp() + nuevoPV);
                //Verificamos que no se pase de los puntos de vida que tenia
                if (aliados[seleccionarAliado].getPVOriginal() < aliados[seleccionarAliado].getPVTemp()) {
                    //Recuperamos los PV originales del Caballero Luz
                    aliados[seleccionarAliado].setPVTemp(aliados[seleccionarAliado].getPVOriginal());
                    varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " ha aumentado " + aliados[seleccionarAliado].getPVTemp() + " puntos de vida");

                } else {
                    //Mostramos informacion sobre el aumento de PV
                    varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " ha aumentado " + nuevoPV + " puntos de vida");

                }
                aliadoValido = true;
            }
        }
    }
    //Metodo para utilizar Pocion Mayor

    private void usarPocionMayor(Objeto objeto, int seleccionarAliado) {

        //Variable para saber si se ha seleccionado un Caballero Luz con poca vida
        boolean aliadoValido = false;
        this.seleccionarAliado = SeleccionarAliadoParaRecuperarVida(aliados);
        while (!aliadoValido) {

            if (this.seleccionarAliado == -1) {
                return;
            }
            if (aliados[seleccionarAliado].getPVOriginal() == aliados[seleccionarAliado].getPVTemp()) {
                varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " No ha perdido vida seleccione otro personaje");
                continue;
            } else {
                //Obtenemos el PV recuperado
                nuevoPV = varios.PocionMayor();
                //Modificamos el PV del aliado
                aliados[seleccionarAliado].setPVTemp(aliados[seleccionarAliado].getPVTemp() + nuevoPV);
                //Verificamos que no se pase de los puntos de vida que tenia
                if (aliados[seleccionarAliado].getPVOriginal() < aliados[seleccionarAliado].getPVTemp()) {
                    //Recuperamos los PV originales del Caballero Luz
                    aliados[seleccionarAliado].setPVTemp(aliados[seleccionarAliado].getPVOriginal());
                    varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " ha aumentado " + aliados[seleccionarAliado].getPVTemp() + " puntos de vida");

                } else {
                    //Mostramos informacion sobre el aumento de PV
                    varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " ha aumentado " + nuevoPV + " puntos de vida");

                }
                aliadoValido = true;
            }
        }
    }

    //Metodo para utilizar Pluma de Fenix
    private void usarPlumaFenix(Objeto objeto, int seleccionarAliado) {

        //Variable para saber si se ha seleccionado un Caballero Luz con poca vida
        boolean aliadoValido = false;
        this.seleccionarAliado = SeleccionarAliadoParaRecuperarVida(aliados);
        while (!aliadoValido) {

            if (this.seleccionarAliado == -1) {
                return;
            }
            if (aliados[seleccionarAliado].getPVOriginal() == aliados[seleccionarAliado].getPVTemp()) {
                varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " No ha perdido vida seleccione otro personaje");
                continue;
            } else {
                //Obtenemos el PV recuperado
                nuevoPV = varios.PlumaFenix();
                //Modificamos el PV del aliado
                aliados[seleccionarAliado].setPVTemp(aliados[seleccionarAliado].getPVTemp() + nuevoPV);
                //Verificamos que no se pase de los puntos de vida que tenia
                //Recuperamos los PV originales del Caballero Luz
                aliados[seleccionarAliado].setPVTemp(aliados[seleccionarAliado].getPVOriginal());
                varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " ha revivido con " + aliados[seleccionarAliado].getPVTemp() + " puntos de vida");
                aliadoValido = true;
            }
        }
    }

    public void mostrarEstadisticas() {
        varios.pintarVerdeBrillante("Puntos de vida de " + obtenerAliadoEnTurno().getNombre() + ": " + obtenerAliadoEnTurno().getPV());
        varios.pintarVerdeBrillante("Puntos de vida de " + obtenerEnemigoEnTurno().getNombre() + ": " + obtenerEnemigoEnTurno().getPV());

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
