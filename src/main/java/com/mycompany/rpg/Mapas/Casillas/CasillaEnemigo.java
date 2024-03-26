package com.mycompany.rpg.Mapas.Casillas;

import com.mycompany.rpg.Batalla.Batalla;
import com.mycompany.rpg.Objetos.Objeto;
import com.mycompany.rpg.Personaje.Aliado;
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
import com.mycompany.rpg.Varios;
import java.util.Random;

/**
 *
 * @author saien
 */
public class CasillaEnemigo extends Casilla {

    int cantEnemigos;
    Random rand = new Random();
    Varios varios;
    Enemigo[] enemigos;
    boolean Derrotados = false;

    public CasillaEnemigo(int id, String logo) {
        super(id, logo);
        varios = new Varios(); 
        this.cantEnemigos = varios.numEnemigos(); //Generamos la cantidad de enemigos de forma aleatoria
        this.enemigos = new Enemigo[cantEnemigos];
        almacenarEnemigos();
    }

    public CasillaEnemigo() {
        
    }

    //Creamos una instancia de batalla y enviamos a los caballeros luz, los enemigos y el inventario
    public void enviarPersonajesBatalla(Aliado[] aliados, Objeto[] objetos) {
        Batalla batalla = new Batalla(aliados, enemigos, objetos);
        setDerrotados(batalla.isDerrotados());
    }

    public String mostrarLogo() {
        return this.getLogo();
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

    public boolean isDerrotados() {
        return Derrotados;
    }

    public void setDerrotados(boolean Disponible) {
        this.Derrotados = Disponible;
    }

   
    

}
