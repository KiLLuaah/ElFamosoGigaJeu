package io.killuaah.elfamosogigajeu.event.events;

import io.killuaah.elfamosogigajeu.event.Event;
import io.killuaah.elfamosogigajeu.hero.Combo;

/**
 * Classe créée le 28/12/2017.
 */
public class ComboDoneEvent extends Event {

    private Combo combo;

    public ComboDoneEvent(Combo combo) {
        this.combo = combo;
    }

    public Combo getCombo() {
        return combo;
    }
}
