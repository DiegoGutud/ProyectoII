package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;



/**
 * Created by Alfonso on 03/06/2018.
 */

public class Rectangulo extends Rectangle implements Figura {




    private Color color;
    private Coordenadas coordenadas;
    public ShapeRenderer shapeRenderer;



    public Rectangulo(float x, float y, float width, float height, Color color){
        super(x, y, width, height);
        this.color=color;
        coordenadas=new Coordenadas(x,y,0);
        establecerCoordenadas();

        shapeRenderer= new ShapeRenderer();


    }




    @Override
    public void moverse() {

    }

    @Override
    public void detenerse() {
        color=Color.RED;
    }

    @Override
    public void destruir() {
        color=Color.CHARTREUSE;
    }

    @Override
    public void congelar() {
        color=Color.BLUE;
    }

    @Override
    public void pintar() {

        MyGdxGame.batch.begin();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(this.color);

        coordenadas.metersToPixeles();
        shapeRenderer.rect(coordenadas.getX(),coordenadas.getY(),-x,-y,getWidth(),getHeight(),1f,1f,coordenadas.getAngle());

        shapeRenderer.end();
        MyGdxGame.batch.end();
        coordenadas.pixelesToMeters();
    }

    @Override
    public boolean seleccionado() {
       if(contains(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY())){
            return true;
        }
        return false;
    }

    @Override
    public void seleccionar() {
        setColor(Color.BLACK);
    }

    @Override
    public void deseleccionar() {
        setColor(Color.BLUE);
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void establecerCoordenadas(){


        coordenadas.addVertice(new Vector2((-getWidth()/2)+x+(getWidth()/2),(-getHeight()/2)+y+(getHeight()/2)));
        coordenadas.addVertice(new Vector2((getWidth()/2)+x+(getWidth()/2),(-getHeight()/2)+y+(getHeight()/2)));
        coordenadas.addVertice(new Vector2((getWidth()/2)+x+(getWidth()/2),(getHeight()/2)+y+(getHeight()/2)));
        coordenadas.addVertice(new Vector2((-getWidth()/2)+x+(getWidth()/2),(getHeight()/2)+y+(getHeight()/2)));
        coordenadas.pixelesToMeters();
    }

    public void enviarCoordenadas(){
            Bodies.getVertices().add(coordenadas);

    }

    @Override
    public Figura copiar() {

        Rectangulo rectangulo=new Rectangulo(this.x,this.y,this.width,this.height,Color.WHITE);
        rectangulo.enviarCoordenadas();
        return rectangulo;
    }



    public Color getColor(){
        return this.color;
    }
    public void setColor(Color color){
        this.color=color;
    }


}
