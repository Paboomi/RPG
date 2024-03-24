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
    Aliado aliado[] = new Aliado[4];
    Aliado trabajos[];
    int experiencia;
    int oro;
    private int numElementos;
    private static Jugador jugador;

    private Jugador() {
        inventario = new Objeto[12];
        numElementos = 0;
        crearInventario();
        crearAliados();
        this.oro = 1000;

    }

    public static Jugador getInstance() {
        if (jugador == null) {
            jugador = new Jugador();
        }
        return jugador;
    }

//Almacenamos a los aliados
    public void almacenarAliados(Aliado aliados, int posAliado) {
        if (posAliado >= 0 && posAliado < this.aliado.length) {
            this.aliado[posAliado] = aliados;
        } else {
            System.out.println("Ya no pueden agregarse mas aliados");
        }
    }

    //creamos a los aliados
    public void crearAliados() {
        Aliado aliado1 = new Aliado("Celes", new Mago_Blanco());
        Aliado aliado2 = new Aliado("Locke", new Ninja());
        Aliado aliado3 = new Aliado("Rydia", new Mago_Oscuro());
        Aliado aliado4 = new Aliado("Vaan", new Guerrero());

        almacenarAliados(aliado1, 0);
        almacenarAliados(aliado2, 1);
        almacenarAliados(aliado3, 2);
        almacenarAliados(aliado4, 3);

    }

    //Metodo para agregar objetos al inventario
    public void agregarObjeto(Objeto objeto, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            //Verificamos que el inventario esta lleno
            if (numElementos == inventario.length) {
                //si asi es lo ampliamos
                ampliarInventario();
            }
            //agregamos el nuevo objeto al inventario
            inventario[numElementos] = objeto;
            numElementos++;

        }
    }

    //Metodo para ampliar capacidad del inventario
    private void ampliarInventario() {
        //doblamos el inventario
        Objeto[] nuevoInventario = new Objeto[inventario.length * 2];

        //pasamos los elementos al nuevo inventario
        for (int i = 0; i < inventario.length; i++) {
            nuevoInventario[i] = inventario[i];

        }
        //asignamos el nuevo inventario al original
        inventario = nuevoInventario;

    }

    public void crearInventario() {
        agregarObjeto(new Pocion(), 8);
        agregarObjeto(new TiendaAcampar(), 2);
        agregarObjeto(new PlumaFenix(), 2);
    }

    public void mostrarInventario() {
        int cantPocion = 0;
        int cantPocionMayor = 0;
        int cantPlumaFenix = 0;
        int cantTiendaAcampar = 0;
        System.out.println("Inventario");
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == null) {
                break;
            } else if (inventario[i] instanceof Pocion) {
                cantPocion++;
            } else if (inventario[i] instanceof PlumaFenix) {
                cantPlumaFenix++;
            } else if (inventario[i] instanceof TiendaAcampar) {
                cantTiendaAcampar++;
            } else if (inventario[i] instanceof PocionMayor) {
                cantPocionMayor++;
            }
        }
        System.out.println("\n\nCantidad de Objetos en el inventario");
        System.out.println("Pocion: " + cantPocion);
        System.out.println("Pocion Mayor: " + cantPocionMayor);
        System.out.println("Pluma Fenix: " + cantPlumaFenix);
        System.out.println("Tienda Acampar: " + cantTiendaAcampar);
    }

    public void usarObjeto(Objeto objeto) {
        // Busca el objeto en el inventario
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null && inventario[i] == objeto) {
                // Verifica si hay suficientes objetos en el inventario
                if (numElementos > 0) {
                    // Elimina el objeto del inventario
                    for (int j = i; j < numElementos - 1; j++) {
                        inventario[j] = inventario[j + 1];//Movemos la posicion actual a una posicion adelante dejando el elemento usado al final
                    }
                    inventario[numElementos - 1] = null; // Elimina la última referencia que es el elemento usado
                    numElementos--;
                    return; // Termina el método después de usar el objeto
                } else {
                    System.out.println("No tienes suficientes " + objeto.getNombre() + " en el inventario.");
                    return;
                }
            }
        }
        System.out.println("No tienes " + objeto.getNombre() + " en el inventario.");
    }

    public Aliado[] getAliado() {
        return aliado;
    }

    public void setAliado(Aliado[] aliado) {
        this.aliado = aliado;
    }

    public Objeto[] getInventario() {
        return inventario;
    }

    public void setInventario(Objeto[] inventario) {
        this.inventario = inventario;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

}
