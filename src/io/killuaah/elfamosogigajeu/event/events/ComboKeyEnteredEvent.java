package io.killuaah.elfamosogigajeu.event.events;

import io.killuaah.elfamosogigajeu.event.Event;
import io.killuaah.elfamosogigajeu.hero.Combo;

/**
 * Classe créée le 28/12/2017.
 */
public class ComboKeyEnteredEvent extends Event {

    public int key;
    public Combo combo;

    public ComboKeyEnteredEvent(int key, Combo combo) {
        this.key = key;
        this.combo = combo;
    }

    public int getKey() {
        return key;
    }

    public Combo getCombo() {
        return combo;
    }
}
