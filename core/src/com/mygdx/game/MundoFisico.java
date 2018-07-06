package com.mygdx.game;

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
 * Created by Alfonso on 05/07/2018.
 */

public class MundoFisico {



    public static World world;
    public static Box2DDebugRenderer box2DDebugger;

    public static RayHandler rayHandler;
    private PointLight luz;
    private PointLight luz2;
    private PointLight luz3;
    private PointLight luz4;


    public MundoFisico(){
        world= new World(new Vector2(0,10),true);
        box2DDebugger=new Box2DDebugRenderer();
        rayHandler = new RayHandler(world);
        rayHandler.setAmbientLight(0f);
        luz= new PointLight(rayHandler,5000, Color.WHITE,4,(MyGdxGame.w/2)/100,0);
        luz2=new PointLight(rayHandler,5000,Color.BLUE,8,(MyGdxGame.w)/100,(MyGdxGame.h/2)/100);
        luz3=new PointLight(MundoFisico.rayHandler,5000,Color.WHITE,4,(MyGdxGame.w/2)/100,((MyGdxGame.h)-(MyGdxGame.h/8))/100);
        luz4=new PointLight(rayHandler,5000, Color.BLUE,8,0,(MyGdxGame.h/2)/100);
        luz.setSoft(true);
        luz2.setSoft(false);
        luz3.setSoft(true);
        luz4.setSoft(false);


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
        world.dispose();
        rayHandler.dispose();
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
