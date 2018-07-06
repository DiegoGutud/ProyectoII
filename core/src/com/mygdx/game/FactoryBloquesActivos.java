package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.BodyDef;

import java.util.ArrayList;

/**
 * Created by Alfonso on 05/07/2018.
 */

public class FactoryBloquesActivos implements FactoryBloque {
    @Override
    public Bloque crearBloque(Figura figura) {
        return new Bloques_Activos(figura);
    }

    @Override
    public Bloque crearBloqueFisico(Figura figura) {

        Bloque bloque= new Bloques_Activos(figura);
        Bloque_Figura bloqueFigura=new Bloque_Figura();
        Bodies body=new Bodies(); //orden
        figura.enviarCoordenadas();
        bloqueFigura.add(bloque);
        body.crearCuerpo(BodyDef.BodyType.DynamicBody);
        Bloque_Figura.Figuras.add(bloqueFigura);
        CuerpoFisico CF=body;

        bloqueFigura.setCuerpo(CF);
        return bloque;
    }


}
