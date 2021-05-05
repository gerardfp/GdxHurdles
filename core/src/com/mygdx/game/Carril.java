package com.mygdx.game;

public class Carril {

    Valla[] vallas;

    Carril(){
        vallas = new Valla[10];

        for (int i = 0; i < 10; i++) {
            vallas[i] = new Valla(i*200+200);
        }
    }
}
