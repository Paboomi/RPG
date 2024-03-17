package com.mycompany.rpg;

import com.mycompany.rpg.Mapas.generarMapa;
import com.mycompany.rpg.Personaje.Aliado;
import com.mycompany.rpg.Personaje.Jugador;
import com.mycompany.rpg.Trabajo.Mago_Blanco;
import com.mycompany.rpg.Trabajo.Mago_Oscuro;
import com.mycompany.rpg.Trabajo.Ninja;
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
        System.out.println("Izquierda - A");
        System.out.println("Presione Q para salir"+RESET);
    }
    

    
    public void pintarRojo(String cadena){
        System.out.println(RED+cadena+RESET);
    }
    public void pintarVerde(String cadena){
        System.out.println(GREEN+cadena+RESET);
    }
    public void pintarAmarillo(String cadena){
        System.out.println(YELLOW+cadena+RESET);
    }
 
    public void pintarBlanco(String cadena){
        System.out.println(WHITE+cadena+RESET);
    }
    public void pintarAzul(String cadena){
        System.out.println(BLUE+cadena+RESET);
    }
    public void pintarCyan(String cadena){
        System.out.println(CYAN+cadena+RESET);
    }
    public void pintarPurpura(String cadena){
        System.out.println(PURPLE+cadena+RESET);
    }
    public void pintarRojoBrillante(String cadena){
        System.out.println(BRIGHT_RED+cadena+RESET);
    }
    public void pintarVerdeBrillante(String cadena){
        System.out.println(BRIGHT_GREEN+cadena+RESET);
    }
    public void pintarCyanBrillante(String cadena){
        System.out.println(BRIGHT_CYAN+cadena+RESET);
    }
    public void pintarAmarilloBrillante(String cadena){
        System.out.println(BRIGHT_YELLOW+cadena+RESET);
    }
    public void pintarMagentaBrillante(String cadena){
        System.out.println(BRIGHT_MAGENTA+cadena+RESET);
    }
    public void pintarAzulBrillante(String cadena){
        System.out.println(BRIGHT_BLUE+cadena+RESET);
    }
}
