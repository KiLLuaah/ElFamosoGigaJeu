package io.killuaah.elfamosogigajeu.event.events;

import io.killuaah.elfamosogigajeu.event.Event;

/**
 * Classe créée le 22/12/2017.
 */
public class MouseEvent extends Event{
    public int x,
               y,
               mouseButton;

    public MouseEvent(int x, int y, int mouseButton) {
        this.x = x;
        this.y = y;
        this.mouseButton = mouseButton;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMouseButton() {
        return mouseButton;
    }
}
