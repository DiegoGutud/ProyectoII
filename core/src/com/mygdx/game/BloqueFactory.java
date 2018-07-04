package com.mygdx.game;

/**
 * Created by Alfonso on 03/06/2018.
 */

public class BloqueFactory {

    public static Bloque Crear(TipoBloque tipo,Figura figura){
        Bloque bloque=null;
        switch(tipo)
        {
            case BLOQUE_ACTIVO:

                bloque =new Bloques_Activos(figura);
                break;
            case PISO:

                bloque =new Piso(figura);
                break;
            default:
                break;
        }
        return bloque;
    }
}
