package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.BodyDef;

/**
 * Created by Alfonso on 05/07/2018.
 */

public class FactoryBloquesPiso implements FactoryBloque {
    @Override
    public Bloque crearBloque(Figura figura) {
        return new Piso(figura);
    }

    @Override
    public Bloque crearBloqueFisico(Figura figura) {

        Bloque bloque= new Bloques_Activos(figura);
        Bloque_Figura bloqueFigura=new Bloque_Figura();
        Bodies body=new Bodies(); //orden
        figura.enviarCoordenadas();
        bloqueFigura.add(bloque);
        body.crearCuerpo(BodyDef.BodyType.StaticBody);
        Bloque_Figura.Figuras.add(bloqueFigura);
        CuerpoFisico CF=body;

        bloqueFigura.setCuerpo(CF);
        return bloque;
    }


}
