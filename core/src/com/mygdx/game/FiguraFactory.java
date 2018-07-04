package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;



/**
 * Created by Alfonso on 15/06/2018.
 */

public class FiguraFactory {

    public static Figura CrearFigura(TipoFigura tipo, float x, float y){
        Figura figura=null;
        switch(tipo)
        {
            case RECTANGULO:

                figura =new Rectangulo(x, y, 20f, 20f, Color.GREEN);
                break;
            case RECTANGULO_PISO:
                Rectangulo rec= new Rectangulo(x, y, (MyGdxGame.w/9)*5f, (MyGdxGame.w/9)*2f, Color.GREEN);
                rec.establecerCoordenadas();
                rec.enviarCoordenadas();
                figura=rec;
                break;


            default:
                break;
        }
        return figura;
    }

    public static Rectangulo CrearRectanguloTablero(TipoFigura tipo, float x, float y){
        Rectangulo rectangulo=null;
        switch(tipo)
        {
            case RECTANGULO_TABLERO:

                rectangulo =new Rectangulo(x, y, MyGdxGame.w/9, MyGdxGame.w/9, Color.BLUE);
                break;



            default:
                break;
        }
        return rectangulo;
    }




}
