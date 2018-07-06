package com.mygdx.game;

/**
 * Created by Alfonso on 05/07/2018.
 */

public class FactoryBloquesTablero implements FactoryBloque {
    @Override
    public Bloque crearBloque(Figura figura) {
        return new BloquesTablero(figura);
    }

    @Override
    public Bloque crearBloqueFisico(Figura figura) {
        return null;
    }


}
