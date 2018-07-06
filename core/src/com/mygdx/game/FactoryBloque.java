package com.mygdx.game;

/**
 * Created by Alfonso on 05/07/2018.
 */

public interface FactoryBloque {

    public Bloque crearBloque(Figura figura);
    public Bloque crearBloqueFisico(Figura figura);

}
