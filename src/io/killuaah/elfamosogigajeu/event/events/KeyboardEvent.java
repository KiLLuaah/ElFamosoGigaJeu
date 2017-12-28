package io.killuaah.elfamosogigajeu.event.events;

import io.killuaah.elfamosogigajeu.event.Event;

/**
 * Classe créée le 22/12/2017.
 */
public class KeyboardEvent extends Event {
    int key;
    String keyName;

    public KeyboardEvent(int key, String keyName) {
        this.key = key;
        this.keyName = keyName;
    }

    public int getKey() {
        return key;
    }

    public String getKeyName() {
        return keyName;
    }

}
