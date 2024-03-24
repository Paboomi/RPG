package com.mycompany.rpg.Trabajo;

import com.mycompany.rpg.Arma.Arma;
import com.mycompany.rpg.Magias.Magia;

/**
 *
 * @author saien
 */
public class Trabajo {
protected String nombre;
    protected Magia[] inventarioMagias;
    protected Arma[] inventarioArmas;
    public void Menu() {

    }

    public double AumentarFuerza() {
        return 0;
    }

    public double DisminuirFuerza() {
        return 0;
    }

    public double AumentarDefensa() {
        return 0;
    }

    public double DisminuirDefensa() {
        return 0;
    }

    public double AumentarPV() {
        return 0;
    }

    public double AumentarConcentracion() {
        return 0;
    }
    
    public double AumentarEspiritu(){
        return 0;
    }
    public double AumentarVelocidad(){
        return 0;
    }
    public double DisminuirVelocidad(){
        return 0;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Magia[] getInventarioMagias() {
        return inventarioMagias;
    }

    public void setInventarioMagias(Magia[] inventarioMagias) {
        this.inventarioMagias = inventarioMagias;
    }

    public Arma[] getInventarioArmas() {
        return inventarioArmas;
    }

    public void setInventarioArmas(Arma[] inventarioArmas) {
        this.inventarioArmas = inventarioArmas;
    }


    

}
