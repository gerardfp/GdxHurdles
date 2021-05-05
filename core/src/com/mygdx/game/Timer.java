package com.mygdx.game;

public class Timer {
    static int game;
    int alarma;
    int frecuencia;
    boolean repetir = true;
    boolean activo = true;

    Timer(int frecuencia) {
        this.frecuencia = frecuencia;
        alarma = game + frecuencia;
    }

    Timer(int frecuencia, boolean repetir) {
        this.frecuencia = frecuencia;
        alarma = game + frecuencia;
        this.repetir = repetir;
    }

    public boolean suena() {
        if (activo && game >= alarma) {
            alarma = game + frecuencia;
            if (!repetir) activo = false;
            return true;
        }
        return false;
    }

    public void activar() {
        activo = true;
        alarma = game + frecuencia;
    }
}
