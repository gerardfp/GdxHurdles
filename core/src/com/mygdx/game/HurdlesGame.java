package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class HurdlesGame extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont bitmapFont;
	Atleta[] atletas;
	Pista pista;
	static float camera;
	public static int floor = 128;

	@Override
	public void create () {
		batch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		bitmapFont.setColor(Color.WHITE);
		bitmapFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		bitmapFont.getData().setScale(2f);

		pista = new Pista();
		atletas = new Atleta[4];
		for (int i = 0; i < 4; i++) atletas[i] = new Atleta(i);
	}

	@Override
	public void render () {
		Timer.game += 1;
		camera = atletas[0].d;

		for (Atleta atleta:atletas) atleta.update();

		for (Atleta atleta:atletas) {
			for (Valla valla: pista.carriles[atleta.carril].vallas){
				if(atleta.choca(valla)) {
					valla.tirar();
					atleta.frenar();
				}
			}
		}

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		pista.render(batch);
		for (int i = 3; i >=0 ; i--) atletas[i].render(batch);
		bitmapFont.draw(batch, "" + atletas[0].d, 540, 440);
		batch.end();
	}
}
