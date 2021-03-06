package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Alfonso on 05/07/2018.
 */

public class RectanguloTablero extends Rectangulo {

    public RectanguloTablero(float x, float y, float width, float height, Color color){
        super(x,y,width,height,color);
    }

    @Override
    public void pintar() {



        MyGdxGame.batch.begin();
        MyGdxGame.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        MyGdxGame.shapeRenderer.setColor(getColor());
        MyGdxGame.shapeRenderer.rect(getX(),getY(),getWidth(),getHeight());

        MyGdxGame.shapeRenderer.end();
        MyGdxGame.batch.end();

    }
}
