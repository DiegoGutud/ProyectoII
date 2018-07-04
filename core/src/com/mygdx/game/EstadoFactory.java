package com.mygdx.game;

/**
 * Created by Alfonso on 03/06/2018.
 */

public class EstadoFactory {

    public static Estado Crear(TipoEstado tipo){
        Estado e=null;
        switch(tipo)
        {
            case MOVERSE:

                e =new Moverse();
                break;
            case DETENERSE:

                e= new Detenerse();
                break;
            default:
                break;
        }
        return e;
    }
}
