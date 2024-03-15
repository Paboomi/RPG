package com.mycompany.rpg.Mapas;

import com.mycompany.rpg.Mapas.Casillas.*;
import com.mycompany.rpg.Varios;
import java.util.Random;

/**
 *
 * @author saien
 */
public class generarMapa {

    Random rand = new Random();
    Varios varios;

    //Emojis
    String ciudad = "\uD83C\uDFF0";//Identificador = 1
    String tienda = "\uD83C\uDFEA";//identificador = 2
    String posada = "\uD83C\uDFE5";// identificador = 3
    String pasto = "\uD83C\uDF42";//identificador = 4

    //Mapa
    protected int largo;
    protected int ancho;
    protected Casilla[][] casillas;

    //Casillas Ciudad
    private int cantCiudades;
    protected CasillaCiudad[] casillaCiudad;
    //Casillas Posada
    private int cantPosada;
    protected CasillaPosada[] casillaPosada;
    //Casilla Tienda
    private int cantTienda;
    protected CasillaTienda[] casillaTienda;

    //Casilla Pasto
    private int cantPasto;
    protected CasillaPasto[][] casillaPasto;

    //Constructor Mapa
    public generarMapa() {
        varios = new Varios();
        
        this.largo = varios.sizeMap();;
        this.ancho = largo;
        this.cantCiudades = varios.cantCiudades();
        this.cantPosada = 1;
        this.cantTienda = 1;

        crearArreglos();
        almacenarCasillas();
        crearCasillas();

    }

    //Generamos la cantidad de casillas de cada tipo
    private void crearArreglos() {
        casillas = new Casilla[largo][ancho];
        casillaCiudad = new CasillaCiudad[cantCiudades];
        casillaPosada = new CasillaPosada[cantPosada];
        casillaTienda = new CasillaTienda[cantTienda];
        casillaPasto = new CasillaPasto[largo][ancho];

    }

    public void almacenarCasillas() {
        almacenarCiudad();
        almacenarTienda();
        almacenarPosada();

    }

    private void almacenarCiudad() {
        for (int i = 0; i < cantCiudades; i++) {
            int fila, columna;
            do {
                fila = varios.numeroAleatorio(0, largo);
                columna = varios.numeroAleatorio(0, ancho);
            } while (casillas[fila][columna] != null); // Evitar sobrescribir casillas
            //casillas[fila][columna] = new CasillaCiudad(1, ciudad);
            casillas[fila][columna] = casillaCiudad[i];
        }
    }

    private void almacenarTienda() {
        int contador = 0;
        while (contador < cantTienda) {
            int fila = varios.numeroAleatorio(0, largo);
            int columna = varios.numeroAleatorio(0, ancho);
            if (casillas[fila][columna] == null) {
                //casillas[fila][columna] = new CasillaTienda(2, tienda);
                casillas[fila][columna] = casillaTienda[0];

                contador++;
            }
        }
    }

    private void almacenarPosada() {
        int contador = 0;
        while (contador < cantPosada) {
            int fila = varios.numeroAleatorio(0, largo);
            int columna = varios.numeroAleatorio(0, ancho);
            if (casillas[fila][columna] == null) {
                //casillas[fila][columna] = new CasillaPosada(3, posada);
                casillas[fila][columna] = casillaPosada[0];
                contador++;
            }
        }
    }
    public void crearCasillas() {
        crearCiudad();
        crearPosada();
        crearTienda();
        crearPasto();
    }

    private void crearCiudad() {
        for (int i = 0; i < cantCiudades; i++) {
            int fila, columna;
            do {
                fila = varios.numeroAleatorio(0, largo);
                columna = varios.numeroAleatorio(0, ancho);
            } while (casillas[fila][columna] != null); // Evitar sobrescribir casillas
            casillas[fila][columna] = new CasillaCiudad(1, ciudad);
        }
    }

    private void crearTienda() {
        int contador = 0;
        while (contador < cantTienda) {
            int fila = varios.numeroAleatorio(0, largo);
            int columna = varios.numeroAleatorio(0, ancho);
            if (casillas[fila][columna] == null) {
                casillas[fila][columna] = new CasillaTienda(2, tienda);
                contador++;
            }
        }
    }

    private void crearPosada() {
        int contador = 0;
        while (contador < cantPosada) {
            int fila = varios.numeroAleatorio(0, largo);
            int columna = varios.numeroAleatorio(0, ancho);
            if (casillas[fila][columna] == null) {
                casillas[fila][columna] = new CasillaPosada(3, posada);
                contador++;
            }
        }
    }

    private void crearPasto() {

        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++) {
                if (casillas[i][j] == null) {
                    casillas[i][j] = new CasillaPasto(4, pasto);

                }

            }

        }

    }

    public void mostrarTablero() {
        for (int fila = 0; fila < largo; fila++) {
            for (int columna = 0; columna < ancho; columna++) {

                if (casillas[fila][columna] != null) {

                    System.out.print(casillas[fila][columna].getLogo() + " ");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public void setCasilla(String casillas, int fila, int columna) {
        this.casillas[fila][columna].setLogo(casillas);
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

}
