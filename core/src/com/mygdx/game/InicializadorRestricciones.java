package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by Alfonso on 05/07/2018.
 */

public class InicializadorRestricciones {

    public InicializadorRestricciones(){}

    public ArrayList<RestriccionesTablero> inicializar(ArrayList<Bloque> BloquesTablero,ArrayList<Bloque> BloquesACrear){
        ArrayList<RestriccionesTablero> restricciones= new ArrayList<RestriccionesTablero>();
        restricciones.add(new RestriccionGeneral(BloquesTablero,BloquesACrear));
        restricciones.add(new Vecindad(5,3,BloquesTablero,BloquesACrear));

    return restricciones;
    }
}
