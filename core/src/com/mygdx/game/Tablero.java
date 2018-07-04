package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by Alfonso on 16/06/2018.
 */

public abstract class Tablero {
    private ArrayList<Bloque> BloquesTablero;
    private ArrayList<Bloque> BloquesACrear;
    private int contador;

    public Tablero (){
        contador=0;
        BloquesTablero=new ArrayList<Bloque>();
        BloquesACrear=new ArrayList<Bloque>();
    }
    public abstract void crearFigura(ArrayList<Bloque> bloque);
    public abstract void validarBloques();
    public abstract void crear();
    public abstract void pintar();
    public abstract void establecerVecindad();
    public abstract boolean validarCreacionBloque(Bloque bloque);
    public abstract void actualizar();

    public ArrayList<Bloque> getBloquesTablero() {
        return BloquesTablero;
    }

    public ArrayList<Bloque> getBloquesACrear() {
        return BloquesACrear;
    }

    public void setBloquesTablero(ArrayList<Bloque> BloquesTablero) {
        this.BloquesTablero = BloquesTablero;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
