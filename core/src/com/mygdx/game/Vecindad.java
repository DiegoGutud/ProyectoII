package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by Alfonso on 04/07/2018.
 */

public class Vecindad implements RestriccionesTablero {

    private ArrayList<Bloque> BloquesTablero;
    private ArrayList<Bloque> BloquesACrear;
    private int columnas;
    private int filas;

    public Vecindad(int columnas, int filas,  ArrayList<Bloque> BloquesTablero, ArrayList<Bloque> BloquesACrear){

        this.columnas=columnas;
        this.filas=filas;
        this.BloquesTablero= BloquesTablero;
        this.BloquesACrear= BloquesACrear;
    }

    @Override
    public void crearRestriccion() {
        for (int i = 0; i <(BloquesTablero.size()-1) ; i++) {
            if( (((i+1)%columnas)!=0)){
                BloquesTablero.get(i).AddVecino(BloquesTablero.get(i+1));

            }



        }
        for (int i = 0; i <(BloquesTablero.size()-columnas) ; i++) {
            BloquesTablero.get(i).AddVecino(BloquesTablero.get(i+columnas));

        }
    }

    @Override
    public boolean validarRestriccion() {
       if (BloquesACrear.size()>1) {
          if(BloquesACrear.get(BloquesACrear.size() - 2).comprobarVecindad(BloquesACrear.get(BloquesACrear.size() - 1))){

              return true;
          }
          else{

              return false;
          }

       }
       else{

           return true;
       }
    }
}
