package com.mygdx.game;

import java.util.ArrayList;



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
    public static void dispose(){
        for (Bloque_Figura a: Figuras) {
            a.getCuerpo().dispose();
        }
    }

    public ArrayList<Bloque> getBloqueFigura(){
        return this.BloqueFigura;
    }
    public void setBloqueFigura(ArrayList<Bloque> BloqueFigura){
        this.BloqueFigura=BloqueFigura;
    }



    public void delete(Bloque bloque) {
        BloqueFigura.remove(BloqueFigura.indexOf(bloque));
    }
    public void deleteAll() {
        BloqueFigura.removeAll(BloqueFigura);
    }
}
