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
    private ArrayList<Vector2> coordenadas;
    public ShapeRenderer shapeRenderer;

    private Texture tex;
    private PolygonSprite poly;
    private PolygonSpriteBatch polybatch;

    public Rectangulo(float x, float y, float width, float height, Color color){
        super(x, y, width, height);
        this.color=color;
        coordenadas=new ArrayList<Vector2>();
        coordenadas.add(new Vector2 (x/100,y/100));
        coordenadas.add(new Vector2(0,0));

        shapeRenderer= new ShapeRenderer();
        tex=new Texture("Piso.jpg");

        PolygonRegion reg= new PolygonRegion(new TextureRegion(tex),new float[]{0,0, getWidth(),0, getWidth(),getHeight(),0,getHeight()}, new short[]{0,1,2 ,0,2,3});
        poly=new PolygonSprite(reg);
        polybatch=new PolygonSpriteBatch();


    }
    public Rectangulo(float x, float y, float width, float height, int color){
        super(x, y, width, height);
        this.color.set(color);

        shapeRenderer= new ShapeRenderer();
    }
    public Rectangulo(float width, float height, int color){
        this.height=height;
        this.width=width;
        this.color.set(color);
        shapeRenderer= new ShapeRenderer();
    }
    public Rectangulo(float width, float height, Color color){
        this.height=height;
        this.width=width;
        this.color.set(color);
        shapeRenderer= new ShapeRenderer();
    }
    public Rectangulo(){}


    @Override
    public void moverse() {
        y=y+0.1f;
        //color=Color.GREEN;
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

       /* polybatch.begin();
        polybatch.disableBlending();
        poly.setPosition(coordenadas.get(0).x*100,coordenadas.get(0).y*100);
        poly.setRotation((float)(Math.toDegrees(coordenadas.get(1).x)));
        poly.setOrigin(-x,-y);
        poly.draw(polybatch);
        polybatch.enableBlending();
        polybatch.end();*/



        MyGdxGame.batch.begin();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(this.color);
      //  shapeRenderer.rotate(0f,0f,1f,(coordenadas.get(1).x*180/(float)Math.PI));
        //shapeRenderer.rect(coordenadas.get(0).x*100,coordenadas.get(0).y*100,getWidth(),getHeight());
        shapeRenderer.rect(coordenadas.get(0).x*100,coordenadas.get(0).y*100,-x,-y,getWidth(),getHeight(),1f,1f,(float)(Math.toDegrees(coordenadas.get(1).x)));
       // Gdx.app.log("pin1","Xpantalla:"+x+"Ypantalla:"+y);
        shapeRenderer.end();
        MyGdxGame.batch.end();
    }

    @Override
    public boolean seleccionado() {
       // Gdx.app.log("TAAAAAAAAAAAAAAAAAAAAAAAAAG1111","Xpantalla:"+Gdx.input.getX()+"Ypantalla:"+Gdx.input.getY());
       // Gdx.app.log("TAAAAAAAAAAAAAAAAAAAAAAAAAG2222","XVector:"+MyGdxGame.touchedPosition.x+"YVector:"+MyGdxGame.touchedPosition.y);
        //Gdx.app.log("TAAAAAAAAAAAAAAAAAAAAAAAAAG3333","XRectangulo:"+this.x+"YRectangulo:"+this.y);

       if(contains(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY())){

       // if(contains(Gdx.input.getX(),Gdx.input.getY())){

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

    public void setCoordenadas(ArrayList<Vector2> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public ArrayList<Vector2> getCoordenadas() {
        return coordenadas;
    }

    public void establecerCoordenadas(){


        coordenadas.add(new Vector2((-getWidth()/2)/100+x/100+(getWidth()/2)/100,(-getHeight()/2)/100+y/100+(getHeight()/2)/100));
        coordenadas.add(new Vector2((getWidth()/2)/100+x/100+(getWidth()/2)/100,(-getHeight()/2)/100+y/100+(getHeight()/2)/100));
        coordenadas.add(new Vector2((getWidth()/2)/100+x/100+(getWidth()/2)/100,(getHeight()/2)/100+y/100+(getHeight()/2)/100));
        coordenadas.add(new Vector2((-getWidth()/2)/100+x/100+(getWidth()/2)/100,(getHeight()/2)/100+y/100+(getHeight()/2)/100));
    }

    public void enviarCoordenadas(){
            Bodies.getVertices().add(coordenadas);

    }

    @Override
    public Figura copiar() {

        establecerCoordenadas();
        Rectangulo rectangulo=new Rectangulo(this.x,this.y,this.width,this.height,Color.WHITE);
        rectangulo.establecerCoordenadas();
        rectangulo.enviarCoordenadas();
        return rectangulo;
    }




    public void setColor(Color color){
        this.color=color;
    }


}
