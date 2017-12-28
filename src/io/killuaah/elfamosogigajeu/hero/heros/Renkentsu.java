package io.killuaah.elfamosogigajeu.hero.heros;

import io.killuaah.elfamosogigajeu.hero.Hero;
import io.killuaah.elfamosogigajeu.hero.Weapon;

/**
 * Classe créée le 28/12/2017.
 */
public class Renkentsu extends Hero {

    public Renkentsu(Weapon heroWeapon, float heroHp, HeroType heroType, String heroName) {
        super(new Weapon(30, Integer.MAX_VALUE, "Poing Du Soleil"), 100, HeroType.DAMAGER, "Renkentsu");
    }
}