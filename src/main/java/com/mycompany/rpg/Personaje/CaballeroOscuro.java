package com.mycompany.rpg.Personaje;

import com.mycompany.rpg.Trabajo.*;
import com.mycompany.rpg.Arma.*;
import com.mycompany.rpg.Arma.ArmaCorta.CuchilloCombate;
import com.mycompany.rpg.Arma.ArmaCorta.Daga;
import com.mycompany.rpg.Arma.ArmaCorta.Estilete;
import com.mycompany.rpg.Arma.ArmaDosManos.Alabarda;
import com.mycompany.rpg.Arma.ArmaDosManos.EspadaLarga;
import com.mycompany.rpg.Arma.ArmaDosManos.Lanza;
import com.mycompany.rpg.Arma.ArmaUnaMano.Espada;
import com.mycompany.rpg.Arma.ArmaUnaMano.Hacha;
import com.mycompany.rpg.Arma.ArmaUnaMano.Maza;
import com.mycompany.rpg.Arma.Baculo.Scientiae;
import com.mycompany.rpg.Arma.Baculo.Statera;
import com.mycompany.rpg.Arma.Baculo.Vivificantem;
import com.mycompany.rpg.Arma.Escudo.EscudoDragon;
import com.mycompany.rpg.Arma.Escudo.EscudoEncantado;
import com.mycompany.rpg.Arma.Escudo.EscudoHierro;

/**
 *
 * @author saien
 */
public class CaballeroOscuro extends Personaje {

    Trabajo trabajo;
    Arma arma;
    private String logo = "\uD83D\uDD30";

    public CaballeroOscuro(String nombre, Trabajo trabajo, Arma arma) {
        this.nombre = nombre;
        this.trabajo = trabajo;
        this.arma = arma;
        iniciarEstadisticas();
        cambiarEstadisticasTrabajo(trabajo);
        cambiarEstadisticasArma(arma, trabajo);
    }

    private void iniciarEstadisticas() {
        this.PV = 150;
        this.fuerza = 50;
        this.defensa = 50;
        this.concentracion = 35;
        this.espiritu = 25;
        this.velocidad = 25;
        this.nivel = 50;
        this.experiencia = 100;
    }

    private void cambiarEstadisticasTrabajo(Trabajo trabajo) {

        if (this.trabajo == null) {

        } else {
            //Obtenemos los porcentajes de los personajes que cambian las estadisticas
            double aumentoTempFuerza = trabajo.AumentarFuerza();
            double aumentoTempDefensa = trabajo.AumentarDefensa();
            double aumentoTempVelocidad = trabajo.AumentarVelocidad();
            double disminuirTempFuerza = trabajo.DisminuirFuerza();
            double disminuirTempDefensa = trabajo.DisminuirDefensa();
            double aumentoTempPV = trabajo.AumentarPV();
            double disminuirTempVelocidad = trabajo.DisminuirVelocidad();

            //Verificamos que tipo de trabajo es para aumentar las estadisticas
            if (trabajo instanceof Mago_Blanco) {
                // Calcular los nuevos valores de los atributos según los porcentajes
                this.fuerza = (int) (fuerza * (1 - disminuirTempFuerza));
                this.defensa = (int) (defensa * (1 + aumentoTempDefensa));
            } else if (trabajo instanceof Mago_Oscuro) {
                // Calcular los nuevos valores de los atributos según los porcentajes
                this.fuerza = (int) (fuerza * (1 - disminuirTempFuerza));
                this.fuerza = (int) (defensa * (1 + aumentoTempDefensa));
            } else if (trabajo instanceof Mago_Rojo) {
                // Calcular los nuevos valores de los atributos según los porcentajes
                this.fuerza = (int) (fuerza * (1 - disminuirTempDefensa));
            } else if (trabajo instanceof Guerrero) {
                // Calcular los nuevos valores de los atributos según los porcentajes
                this.fuerza = (int) (fuerza * (1 + aumentoTempFuerza));
                this.velocidad = (int) (velocidad * (1 - disminuirTempVelocidad));
            } else if (trabajo instanceof Ninja) {
                // Calcular los nuevos valores de los atributos según los porcentajes
                this.velocidad = (int) (velocidad * (1 + aumentoTempVelocidad));
                this.defensa = (int) (defensa * (1 - disminuirTempDefensa));
            } else if (trabajo instanceof Paladin) {
                // Calcular los nuevos valores de los atributos según los porcentajes
                this.defensa = (int) (defensa * (1 + aumentoTempDefensa));
                this.PV = (int) (PV * (1 + aumentoTempPV));
            }
        }
    }

    private void cambiarEstadisticasArma(Arma arma, Trabajo trabajo) {

        if (this.trabajo == null) {

        } else {
            //Obtenemos los valores de las armas que cambian las estadisticas
            int aumentoTempFuerza = arma.AumentarFuerza();
            int aumentoTempDefensa = arma.AumentarDefensa();
            int aumentoTempVelocidad = arma.AumentarVelocidad();
            int disminuirTempVelocidad = arma.DisminuirVelocidad();
            int aumentoTempPV = arma.AumentarPV();
            int aumentoTempConcentracion = arma.AumentarConcentracion();

            //Verificamos que tipo de arma es para aumentar las estadisticas
            if (arma instanceof CuchilloCombate) {
                // Calcular los nuevos valores de los atributos
                velocidad = velocidad + aumentoTempVelocidad;
            } else if (arma instanceof Daga) {
                // Calcular los nuevos valores de los atributos
                velocidad = velocidad + aumentoTempVelocidad;
            } else if (arma instanceof Estilete) {
                // Calcular los nuevos valores de los atributos
                velocidad = velocidad + aumentoTempVelocidad;
            } else if (arma instanceof Alabarda) {
                // Calcular los nuevos valores de los atributos
                fuerza = fuerza + aumentoTempFuerza;
                velocidad = velocidad + disminuirTempVelocidad;
            } else if (arma instanceof EspadaLarga) {
                // Calcular los nuevos valores de los atributos
                fuerza = fuerza + aumentoTempFuerza;
                velocidad = velocidad + disminuirTempVelocidad;
            } else if (arma instanceof Lanza) {
                // Calcular los nuevos valores de los atributos
                velocidad = velocidad + aumentoTempFuerza;
                velocidad = velocidad + disminuirTempVelocidad;
            } else if (arma instanceof Espada) {
                //Verificamos si el trabajo del Caballero Luz es de tipo Guerrero
                if (trabajo instanceof Guerrero) {
                    //Duplicamos el valor del aumento de Fuerza
                    fuerza = (fuerza + (aumentoTempFuerza * 2));

                }
                // Calcular los nuevos valores de los atributos
                fuerza = fuerza + aumentoTempFuerza;
            } else if (arma instanceof Hacha) {
                //Verificamos si el trabajo del Caballero Luz es de tipo Guerrero
                if (trabajo instanceof Guerrero) {
                    //Duplicamos el valor del aumento de Fuerza
                    fuerza = (fuerza + (aumentoTempFuerza * 2));
                }
                // Calcular los nuevos valores de los atributos
                fuerza = fuerza + aumentoTempFuerza;
            } else if (arma instanceof Maza) {
                //Verificamos si el trabajo del Caballero Luz es de tipo Guerrero
                if (trabajo instanceof Guerrero) {
                    //Duplicamos el valor del aumento de Fuerza
                    fuerza = (fuerza + (aumentoTempFuerza * 2));
                }
                // Calcular los nuevos valores de los atributos
                fuerza = fuerza + aumentoTempFuerza;
            } else if (arma instanceof Scientiae) {
                // Calcular los nuevos valores de los atributos
                concentracion = concentracion + aumentoTempConcentracion;
                PV = PV + aumentoTempPV;
            } else if (arma instanceof Statera) {
                // Calcular los nuevos valores de los atributos
                concentracion = concentracion + aumentoTempConcentracion;
                PV = PV + aumentoTempPV;
            } else if (arma instanceof Vivificantem) {
                // Calcular los nuevos valores de los atributos
                concentracion = concentracion + aumentoTempConcentracion;
                PV = PV + aumentoTempPV;
            } else if (arma instanceof EscudoDragon) {
                // Calcular los nuevos valores de los atributos
                defensa = defensa + aumentoTempDefensa;
            } else if (arma instanceof EscudoEncantado) {
                // Calcular los nuevos valores de los atributos
                defensa = defensa + aumentoTempDefensa;
            } else if (arma instanceof EscudoHierro) {
                // Calcular los nuevos valores de los atributos
                defensa = defensa + aumentoTempDefensa;
            }
        }
    }

    @Override
    public String toString() {
        return logo +" "+nombre+" "+ logo + "\n"
                + "Nivel: " + nivel + "\n"
                + "PV: " + PV + "\n"
                + "Fuerza: " + fuerza + "\n"
                + "Defensa: " + defensa + "\n"
                + "Concentración: " + concentracion + "\n"
                + "Espíritu: " + espiritu + "\n";
    }
}
