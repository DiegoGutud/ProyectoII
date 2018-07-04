package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by Alfonso on 16/06/2018.
 */

public class TableroHorizontal implements TableroDisposicion {

    private int columnas;
    private int filas;
    private float x;
    private float y;

    public TableroHorizontal(){
       columnas=5;
       filas=3;
       x= (MyGdxGame.w/9)*2;
       y= (MyGdxGame.h/15);
    }

    @Override
    public void disponer(TableroGrafico tablero) {tablero.Rectangular(columnas, filas,x,y);

    }

    @Override
    public void establecerVecindad(ArrayList<Bloque> BloquesTablero) {
        for (int i = 0; i <(BloquesTablero.size()-1) ; i++) {
            if( (((i+1)%columnas)!=0)){
            BloquesTablero.get(i).AddVecino(BloquesTablero.get(i+1));
            }


            
        }
        for (int i = 0; i <(BloquesTablero.size()-columnas) ; i++) {
            BloquesTablero.get(i).AddVecino(BloquesTablero.get(i+columnas));
        }
    }
}
//Lo de small y eso se crea cuando se le vaya a llamar