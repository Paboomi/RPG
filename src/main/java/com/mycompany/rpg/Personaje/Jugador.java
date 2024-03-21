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
    Trabajo trabajos[];
    int experiencia;
    int oro;
    private int numElementos;

    public Jugador() {
        crearAliados();
        inventario = new Objeto[12];
        numElementos=0;
        crearInventario();
        this.oro = 1000;

    }
    //Almacenamos a los aliados
    public void almacenarAliados(Aliado aliados, int posAliado) {
        if (posAliado >= 0 && posAliado < this.aliado.length) {
            this.aliado[posAliado] = aliados;
        } else {
            System.out.println("Ya no pueden agregarse mas aliados");
        }
    }

    public void verTrabajosAliados() {
        for (int i = 0; i < aliado.length; i++) {
            aliado[i].mostrarTrabajos();

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
    public void agregarObjeto(Objeto objeto, int cantidad){
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
    private void ampliarInventario(){
        //doblamos el inventario
        Objeto[] nuevoInventario = new Objeto[inventario.length * 2];
        
        //pasamos los elementos al nuevo inventario
        for (int i = 0; i < inventario.length; i++) {
            nuevoInventario[i] = inventario[i];
            
        }
        //asignamos el nuevo inventario al original
        inventario = nuevoInventario;
        
        
    }
    
    public void crearInventario(){
        agregarObjeto(new Pocion(), 8);
        agregarObjeto(new TiendaAcampar(), 2);
        agregarObjeto(new PlumaFenix(), 2);
    }
    
    public void mostrarInventario(){
        System.out.println("Inventario");
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == null) {
                break;
            }else{
                System.out.println((i+1) + ". " + inventario[i].getNombre());
            }
            
        }
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
