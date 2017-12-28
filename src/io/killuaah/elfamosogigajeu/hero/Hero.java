package io.killuaah.elfamosogigajeu.hero;

import io.killuaah.elfamosogigajeu.utils.U;

import java.awt.*;
import java.util.ArrayList;

/**
 * Classe créée le 28/12/2017.
 */
public class Hero {

    public enum HeroType {
        DAMAGER(U.toColor(255,0,0)),
        TANK(U.toColor(0,0,255)),
        SUPPORT(U.toColor(0,255,0));

        private Color typeColor;

        HeroType(Color typeColor) {
            this.typeColor = typeColor;
        }
    }
    private ArrayList<Combo> combos = new ArrayList<>();
    private Weapon heroWeapon;
    private float heroHp;
    private HeroType heroType;
    private String heroName;

    public Hero(Weapon heroWeapon, float heroHp, HeroType heroType, String heroName) {
        this.heroWeapon = heroWeapon;
        this.heroHp = heroHp;
        this.heroType = heroType;
        this.heroName = heroName;
    }

    public String getHeroName() {
        return heroName;
    }

    public ArrayList<Combo> getCombos() {
        return combos;
    }

    public Weapon getHeroWeapon() {
        return heroWeapon;
    }

    public float getHeroHp() {
        return heroHp;
    }

    public HeroType getHeroType() {
        return heroType;
    }
}
