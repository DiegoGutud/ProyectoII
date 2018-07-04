package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by Alfonso on 16/06/2018.
 */

public class Factory {
    public static Tablero CrearTablero(TipoTablero tipo,TipoDisposicion disposicion ){
        Tablero tablero=null;
        switch(tipo)
        {
            case TABLERO_RECTANGULOS:

                tablero =new TableroRectangulo(Factory.CrearDisposicion(disposicion));
                break;


            default:
                break;
        }
        return tablero;
    }

    public static TableroDisposicion CrearDisposicion(TipoDisposicion tipo){
        TableroDisposicion disposicion=null;
        switch(tipo)
        {
            case HORIZONTAL:

                disposicion =new TableroHorizontal();
                break;


            default:
                break;
        }
        return disposicion;
    }




}
