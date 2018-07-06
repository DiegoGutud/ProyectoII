package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;

/**
 * Created by Alfonso on 16/06/2018.
 */

public class TableroRectangulo extends TableroGrafico {


    private int columnas;
    private int filas;
    private float x;
    private float y;

  /*  public TableroHorizontal(){
        columnas=5;
        filas=3;
        x= (MyGdxGame.w/9)*2;
        y= (MyGdxGame.h/15);
    }*/


    public TableroRectangulo(int columnas, int filas, float x, float y){
        this.columnas=columnas;
        this.filas=filas;
        this.x=x;
        this.y=y;
    }
    @Override
    public void crear(FactoryBloque factoryBloque){

        RectanguloTablero rectangulo=null;

        float X=x;
        float Y=y;



        for (int i = 0; i <filas ; i++) {
            X=x;

            for (int j = 0; j < columnas; j++) {

                rectangulo= new RectanguloTablero(X,Y,MyGdxGame.w/9,MyGdxGame.w/9, Color.BLUE); //FiguraFactory.CrearRectanguloTablero(TipoFigura.RECTANGULO_TABLERO,X,Y);
                //BloqueFactory.Crear(TipoBloque.BLOQUE_ACTIVO,rectangulo);
                getBloquesTablero().add(factoryBloque.crearBloque(rectangulo));
                X=rectangulo.getX()+rectangulo.getWidth()+ 2f/*(MyGdxGame.w/20)*/;
            }
            Y=rectangulo.getY()+rectangulo.getHeight()+ 2f/*(MyGdxGame.h/20)*/;
        }
    }

    @Override
    public void pintar() {
        for(Bloque a: getBloquesTablero()){
            a.GetFigura().pintar();
        }
    }

  //  @Override


  /*  @Override
    public void Rectangular(int columnas, int filas, float x, float y) {


        Rectangulo rectangulo=null;
        Bloque bloque= null;
        float X=x;
        float Y=y;



        for (int i = 0; i <filas ; i++) {
            X=x;
            for (int j = 0; j < columnas; j++) {
                rectangulo=FiguraFactory.CrearRectanguloTablero(TipoFigura.RECTANGULO_TABLERO,X,Y);
                bloque=BloqueFactory.Crear(TipoBloque.BLOQUE_ACTIVO,rectangulo);
                getBloquesTablero().add(bloque);
                X=rectangulo.getX()+rectangulo.getWidth()+ 2f/*(MyGdxGame.w/20)*/;
          /*  }
                Y=rectangulo.getY()+rectangulo.getHeight()+ 2f/*(MyGdxGame.h/20)*/;
      /*  }

    }*/



}
