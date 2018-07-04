package com.mygdx.game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;


public class MyGdxGame extends ApplicationAdapter {
	static SpriteBatch batch;
	Bloque_Figura Figuras;
	ShapeRenderer shapeRenderer;
	Tablero tablero;
	Bloque piso;
	static OrthographicCamera camera;
	static Vector3 touchedPosition;
	static float w;
	static float h;
	//camera = new OrthographicCamera();
	//camera.setToOrtho(false,800,400);

	
	@Override
	public void create () {
		w=Gdx.graphics.getWidth();
		h= Gdx.graphics.getHeight();
		batch = new SpriteBatch();
				Figuras= new Bloque_Figura();

		touchedPosition= new Vector3();
		shapeRenderer= new ShapeRenderer();
		tablero=null;
		tablero=Factory.CrearTablero(TipoTablero.TABLERO_RECTANGULOS,TipoDisposicion.HORIZONTAL);
		tablero.crear();
		tablero.establecerVecindad();


//piso
		/*Bloque_Figura bloqueFigura=new Bloque_Figura();
		Bodies body=new Bodies(); //orden

		piso=BloqueFactory.Crear(TipoBloque.PISO,FiguraFactory.CrearFigura(TipoFigura.RECTANGULO_PISO,10+(w/9f)*2f,h-(h/15f)-(w/9f)*2f));
		Bloque_Figura.Figuras.add(bloqueFigura);
		body.Piso();
		CuerpoFisico CF=body;
		bloqueFigura.setCuerpo(CF);*/







		//camera=new OrthographicCamera(30/100,30*(h/w)/100);
		camera=new OrthographicCamera((w)/100,(h)/100);
		camera.position.set((w/100)/2,(h/100)/2,0);

		Bodies.CrearMundo();


		Bodies.Piso();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(Color.VIOLET.r, Color.VIOLET.g, Color.VIOLET.b, Color.VIOLET.a);

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		//batch.begin();

		//batch.end();
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		Bodies.ActualizarMundo();

		Bodies.Actualizarluces();
		Bodies.pintarLuces();

		tablero.actualizar();
		Bloque_Figura.Actualizar();
		tablero.pintar();
		Bloque_Figura.pintar();



	}
	
	@Override
	public void dispose () {
		batch.dispose();
		Bodies.Dispose();
	}
}
