package io.killuaah.elfamosogigajeu.event.events;

import io.killuaah.elfamosogigajeu.event.Event;

/**
 * Classe créée le 28/12/2017.
 */
public class ControllerEvent extends Event {


    private float x, y;

    private int button;

    public ControllerEvent(float x, float y, int button) {
        this.x = x;
        this.y = y;
        this.button = button;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getButton() {
        return button;
    }
}
