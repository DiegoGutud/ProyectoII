package com.mygdx.game;

/**
 * Created by Alfonso on 03/06/2018.
 */

public class Bloques_Activos extends Bloque{

    private PowerUps power_up;

    public Bloques_Activos(Figura figura) {
        super(figura);
        power_up=null;
    }

    public void SetPowerUp(PowerUps power_up) {
        this.power_up=power_up;
    }

    public PowerUps GetPowerUp() {
        return this.power_up;
    }

    public void Activar() {
        power_up.activar(super.GetFigura());
    }
}


