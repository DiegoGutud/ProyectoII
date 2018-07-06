package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by Alfonso on 04/07/2018.
 */

public class RestriccionGeneral implements RestriccionesTablero {

    private ArrayList<Bloque> BloquesTablero;
    private ArrayList<Bloque> BloquesACrear;

    public RestriccionGeneral(ArrayList<Bloque> BloquesTablero,ArrayList<Bloque> BloquesACrear){
        this.BloquesTablero= BloquesTablero;
        this.BloquesACrear=BloquesACrear;
    }

    @Override
    public void crearRestriccion() {

    }

    @Override
    public boolean validarRestriccion() {
        Bloque bloque=BloquesACrear.get(BloquesACrear.size()-1);
        BloquesACrear.remove(BloquesACrear.size()-1);
        Bloque b;


        //comprueba si se a deseleccionado un bloque, para ello verifica si el bloque a agregar se habia agregado dos trunos atrás y de ser así elimina de la lista el ultimo bloque agregado
        if ( (BloquesACrear.size()>1 )&& (  bloque.equals(BloquesACrear.get(BloquesACrear.size() - 2)) ) ) {

            b=BloquesACrear.get(BloquesACrear.size()-1);
            b.GetFigura().deseleccionar();//LEy demeter
            BloquesACrear.remove(b);
            BloquesACrear.add(bloque);
            return true;
        }
        else {
            //comprueba que el ultimo bloque añadido no esté ya en la lista
            if(!BloquesACrear.contains(bloque)){
                BloquesACrear.add(bloque);

                return true;
            }
            else{
                BloquesACrear.add(bloque);
                return false;
            }

        }


    }
}
