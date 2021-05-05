package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Atleta {


    private final Animacion runAnim, jumpAnim, idleAnim;
    float y, w, h, vx, vy, d;
    int carril;

    Atleta(int carril) {
        y = 0;
        w = 11 * 4;
        h = 18 * 4;
        vx = 0;
        vy = 0;
        this.carril = carril;
        runAnim = new Animacion(6f, true, "run" + carril + "_0.png", "run" + carril + "_1.png", "run" + carril + "_2.png", "run" + carril + "_3.png", "run" + carril + "_4.png", "run" + carril + "_5.png", "run" + carril + "_6.png", "run" + carril + "_7.png");
        jumpAnim = new Animacion(6f, false, "jump" + carril + "_0.png");
        idleAnim = new Animacion(6f, false, "idle" + carril + "_0.png");
    }

    boolean choca(Valla valla) {
        return Math.abs(d - valla.pos) < 1 && y < Valla.altura;
    }

    public void frenar() {
        vx -= 1f;

        if(vx < 0) vx = 0;
    }

    void update() {
        if (carril == 0 && Gdx.input.isKeyJustPressed(Input.Keys.L)
                || carril == 1 && Gdx.input.isKeyJustPressed(Input.Keys.K)
                || carril == 2 && Gdx.input.isKeyJustPressed(Input.Keys.J)
                || carril == 3 && Gdx.input.isKeyJustPressed(Input.Keys.H)) {
            vx = 1.85f;
        }

        if (vx >= 0) {
            d += vx;
            vx -= 0.05f;
        }

        if (vx < 0) {
            vx = 0;
        }

        if (carril == 0 && Gdx.input.isKeyPressed(Input.Keys.A) && y == 0
                || carril == 1 && Gdx.input.isKeyPressed(Input.Keys.S) && y == 0
                || carril == 2 && Gdx.input.isKeyPressed(Input.Keys.D) && y == 0
                || carril == 3 && Gdx.input.isKeyPressed(Input.Keys.F) && y == 0) {
            vy = 3.61f;
        }

        if (y >= 0) {
            y += vy;
            vy -= 0.197f;
        }

        if (y < 0) {
            y = 0;
            vy = 0;
        }
    }

    void render(SpriteBatch batch) {
        if (carril == 0) {
            if (y > 0) {
                batch.draw(jumpAnim.getFrame(Timer.game), 200 + carril * 4 * 4, y + HurdlesGame.floor + carril * 4 * 4, 13 * 4, 14 * 4);
            } else if (vx == 0) {
                batch.draw(idleAnim.getFrame(Timer.game), 200 + carril * 4 * 4, y + HurdlesGame.floor + carril * 4 * 4, 11 * 4, 18 * 4);
            } else {
                batch.draw(runAnim.getFrame(Timer.game), 200 + carril * 4 * 4, y + HurdlesGame.floor + carril * 4 * 4, 11 * 4, 18 * 4);
            }
        } else {
            if (y > 0) {
                batch.draw(jumpAnim.getFrame(Timer.game), d + carril * 4 * 4 + 200 - HurdlesGame.camera, y + HurdlesGame.floor + carril * 4 * 4, 13 * 4, 14 * 4);
            } else if (vx == 0) {
                batch.draw(idleAnim.getFrame(Timer.game), d + carril * 4 * 4 + 200 - HurdlesGame.camera, y + HurdlesGame.floor + carril * 4 * 4, 11 * 4, 18 * 4);
            } else {
                batch.draw(runAnim.getFrame(Timer.game), d + carril * 4 * 4 + 200 - HurdlesGame.camera, y + HurdlesGame.floor + carril * 4 * 4, 11 * 4, 18 * 4);
            }
        }
    }
}
