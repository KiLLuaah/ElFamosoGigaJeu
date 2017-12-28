package io.killuaah.elfamosogigajeu.hero;

import io.killuaah.elfamosogigajeu.event.EventHandler;
import io.killuaah.elfamosogigajeu.event.EventManager;
import io.killuaah.elfamosogigajeu.event.events.ComboDoneEvent;
import io.killuaah.elfamosogigajeu.event.events.ComboKeyEnteredEvent;
import io.killuaah.elfamosogigajeu.event.events.KeyboardEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe créée le 28/12/2017.
 */
public class Combo {

    public String[] comboKeys;

    public List<String> comboKeysEntered = new ArrayList<>();

    public String comboName;

    public Hero owner;

    public Combo(String[] comboKeys, String comboName, Hero owner) {
        this.comboKeys = comboKeys;
        this.owner = owner;
        this.comboName = comboName;
        EventManager.register(this);
    }

    @EventHandler
    public void onKey(KeyboardEvent event) {
        comboKeysEntered.add(event.getKeyName().toUpperCase());
        if (isComboDone()) {
            ComboDoneEvent comboDoneEvent = new ComboDoneEvent(this);
            comboDoneEvent.call();
        }
        else {
            ComboKeyEnteredEvent comboKeyEnteredEvent = new ComboKeyEnteredEvent(event.getKey(), this);
            comboKeyEnteredEvent.call();
        }
    }


    public boolean isComboDone() {
        if (this.comboKeysEntered.size() == this.comboKeys.length) return true;
        else return false;
    }

    public String[] getComboKeys() {
        return comboKeys;
    }

    public List<String> getComboKeysEntered() {
        return comboKeysEntered;
    }

    public String getComboName() {
        return comboName;
    }

    public Hero getOwner() {
        return owner;
    }
}
