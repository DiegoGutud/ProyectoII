package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

import box2dLight.PointLight;
import box2dLight.RayHandler;

/**
 * Created by Alfonso on 25/06/2018.
 */

public class Bodies implements CuerpoFisico {

    private ArrayList<Fixture> fixtures;
    private ArrayList<Coordenadas>  coordenadas;
    private static ArrayList<Coordenadas> vertices;
    private Body body;
    private Vector2 coorBody;
    private Vector2 BodyOffset;





    public static ArrayList<Coordenadas> getVertices() {
        return vertices;
    }

    public static void setVertices(ArrayList<Coordenadas> vertices) {
        Bodies.vertices = vertices;
    }

    public Bodies(){
        fixtures= new ArrayList<Fixture>();
        coordenadas=new ArrayList<Coordenadas>();
        vertices= new ArrayList<Coordenadas>();

        coorBody=new Vector2();
        BodyOffset=new Vector2(0,0);

        body=null;

    }


    @Override
    public void Actualizar() {


        for(Coordenadas a: coordenadas) {

            a.setX((body.getPosition().x-BodyOffset.x)+a.getX());
            a.setY((body.getPosition().y-BodyOffset.y)+a.getY());
            a.setAngle((float) Math.toDegrees(body.getAngle()));

        }
       if(body!=null) {
           BodyOffset.set(body.getPosition().x, body.getPosition().y);
       }
    }

    @Override
    public void crear() {



        cargarVertices();


        Vector2[] vertices1;


        body = MundoFisico.world.createBody(MundoFisico.crearBodyDef(BodyDef.BodyType.DynamicBody));


        for(Coordenadas a: coordenadas) {


            vertices1 = a.ListToArray();



            PolygonShape shape = MundoFisico.crearShape(vertices1);
            Fixture fixture = body.createFixture(MundoFisico.crearFixtureDef(shape));
            fixtures.add(fixture);
            shape.dispose();


            coorBody.set(a.getX(), a.getY());
        }


    }







    public void crearCuerpo(BodyDef.BodyType tipo){



        cargarVertices();


        Vector2[] vertices1;


        body = MundoFisico.world.createBody(MundoFisico.crearBodyDef(tipo));


        for(Coordenadas a: coordenadas) {


            vertices1 = a.ListToArray();



            PolygonShape shape = MundoFisico.crearShape(vertices1);
            Fixture fixture = body.createFixture(MundoFisico.crearFixtureDef(shape));
            fixtures.add(fixture);
            shape.dispose();


            coorBody.set(a.getX(), a.getY());
        }
    }


    public void cargarVertices(){
        for (Coordenadas a: this.vertices) {
            this.coordenadas.add(a);

        }

        this.vertices.clear();
    }




}
