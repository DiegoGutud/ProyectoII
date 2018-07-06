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


    public TableroGrafico( ){

    }





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
                        Gdx.app.log("Cicloooooooooooooooooooooooooooooooooo","REMOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOVEEED");
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

  /*  @Override
    public boolean validarCreacionBloque(Bloque bloque){
            Bloque b;
            //comprueba que la lista de bloques creados no este vacia
            if(!getBloquesACrear().isEmpty()){
                // comprueba que el bloque seleccionado no haya sido seleccionado y que sea vecino del ultimo bloque seleccionado
                if ( (getBloquesACrear().get(getBloquesACrear().size()-1).comprobarVecindad(bloque))) {
                         //comprueba si se a deseleccionado un bloque, para ello verifica si el bloque a agregar se habia agregado dos trunos atrás y de ser así elimina de la lista el ultimo bloque agregado
                         if ( (getBloquesACrear().size()>1 )&& (  bloque.equals(getBloquesACrear().get(getBloquesACrear().size() - 2)) ) ) {

                             b=getBloquesACrear().get(getBloquesACrear().size()-1);
                             b.GetFigura().deseleccionar();
                             getBloquesACrear().remove(b);
                             return false;
                         }
                         else {
                             return !getBloquesACrear().contains(bloque);

                         }

                }
                else{

                    return false;
                }
            }
            return true;


    }*/
    @Override
    public void crearFigura(ArrayList<Bloque> bloque){

        Bloque_Figura bloqueFigura=new Bloque_Figura();
        Bodies body=new Bodies(); //orden
        CuerpoFisico CF=body;

        ArrayList<Bloque> BloquesNuevos = new ArrayList<Bloque>();
//AÑADIR VECINOS DE CADA UNO POR AQUI SI ES QUE YA NO ESTAN AÑADIDOS
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

