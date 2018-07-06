package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by Alfonso on 16/06/2018.
 */

public abstract class Tablero {
    private ArrayList<Bloque> BloquesTablero;
    private ArrayList<Bloque> BloquesACrear;
    private ArrayList<RestriccionesTablero> Restricciones;


    public Tablero (){

        BloquesTablero=new ArrayList<Bloque>();
        BloquesACrear=new ArrayList<Bloque>();
        Restricciones=new ArrayList<RestriccionesTablero>();
    }
    public abstract void crearFigura(ArrayList<Bloque> bloque);
    public abstract void crear(FactoryBloque factoryBloque);
    public abstract void pintar();
    public abstract void actualizar();
    public static Tablero inicializar(FactoryTablero factory){
        return factory.crearTablero();
    }

    public boolean validarRestricciones(){
        for (RestriccionesTablero a: Restricciones) {
            if(!a.validarRestriccion()){
                return false;
            }
        }
        return true;
    }

    public void crearRestricciones(){
        for (RestriccionesTablero a: Restricciones) {
            a.crearRestriccion();

        }
    }
    public ArrayList<Bloque> getBloquesTablero() {
        return BloquesTablero;
    }

    public ArrayList<Bloque> getBloquesACrear() {
        return BloquesACrear;
    }

    public void setBloquesTablero(ArrayList<Bloque> BloquesTablero) {
        this.BloquesTablero = BloquesTablero;
    }

    public ArrayList<RestriccionesTablero> getRestricciones(){
        return this.Restricciones;
    }
    public void addRestricciones(RestriccionesTablero restriccion){
        Restricciones.add(restriccion);
    }
    public void setRestricciones(ArrayList<RestriccionesTablero> restricciones){
        this.Restricciones=restricciones;
    }

}
