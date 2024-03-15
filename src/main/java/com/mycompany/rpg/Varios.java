package com.mycompany.rpg;

import com.mycompany.rpg.Mapas.generarMapa;
import java.util.Random;

/**
 *
 * @author saien
 */
public class Varios {

    Random rand = new Random();

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String BRIGHT_RED = "\033[0;91m";   // BRIGHT RED
    public static final String BRIGHT_GREEN = "\033[0;92m";   // BRIGHT GREEN
    public static final String BRIGHT_YELLOW = "\033[0;93m";   // BRIGHT YELLOW
    public static final String BRIGHT_BLUE = "\033[0;94m";   // BRIGHT BLUE
    public static final String BRIGHT_MAGENTA = "\033[0;95m";   // BRIGHT MAGENTA
    public static final String BRIGHT_CYAN = "\033[0;96m";   // BRIGHT CYAN

    public Varios() {

    }

    public int numeroAleatorio(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    public int cantEnemigos(int numero) {
        int op = numero;

        switch (op) {
            case 7:
                return 20;

            case 10:
                return 30;

            case 12:
                return 40;

            default:
                throw new IllegalArgumentException("Tamaño de mapa no válido: " + op);

        }
    }

    public int cantCiudades() {
        return rand.nextInt(3) + 3;
    }

    public int sizeMap() {
        int[] size = {7, 10, 12};
        int num = rand.nextInt(size.length);

        return size[num];

    }
    
    public void instructionMov(){
        System.out.println(BRIGHT_YELLOW+"Instrucciones para realizar movimientos:");
        System.out.println("Se movera una casilla a la vez al momento de ingresar la dirección y presionar enter");
        System.out.println("\n\nDirecciones disponibles:"+RESET);
        System.out.println(BRIGHT_GREEN+"Arriba - W");
        System.out.println("Abajo - S");
        System.out.println("Derecha - D");
        System.out.println("Izquierda - A"+RESET);
    }
}
