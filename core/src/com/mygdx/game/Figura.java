package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by Alfonso on 03/06/2018.
 */

public interface Figura {

    public void moverse();
    public void detenerse();
    public void destruir();
    public void congelar();
    public void pintar();
    public boolean seleccionado();
    public void seleccionar();
    public void deseleccionar();
    public Figura copiar();
    public void enviarCoordenadas();



}
