package com.mycompany.rpg.Trabajo;

import com.mycompany.rpg.Arma.Arma;
import com.mycompany.rpg.Arma.Baculo.Scientiae;
import com.mycompany.rpg.Magias.Magia;
import com.mycompany.rpg.Magias.MagiaOscura.Meteoro;

/**
 *
 * @author saien
 */
public class Mago_Oscuro extends Trabajo {

    Magia[] inventarioMagias;
    Arma[] inventarioArmas;
    boolean subioNivel = false;

    private int numElementosMagia;
    private int numElementosArma;

    public Mago_Oscuro() {
        this.nombre = "Mago Oscuro";
        this.numElementosArma = 0;
        this.numElementosMagia = 0;
        inventarioArmas = new Arma[1];
        inventarioMagias = new Magia[1];
        inventarioArmas[0] = new Scientiae();
        inventarioMagias[0] = new Meteoro();
    }

    //Metodo para agregar Magias desde la tienda
    public void agregarMagia(Magia magia, int cantidad) {
        numElementosMagia = 0;
        for (int i = 0; i < cantidad; i++) {
            //Verificamos que el inventario esta lleno
            if (numElementosMagia == inventarioMagias.length) {
                //si asi es lo ampliamos
                ampliarInventarioMagia();
            }
            //agregamos el nuevo objeto al inventario
            inventarioMagias[numElementosMagia] = magia;
            numElementosMagia++;

        }
    }

    private void ampliarInventarioMagia() {
        //doblamos el inventario
        Magia[] nuevoInventario = new Magia[inventarioMagias.length * 2];

        //pasamos los elementos al nuevo inventario
        for (int i = 0; i < inventarioMagias.length; i++) {
            nuevoInventario[i] = inventarioMagias[i];

        }
        //asignamos el nuevo inventario al original
        inventarioMagias = nuevoInventario;

    }

    //metodo para agregar Armas desde la tienda
    public void agregarArma(Arma arma, int cantidad) {
        numElementosArma = 0;
        for (int i = 0; i < cantidad; i++) {
            //Verificamos que el inventario esta lleno
            if (numElementosArma == inventarioArmas.length) {
                //si asi es lo ampliamos
                ampliarInventarioArmas();
            }
            //agregamos el nuevo objeto al inventario
            inventarioArmas[numElementosArma] = arma;
            numElementosArma++;

        }
    }

    private void ampliarInventarioArmas() {
        //doblamos el inventario
        Arma[] nuevoInventario = new Arma[inventarioArmas.length * 2];

        //pasamos los elementos al nuevo inventario
        for (int i = 0; i < inventarioArmas.length; i++) {
            nuevoInventario[i] = inventarioArmas[i];

        }
        //asignamos el nuevo inventario al original
        inventarioArmas = nuevoInventario;

    }

    //Metodo para eliminar una magia que se ha usado en la batalla
    public void usarMagia(Magia magia) {
        // Busca el objeto en el inventario
        for (int i = 0; i < inventarioMagias.length; i++) {
            if (inventarioMagias[i] != null && inventarioMagias[i] == magia) {
                // Verifica si hay suficientes objetos en el inventario
                if (numElementosMagia > 0) {
                    // Elimina el objeto del inventario
                    for (int j = i; j < numElementosMagia - 1; j++) {
                        //Movemos la posicion actual a una posicion adelante dejando el elemento usado al final
                        inventarioMagias[j] = inventarioMagias[j + 1];
                    }
                    // Elimina la última referencia que es el elemento usado
                    inventarioMagias[numElementosMagia - 1] = null;
                    numElementosMagia--;
                    return; // Termina el método después de usar el objeto
                } else {
                    System.out.println("No tienes suficientes " + magia.getNombre() + " en el inventario.");
                    return;
                }
            }
        }
        System.out.println("No tienes " + magia.getNombre() + " en el inventario.");
    }

    //Metodos para aumentar estadisitcas a la hora de equipar el trabajo
    @Override
    public double DisminuirFuerza() {
        return 0.60;
    }

    @Override
    public double AumentarDefensa() {
        return 0.15;
    }

    //GETTERS Y SETTERS
    public void setsubioNivel(boolean subionivel) {
        this.subioNivel = subionivel;
    }

    public boolean EstaActivo() {
        return (subioNivel) ? true : false;
    }

    public int cantArmas() {
        return 1;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Arma[] getInventarioArmas() {
        return inventarioArmas;
    }

    @Override
    public void setInventarioArmas(Arma[] inventarioArmas) {
        this.inventarioArmas = inventarioArmas;
    }

}
