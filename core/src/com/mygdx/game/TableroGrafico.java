package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.sql.BatchUpdateException;
import java.util.ArrayList;

/**
 * Created by Alfonso on 16/06/2018.
 */

public abstract class TableroGrafico extends Tablero {


    public TableroGrafico( ){}

    @Override
    public void actualizar(){

        if(Gdx.input.isTouched()){

            for (Bloque a: getBloquesTablero()) {

                //Comprueba que se haya seleccionado el bloque
                if(a.GetFigura().seleccionado()){  //Ley de Demeter

                    getBloquesACrear().add(a);
                    if( (getBloquesACrear().isEmpty()) || (validarRestricciones())) {

                        a.GetFigura().seleccionar();//Ley de Demeter

                    }
                    else{

                        getBloquesACrear().remove(getBloquesACrear().size()-1);
                    }
                    break;
                }

            }

        }
        else{
            if(!getBloquesACrear().isEmpty()){
                crearFigura(getBloquesACrear());
                for (Bloque a: getBloquesACrear()) {
                    a.GetFigura().deseleccionar();
                }
                getBloquesACrear().clear();
            }
        }
    }


    @Override
    public void crearFigura(ArrayList<Bloque> bloque){

        Bloque_Figura bloqueFigura=new Bloque_Figura();
        Bodies body=new Bodies();
        CuerpoFisico CF=body;

        ArrayList<Bloque> BloquesNuevos = new ArrayList<Bloque>();

        FactoryBloque factoryBloque= new FactoryBloquesActivos();
        for (Bloque a: bloque) {
            BloquesNuevos.add(a.copiar(factoryBloque));
        }

        bloqueFigura.setBloqueFigura(BloquesNuevos);
        Bloque_Figura.Figuras.add(bloqueFigura);

        CF.crear();
        bloqueFigura.setCuerpo(CF);



    }




}

