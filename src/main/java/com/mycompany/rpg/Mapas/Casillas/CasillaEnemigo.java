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

    Random rand = new Random();
    Varios varios;
    //Agregado
    private boolean ciudadDisponible;
    private String nuevoLogo = "\uD83C\uDF8F";

    public CasillaEnemigo(int id, String logo) {
        super(id, logo);
    }

    public CasillaEnemigo() {
        varios = new Varios();
        //Agregado
        cambiarCiudadRecuperada();

    }

    //Creamos una instancia de batalla y enviamos a los caballeros luz, los enemigos y el inventario
    public void enviarPersonajesBatalla(Aliado[] aliados, Objeto[] objetos, Enemigo[] enemigos) {
        if (!ciudadDisponible) {
            Batalla batalla = new Batalla(aliados, enemigos, objetos);
            //agregado
            setCiudadDisponible(batalla.isCiudadReconquistada());
        }else{
            varios.pintarVerdeBrillante("Esta ciudad ya ha sido reconquista");
        }

    }
    //agregado
    private void cambiarCiudadRecuperada(){
        if (!ciudadDisponible) {
            
        }else{
            setLogo(nuevoLogo);
        }
    }

    public String mostrarLogo() {
        return this.getLogo();
    }


    public boolean isCiudadDisponible() {
        return ciudadDisponible;
    }

    public void setCiudadDisponible(boolean ciudadDisponible) {
        this.ciudadDisponible = ciudadDisponible;
    }

}
