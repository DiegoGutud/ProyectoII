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
    private ArrayList<ArrayList<Vector2>>  coordenadas;
    private ArrayList<Vector2>  coordenadasIniciales;
    private static ArrayList<ArrayList<Vector2>> vertices;
    private Body body;
    private Vector2 coorBody;
    private static World world;
    private static RayHandler rayHandler;
    private Vector2 BodyOffset;
    private static Body piso;
    private static PointLight luz;
    private static PointLight luz2;
    private static PointLight luz3;
    private static PointLight luz4;
    private static Box2DDebugRenderer box2DDebugger;




    public static ArrayList<ArrayList<Vector2>> getVertices() {
        return vertices;
    }

    public static void setVertices(ArrayList<ArrayList<Vector2>> vertices) {
        Bodies.vertices = vertices;
    }

    public Bodies(){
        fixtures= new ArrayList<Fixture>();
        coordenadas=new ArrayList<ArrayList<Vector2>>();
        coordenadasIniciales=new ArrayList<Vector2>();
        vertices= new ArrayList<ArrayList<Vector2>>();

        coorBody=new Vector2();
        BodyOffset=new Vector2(0,0);

        body=null;

    }

    public static void CrearMundo(){
        world= new World(new Vector2(0,10),true);
        box2DDebugger=new Box2DDebugRenderer();
        rayHandler = new RayHandler(world);
        rayHandler.setAmbientLight(0f);
        luz= new PointLight(rayHandler,5000, Color.WHITE,4,(MyGdxGame.w/2)/100,0);//(MyGdxGame.w/2)/100,(MyGdxGame.h/2)/100);
        luz2=new PointLight(rayHandler,5000,Color.BLUE,8,(MyGdxGame.w)/100,(MyGdxGame.h/2)/100);
        luz4=new PointLight(rayHandler,5000, Color.BLUE,8,0,(MyGdxGame.h/2)/100);
        luz.setSoft(true);
        luz2.setSoft(false);
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
    public ArrayList<ArrayList<Vector2>> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<ArrayList<Vector2>> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public ArrayList<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(ArrayList<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

    public void EstablecerCoordenadas(ArrayList<Vector2> coordenadas){
        this.coordenadas.add(coordenadas);
    }

    @Override
    public void Actualizar() {

        float deltaX;
        float deltaY;
        float Offsetx;
        float Offsety;
        float finalX;
        float finalY;
        float comienzoX=this.coordenadas.get(this.coordenadas.size()-1).get(0).x;
        float comienzoY =this.coordenadas.get(this.coordenadas.size()-1).get(0).y;
        int i=0;

        for(ArrayList<Vector2> a: coordenadas) {

            Offsetx=coordenadasIniciales.get(i).x-coorBody.x;
            Offsety=coordenadasIniciales.get(i).y-coorBody.y;
            deltaX= (float) Math.cos(Math.abs(body.getAngle()))*Offsetx;
            deltaY=(float) Math.sin(Math.abs(body.getAngle()+90))*Offsety;

            finalX=a.get(0).x+deltaX;
            finalY=a.get(0).y+deltaY;



          a.get(0).set((body.getPosition().x-BodyOffset.x)+a.get(0).x,(body.getPosition().y-BodyOffset.y)+a.get(0).y);

           // a.get(0).set(finalX,finalY);
           // a.get(0).set(deltaX+coorBody.x+body.getPosition().x,deltaY+coorBody.y+body.getPosition().y);


          //  a.get(0).set(deltaX+coorBody.x+body.getPosition().x,deltaY+coorBody.y+body.getPosition().y);

          //  a.get(0).set(deltaX+body.getPosition().x,deltaY+body.getPosition().y);

            //a.get(0).set(body.getPosition().x+coordenadasIniciales.get(i).x,body.getPosition().y+coordenadasIniciales.get(i).y);
             //a.get(0).set(coorBody.x+body.getPosition().x,coorBody.y+body.getPosition().y);

            //a.get(0).set(body.getPosition().x+coorBody.x,body.getPosition().y+coorBody.y);

            //a.get(0).set(body.getPosition().x,body.getPosition().y);
            a.get(1).set(body.getAngle(),body.getAngle());
            // a.get(0).set(body.getPosition().x,body.getPosition().y);
            Gdx.app.log("Fisica","X:"+(body.getPosition().x)+" Y:"+(body.getPosition().y));
            Gdx.app.log("Inicial Grafico del Body","Xpantalla:"+(coorBody.x)+" Ypantalla:"+(coorBody.y));
            Gdx.app.log("Posicion Final","Xpantalla:"+(body.getPosition().x+coorBody.x)+" Ypantalla:"+(body.getPosition().y+coorBody.y));
            //Gdx.app.log("Piiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii","Xpantalla:"+(coordenadasIniciales.get(i).x+deltaX)+" Ypantalla:"+(coordenadasIniciales.get(i).y+deltaY));
           // Gdx.app.log("Piiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii","Xpantalla:"+(deltaX)+" Ypantalla:"+(deltaY));
            Gdx.app.log("Angle","Angle:"+Math.toDegrees(a.get(1).x));
            i++;
        }
        BodyOffset.set(body.getPosition().x,body.getPosition().y);
    }

    @Override
    public void crear() {





       cargarVertices();


        Vector2[] vertices1;


        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
       //bodyDef.position.set(a.get(0).x + 25f / 100, a.get(0).y + 25f / 100);
        bodyDef.position.set(0,0);


        //bodyDef.position.set(coordenadas.get(0).get(0).x + 100f / 100, coordenadas.get(0).get(0).y + 100f / 100);
        body = world.createBody(bodyDef);


        for(ArrayList<Vector2> a: coordenadas) {



            vertices1 = new Vector2[a.size()-2];
            Gdx.app.log("YOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO","X: "+a.get(0).x+" Y: "+a.get(0).y);
            boolean coordenadasOrigen=true;
            boolean angulo=false;
            int j=0;
            for (Vector2 b: a) {

                Gdx.app.log("TAAAAAAAAAAAAAAAAAAAAAAAAAG1111","Xpantalla:"+b.x+"Ypantalla:"+b.y);
                if(!coordenadasOrigen) {
                    vertices1[j] = b;
                    Gdx.app.log("TAAAAAAAAAAAAAAAAAAAAAAAAAG1111","hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh:"+j);
                    j++;
                }
                else{
                    if (!angulo) {
                        coordenadasIniciales.add(new Vector2(b));
                        angulo=true;
                    }
                    else{
                        coordenadasOrigen=false;
                    }

                }



            }

            PolygonShape shape=new PolygonShape();

            shape.set(vertices1);

            FixtureDef fixtureDef=new FixtureDef();
            fixtureDef.density=1f;
            fixtureDef.isSensor=false;
            fixtureDef.shape= shape;
            Fixture fixture= body.createFixture(fixtureDef);
            fixtures.add(fixture);
            shape.dispose();


            coorBody.set(coordenadasIniciales.get(0));

        }




    }

    public static void Piso(){

        BodyDef bodyDef= new BodyDef();
        bodyDef.type=BodyDef.BodyType.StaticBody;

        FixtureDef fixtureDef=new FixtureDef();
        fixtureDef.density=1f;


           // bodyDef.position.set(((MyGdxGame.w/9f)*2f)/100+((MyGdxGame.w/9)/2)/100,(MyGdxGame.h-(MyGdxGame.h/15f)-(MyGdxGame.w/9f)*2f)/100+((MyGdxGame.w/9)/2)/100);
           bodyDef.position.set(((((MyGdxGame.w/9)*5)/2)/100)+((MyGdxGame.w/9)*2)/100,((MyGdxGame.h)/100)-((MyGdxGame.h/15)/100));

            piso=world.createBody(bodyDef);



            PolygonShape shape=new PolygonShape();
            shape.setAsBox(((((MyGdxGame.w/9)*5)/2)/100)+(2*5)/100,((((MyGdxGame.w/9)*3)/2)/100));

            fixtureDef.shape= shape;

            Fixture fixture= piso.createFixture(fixtureDef);
            shape.dispose();


       luz3=new PointLight(rayHandler,5000,Color.WHITE,4,0,0);
       luz3.attachToBody(piso);
       luz3.setSoft(true);

    }



    public void cargarVertices(){
        for (ArrayList<Vector2> a: this.vertices) {
            this.coordenadas.add(a);

        }

        this.vertices.clear();
    }




}
