package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Valla {
    Animacion caerAnim = new Animacion(4f, false, "fall_0.png", "fall_1.png", "fall_2.png", "fall_3.png", "fall_4.png");
    Animacion enpieAnim = new Animacion(6f, false, "hurdle.png");

    int pos;
    static int altura;
    boolean enpie = true;
    float stateFrame = 0;

    public Valla(int i) {
        this.pos = i;
        altura = 27;
    }

    public void render(SpriteBatch batch, int c) {
        stateFrame += 1;
        if(enpie){
            batch.draw(enpieAnim.getFrame(stateFrame), pos-HurdlesGame.camera+4*4*c+200, 124+3*4*c, 7*4, 12*4);
        } else {
            batch.draw(caerAnim.getFrame(stateFrame), pos-HurdlesGame.camera+4*4*c+200, 124+3*4*c, 7*4, 12*4);
        }
    }

    public void tirar() {
        stateFrame = 0;
        enpie = false;
    }
}
