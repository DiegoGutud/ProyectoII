package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Alfonso on 05/07/2018.
 */

public class Coordenadas {

    private float x;
    private float y;
    private ArrayList<Vector2> vertices;
    private float angle;
    //Pixel to Meters Ratio
    private static float PMR=100;



    public Coordenadas(float x, float y, float angle){
        this.x=x;
        this.y=y;
        this.angle=angle;
        this.vertices=new ArrayList<Vector2>();
    }

    public void pixelesToMeters(){
        this.x=x/PMR;
        this.y=y/PMR;
        for (Vector2 a: vertices) {
            a.x=a.x/PMR;
            a.y=a.y/PMR;
        }
    }

    public void metersToPixeles(){
        this.x=x*PMR;
        this.y=y*PMR;
        for (Vector2 a: vertices) {
            a.x=a.x*PMR;
            a.y=a.y*PMR;
        }
    }

    public Vector2[] ListToArray(){
        Vector2[] vertices1 = new Vector2[vertices.size()];
        int i=0;
        for (Vector2 a: vertices) {
            vertices1[i] = a;
            i++;
        }
        return vertices1;
    }

    public void addVertice(Vector2 vertice)
    {
        vertices.add(vertice);
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;

    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ArrayList<Vector2> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vector2> vertices) {
        this.vertices = vertices;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

}
