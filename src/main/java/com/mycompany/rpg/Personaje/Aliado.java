package com.mycompany.rpg.Personaje;

import com.mycompany.rpg.Trabajo.*;
import com.mycompany.rpg.Arma.*;
import com.mycompany.rpg.Arma.Baculo.*;
import com.mycompany.rpg.Arma.Escudo.*;
import com.mycompany.rpg.Arma.ArmaCorta.*;
import com.mycompany.rpg.Arma.ArmaDosManos.*;
import com.mycompany.rpg.Arma.ArmaUnaMano.*;
import com.mycompany.rpg.Magias.Magia;

/**
 *
 * @author saien
 */
public class Aliado extends Personaje {

    private String nombre;
    private Trabajo[] trabajo;
    Arma armas[];
    Magia[] inventarioMagias;
    Trabajo trabajoActivo;
    private int numElementos;
    //Variables temporales al utilizar un trabajo
    private int FuerzaTemp;
    private int concentracionTemp;
    private int espirituTemp;
    private int DefensaTemp;
    private int VelocidadTemp;
    private int PVTemp;
    //Variables al utilizar los Objetos en la clase batalla
    private int PVOriginal;
    private int VelocidadOriginal;

    public Aliado(String nom, Trabajo trabajoInicial) {
        this.nombre = nom;
        this.trabajo = new Trabajo[2];
        this.trabajo[0] = trabajoInicial;
        this.inventarioMagias = new Magia[1];
        this.numElementos = 0;
        iniciarEstadisticas();
        iniciarTemporales();

    }

    public Aliado() {
        //Constructor para otras acciones
    }

    public void iniciarEstadisticas() {
        this.PV = 100;
        this.fuerza = 65;
        this.defensa = 60;
        this.concentracion = 35;
        this.espiritu = 25;
        this.velocidad = 15;
        this.nivel = 10;
        this.experiencia = 0;
    }

    private void iniciarTemporales() {
        FuerzaTemp = this.fuerza;
        DefensaTemp = this.defensa;
        VelocidadTemp = this.velocidad;
        PVTemp = this.PV;
        concentracionTemp = this.concentracion;
        espirituTemp = this.espiritu;
        PVOriginal = 0;
        VelocidadOriginal = 0;
    }

    public void agregarTrabajo(Trabajo trabaJonuevo) {
        if (this.trabajo[1] == null) {
            this.trabajo[1] = trabaJonuevo;
            System.out.println("Se ha agregado el trabajo de: " + trabajo[1].getNombre());
        } else {
            System.out.println("No hay espacio para otro trabajo");
        }
    }

    public void cambiarTrabajo(Trabajo trabajoNuevo, int pos) {
        int posTrabajo = pos - 1;
        if (this.trabajo[posTrabajo] == null) {
            System.out.println(nombre + "No tiene ningun trabajo asignado en esta posicion");
        } else {
            System.out.println("Se ha cambiado el trabajo " + trabajo[posTrabajo].getNombre() + " por " + trabajoNuevo.getNombre());

            this.trabajo[posTrabajo] = trabajoNuevo;
        }
    }

    public void agregarObjeto(Magia magia, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            //Verificamos que el inventario esta lleno
            if (numElementos == inventarioMagias.length) {
                //si asi es lo ampliamos
                ampliarInventario();
            }
            //agregamos el nuevo objeto al inventario
            inventarioMagias[numElementos] = magia;
            numElementos++;

        }
    }

    private void ampliarInventario() {
        //doblamos el inventario
        Magia[] nuevoInventario = new Magia[inventarioMagias.length * 2];

        //pasamos los elementos al nuevo inventario
        for (int i = 0; i < inventarioMagias.length; i++) {
            nuevoInventario[i] = inventarioMagias[i];

        }
        //asignamos el nuevo inventario al original
        inventarioMagias = nuevoInventario;

    }

    public void cambiarEstadisticasTemporalTrabajo(Trabajo trabajo) {
        for (int i = 0; i < this.trabajo.length; i++) {
            if (this.trabajo[i] == null) {

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
                    FuerzaTemp = (int) (fuerza * (1 - disminuirTempFuerza));
                    DefensaTemp = (int) (defensa * (1 + aumentoTempDefensa));
                } else if (trabajo instanceof Mago_Oscuro) {
                    // Calcular los nuevos valores de los atributos según los porcentajes
                    FuerzaTemp = (int) (fuerza * (1 - disminuirTempFuerza));
                    DefensaTemp = (int) (defensa * (1 + aumentoTempDefensa));
                } else if (trabajo instanceof Mago_Rojo) {
                    // Calcular los nuevos valores de los atributos según los porcentajes
                    FuerzaTemp = (int) (fuerza * (1 - disminuirTempDefensa));
                } else if (trabajo instanceof Guerrero) {
                    // Calcular los nuevos valores de los atributos según los porcentajes
                    FuerzaTemp = (int) (fuerza * (1 + aumentoTempFuerza));
                    VelocidadTemp = (int) (velocidad * (1 - disminuirTempVelocidad));
                } else if (trabajo instanceof Ninja) {
                    // Calcular los nuevos valores de los atributos según los porcentajes
                    VelocidadTemp = (int) (velocidad * (1 + aumentoTempVelocidad));
                    DefensaTemp = (int) (defensa * (1 - disminuirTempDefensa));
                } else if (trabajo instanceof Paladin) {
                    // Calcular los nuevos valores de los atributos según los porcentajes
                    DefensaTemp = (int) (defensa * (1 + aumentoTempDefensa));
                    PVTemp = (int) (PV * (1 + aumentoTempPV));
                }
            }
        }

    }

    public void EstadisticasTemporalPaladin(Trabajo trabajo, Arma arma, Arma escudo) {
        Arma armaAliado = arma;
        Arma escudoAliado = escudo;
        Trabajo trabajoActivo = trabajo;
        //Obtenemos los valores de las armas que cambian las estadisticas
        int aumentoTempFuerza = armaAliado.AumentarFuerza();
        int aumentoTempDefensa = escudoAliado.AumentarDefensa();
        //Dado que el paladin puede usar un escudo y un arma de una mano verificamos el trabajo activo
        if (trabajoActivo instanceof Paladin) {
            Arma[] armas = trabajo.getInventarioArmas();
            for (int i = 0; i < armas.length; i++) {
                if (armas[i] instanceof ArmaUnaMano) {
                    FuerzaTemp = FuerzaTemp + aumentoTempFuerza;
                    break;
                }
            }
            for (int j = 0; j < armas.length; j++) {
                if (armas[j] instanceof Escudo) {
                    DefensaTemp = DefensaTemp + aumentoTempDefensa;
                }
            }

        }
    }

    public void EstidisticasTemporalPaladinSinEscudo(Trabajo trabajo, Arma arma) {
        Arma armaAliado = arma;
        Trabajo trabajoActivo = trabajo;
         int aumentoTempFuerza = armaAliado.AumentarFuerza();
        if (trabajoActivo instanceof Paladin) {
            FuerzaTemp = FuerzaTemp + aumentoTempFuerza;
        }

    }

    public void cambiarEstadisticasTemporalArma(Arma arma, Trabajo trabajo) {
        Arma armaAliado = arma;
        Trabajo trabajoActivo = trabajo;

        for (int i = 0; i < this.trabajo.length; i++) {
            if (this.trabajo[i] == null) {

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
                    VelocidadTemp = VelocidadTemp + aumentoTempVelocidad;
                } else if (arma instanceof Daga) {
                    // Calcular los nuevos valores de los atributos
                    VelocidadTemp = VelocidadTemp + aumentoTempVelocidad;
                } else if (arma instanceof Estilete) {
                    // Calcular los nuevos valores de los atributos
                    VelocidadTemp = VelocidadTemp + aumentoTempVelocidad;
                } else if (arma instanceof Alabarda) {
                    // Calcular los nuevos valores de los atributos
                    FuerzaTemp = FuerzaTemp + aumentoTempFuerza;
                    VelocidadTemp = VelocidadTemp + disminuirTempVelocidad;
                } else if (arma instanceof EspadaLarga) {
                    // Calcular los nuevos valores de los atributos
                    FuerzaTemp = FuerzaTemp + aumentoTempFuerza;
                    VelocidadTemp = VelocidadTemp + disminuirTempVelocidad;
                } else if (arma instanceof Lanza) {
                    // Calcular los nuevos valores de los atributos
                    FuerzaTemp = FuerzaTemp + aumentoTempFuerza;
                    VelocidadTemp = VelocidadTemp + disminuirTempVelocidad;
                } else if (arma instanceof Espada) {
                    //Verificamos si el trabajo del Caballero Luz es de tipo Guerrero
                    if (trabajo instanceof Guerrero) {
                        int cantArma = 0;
                        Arma[] armas = trabajo.getInventarioArmas();
                        //Analizamos si tiene mas de una espada en su inventario
                        for (int j = 0; j < armas.length; j++) {
                            if (armas[j] instanceof Espada) {
                                cantArma++;
                            }
                        }
                        //Si es cierto 
                        if (cantArma >= 2) {
                            //Duplicamos el valor del aumento de Fuerza
                            FuerzaTemp = (FuerzaTemp + (aumentoTempFuerza * 2));
                        } else {
                            //Modificamos la fuerza de forma normal
                            FuerzaTemp = FuerzaTemp + aumentoTempFuerza;
                        }
                    }
                    // Calcular los nuevos valores de los atributos
                    FuerzaTemp = FuerzaTemp + aumentoTempFuerza;
                } else if (arma instanceof Hacha) {
                    //Verificamos si el trabajo del Caballero Luz es de tipo Guerrero
                    if (trabajo instanceof Guerrero) {
                        int cantArma = 0;
                        Arma[] armas = trabajo.getInventarioArmas();
                        //Analizamos si tiene mas de una espada en su inventario
                        for (int j = 0; j < armas.length; j++) {
                            if (armas[j] instanceof Hacha) {
                                cantArma++;
                            }
                        }
                        //Si es cierto 
                        if (cantArma >= 2) {
                            //Duplicamos el valor del aumento de Fuerza
                            FuerzaTemp = (FuerzaTemp + (aumentoTempFuerza * 2));
                        } else {
                            //Modificamos la fuerza de forma normal
                            FuerzaTemp = FuerzaTemp + aumentoTempFuerza;
                        }
                    }
                    // Calcular los nuevos valores de los atributos
                    FuerzaTemp = FuerzaTemp + aumentoTempFuerza;
                } else if (arma instanceof Maza) {
                    //Verificamos si el trabajo del Caballero Luz es de tipo Guerrero
                    if (trabajo instanceof Guerrero) {
                        int cantArma = 0;
                        Arma[] armas = trabajo.getInventarioArmas();
                        //Analizamos si tiene mas de una espada en su inventario
                        for (int j = 0; j < armas.length; j++) {
                            if (armas[j] instanceof Espada) {
                                cantArma++;
                            }
                        }
                        //Si es cierto 
                        if (cantArma >= 2) {
                            //Duplicamos el valor del aumento de Fuerza
                            FuerzaTemp = (FuerzaTemp + (aumentoTempFuerza * 2));
                        } else {
                            //Modificamos la fuerza de forma normal
                            FuerzaTemp = FuerzaTemp + aumentoTempFuerza;
                        }
                    }
                    // Calcular los nuevos valores de los atributos
                    FuerzaTemp = FuerzaTemp + aumentoTempFuerza;
                } else if (arma instanceof Scientiae) {
                    // Calcular los nuevos valores de los atributos
                    concentracionTemp = concentracionTemp + aumentoTempConcentracion;
                    PVTemp = PVTemp + aumentoTempPV;
                } else if (arma instanceof Statera) {
                    // Calcular los nuevos valores de los atributos
                    concentracionTemp = concentracionTemp + aumentoTempConcentracion;
                    PVTemp = PVTemp + aumentoTempPV;
                } else if (arma instanceof Vivificantem) {
                    // Calcular los nuevos valores de los atributos
                    concentracionTemp = concentracionTemp + aumentoTempConcentracion;
                    PVTemp = PVTemp + aumentoTempPV;
                } else if (arma instanceof EscudoDragon) {
                    // Calcular los nuevos valores de los atributos
                    DefensaTemp = DefensaTemp + aumentoTempDefensa;
                } else if (arma instanceof EscudoEncantado) {
                    // Calcular los nuevos valores de los atributos
                    DefensaTemp = DefensaTemp + aumentoTempDefensa;
                } else if (arma instanceof EscudoHierro) {
                    // Calcular los nuevos valores de los atributos
                    DefensaTemp = DefensaTemp + aumentoTempDefensa;
                }
            }
        }

    }
    
//GETTERS Y SETTERS

    public Trabajo getTrabajoActivo() {
        return trabajoActivo;
    }

    public void setTrabajoActivo(Trabajo trabajoActivo) {
        this.trabajoActivo = trabajoActivo;
    }
  
    

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Arma[] getArmas() {
        return armas;
    }

    public void setArmas(Arma[] armas) {
        this.armas = armas;
    }

    public Trabajo[] getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo[] trabajos) {
        this.trabajo = trabajos;
    }

    @Override
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public int getFuerza() {
        return fuerza;
    }

    @Override
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public int getDefensa() {
        return defensa;
    }

    @Override
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public int getConcentracion() {
        return concentracion;
    }

    @Override
    public void setConcentracion(int concentracion) {
        this.concentracion = concentracion;
    }

    @Override
    public int getEspiritu() {
        return espiritu;
    }

    @Override
    public void setEspiritu(int espiritu) {
        this.espiritu = espiritu;
    }

    @Override
    public int getExperiencia() {
        return experiencia;
    }

    @Override
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public int getPV() {
        return PV;
    }

    @Override
    public void setPV(int PV) {
        this.PV = PV;
    }

    public int getFuerzaTemp() {
        return FuerzaTemp;
    }

    public void setFuerzaTemp(int FuerzaTemp) {
        this.FuerzaTemp = FuerzaTemp;
    }

    public int getDefensaTemp() {
        return DefensaTemp;
    }

    public void setDefensaTemp(int DefensaTemp) {
        this.DefensaTemp = DefensaTemp;
    }

    public int getVelocidadTemp() {
        return VelocidadTemp;
    }

    public void setVelocidadTemp(int VelocidadTemp) {
        this.VelocidadTemp = VelocidadTemp;
    }

    public int getPVTemp() {
        return PVTemp;
    }

    public void setPVTemp(int PVTemp) {
        this.PVTemp = PVTemp;
    }

    public int getPVOriginal() {
        return PVOriginal;
    }

    public void setPVOriginal(int PVOriginal) {
        this.PVOriginal = PVOriginal;
    }

    public int getVelocidadOriginal() {
        return VelocidadOriginal;
    }

    public void setVelocidadOriginal(int VelocidadOriginal) {
        this.VelocidadOriginal = VelocidadOriginal;
    }

}
