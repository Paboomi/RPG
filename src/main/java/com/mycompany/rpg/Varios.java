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
//metodo para generar numeros aleatorios 

    public int numeroAleatorio(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
//metodo para generar cantidad de enemigos segun el tamaño del mapa

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
                return 0;

        }
    }
//metodo para generar ciudades

    public int cantCiudades() {
        return rand.nextInt(3) + 3;
    }
//metodo para generar tamaños de mapas

    public int sizeMap() {
        int[] size = {7, 10, 12};
        int num = rand.nextInt(size.length);

        return size[num];

    }
//metodo para generar enemigos

    public int numEnemigos() {
        return rand.nextInt(3) + 1;
    }
//Instrucciones para movimientos

    public void instructionMov() {
        System.out.println(BRIGHT_YELLOW + "Instrucciones para realizar movimientos:");
        System.out.println("Se movera una casilla a la vez al momento de ingresar la dirección y presionar enter");
        System.out.println("\n\nDirecciones disponibles:" + RESET);
        System.out.println(BRIGHT_GREEN + "Arriba - W");
        System.out.println("Abajo - S");
        System.out.println("Derecha - D");
        System.out.println("Izquierda - A");
        System.out.println("Presione Q para salir" + RESET);
    }

    public void menuMago() {
        System.out.println(BRIGHT_GREEN + "Elija una accion para realizar");
        System.out.println("1.- Atacar");
        System.out.println("2.- Usar Objeto");
        System.out.println("3.- Usar Magia");
        System.out.println("4.- Usar Habilidad especial");
        System.out.println("5.- Saltar Turno" + RESET);
    }
//Menu para los trabajos que no son magos

    public void menuAliado() {
        System.out.println(BRIGHT_GREEN + "Elija una accion para realizar");
        System.out.println("1.- Atacar");
        System.out.println("2.- Usar Objeto");
        System.out.println("3.- Saltar turno" + RESET);

    }

    //Metodo para Menu Objetos
    public void menuObjetos() {
        System.out.println(BRIGHT_YELLOW+"Seleccione un objeto para usar"+RESET);
        System.out.println(BRIGHT_GREEN+"1.- Pocion");
        System.out.println("2.- Pluma Fenix");
        System.out.println("3.- Tienda Acampar");
        System.out.println("4.- Freno");
        System.out.println("5.- Pocion Mayor");
        System.out.println("6.- Velocidad"+RESET);
    }

    //metodo para modificar velocidad de aliados
    public int Velocidad() {
        return rand.nextInt(5) + 1;
    }

    //Metodo para Pluma de fenix 
    public int PlumaFenix() {
        return rand.nextInt(11) + 10;
    }

    //Metodo para Pocion 
    public int Pocion() {
        return rand.nextInt(3) * 10 + 10;
    }

    //Metodo para Pocion Mayor 
    public int PocionMayor() {
        return rand.nextInt(4) * 10 + 30;
    }

    //Metodo para Freno
    public int Freno() {
        return rand.nextInt(5) + 1;
    }

    //Metodos para colorear String
    public void pintarRojo(String cadena) {
        System.out.println(RED + cadena + RESET);
    }

    public void pintarVerde(String cadena) {
        System.out.println(GREEN + cadena + RESET);
    }

    public void pintarAmarillo(String cadena) {
        System.out.println(YELLOW + cadena + RESET);
    }

    public void pintarBlanco(String cadena) {
        System.out.println(WHITE + cadena + RESET);
    }

    public void pintarAzul(String cadena) {
        System.out.println(BLUE + cadena + RESET);
    }

    public void pintarCyan(String cadena) {
        System.out.println(CYAN + cadena + RESET);
    }

    public void pintarPurpura(String cadena) {
        System.out.println(PURPLE + cadena + RESET);
    }

    public void pintarRojoBrillante(String cadena) {
        System.out.println(BRIGHT_RED + cadena + RESET);
    }

    public void pintarVerdeBrillante(String cadena) {
        System.out.println(BRIGHT_GREEN + cadena + RESET);
    }

    public void pintarCyanBrillante(String cadena) {
        System.out.println(BRIGHT_CYAN + cadena + RESET);
    }

    public void pintarAmarilloBrillante(String cadena) {
        System.out.println(BRIGHT_YELLOW + cadena + RESET);
    }

    public void pintarMagentaBrillante(String cadena) {
        System.out.println(BRIGHT_MAGENTA + cadena + RESET);
    }

    public void pintarAzulBrillante(String cadena) {
        System.out.println(BRIGHT_BLUE + cadena + RESET);
    }
}
