package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Alfonso on 05/07/2018.
 */

public interface FactoryFigura {
    public Figura crearFigura(float x, float y, ArrayList<Vector2> vertices,Color color);
    public Figura crearFigura(float x, float y,  float width, float height,Color color);
}
