package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pista {

    Texture texture = new Texture("pista.png");

    Carril[] carriles;

    Pista(){
        carriles = new Carril[4];

        for (int i = 0; i < 4; i++) {
            carriles[i] = new Carril();
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < 33; i++) {
            batch.draw(texture, 5*4*i-(HurdlesGame.camera%20), 0, 5*4, 120*4);
        }

        for (int i = 0; i < 4; i++) {
            for(Valla valla: carriles[i].vallas) {
                valla.render(batch, i);
            }
        }
    }
}
