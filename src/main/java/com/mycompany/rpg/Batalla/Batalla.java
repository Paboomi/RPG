package com.mycompany.rpg.Batalla;

import com.mycompany.rpg.Arma.Arma;
import com.mycompany.rpg.Arma.ArmaUnaMano.ArmaUnaMano;
import com.mycompany.rpg.Arma.Escudo.Escudo;
import com.mycompany.rpg.Magias.Magia;
import com.mycompany.rpg.Magias.MagiaOscura.*;
import com.mycompany.rpg.Magias.MagiaBlanca.*;
import com.mycompany.rpg.Objetos.Freno;
import com.mycompany.rpg.Objetos.Objeto;
import com.mycompany.rpg.Objetos.PlumaFenix;
import com.mycompany.rpg.Objetos.Pocion;
import com.mycompany.rpg.Objetos.PocionMayor;
import com.mycompany.rpg.Objetos.TiendaAcampar;
import com.mycompany.rpg.Objetos.Velocidad;
import com.mycompany.rpg.Personaje.Aliado;
import com.mycompany.rpg.Personaje.Enemigo;
import com.mycompany.rpg.Personaje.Enemigo_Fuego.Enemigo_Fuego;
import com.mycompany.rpg.Personaje.Enemigo_Hielo.Enemigo_Hielo;
import com.mycompany.rpg.Personaje.Jugador;
import com.mycompany.rpg.Trabajo.Mago_Blanco;
import com.mycompany.rpg.Trabajo.Mago_Oscuro;
import com.mycompany.rpg.Trabajo.Mago_Rojo;
import com.mycompany.rpg.Trabajo.Paladin;
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
    Objeto[] objetos;
    Jugador jugador;
    Trabajo trabajoSeleccionado;
    Magia magiaSeleccionada;
    Trabajo[] trabajos;

    private String felicidades = "\uD83C\uDF89";
    private boolean ciudadReconquistada=false;
    private int indiceEnemigoEnTurno;
    private int indiceAliadoEnTurno;
    private int op;
    private int fuerzAliado = 0;
    private int defensaAliado = 0;
    private int velocidadAliado = 0;
    private int defensaEnemigo = 0;
    private int fuerzaEnemigo = 0;
    private int finalDamage = 0;
    private int nuevoPV = 0;
    private int concentracionAliado = 0;
    private int espirituAliado = 0;
    private int espirituEnemigo = 0;
    private int concentracionEnemigo = 0;
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
        ordenarAliados();
        ordenarEnemigos();
        IniciarPelea();
    }

    public Batalla() {

    }

    //Iniciamos la pelea
    public void IniciarPelea() {
        boolean turnoInicial = rand.nextBoolean();
        int aliadosCansados = 0;

        for (Aliado aliado : aliados) {
            if (aliado.getPVTemp() < 0) {
                aliadosCansados++;
            }
        }
        if (aliadosCansados == aliados.length) {
            varios.pintarCyanBrillante("Los Caballeros Luz estan Exhaustos, no pueden pelear");
            return;
        }

        varios.pintarBlanco(limpiarPantalla + "\n\n\nLa batalla empezara pronto");
        SeleccionarEquipamentoInicial();
        ordenarAliados();
        mostrarEstadisticasAliado();
        mostrarEstadisticasEnemigo();
        if (turnoInicial) {
            varios.pintarBlanco("\n\nLos Caballeros de Luz inician");
            do {
                if (obtenerAliadoEnTurno().getPV() <= 0) {
                    varios.pintarRojoBrillante(obtenerAliadoEnTurno().getNombre() + " esta exhausto");
                    cambiarTurnoAliados();
                }
                imprimirAliadoEnTurno();
                imprimirEnemigoEnTurno();
                mostrarPuntosVida();
                AtacarAliado();
                EnemigoAtacar();
                cambiarTurnoAliados();
                cambiarTurnoEnemigos();
            } while (obtenerPVAliados() != 0 || obtenerPVEnemigos() != 0);

        } else {
            varios.pintarBlanco("\n\nEl equipo enemigo inicia");
            do {

                //imprimirAliadoEnTurno();
                if (obtenerEnemigoEnTurno().getPV() <= 0) {
                    cambiarTurnoEnemigos();
                }
                imprimirEnemigoEnTurno();
                imprimirAliadoEnTurno();
                mostrarPuntosVida();
                EnemigoAtacar();
                AtacarAliado();
                cambiarTurnoAliados();
                cambiarTurnoEnemigos();
            } while (obtenerPVAliados() != 0 || obtenerPVEnemigos() != 0);

        }
        if (obtenerPVEnemigos() == 0) {
            System.out.println("\n\n");
            varios.pintarVerdeBrillante(felicidades+"Los Caballeros Luz han vencido!" + felicidades);
            setCiudadReconquistada(true);
        }else{
            varios.pintarRojoBrillante("Las Caballeros Luz han perdido");
            setCiudadReconquistada(false);
        }
    }

    private void SeleccionarEquipamentoInicial() {
        for (int i = 0; i < aliados.length; i++) {
            trabajos = aliados[i].getTrabajo();
            varios.pintarAmarilloBrillante("\n\nSeleccione un trabajo para " + aliados[i].getNombre());
            for (int j = 0; j < trabajos.length; j++) {
                //Verificamos si tiene alguna posicion vacia en el array
                if (trabajos[j] == null) {
                    varios.pintarRojoBrillante((j + 1) + ".- Sin trabajo asignado");
                } else {

                    varios.pintarVerdeBrillante((j + 1) + ".- " + trabajos[j].getNombre());

                }

            }
            op = Integer.parseInt(sc.nextLine());
            op--;
            //Verificamos que la opcion seleccionada este dentro de los limites del array y que exista
            if (op < 0 || op > trabajos.length || trabajos[op] == null) {
                varios.pintarRojoBrillante("Opción inválida. Seleccione nuevamente.");
                continue; // Permite que el usuario seleccione nuevamente
            }
            //Asignamos el trabajo seleccionado a nuestra variable de tipo Aliado
            trabajoSeleccionado = trabajos[op];
            //Asignamos el trabajo Activo para este aliado
            aliados[i].setTrabajoActivo(trabajoSeleccionado);
            //CAMBIAMOS LAS ESTADISTICAS DEL ALIADO SEGUN EL TRABAJO ELEGIDO PARA LA PELEA
            aliados[i].cambiarEstadisticasTemporalTrabajo(trabajoSeleccionado);

            /*----------------------------------------------------------------------------------*/
            Arma armas[] = trabajoSeleccionado.getInventarioArmas();
            Arma armaSeleccionada;
            Arma escudoSeleccionado;
            int opArma = 0;
            int opEscudo = 0;
            boolean tieneEscudos = false;
            //Le pedimos al Caballero que seleccione el arma que usara
            varios.pintarAmarilloBrillante("\nSeleccione el arma a utilizar");
            //Verificamos si el trabajo seleccionado es un Paladin
            if (trabajoSeleccionado instanceof Paladin) {
                for (int k = 0; k < armas.length; k++) {
                    if (armas[k] == null) {
                        varios.pintarRojoBrillante((k + 1) + ".- No hay armas asignadas");
                    } else if (armas[k] instanceof ArmaUnaMano) {
                        varios.pintarCyanBrillante((k + 1) + ".- " + armas[k].getNombre());
                    }

                }
                opArma = Integer.parseInt(sc.nextLine());
                opArma--;
                armaSeleccionada = armas[opArma];
                varios.pintarAmarilloBrillante("Selecciones el escudo que quiere utilizar");
                for (int n = 0; n < armas.length; n++) {
                    if (armas[n] instanceof Escudo) {
                        varios.pintarCyanBrillante((n + 1) + ".- " + armas[n].getNombre());
                        tieneEscudos = true;
                    } else {
                        varios.pintarRojoBrillante("No tienes escudos en tu inventario");
                    }
                }
                if (tieneEscudos) {
                    opEscudo = Integer.parseInt(sc.nextLine());
                    opEscudo--;
                    escudoSeleccionado = armas[opEscudo];
                    aliados[i].EstadisticasTemporalPaladin(trabajoSeleccionado, armaSeleccionada, escudoSeleccionado);
                    //Obtenemos los atributos del Caballero para usar los objetos
                    obtenerAtributosIniciales(aliados[i]);
                } else {
                    aliados[i].EstidisticasTemporalPaladinSinEscudo(trabajoSeleccionado, armaSeleccionada);
                    //Obtenemos los atributos del Caballero para usar los objetos
                    obtenerAtributosIniciales(aliados[i]);
                }

            } else {
                for (int j = 0; j < armas.length; j++) {
                    if (armas[j] == null) {
                        varios.pintarRojoBrillante((j + 1) + ".- No hay armas asignadas");
                    } else {
                        varios.pintarCyanBrillante((j + 1) + ".- " + armas[j].getNombre());
                    }

                }
                opArma = Integer.parseInt(sc.nextLine());
                opArma--;
                if (opArma >= 0 && opArma <= armas.length) {
                    armaSeleccionada = armas[opArma];
                    aliados[i].cambiarEstadisticasTemporalArma(armaSeleccionada, trabajoSeleccionado);
                }
                //Obtenemos los atributos del Caballero para usar los objetos
                obtenerAtributosIniciales(aliados[i]);
            }

        }
    }

    private void SeleccionarArmaInicio(Trabajo trabajo) {
        Arma armas[] = trabajo.getInventarioArmas();
        Arma armaSeleccionada;
        varios.pintarAmarilloBrillante("Seleccione un báculo");
        for (int i = 0; i < armas.length; i++) {
            if (armas[i] == null) {
                varios.pintarRojoBrillante((i + 1) + ".- No hay armas asignadas");
            } else {
                varios.pintarCyanBrillante((i + 1) + ".- " + armas[i].getNombre());
            }

        }

        int opArma = Integer.parseInt(sc.nextLine());
        opArma--;
        if (opArma >= 0 && opArma <= armas.length) {
            armaSeleccionada = armas[opArma];
            obtenerAliadoEnTurno().cambiarEstadisticasTemporalArma(armaSeleccionada, trabajoSeleccionado);

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
//Metodo para cambiar turno de los Caballeros Luz

    private void cambiarTurnoAliados() {
        if (indiceAliadoEnTurno < aliados.length - 1) {
            indiceAliadoEnTurno++;
        } else {
            indiceAliadoEnTurno = 0;
        }

        for (Aliado aliado : aliados) {
            aliado.reducirContadorEscudo();
            aliado.reducirContadorCoraza();
        }
    }
//Metodo para cambiar el turno del enemigo

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

    private void mostrarEstadisticasAliado() {
        for (Aliado aliado : aliados) {
            varios.pintarCyanBrillante(aliado.toString() + "              ");
        }
        System.out.println();
    }

    private void mostrarEstadisticasEnemigo() {
        for (Enemigo enemigo : enemigos) {
            varios.pintarCyanBrillante(enemigo.toString() + "              ");
        }
        System.out.println();
    }

    private void mostrarEstadisticas() {
        obtenerAliadoEnTurno().toString();
        obtenerEnemigoEnTurno().toString();
    }

    public void accionesAliado() {

        varios.pintarVerdeBrillante(obtenerAliadoEnTurno().getNombre() + " pelea");
    }

    public void accionesEnemigo() {

        varios.pintarVerdeBrillante(obtenerEnemigoEnTurno().getNombre() + " pelea");
    }

//Obtenemos los valores de los atributos originales de los Caballeros Luz
    public void obtenerAtributosIniciales(Aliado aliado) {
        aliado.setPVOriginal(aliado.getPVTemp());
        aliado.setVelocidadOriginal(aliado.getVelocidadTemp());
    }

    //Metodo para que los aliados ataquen
    public void AtacarAliado() {
        //Verificamos si el trabajo seleccionado es un mago
        if ((obtenerAliadoEnTurno().getTrabajoActivo() instanceof Mago_Blanco) || (obtenerAliadoEnTurno().getTrabajoActivo() instanceof Mago_Rojo) || (obtenerAliadoEnTurno().getTrabajoActivo() instanceof Mago_Oscuro)) {
            //Mostramos las opciones para el mago
            varios.menuMago();
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1:
                    CaballeroAtacaFisico();

                    break;
                case 2:
                    UsarObjetos();
                    break;
                case 3:
                    MostrarMagias(obtenerAliadoEnTurno().getTrabajoActivo());
                    UsarMagias(magiaSeleccionada);

                    break;
                case 4:
                    //Si quiere atacar con baculo
                    //int fuerzAliado = obtenerAliadoEnTurno().getFuerza();
                    //int defensaEnemigo = obtenerEnemigoEnTurno().getDefensa();

                    break;
                default:
                    varios.pintarRojoBrillante("Opcion invalida");
            }
        } else {
            varios.menuAliado();
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1:
                    CaballeroAtacaFisico();
                    break;
                case 2:
                    UsarObjetos();
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }
//Metodo para usar los objetos del inventario del Jugador

    public void UsarObjetos() {
        seleccionarAliado = 0;
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
                            //SeleccionarAliadoParaRecuperarVida(aliados);
                            usarPocion();
                            if (seleccionarAliado == -1) {
                                varios.pintarCyanBrillante("No se ha utilizado el objeto");
                                return;
                            } else {
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
                            usarPlumaFenix();
                            if (seleccionarAliado == -1) {
                                varios.pintarCyanBrillante("No se ha utilizado el objeto");
                                break;
                                //return;
                            } else {
                                jugador.usarObjeto(objetoSeleccionado);
                                objetoEncontrado = true;
                                break;
                            }
                        }
                    }
                    if (!objetoEncontrado) {
                        varios.pintarRojoBrillante("Este objeto no esta en tu inventario. Elije otro");

                    }

                    break;

                case 3:
                    for (int i = 0; i < objetos.length; i++) {
                        if (objetos[i] instanceof TiendaAcampar) {
                            objetoSeleccionado = objetos[i];
                            for (int j = 0; j < aliados.length; j++) {
                                if (aliados[j].getPVTemp() < aliados[j].getPVTemp()) {

                                    aliados[j].setPVTemp(aliados[j].getPVOriginal());
                                }
                            }
                            varios.pintarCyanBrillante("Los Caballeros de Luz han recobrado sus puntos de vida");
                            //Restamos el objeto del inventario del Jugador
                            jugador.usarObjeto(objetoSeleccionado);
                            return;
                        }
                    }
                    varios.pintarRojoBrillante("Este objeto no esta en tu inventario. Elije otro");
                    objetoEncontrado = false;
                    break;
                case 4:
                    for (int i = 0; i < objetos.length; i++) {
                        if (objetos[i] instanceof Freno) {
                            objetoSeleccionado = objetos[i];
                            usarFreno();
                            if (seleccionarAliado == -1) {
                                varios.pintarCyanBrillante("No se ha utilizado el objeto");
                                break;
                                //return;
                            } else {
                                //Volvemos a reordenar los Caballeros Luz por su velocidad
                                ordenarAliados();
                                //Restamos el objeto del inventario del Jugador
                                jugador.usarObjeto(objetoSeleccionado);
                                objetoEncontrado = true;
                                break;
                            }

                        }
                    }
                    if (!objetoEncontrado) {
                        varios.pintarRojoBrillante("Este objeto no esta en tu inventario. Elije otro");

                    }
                    break;
                case 5:
                    for (int i = 0; i < objetos.length; i++) {
                        if (objetos[i] instanceof PocionMayor) {
                            varios.pintarAmarillo("Seleccione un Caballero de la Luz para recuperar vida:");
                            objetoSeleccionado = objetos[i];
                            //SeleccionarAliadoParaRecuperarVida(aliados);
                            usarPocionMayor();
                            if (seleccionarAliado == -1) {
                                varios.pintarCyanBrillante("No se ha utilizado el objeto");
                                break;
                                //return;
                            } else {
                                jugador.usarObjeto(objetoSeleccionado);
                                objetoEncontrado = true;
                                break;
                            }
                        }
                    }
                    if (!objetoEncontrado) {
                        varios.pintarRojoBrillante("Este objeto no esta en tu inventario. Elije otro");

                    }
                    break;
                case 6:
                    for (int i = 0; i < objetos.length; i++) {
                        if (objetos[i] instanceof Velocidad) {
                            objetoSeleccionado = objetos[i];
                            usarVelocidad();
                            if (seleccionarAliado == -1) {
                                varios.pintarCyanBrillante("No se ha utilizado el objeto");
                                break;
                                //return;
                            } else {
                                //Volvemos a reordenar los Caballeros Luz por su velocidad
                                ordenarAliados();
                                //Restamos el objeto del inventario del Jugador
                                jugador.usarObjeto(objetoSeleccionado);
                                objetoEncontrado = true;
                                break;
                            }
                        }
                    }
                    if (!objetoEncontrado) {
                        varios.pintarRojoBrillante("Este objeto no esta en tu inventario. Elije otro");

                    }
                    break;

                default:
                    varios.pintarRojoBrillante("Opcion no valida");
            }
        } while (!objetoEncontrado);

    }

    //Metodo para mostrar y seleccionar la Magia a usar
    private void MostrarMagias(Trabajo trabajo) {
        Magia[] magiasDisponibles = trabajo.getInventarioMagias();
        //Verificamos que el inventario no este vacio
        if (magiasDisponibles == null) {
            varios.pintarRojoBrillante("El inventario esta vacio");
            return;
        }
        //Recorremos el inventario de magias de ese Caballero
        for (int i = 0; i < magiasDisponibles.length; i++) {
            if (magiasDisponibles[i] == null) {
                varios.pintarRojoBrillante((i + 1) + ".- Sin magia asiganadas");
            }
            varios.pintarCyanBrillante((i + 1) + ".- " + magiasDisponibles[i].getNombre());
        }
        int opMagia = Integer.parseInt(sc.nextLine());
        opMagia--;
        magiaSeleccionada = magiasDisponibles[opMagia];
    }

    //Metodo para que el enemigo ataque
    private void EnemigoAtacar() {
        boolean ataqueFisico;
        ataqueFisico = rand.nextBoolean();
        if (ataqueFisico) {
            EnemigoAtacaFisico();
        } else {
            EnemigoAtacarMagia();
        }
    }

    //Metodo para que el Caballero Luz ataque
    private void CaballeroAtacaFisico() {
        finalDamage = 0;
        //Obtenemos las estadisticas necesarias
        fuerzAliado = (int) (obtenerAliadoEnTurno().getFuerzaTemp());
        defensaEnemigo = obtenerEnemigoEnTurno().getDefensa();
        //Verificamos que la fuerza del Caballero de luz sea menor que la defensa del enemigo
        if (fuerzAliado <= defensaEnemigo) {
            varios.pintarVerdeBrillante(obtenerAliadoEnTurno().getNombre() + " no ha ocasionado daño");
        } else {
            //Realizamos el calculo de daño
            finalDamage = fuerzAliado - defensaEnemigo;
            varios.pintarVerdeBrillante(obtenerAliadoEnTurno().getNombre() + " ha hecho: " + finalDamage + " puntos de daño");
            int nuevoPVenemigo = obtenerEnemigoEnTurno().getPV() - finalDamage;
            if (nuevoPVenemigo <= 0) {
                obtenerEnemigoEnTurno().setPV(0);
                varios.pintarVerdeBrillante(obtenerEnemigoEnTurno().getNombre() + " ha sido derrotado");
            } else {
                obtenerEnemigoEnTurno().setPV(nuevoPVenemigo);
                varios.pintarVerdeBrillante(obtenerEnemigoEnTurno().getNombre() + " ha recibido " + finalDamage + " puntos daño");
                mostrarPuntosVida();
            }
        }
    }

    //Metodo para usar Magias
    private void UsarMagias(Magia magia) {
        finalDamage = 0;
        Magia magiaActiva = magia;
        Aliado aliadoSeleccionado;
        Trabajo trabajoActivo = obtenerAliadoEnTurno().getTrabajoActivo();
        //Si la magia es hielo y el aliado fuego se hace mas daño
        if ((magiaActiva instanceof Hielo) && (obtenerEnemigoEnTurno() instanceof Enemigo_Fuego)) {
            concentracionAliado = obtenerAliadoEnTurno().getConcentracionTemp();
            espirituEnemigo = obtenerEnemigoEnTurno().getEspiritu();
            //Calculamos el daño de la magia
            int damageMagia = magiaActiva.Damage() * (1 + concentracionAliado / 100);
            //Aplicamos el 20% mas de daño
            finalDamage = (int) ((damageMagia) - espirituEnemigo);
            int nuevoPVEnemigo = (int) (obtenerEnemigoEnTurno().getPV() - (finalDamage + (finalDamage * 0.2)));
            if (nuevoPVEnemigo <= 0) {
                obtenerEnemigoEnTurno().setPV(0);
                //Restamos la magia usada del inventario
                trabajoActivo.usarMagias(magiaActiva);
                varios.pintarVerdeBrillante(obtenerEnemigoEnTurno().getNombre() + " ha sido derrotado");
            } else {
                //Asignamos el nuevo PV al Enemigo
                obtenerEnemigoEnTurno().setPV(nuevoPVEnemigo);
                //Restamos la magia usada del inventario
                trabajoActivo.usarMagias(magiaActiva);
                varios.pintarVerdeBrillante(obtenerEnemigoEnTurno().getNombre() + " ha recibido " + (finalDamage + (finalDamage * 0.2)) + " puntos daño");

            }
            mostrarPuntosVida();
            //Si la magia es fuego y el enemigo hielo se hace mas daño
        } else if ((magiaActiva instanceof Fuego) && (obtenerEnemigoEnTurno() instanceof Enemigo_Hielo)) {
            concentracionAliado = obtenerAliadoEnTurno().getConcentracionTemp();
            espirituEnemigo = obtenerEnemigoEnTurno().getEspiritu();
            //Calculamos el daño de la magia
            int damageMagia = magiaActiva.Damage() * (1 + concentracionAliado / 100);
            //Aplicamos el 20% mas de daño
            finalDamage = (int) ((damageMagia) - espirituEnemigo);
            int nuevoPVEnemigo = (int) (obtenerEnemigoEnTurno().getPV() - (finalDamage + (finalDamage * 0.2)));
            if (nuevoPVEnemigo <= 0) {
                obtenerEnemigoEnTurno().setPV(0);
                //Restamos la magia usada del inventario
                trabajoActivo.usarMagias(magiaActiva);
                varios.pintarVerdeBrillante(obtenerEnemigoEnTurno().getNombre() + " ha sido derrotado");
            } else {
                //Asignamos el nuevo PV al Enemigo
                obtenerEnemigoEnTurno().setPV(nuevoPVEnemigo);
                //Restamos la magia usada del inventario
                trabajoActivo.usarMagias(magiaActiva);
                varios.pintarVerdeBrillante(obtenerEnemigoEnTurno().getNombre() + " ha recibido " + (finalDamage + (finalDamage * 0.2)) + " puntos daño");
            }
            mostrarPuntosVida();
            //Magia Especial
        } else if (magiaActiva instanceof Divinidad) {
            int damageTotal = 0;
            int damage = magiaActiva.Damage();
            //Como hace danio a todos los enemigos entonces recorremos el arreglo y vemos si tienen vida
            for (int n = 0; n < enemigos.length; n++) {
                //Verificamos que los enemigos tengan vida
                if (enemigos[n].getPV() > 0) {
                    concentracionAliado = obtenerAliadoEnTurno().getConcentracionTemp();
                    espirituEnemigo = enemigos[n].getEspiritu();
                    if (concentracionAliado > espirituEnemigo) {
                        //Calculamos el daño de la magia
                        damage = damage * (1 + concentracionAliado / 100);
                        finalDamage = (int) (damage - espirituAliado);
                        int nuevoPVEnemigo = (int) (enemigos[n].getPV() - finalDamage);
                        if (nuevoPVEnemigo <= 0) {
                            enemigos[n].setPV(0);
                            varios.pintarVerdeBrillante(enemigos[n].getNombre() + " ha sido derrotado");
                        } else {
                            //Asignamos el nuevo PV al Enemigo
                            enemigos[n].setPV(nuevoPVEnemigo);
                            varios.pintarVerdeBrillante(enemigos[n].getNombre() + "recibe: " + finalDamage + " puntos de daño");
                        }
                        damageTotal = damageTotal + finalDamage;

                    } else {
                        varios.pintarRojoBrillante(enemigos[n].getNombre() + " no recibe daño");
                    }
                }

            }
            //Aplicamos el 40% del daño hecho a los enemigos y los convertimos en PV
            int aliadosVivos = 0;
            for (Aliado aliado : aliados) {
                if (aliado.getPVTemp() > 0) {
                    aliadosVivos++;
                }
            }
            int cantCurar = 0;
            if (aliadosVivos > 0) {
                //Calculamos el 40% del danio hecho
                int damageHecho = (int) (damageTotal * 0.4);
                //Calculamos los PV que recupera cada aliado
                cantCurar = damageHecho / aliadosVivos;

                //Aplicamos los nuevos PV
                for (Aliado aliado : aliados) {
                    if (aliado.getPVTemp() > 0) {
                        int PVInicio = aliado.getPVTemp();
                        aliado.setPVTemp(PVInicio + cantCurar);
                    }
                }
                varios.pintarVerdeBrillante("\nLos aliados reciben " + cantCurar + " puntos de vida");
            }
            /*---------------------------------------------------------------------------------------------*/
        } else if (magiaActiva instanceof Meteoro) {
            int damageMagia = magiaActiva.Damage();
            //recorremos el arreglo de enemigos
            for (int i = 0; i < enemigos.length; i++) {
                if (enemigos[i].getPV() > 0) {
                    concentracionAliado = obtenerAliadoEnTurno().getConcentracionTemp();
                    espirituEnemigo = enemigos[i].getEspiritu();
                    if (concentracionAliado > espirituEnemigo) {
                        //Calculamos el danio por la magia
                        //Calculamos el daño de la magia
                        damageMagia = damageMagia * (1 + concentracionAliado / 100);
                        finalDamage = (int) ((damageMagia) - espirituEnemigo);
                        int nuevoPVEnemigo = (int) (enemigos[i].getPV() - finalDamage);
                        varios.pintarVerdeBrillante(enemigos[i].getNombre() + "recibe: " + finalDamage + " puntos de daño");
                        if (nuevoPVEnemigo <= 0) {
                            enemigos[i].setPV(0);
                            varios.pintarVerdeBrillante(enemigos[i].getNombre() + " ha sido derrotado");
                        } else {
                            //Asignamos el nuevo PV al Enemigo
                            enemigos[i].setPV(nuevoPVEnemigo);
                            varios.pintarVerdeBrillante(enemigos[i].getNombre() + "recibe: " + finalDamage + " puntos de daño");

                        }
                        mostrarPuntosVida();
                    } else {
                        varios.pintarRojoBrillante(enemigos[i].getNombre() + " no recibe daño");
                    }

                }

            }


            /*-------------------------------------------------*/
            //Aplicamos el perder turno para el enemigo
            boolean perderTurno = magiaActiva.PerderTurno();
            if (perderTurno) {
                //Obtenemos el tamanio del arreglo
                int cantAliados = enemigos.length;
                //Si el indice del enemigo en turno ya es el ultimo entonces el primer enemigo pierde el turno
                if (indiceEnemigoEnTurno == cantAliados) {
                    indiceEnemigoEnTurno = 1;
                } else { // De lo contrario aumentamos en 1 el indice
                    indiceEnemigoEnTurno++;
                }
                varios.pintarVerdeBrillante("El equipo enemigo pierde un turno");
            }
        } else if (magiaActiva instanceof MagiaOscura) {
            concentracionAliado = obtenerAliadoEnTurno().getConcentracionTemp();
            espirituEnemigo = obtenerEnemigoEnTurno().getEspiritu();
            if (concentracionAliado > espirituEnemigo) {
                //Calculamos el daño de la magia
                int damageMagia = magiaActiva.Damage() * (1 + concentracionAliado / 100);
                //Aplicamos daño
                finalDamage = (int) ((damageMagia) - espirituEnemigo);
                int nuevoPVEnemigo = (int) (obtenerEnemigoEnTurno().getPV() - finalDamage);
                varios.pintarVerdeBrillante(obtenerEnemigoEnTurno() + " recibe " + finalDamage + " puntos de daño");
                if (nuevoPVEnemigo <= 0) {
                    obtenerEnemigoEnTurno().setPV(0);
                    //Restamos la magia usada del inventario
                    trabajoActivo.usarMagias(magiaActiva);
                    varios.pintarVerdeBrillante(obtenerEnemigoEnTurno() + " ha sido derrotado ");
                } else {
                    //Asignamos el nuevo PV al Enemigo
                    obtenerEnemigoEnTurno().setPV(nuevoPVEnemigo);
                    //Restamos la magia usada del inventario
                    trabajoActivo.usarMagias(magiaActiva);
                }
                mostrarPuntosVida();

            } else {
                varios.pintarRojoBrillante(obtenerEnemigoEnTurno() + " no recibe daño");
            }
            /*------------------------------------------------------------------------------*/
        } else if (magiaActiva instanceof MagiaEscudo) {
            boolean aliadoValido = false;
            int opAliado;
            do {
                varios.pintarAmarilloBrillante("Seleccione un aliado para aumentar la defensa");
                for (int i = 0; i < aliados.length; i++) {
                    if (aliados[i].getPVTemp() > 0) {
                        varios.pintarVerdeBrillante((i + 1) + ".- " + aliados[i].getNombre());
                    }

                }
                opAliado = Integer.parseInt(sc.nextLine());
                opAliado--;
                if (opAliado >= 0 && opAliado <= aliados.length) {
                    aliadoSeleccionado = aliados[opAliado];
                    aliadoSeleccionado.AplicarEscudo(magiaActiva, obtenerAliadoEnTurno());
                    //Restamos la magia usada del inventario
                    trabajoActivo.usarMagias(magiaActiva);
                    aliadoValido = true;
                } else {
                    varios.pintarRojoBrillante("Elija una opcion valida");
                }
            } while (!aliadoValido);
            /*--------------------------------------------------------------------*/
        } else if (magiaActiva instanceof Coraza) {
            boolean aliadoValido = false;
            int opAliado;
            do {
                varios.pintarAmarilloBrillante("Seleccione un aliado para aumentar la defensa");
                for (int i = 0; i < aliados.length; i++) {
                    if (aliados[i].getPVTemp() > 0) {
                        varios.pintarVerdeBrillante((i + 1) + ".- " + aliados[i].getNombre());
                    }

                }
                opAliado = Integer.parseInt(sc.nextLine());
                opAliado--;
                if (opAliado >= 0 && opAliado <= aliados.length) {
                    aliadoSeleccionado = aliados[opAliado];
                    aliadoSeleccionado.AplicarCoraza(magiaActiva, obtenerAliadoEnTurno());
                    //Restamos la magia usada del inventario
                    trabajoActivo.usarMagias(magiaActiva);
                    aliadoValido = true;
                } else {
                    varios.pintarRojoBrillante("Elija una opcion valida");
                }
            } while (!aliadoValido);
            /*----------------------------------------------------------------*/
        } else if (magiaActiva instanceof Revivir) {
            seleccionarAliado = 0;
            //Variable para saber si se ha seleccionado un Caballero Luz con poca vida
            boolean aliadoValido = false;
            while (!aliadoValido) {
                this.seleccionarAliado = SeleccionarAliadoParaRevivir();

                if (this.seleccionarAliado == -1) {

                    return;
                }
                //Obtenemos el PV recuperado
                int nuevoPV = (int) (magiaActiva.recuperarPV() * (1 + obtenerAliadoEnTurno().getConcentracionTemp() / 100));
                //Modificamos el PV del aliado
                aliados[seleccionarAliado].setPVTemp(nuevoPV);
                //Mostramos los PV recuperados
                varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " ha revivido con " + aliados[seleccionarAliado].getPVTemp() + " puntos de vida");
                //Restamos la magia usada del inventario
                trabajoActivo.usarMagias(magiaActiva);
                aliadoValido = true;
            }
            /*--------------------------------------------------------------------*/
        } else if (magiaActiva instanceof Cura) {
            seleccionarAliado = 0;
            //Variable para saber si se ha seleccionado un Caballero Luz con poca vida
            boolean aliadoValido = false;
            while (!aliadoValido) {
                this.seleccionarAliado = SeleccionarAliadoParaCurar();

                if (this.seleccionarAliado == -1) {

                    return;
                }
                //Obtenemos el PV recuperado
                int nuevoPV = (int) (magiaActiva.recuperarPV() * (1 + obtenerAliadoEnTurno().getConcentracionTemp() / 100));
                //Modificamos el PV del aliado
                aliados[seleccionarAliado].setPVTemp(nuevoPV);
                //Mostramos los PV recuperados
                varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " ha revivido con " + aliados[seleccionarAliado].getPVTemp() + " puntos de vida");
                //Restamos la magia usada del inventario
                trabajoActivo.usarMagias(magiaActiva);
                aliadoValido = true;
            }
        }
    }

    //Calcular el daño que hace el enemigo con ataque fisico
    private void EnemigoAtacaFisico() {
        finalDamage = 0;
        fuerzaEnemigo = obtenerEnemigoEnTurno().getFuerza();
        defensaAliado = (int) (obtenerAliadoEnTurno().getDefensaTemp());
        //Verificamos si la defensa del Caballero luz es mayor que la fuerza del enemigo
        if (defensaAliado >= fuerzaEnemigo) {
            varios.pintarVerdeBrillante(obtenerAliadoEnTurno().getNombre() + " no ha recibido daño");
        } else {
            //Realizamos el calculo de daño
            finalDamage = fuerzaEnemigo - defensaAliado;
            int nuevoPVAliado = obtenerAliadoEnTurno().getPVTemp() - finalDamage;
            varios.pintarVerdeBrillante(obtenerEnemigoEnTurno().getNombre() + " ha hecho: " + finalDamage + " puntos de daño");
            if (nuevoPVAliado <= 0) {
                varios.pintarVerdeBrillante(obtenerAliadoEnTurno().getNombre() + " ha sido derrotado");

            } else {

                obtenerAliadoEnTurno().setPVTemp(nuevoPVAliado);
            }
            mostrarPuntosVida();
        }
    }

    //Calcular el daño que hace el enemigo con ataque Magico
    private void EnemigoAtacarMagia() {
        concentracionEnemigo = obtenerEnemigoEnTurno().getConcentracion();
        espirituAliado = (int) obtenerAliadoEnTurno().getEspiritu();
        if (concentracionEnemigo <= espirituAliado) {
            varios.pintarVerdeBrillante(obtenerAliadoEnTurno().getNombre() + " no ha recibido daño");
        } else {
            //Realizamos calculo de daño
            finalDamage = concentracionEnemigo - espirituAliado;
            varios.pintarVerdeBrillante(obtenerEnemigoEnTurno().getNombre() + " ha hecho: " + finalDamage + " puntos de daño");
            int nuevoPVAliado = obtenerAliadoEnTurno().getPVTemp() - finalDamage;
            if (nuevoPVAliado <= 0) {
                obtenerAliadoEnTurno().setPVTemp(0);
            } else {

                obtenerAliadoEnTurno().setPVTemp(nuevoPVAliado);
            }
            mostrarPuntosVida();
        }
    }

    //Metodo para mostrar los aliados
    private int SeleccionarAliadoParaRecuperarVida(Aliado[] aliados) {
        varios.pintarAmarillo("Seleccione un Caballero de la Luz:");
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
        seleccionarAliado--; //Disminuimos en 1 la opcion seleccionada
        return seleccionarAliado;
    }

    //Metodo para mostrar los aliados para usar magia Revivir
    private int SeleccionarAliadoParaRevivir() {
        varios.pintarAmarillo("Seleccione un Caballero de la Luz:");
        //Recorremos el arreglo de aliados
        for (int j = 0; j < aliados.length; j++) {
            //Mostramos los puntos de vida de los aliados
            if (aliados[j].getPVTemp() <= 0) {

                varios.pintarCyanBrillante((j + 1) + ".- " + aliados[j].getNombre() + " puntos de vida: " + aliados[j].getPVTemp());
            }
        }
        varios.pintarAmarilloBrillante("Si desea salir presione 0");
        seleccionarAliado = Integer.parseInt(sc.nextLine());
        if (seleccionarAliado == 0) {
            return -1;
        }
        seleccionarAliado--; //Disminuimos en 1 la opcion seleccionada
        return seleccionarAliado;
    }
    //Metodo para mostrar los aliados para usar magia Cura

    private int SeleccionarAliadoParaCurar() {
        varios.pintarAmarillo("Seleccione un Caballero de la Luz:");
        //Recorremos el arreglo de aliados
        for (int j = 0; j < aliados.length; j++) {
            //Mostramos los puntos de vida de los aliados
            if (aliados[j].getPVTemp() < aliados[j].getPVOriginal()) {

                varios.pintarCyanBrillante((j + 1) + ".- " + aliados[j].getNombre() + " puntos de vida: " + aliados[j].getPVTemp());
            }
        }
        varios.pintarAmarilloBrillante("Si desea salir presione 0");
        seleccionarAliado = Integer.parseInt(sc.nextLine());
        if (seleccionarAliado == 0) {
            return -1;
        }
        seleccionarAliado--; //Disminuimos en 1 la opcion seleccionada
        return seleccionarAliado;
    }

    //Metodo para usar la Pocion
    private void usarPocion() {

        //Variable para saber si se ha seleccionado un Caballero Luz con poca vida
        boolean aliadoValido = false;
        while (!aliadoValido) {
            this.seleccionarAliado = SeleccionarAliadoParaRecuperarVida(aliados);

            if (this.seleccionarAliado == -1) {
                return;
            }
            if (aliados[seleccionarAliado].getPVOriginal() == aliados[seleccionarAliado].getPVTemp()) {
                varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " No ha perdido vida seleccione otro personaje");
                return;
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

    private void usarPocionMayor() {

        //Variable para saber si se ha seleccionado un Caballero Luz con poca vida
        boolean aliadoValido = false;
        while (!aliadoValido) {
            this.seleccionarAliado = SeleccionarAliadoParaRecuperarVida(aliados);

            if (this.seleccionarAliado == -1) {
                return;
            }
            if (aliados[seleccionarAliado].getPVOriginal() == aliados[seleccionarAliado].getPVTemp()) {
                varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " No ha perdido vida seleccione otro personaje");
                //return;
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

    //Metodo para usar Freno
    private void usarFreno() {
        varios.pintarAmarillo("Seleccione un Caballero de la Luz para disminuir velocidad:");
        //Recorremos el arreglo de aliados
        for (int j = 0; j < aliados.length; j++) {

            //Mostramos la velocidad de los aliados
            varios.pintarCyanBrillante((j + 1) + ".- " + aliados[j].getNombre() + " velocidad: " + aliados[j].getVelocidadTemp());
        }
        varios.pintarAmarilloBrillante("Para salir presione 0");
        seleccionarAliado = Integer.parseInt(sc.nextLine());
        seleccionarAliado--;
        if (seleccionarAliado >= 0) {
            //Restamos la velocidad del Caballero Luz con el valor del metod Freno
            velocidadAliado = aliados[seleccionarAliado].getVelocidadTemp() - varios.Freno();
            //Modificamos la velocidad del Caballero
            aliados[seleccionarAliado].setVelocidadTemp(velocidadAliado);
            //Mostramos informacion sobre la velocidad modificada
            varios.pintarCyanBrillante("Velocidad de " + aliados[seleccionarAliado].getNombre() + ": " + aliados[seleccionarAliado].getVelocidadTemp());
        }

    }

    //Metodo para utilizar Pluma de Fenix
    private void usarPlumaFenix() {
        seleccionarAliado = 0;
        //Variable para saber si se ha seleccionado un Caballero Luz con poca vida
        boolean aliadoValido = false;
        while (!aliadoValido) {
            this.seleccionarAliado = SeleccionarAliadoParaRecuperarVida(aliados);

            if (this.seleccionarAliado == -1) {
                return;
            }
            if (aliados[seleccionarAliado].getPVOriginal() == aliados[seleccionarAliado].getPVTemp()) {
                varios.pintarCyanBrillante(aliados[seleccionarAliado].getNombre() + " No ha perdido vida seleccione otro personaje");
                //return;
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

//Metodo para usar la magia de Velocidad
    private void usarVelocidad() {
        varios.pintarAmarillo("Seleccione un Caballero de la Luz para aumentar velocidad:");
        //Recorremos el arreglo de aliados
        for (int j = 0; j < aliados.length; j++) {
            //Mostramos los aliados
            varios.pintarCyanBrillante((j + 1) + ".- " + aliados[j].getNombre() + " velocidad: " + aliados[j].getVelocidadTemp());
        }
        varios.pintarAmarilloBrillante("Para salir presione 0");
        seleccionarAliado = Integer.parseInt(sc.nextLine());
        seleccionarAliado--;
        if (seleccionarAliado >= 0) {
            //Sumamos la velocidad del Caballero Luz con el valor del metod Velocidad
            velocidadAliado = aliados[seleccionarAliado - 1].getVelocidadTemp() + varios.Velocidad();
            //Modificamos la velocidad del Caballero
            aliados[seleccionarAliado - 1].setVelocidadTemp(velocidadAliado);
            //Mostramos informacion sobre la velocidad modificada
            varios.pintarCyanBrillante("Velocidad de " + aliados[seleccionarAliado - 1].getNombre() + ": " + aliados[seleccionarAliado - 1].getVelocidadTemp());

        }

    }

    public void mostrarPuntosVida() {
        varios.pintarVerdeBrillante("Puntos de vida de " + obtenerAliadoEnTurno().getNombre() + ": " + obtenerAliadoEnTurno().getPVTemp());
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

    public boolean isCiudadReconquistada() {
        return ciudadReconquistada;
    }

    public void setCiudadReconquistada(boolean ciudadReconquistada) {
        this.ciudadReconquistada = ciudadReconquistada;
    }
    
    

}
