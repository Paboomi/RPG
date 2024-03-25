package com.mycompany.rpg.Mapas.Casillas;

import com.mycompany.rpg.Arma.Arma;
import com.mycompany.rpg.Arma.ArmaCorta.*;
import com.mycompany.rpg.Arma.ArmaUnaMano.*;
import com.mycompany.rpg.Arma.ArmaDosManos.*;
import com.mycompany.rpg.Arma.Baculo.*;
import com.mycompany.rpg.Batalla.BatallaCaballerosOscuros;
import com.mycompany.rpg.Objetos.Objeto;
import com.mycompany.rpg.Personaje.Aliado;
import com.mycompany.rpg.Personaje.CaballeroOscuro;
import com.mycompany.rpg.Varios;
import com.mycompany.rpg.Trabajo.*;
import java.util.Random;

/**
 *
 * @author saien
 */
public class CasillaCiudad extends Casilla {

    private static final String[] NOMBRES = {
        "Morgoth", "Grimnir",
        "Kael'thas", "Arthas", "Zul'jin",
        "Kil'jaeden", "Anub'arak", "Illidan",
        "Gul'dan", "Ner'zhul", "Cho'gall"
    };
    private static final Arma[] armas = {
        new CuchilloCombate(), new Daga(), new Estilete(), new Espada(), new Hacha(), new Maza(),
        new Alabarda(), new Lanza(), new EspadaLarga(), new Scientiae(), new Statera(), new Vivificantem()
    };
    Random rand = new Random();
    CaballeroOscuro[] caballeros;

    //Constructor para generar el mapa
    public CasillaCiudad(int id, String logo) {
        super(id, logo);
    }

    //Constructor para usar en la Batalla
    public CasillaCiudad() {
        this.caballeros = new CaballeroOscuro[4];
        almacenarCaballeros();
    }

    //Creamos una instancia de batalla y enviamos a los caballeros luz, los enemigos y el inventario
    public void enviarPersonajesBatalla(Aliado[] aliados, Objeto[] objetos) {
        BatallaCaballerosOscuros batalla = new BatallaCaballerosOscuros(aliados, caballeros, objetos);

    }

    public Trabajo generarTrabajo() {
        int op = rand.nextInt(5);
        switch (op) {

            case 0:
                return new Guerrero();

            case 1:
                return new Mago_Blanco();

            case 2:
                return new Mago_Oscuro();

            case 3:
                return new Mago_Rojo();

            case 4:
                return new Ninja();

            case 5:
                return new Paladin();

            default:
                return null;

        }
    }

    //Guardamos los enemigos generados y que seran enviados a la Batalla
    public void almacenarCaballeros() {

        for (int i = 0; i < 4; i++) {
            Trabajo trabajo = generarTrabajo();
            String nombreAleatorio = NOMBRES[rand.nextInt(NOMBRES.length)];
            Arma armaAleatoria = armas[rand.nextInt(armas.length)];
            caballeros[i] = new CaballeroOscuro(nombreAleatorio, trabajo, armaAleatoria);
        }
    }

    public String mostrarLogo() {
        return this.getLogo();
    }

    public CaballeroOscuro[] getCaballeros() {
        return caballeros;
    }

    public void setCaballeros(CaballeroOscuro[] caballeros) {
        this.caballeros = caballeros;
    }
    
    
}
