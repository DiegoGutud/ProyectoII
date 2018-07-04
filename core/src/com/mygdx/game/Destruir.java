package com.mygdx.game;

/**
 * Created by Alfonso on 03/06/2018.
 */

public class Destruir implements PowerUps {

    @Override
    public void activar(Figura figura) {
        // TODO Auto-generated method stub
        figura.destruir();
    }

}
