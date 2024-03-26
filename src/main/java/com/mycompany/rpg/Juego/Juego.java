package com.mycompany.rpg.Juego;

import com.mycompany.rpg.Mapas.Casillas.Casilla;
import com.mycompany.rpg.Mapas.Casillas.CasillaCiudad;
import com.mycompany.rpg.Mapas.Casillas.CasillaEnemigo;
import com.mycompany.rpg.Mapas.Casillas.CasillaPasto;
import com.mycompany.rpg.Mapas.Casillas.CasillaPosada;
import com.mycompany.rpg.Mapas.Casillas.CasillaTienda;
import com.mycompany.rpg.Mapas.generarMapa;
import com.mycompany.rpg.Personaje.Enemigo;
import com.mycompany.rpg.Personaje.Enemigo_Fuego.Caballerigneo;
import com.mycompany.rpg.Personaje.Enemigo_Fuego.Flamvell;
import com.mycompany.rpg.Personaje.Enemigo_Fuego.Springan;
import com.mycompany.rpg.Personaje.Enemigo_Hielo.Caballero_Hielo;
import com.mycompany.rpg.Personaje.Enemigo_Hielo.Reina_Hielo;
import com.mycompany.rpg.Personaje.Enemigo_Hielo.Zerofyne;
import com.mycompany.rpg.Personaje.Enemigo_Neutro.Bestia_Attorix;
import com.mycompany.rpg.Personaje.Enemigo_Neutro.Garoozis;
import com.mycompany.rpg.Personaje.Enemigo_Neutro.Lancero_Negro;
import com.mycompany.rpg.Personaje.Jugador;
import com.mycompany.rpg.Varios;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author saien
 */
public class Juego {

    generarMapa mapa;
    Varios varios;
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    Enemigo[] enemigos;
    CasillaEnemigo enemigo;
    //Agregados para batalla
    Jugador jugador;
    //CasillaEnemigo enemigo;

    //Logos objetos
    String ciudad = new String("\uD83C\uDFF0");
    String tienda = new String("\uD83C\uDFEA");
    String posada = new String("\uD83C\uDFE5");
    String pasto = new String("\uD83C\uDF42");
    String logoJugador = new String("\uD83D\uDC66");
    //Variables para generar personajes
    private int cantEnemigos;
    private int posX;
    private int posY;
    private int posEX;
    private int posEY;

    //Constructor 
    public Juego() {
        //instanciamos las clases
        mapa = new generarMapa();
        varios = new Varios();
        jugador = Jugador.getInstance();
        enemigo = new CasillaEnemigo();
        this.cantEnemigos = varios.numEnemigos(); //Generamos la cantidad de enemigos de forma aleatoria
        this.enemigos = new Enemigo[cantEnemigos];
        //enemigo = new CasillaEnemigo();
        //Llamamos a las funcionalidades
        generarPersonajes();
        movimientos();
    }

    private void generarPersonajes() {
        int contEnemigos = 0;

        //Generamos al jugador en una posicion aleatoria
        do {
            posX = varios.numeroAleatorio(0, mapa.getAncho());
            posY = varios.numeroAleatorio(0, mapa.getLargo());

        } while ((mapa.getCasilla(posX, posY) instanceof CasillaCiudad) || (mapa.getCasilla(posX, posY) instanceof CasillaPosada) || (mapa.getCasilla(posX, posY) instanceof CasillaTienda) || (mapa.getCasilla(posX, posY) instanceof CasillaEnemigo));
        //Guardamos la posicion del jugador en el tablero y mostramos su logo
        mapa.setCasilla(logoJugador, posX, posY);

        //Generamos enemigos aleatorios dependiendo el tamaño del mapa
        cantEnemigos = varios.cantEnemigos(mapa.getLargo());
        do {
            do {
                posEX = varios.numeroAleatorio(0, mapa.getAncho());
                posEY = varios.numeroAleatorio(0, mapa.getLargo());

            } while (!(mapa.getCasilla(posEX, posEY) instanceof CasillaPasto) || (mapa.getCasilla(posEX, posEY).getLogo().equals(logoJugador)));
            //Guardamos los enemigos en las casillas del tablero y los escondemos
            mapa.setCasillaEnemigo(posEX, posEY);
            contEnemigos++;
        } while (contEnemigos <= cantEnemigos);

        mapa.mostrarTablero();
    }

    private void movimientos() {
        varios.instructionMov();
        char op;
        boolean salir = false;
        int tempX = posX;
        int tempY = posY;

        do {
            System.out.println("Ingrese la direccion en la que desea moverse");
            op = sc.nextLine().charAt(0);

            switch (op) {
                //Movimiento hacia arriba
                case 'w':
                    tempX = tempX - 1;

                    // Comprobamos si el movimiento está fuera del mapa
                    if (tempX < 0) {
                        varios.pintarRojoBrillante("No puede seguir avanzando fuera del mapa");
                        tempX = tempX + 1; // Retrocedemos el movimiento
                    } else {
                        // Comprobamos qué tipo de casilla hay en la nueva posición
                        Casilla casillaNueva = mapa.getCasilla(tempX, tempY);
                        if (casillaNueva instanceof CasillaTienda) {
                            System.out.println("Aqui deberia ir la tienda");

                        } else if (casillaNueva instanceof CasillaPasto) {

                        } else if (casillaNueva instanceof CasillaPosada) {
                            System.out.println("Aqui deberia ir la posada");

                        } else if (casillaNueva instanceof CasillaCiudad) {
                            System.out.println("Aqui deberian tirarse riata");
                            //mandamos a los caballeros luz a la batalla
                            CasillaCiudad ciudad = new CasillaCiudad();
                            ciudad.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());

                        } else if (casillaNueva instanceof CasillaEnemigo) {
                            System.out.println("Aqui deberian tirarse riata");
                            //mandamos a los caballeros luz a la batalla
                            //CasillaEnemigo enemigo = new CasillaEnemigo();
                            almacenarEnemigos();
                            enemigo.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario(), getEnemigos());

                        }

                        // Actualizamos la posición del jugador en el mapa
                        mapa.setCasilla(logoJugador, tempX, tempY);
                        logOriginal();
                        mapa.mostrarTablero();
                    }

                    // Actualizamos las coordenadas del jugador
                    posX = tempX;
                    posY = tempY;
                    break;

                //Movimiento hacia abajo
                case 's':
                    tempX = tempX + 1;

                    // Comprobamos si el movimiento está fuera del mapa
                    if (tempX >= mapa.getAncho()) {
                        varios.pintarRojoBrillante("No puede seguir avanzando fuera del mapa");
                        tempX = tempX - 1; // Retrocedemos el movimiento
                    } else {
                        // Comprobamos qué tipo de casilla hay en la nueva posición
                        Casilla casillaNueva = mapa.getCasilla(tempX, tempY);
                        if (casillaNueva instanceof CasillaTienda) {
                            System.out.println("Aqui deberia ir la tienda");

                        } else if (casillaNueva instanceof CasillaPasto) {

                        } else if (casillaNueva instanceof CasillaPosada) {
                            System.out.println("Aqui deberia ir la posada");

                        } else if (casillaNueva instanceof CasillaCiudad) {
                            System.out.println("Aqui deberian tirarse riata");
                            CasillaCiudad ciudad = new CasillaCiudad();
                            ciudad.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());

                        } else if (casillaNueva instanceof CasillaEnemigo) {
                            System.out.println("Aqui deberian tirarse riata");
                            //mandamos a los caballeros luz a la batalla

                            enemigo.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario(), getEnemigos());

                        }

                        // Actualizamos la posición del jugador en el mapa
                        mapa.setCasilla(logoJugador, tempX, tempY);
                        logOriginal();
                        mapa.mostrarTablero();
                    }

                    // Actualizamos las coordenadas del jugador
                    posX = tempX;
                    posY = tempY;
                    break;

                //Movimiento hacia la izquierda
                case 'a':
                    tempY = tempY - 1;
                    // Comprobamos si el movimiento está fuera del mapa
                    if (tempY < 0) {
                        varios.pintarRojoBrillante("No puede seguir avanzando fuera del mapa");
                        tempY = tempY + 1; // Retrocedemos el movimiento
                    } else {
                        // Comprobamos qué tipo de casilla hay en la nueva posición
                        Casilla casillaNueva = mapa.getCasilla(tempX, tempY);
                        if (casillaNueva instanceof CasillaTienda) {
                            System.out.println("Aqui deberia ir la tienda");

                        } else if (casillaNueva instanceof CasillaPasto) {

                        } else if (casillaNueva instanceof CasillaPosada) {
                            System.out.println("Aqui deberia ir la posada");

                        } else if (casillaNueva instanceof CasillaCiudad) {
                            System.out.println("Aqui deberian tirarse riata");
                            CasillaCiudad ciudad = new CasillaCiudad();
                            ciudad.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());

                        } else if (casillaNueva instanceof CasillaEnemigo) {
                            System.out.println("Aqui deberian tirarse riata");
                            //mandamos a los caballeros luz a la batalla
                            //CasillaEnemigo enemigo = new CasillaEnemigo();
                            enemigo.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario(), getEnemigos());

                        }

                        // Actualizamos la posición del jugador en el mapa
                        mapa.setCasilla(logoJugador, tempX, tempY);
                        logOriginal();
                        mapa.mostrarTablero();
                    }

                    // Actualizamos las coordenadas del jugador
                    posX = tempX;
                    posY = tempY;
                    break;
                case 'd':
                    tempY = tempY + 1;
                    // Comprobamos si el movimiento está fuera del mapa
                    if (tempY >= mapa.getLargo()) {
                        varios.pintarRojoBrillante("No puede seguir avanzando fuera del mapa");
                        tempY = tempY - 1; // Retrocedemos el movimiento
                    } else {
                        // Comprobamos qué tipo de casilla hay en la nueva posición
                        Casilla casillaNueva = mapa.getCasilla(tempX, tempY);
                        if (casillaNueva instanceof CasillaTienda) {
                            System.out.println("Aqui deberia ir la tienda");

                        } else if (casillaNueva instanceof CasillaPasto) {

                        } else if (casillaNueva instanceof CasillaPosada) {
                            System.out.println("Aqui deberia ir la posada");

                        } else if (casillaNueva instanceof CasillaCiudad) {
                            System.out.println("Aqui deberian tirarse riata");
                            CasillaCiudad ciudad = new CasillaCiudad();
                            ciudad.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());

                        } else if (casillaNueva instanceof CasillaEnemigo) {
                            System.out.println("Aqui deberian tirarse riata");

                            //CasillaEnemigo enemigo = new CasillaEnemigo();
                            enemigo.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario(), getEnemigos());

                        }

                        // Actualizamos la posición del jugador en el mapa
                        mapa.setCasilla(logoJugador, tempX, tempY);
                        logOriginal();
                        mapa.mostrarTablero();
                    }

                    // Actualizamos las coordenadas del jugador
                    posX = tempX;
                    posY = tempY;
                    break;

                case 'q':
                    salir = true;
                    break;
                default:
                    varios.pintarRojoBrillante("Seleccione una direccion valida");
            }
        } while (!salir);

    }

    private void logOriginal() {
        int x = posX;
        int y = posY;

        if (mapa.getCasilla(x, y) instanceof CasillaPasto) {
            mapa.setCasilla(pasto, posX, posY);
        }
        if (mapa.getCasilla(x, y) instanceof CasillaTienda) {
            mapa.setCasilla(tienda, posX, posY);
        }
        if (mapa.getCasilla(x, y) instanceof CasillaPosada) {
            mapa.setCasilla(posada, posX, posY);
        }
        if (mapa.getCasilla(x, y) instanceof CasillaCiudad) {
            mapa.setCasilla(ciudad, posX, posY);
        }
        if (mapa.getCasilla(x, y) instanceof CasillaEnemigo) {
            mapa.setCasilla(pasto, x, y);
        }
    }

    //Generamos una instancia de enemigo aleatorio con un nivel de forma aleatoria
    public Enemigo generarEnemigos() {
        int nivel = rand.nextInt(5) * 10 + 10;
        int op = rand.nextInt(9);
        switch (op) {

            case 0:
                return new Caballerigneo(nivel);

            case 1:
                return new Flamvell(nivel);

            case 2:
                return new Springan(nivel);

            case 3:
                return new Caballero_Hielo(nivel);

            case 4:
                return new Zerofyne(nivel);

            case 5:
                return new Reina_Hielo(nivel);

            case 6:
                return new Garoozis(nivel);

            case 7:
                return new Bestia_Attorix(nivel);
            case 8:
                return new Lancero_Negro(nivel);

            default:
                return null;

        }
    }

    //Guardamos los enemigos generados y que seran enviados a la Batalla
    public void almacenarEnemigos() {

        for (int i = 0; i < cantEnemigos; i++) {
            Enemigo enemigo = generarEnemigos();
            enemigos[i] = enemigo;
        }
    }

    public Enemigo[] getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(Enemigo[] enemigos) {
        this.enemigos = enemigos;
    }

}
