package com.mycompany.rpg.Objetos;

/**
 *
 * @author saien
 */
public class TiendaAcampar extends Objeto{
    private int recuperarPV;
    private int recuperarPuntosMagia;
    private String nombre;
    
    public TiendaAcampar(){
        nombre="Tienda de campaña";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
