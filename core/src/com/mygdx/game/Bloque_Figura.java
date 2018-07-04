package com.mygdx.game;

import java.util.ArrayList;

import static com.mygdx.game.TipoEstado.DETENERSE;
import static com.mygdx.game.TipoEstado.MOVERSE;

/**
 * Created by Alfonso on 03/06/2018.
 */

public class Bloque_Figura  {
   private ArrayList<Bloque> BloqueFigura;
   public static ArrayList<Bloque_Figura> Figuras =new ArrayList<Bloque_Figura>();;
   private CuerpoFisico cuerpo;

   public Bloque_Figura(){
       BloqueFigura=new ArrayList<Bloque>();

       cuerpo=null;
   }


    public void add(Bloque bloque) {
        BloqueFigura.add(bloque);
    }

    public void setCuerpo(CuerpoFisico cuerpo) {
        this.cuerpo = cuerpo;
    }

    public CuerpoFisico getCuerpo() {
        return cuerpo;
    }
    /*  public void detenerse(){
        if( (BloqueFigura!= null) && (BloqueFigura.size() !=0)){

            for (Bloque a: BloqueFigura){

                a.SetEstado(EstadoFactory.Crear(DETENERSE));
                a.Actuar();
            }
        }

    }*/

    public static void pintar() {
        for (Bloque_Figura a: Figuras) {
            for (Bloque b: a.getBloqueFigura()) {
                b.GetFigura().pintar();
            }
        }
    }

    public static void Actualizar(){
        for (Bloque_Figura a: Figuras) {
            a.getCuerpo().Actualizar();
        }
    }


    public ArrayList<Bloque> getBloqueFigura(){
        return this.BloqueFigura;
    }
    public void setBloqueFigura(ArrayList<Bloque> BloqueFigura){
        this.BloqueFigura=BloqueFigura;
    }

    public boolean verificar(){
        if ( (BloqueFigura!= null) && (BloqueFigura.size() !=0)) {
         return true;
        }
        return false;
    }

    public void delete(Bloque bloque) {
        BloqueFigura.remove(BloqueFigura.indexOf(bloque));
    }
    public void deleteAll() {
        BloqueFigura.removeAll(BloqueFigura);
    }
}
