package com.mycompany.rpg;

import com.mycompany.rpg.Mapas.generarMapa;
import java.util.Random;

/**
 *
 * @author saien
 */
public class Varios {

    Random rand = new Random();

    
    public Varios(){

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
}
