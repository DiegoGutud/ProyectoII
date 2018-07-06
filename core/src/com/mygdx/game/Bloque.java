package com.mygdx.game;

/**
 * Created by Alfonso on 03/06/2018.
 */

import java.util.ArrayList;

public abstract class Bloque {

    private ArrayList<Bloque> Vecinos;
    private Estado estado;

    private Figura figura;

    public Bloque(Figura figura) {
        this.figura=figura;
        estado = null;
        Vecinos= new ArrayList<Bloque>();
    }



    public void AddVecino(Bloque bloque) {
        this.Vecinos.add(bloque);
        bloque.Vecinos.add(this);

    }

    public void DeleteVecino(Bloque bloque) {
        Vecinos.remove(Vecinos.indexOf(bloque));
    }

    public boolean comprobarVecindad(Bloque bloque){
        return (this.Vecinos.contains(bloque));
    }
    public Bloque copiar(FactoryBloque factoryBloque){
        Bloque bloque=factoryBloque.crearBloque(this.figura.copiar());
                //BloqueFactory.Crear(TipoBloque.BLOQUE_ACTIVO,this.figura.copiar());
        return bloque;
    }


    public void SetEstado(Estado estado) {
        this.estado=estado;
    }

    public Estado GetEstado() {
        return this.estado;
    }

    public void Actuar() {
        estado.Actuar(this.figura);
    }




    public void SetFigura(Figura figura){
        this.figura=figura;
    }

    public Figura GetFigura(){
        return this.figura;
    }

}
