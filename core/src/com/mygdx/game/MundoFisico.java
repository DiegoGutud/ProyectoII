package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

import box2dLight.PointLight;
import box2dLight.RayHandler;

/**
 * Created by Alfonso on 05/07/2018.
 */

public class MundoFisico {



    public static World world;
    public static Box2DDebugRenderer box2DDebugger;

    public static RayHandler rayHandler;
    private static ArrayList<PointLight> Luces;
    private PointLight luz;


    public MundoFisico(){
        world= new World(new Vector2(0f,10f),true);
        box2DDebugger=new Box2DDebugRenderer();
        Luces= new ArrayList<PointLight>();
        rayHandler = new RayHandler(world);
        rayHandler.setAmbientLight(0f);
        luz= new PointLight(rayHandler,5000, Color.WHITE,4,(MyGdxGame.w/2)/100,0);
        luz.setSoft(true);
        Luces.add(luz);
        luz=new PointLight(rayHandler,5000,Color.BLUE,8,(MyGdxGame.w)/100,(MyGdxGame.h/2)/100);
        luz.setSoft(false);
        Luces.add(luz);
        luz=new PointLight(MundoFisico.rayHandler,5000,Color.WHITE,4,(MyGdxGame.w/2)/100,((MyGdxGame.h)-(MyGdxGame.h/8))/100);
        luz.setSoft(true);
        Luces.add(luz);
        luz=new PointLight(rayHandler,5000, Color.BLUE,8,0,(MyGdxGame.h/2)/100);
        luz.setSoft(false);
        Luces.add(luz);
        luz=null;




    }
    public static void ActualizarMundo(){
        world.step(1/60f,6,2);
        box2DDebugger.render(world,MyGdxGame.camera.combined);


    }

    public static void Actualizarluces(){

        rayHandler.setCombinedMatrix(MyGdxGame.camera.combined);
        rayHandler.update();
    }

    public static void pintarLuces(){
        rayHandler.render();
    }

    public static void Dispose() {

       rayHandler.dispose();
        world.dispose();

    }

    public static BodyDef crearBodyDef(BodyDef.BodyType tipo){
        BodyDef  bodyDef = new BodyDef();
        bodyDef.type = tipo;
        return bodyDef;
    }

    public static PolygonShape crearShape(Vector2[] vertices){
        PolygonShape shape=new PolygonShape();
        shape.set(vertices);
        return shape;
    }

    public static FixtureDef crearFixtureDef(PolygonShape shape){
        FixtureDef fixtureDef=new FixtureDef();
        fixtureDef.density=1f;
        fixtureDef.isSensor=false;
        fixtureDef.shape= shape;
        return fixtureDef;
    }

}
