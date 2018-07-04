package com.mygdx.game;


import java.util.ArrayList;

/**
 * Created by Alfonso on 16/06/2018.
 */

public class TableroRectangulo extends TableroGrafico {

    public TableroRectangulo(TableroDisposicion disposicion){
        super(disposicion);
        setDispocicion(disposicion);
    }
    @Override
    public void crear(){
        getDispocicion().disponer(this);
    }

    @Override
    public void pintar() {
        for(Bloque a: getBloquesTablero()){
            a.GetFigura().pintar();
        }
    }

    @Override
    public void establecerVecindad() {
        getDispocicion().establecerVecindad(getBloquesTablero());
    }

    @Override
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
            }
                Y=rectangulo.getY()+rectangulo.getHeight()+ 2f/*(MyGdxGame.h/20)*/;
        }

    }


    @Override
    public void Diagonal() {

    }



    @Override
    public void validarBloques() {

    }
}
