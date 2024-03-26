package com.mycompany.rpg.Mapas;

import com.mycompany.rpg.Mapas.Casillas.*;
import com.mycompany.rpg.Mapas.generarMapa;
import com.mycompany.rpg.Personaje.Jugador;
import com.mycompany.rpg.Varios;
import java.util.Scanner;

public class Mapa {

    private generarMapa mapa;
    private Varios varios;
    private Scanner sc = new Scanner(System.in);
    private Jugador jugador;

    //Logos objetos
    String ciudad = new String("\uD83C\uDFF0");
    String tienda = new String("\uD83C\uDFEA");
    String posada = new String("\uD83C\uDFE5");
    String pasto = new String("\uD83C\uDF42");
    String logoJugador = new String("\uD83D\uDC66");
    private int posX;
    private int posY;

    public Mapa() {
        mapa = new generarMapa();
        varios = new Varios();
        jugador = Jugador.getInstance();
        generarPersonajes();
        movimientos();
    }

    private void generarPersonajes() {
        // Generar jugador en una posición aleatoria
        do {
            posX = varios.numeroAleatorio(0, mapa.getAncho());
            posY = varios.numeroAleatorio(0, mapa.getLargo());
        } while ((mapa.getCasilla(posX, posY) instanceof CasillaCiudad)
                || (mapa.getCasilla(posX, posY) instanceof CasillaPosada)
                || (mapa.getCasilla(posX, posY) instanceof CasillaTienda)
                || (mapa.getCasilla(posX, posY) instanceof CasillaEnemigo));

        // Guardar la posición del jugador en el tablero y mostrar su logo
        mapa.setCasilla(logoJugador, posX, posY);
        mapa.mostrarTablero();
    }

    private void movimientos() {
        varios.instructionMov();
        char op;
        boolean salir = false;
        int tempX = posX;
        int tempY = posY;

        do {
            System.out.println("Ingrese la dirección en la que desea moverse");
            op = sc.nextLine().charAt(0);

            switch (op) {
                // Movimiento hacia arriba
                case 'w':
                    tempX = tempX - 1;
                    realizarMovimiento(tempX, tempY);
                    break;

                // Movimiento hacia abajo
                case 's':
                    tempX = tempX + 1;
                    realizarMovimiento(tempX, tempY);
                    break;

                // Movimiento hacia la izquierda
                case 'a':
                    tempY = tempY - 1;
                    realizarMovimiento(tempX, tempY);
                    break;

                // Movimiento hacia la derecha
                case 'd':
                    tempY = tempY + 1;
                    realizarMovimiento(tempX, tempY);
                    break;

                case 'q':
                    salir = true;
                    break;

                default:
                    varios.pintarRojoBrillante("Seleccione una dirección válida");
            }
        } while (!salir);
    }

    private void realizarMovimiento(int tempX, int tempY) {
        if (tempX < 0 || tempX >= mapa.getAncho() || tempY < 0 || tempY >= mapa.getLargo()) {
            varios.pintarRojoBrillante("No puede seguir avanzando fuera del mapa");
        } else {
            Casilla casillaNueva = mapa.getCasilla(tempX, tempY);
            if (casillaNueva instanceof CasillaTienda) {
                System.out.println("Aquí debería ir la tienda");
            } else if (casillaNueva instanceof CasillaPosada) {
                System.out.println("Aquí debería ir la posada");
            } else if (casillaNueva instanceof CasillaCiudad) {
                System.out.println("Aquí deberían tirarse riata");
                CasillaCiudad ciudad = (CasillaCiudad) casillaNueva;
                ciudad.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());
            } else if (casillaNueva instanceof CasillaEnemigo) {
                System.out.println("Aquí deberían tirarse riata");
                CasillaEnemigo enemigo = (CasillaEnemigo) casillaNueva;
                enemigo.enviarPersonajesBatalla(jugador.getAliado(), jugador.getInventario());
            } else {
                mapa.setCasilla(logoJugador, tempX, tempY);
                mapa.setCasilla(mapa.getCasilla(posX, posY).getLogo(), posX, posY);
                mapa.mostrarTablero();
                posX = tempX;
                posY = tempY;
            }
        }
    }

}
