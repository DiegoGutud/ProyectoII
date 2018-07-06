package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Alfonso on 05/07/2018.
 */

public class FactoryFiguraTablerRect implements FactoryFigura{
    @Override
    public Rectangulo crearFigura(float x, float y, ArrayList<Vector2> vertices, Color color) {
        return new RectanguloTablero(x,y,vertices.get(1).x-vertices.get(0).x,vertices.get(3).y-vertices.get(0).y, color);


    }

    @Override
    public Rectangulo crearFigura(float x, float y, float width, float height, Color color) {
        return new RectanguloTablero(x,y,width,height, color);
    }
}
