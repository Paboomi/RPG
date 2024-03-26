package com.mycompany.rpg.Mapas.Casillas;

import com.mycompany.rpg.Personaje.Aliado;
import com.mycompany.rpg.Personaje.Jugador;
import com.mycompany.rpg.Varios;
import java.util.Scanner;

/**
 *
 * @author saien
 */
public class CasillaPosada extends Casilla {

    private final int costoRecuperacion = 150;
    Jugador jugador;
    Scanner sc = new Scanner(System.in);
    Varios varios;
    Aliado[] aliados;

    public CasillaPosada(int id, String logo) {
        super(id, logo);
    }

    public CasillaPosada() {
        jugador = Jugador.getInstance();
        this.aliados = jugador.getAliado();
        varios = new Varios();
    }

    public void EntrarPosada() {
        varios.pintarCyanBrillante("Bienvenido a la posada");
        varios.pintarAmarilloBrillante("El costo por descansar aqui es de " + costoRecuperacion + " monedas");
        varios.pintarCyanBrillante("Ingresa 's' para confirmar o 'n' para salir de la posada");
        String op = sc.nextLine();

        if (op.equalsIgnoreCase("S")) {
            if (jugador.getOro() >= costoRecuperacion) {
                RecuperarAliados();
                varios.pintarVerdeBrillante("Los aliados han recuperado sus puntos de vida");
            }else{
                varios.pintarRojoBrillante("No tienes suficiente oro para que descanses aqui");
            }
        }
        sc.close();
    }

    //Metodo para recuperar Aliados
    private void RecuperarAliados() {
        for (Aliado aliado : aliados) {
            aliado.setPV(100);
        }
    }

    public String mostrarLogo() {
        return this.getLogo();
    }
}
