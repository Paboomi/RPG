package com.mycompany.rpg.Mapas.Casillas;

import com.mycompany.rpg.Arma.ArmaUnaMano.Espada;
import com.mycompany.rpg.Arma.ArmaUnaMano.Hacha;
import com.mycompany.rpg.Arma.ArmaUnaMano.Maza;
import com.mycompany.rpg.Personaje.Aliado;
import com.mycompany.rpg.Personaje.Jugador;
import com.mycompany.rpg.Trabajo.Trabajo;
import com.mycompany.rpg.Varios;
import java.util.Scanner;

/**
 *
 * @author saien
 */
public class CasillaTienda extends Casilla {

    Varios varios;
    Scanner sc = new Scanner(System.in);
    Jugador jugador;

    Aliado[] aliados;
    Trabajo trabajoSeleccionado;
    public CasillaTienda(int id, String logo) {
        super(id, logo);
    }

    public CasillaTienda() {
        varios = new Varios();
        jugador = Jugador.getInstance();
        this.aliados = jugador.getAliado();
    }

    public void Menu() {
        int opcion;
        int op;
        do {
            System.out.println("Bienvenido a la tienda. Por favor, elija una sección:");
            System.out.println("1. Armas de una mano");
            System.out.println("2. Armas pesadas");
            System.out.println("3. Armas cortas");
            System.out.println("4. Bacúlos");
            System.out.println("5. Escudos");
            System.out.println("6. Trabajos");
            System.out.println("7. Magias");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarArmasUnaMano();
                    op = Integer.parseInt(sc.nextLine());
                    break;
                case 2:
                    mostrarArmasPesadas();
                    break;
                case 3:
                    mostrarArmasCortas();
                    break;
                case 4:
                    mostrarBaculos();
                    break;
                case 5:
                    mostrarEscudos();
                    break;
                case 6:
                    mostrarTrabajos();
                    break;
                case 7:
                    mostrarMagias();
                    break;
                case 8:
                    System.out.println("Gracias por visitar la tienda. ¡Vuelve pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
            }
        } while (opcion != 8);

        sc.close();
    }

    public void mostrarArmasUnaMano() {
        int op;
        int aliadoSeleccionado;
        int cantidad;
        System.out.println("\nArmas de una mano:");
        System.out.println("1. Espada: 400");
        System.out.println("2. Hacha: 500");
        System.out.println("3. Maza: 600");
        varios.pintarAmarilloBrillante("Seleccione el arma que desea comprar");
        op = Integer.parseInt(sc.nextLine());
        varios.pintarAmarilloBrillante("Seleccione la cantidad");
        cantidad = Integer.parseInt(sc.nextLine());
        
        switch (op) {
            case 1:
                varios.pintarCyanBrillante("Seleccione el aliado al que quiere darle el arma");
                Espada espada = new Espada();
                aliadoSeleccionado = MostrarAliados();
                if (aliadoSeleccionado < 0) {
                    return;
                } else {
                    trabajoSeleccionado.agregarArma(espada, cantidad);
                }
                break;
            case 2:
                varios.pintarCyanBrillante("Seleccione el aliado al que quiere darle el arma");
                Hacha hacha = new Hacha();
                aliadoSeleccionado = MostrarAliados();
                if (aliadoSeleccionado < 0) {
                    return;
                } else {
                    trabajoSeleccionado.agregarArma(hacha, cantidad);
                }
                break;
            case 3:
                varios.pintarCyanBrillante("Seleccione el aliado al que quiere darle el arma");
                Maza maza = new Maza();
                aliadoSeleccionado = MostrarAliados();
                if (aliadoSeleccionado < 0) {
                    return;
                } else {
                    trabajoSeleccionado.agregarArma(maza, cantidad);
                }
                break;
            default:
                varios.pintarRojoBrillante("Opcion no disponible");
        }

    }

    public static void mostrarArmasPesadas() {
        System.out.println("\nArmas pesadas:");
        System.out.println("1. Alabarda");
        System.out.println("2. Espada Larga");
        System.out.println("3. Lanza");
    }

    public static void mostrarArmasCortas() {
        System.out.println("\nArmas cortas:");
        System.out.println("1. Cuchillo Combate");
        System.out.println("2. Daga");
        System.out.println("3. Estilete");
    }

    public static void mostrarBaculos() {
        System.out.println("\nBacúlos:");
        System.out.println("1. Scientiae");
        System.out.println("2. Statera");
        System.out.println("3. Vivificantem");
    }

    public static void mostrarEscudos() {
        System.out.println("\nEscudos:");
        System.out.println("1. Escudo Dragon");
        System.out.println("2. Escudo Encantado");
        System.out.println("3. Escudo Hierro");
    }

    public static void mostrarTrabajos() {
        System.out.println("\nTrabajos:");
        System.out.println("1. Ninja");
        System.out.println("2. Guerrero");
        System.out.println("3. Mago Oscuro");
        System.out.println("4. Mago Blanco");
        System.out.println("5. Mago Rojo");
        System.out.println("6. Paladin");
    }

    public static void mostrarMagias() {
        System.out.println("\nMagias:");
        System.out.println("1. Magia Blanca");
        System.out.println("2. Magia Oscura");
    }

    public String mostrarLogo() {
        return this.getLogo();
    }

    private int MostrarAliados() {
        int op;
        varios.pintarAmarilloBrillante("Seleccione un aliado");
        for (int i = 0; i < aliados.length; i++) {
            varios.pintarAmarilloBrillante((i + 1) + ".- " + aliados[i].getNombre());
        }
        varios.pintarVerdeBrillante("Para salir presione 0");
        op = Integer.parseInt(sc.nextLine());
        op--;
        if (op >= 0) {
            trabajoSeleccionado=aliados[op].getTrabajo()[op];
        }
        return op;
    }
}
