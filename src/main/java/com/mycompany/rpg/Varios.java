package com.mycompany.rpg;

import java.util.Random;

/**
 *
 * @author saien
 */
public class Varios {

    Random rand = new Random();

    public int numeroAleatorio(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    public int cantCiudades() {
        return rand.nextInt(3)+3;
       /* int num;
        num = rand.nextInt(3);
        
        switch (num) {
            case 0:
                
                break;
            default:
                throw new AssertionError();
        }*/
    }
}
