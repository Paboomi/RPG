package com.mycompany.rpg.Personaje;

import com.mycompany.rpg.Objetos.*;
import com.mycompany.rpg.Trabajo.*;
import com.mycompany.rpg.Arma.*;
import com.mycompany.rpg.Varios;

/**
 *
 * @author saien
 */
public class Jugador extends Personaje {

    Varios varios = new Varios();
    Objeto[] inventario;
    Aliado aliado[] = new Aliado[3];
    Trabajo trabajos[];
    Arma armas[];
    int experiencia;
    int oro;
    private String nombre = "Vaan";

    public Jugador() {
        crearAliados();

    }

    public void almacenarAliados(Aliado aliados, int posAliado) {
        if (posAliado >= 0 && posAliado < this.aliado.length) {
            this.aliado[posAliado] = aliados;
        } else {
            System.out.println("Ya no pueden agregarse mas aliados");
        }
    }

    public void verTrabajosAliados() {
        for (int i = 0; i < aliado.length; i++) {
            aliado[i].mostrarTrabajos();

        }
    }

    public void crearAliados() {
        Aliado aliado1 = new Aliado("Celes", new Mago_Blanco());
        Aliado aliado2 = new Aliado("Locke", new Ninja());
        Aliado aliado3 = new Aliado("Rydia", new Mago_Oscuro());

        almacenarAliados(aliado1, 0);
        almacenarAliados(aliado2, 1);
        almacenarAliados(aliado3, 2);

    }

}
