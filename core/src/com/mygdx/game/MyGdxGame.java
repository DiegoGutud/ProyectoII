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

	static OrthographicCamera camera;
	static Vector3 touchedPosition;
	static float w;
	static float h;
	private InicializadorRestricciones restriccionesTablero;
	private MundoFisico mundoFisico;


	
	@Override
	public void create () {
		w=Gdx.graphics.getWidth();
		h= Gdx.graphics.getHeight();
		batch = new SpriteBatch();
				Figuras= new Bloque_Figura();

		touchedPosition= new Vector3();
		shapeRenderer= new ShapeRenderer();

		mundoFisico=new MundoFisico();
		restriccionesTablero=new InicializadorRestricciones();

		tablero=Tablero.inicializar(new FactoryTableroRectangular(5,3,(MyGdxGame.w/9)*2,MyGdxGame.h/15));

		tablero.crear(new FactoryBloquesActivos());
		tablero.setRestricciones(restriccionesTablero.inicializar(tablero.getBloquesTablero(),tablero.getBloquesACrear()));
		tablero.crearRestricciones();



//piso

		FactoryFigura factoryFigura=new FactoryFiguraRectangulo();
		FactoryBloque factoryBloque= new FactoryBloquesPiso();
		factoryBloque.crearBloqueFisico(factoryFigura.crearFigura((w/9f)*2f,h-(h/15f)-(w/9f)*2f,(MyGdxGame.w/9)*5f,(MyGdxGame.w/9)*2.5f,Color.SKY));



		camera=new OrthographicCamera((w)/100,(h)/100);
		camera.position.set((w/100)/2,(h/100)/2,0);





	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(Color.VIOLET.r, Color.VIOLET.g, Color.VIOLET.b, Color.VIOLET.a);

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



		camera.update();

		batch.setProjectionMatrix(camera.combined);
		MundoFisico.ActualizarMundo();

		MundoFisico.Actualizarluces();
		MundoFisico.pintarLuces();

		tablero.actualizar();
		Bloque_Figura.Actualizar();
		tablero.pintar();
		Bloque_Figura.pintar();



	}
	
	@Override
	public void dispose () {
		batch.dispose();
		MundoFisico.Dispose();
	}
}
