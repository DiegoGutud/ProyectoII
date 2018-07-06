package com.mygdx.game;

/**
 * Created by Alfonso on 05/07/2018.
 */
public class FactoryTableroRectangular implements FactoryTablero {

  private int columnas;
  private int filas;
  private float x;
  private float y;

    public FactoryTableroRectangular(int columnas, int filas, float x, float y) {
        this.columnas=columnas;
        this.filas=filas;
        this.x=x;
        this.y=y;
    }

    @Override
    public Tablero crearTablero() {
        return new TableroRectangulo(columnas, filas,x,y);
    }
}
