package io.killuaah.elfamosogigajeu.hero;

/**
 * Classe créée le 28/12/2017.
 */
public class Weapon {
    private float damageGiven;
    private int ammoCount;
    private String weaponName;

    public Weapon(float damageGiven, int ammoCount, String weaponName) {
        this.damageGiven = damageGiven;
        this.ammoCount = ammoCount;
        this.weaponName = weaponName;
    }

    public float getDamageGiven() {
        return damageGiven;
    }

    public int getAmmoCount() {
        return ammoCount;
    }

    public void setAmmoCount(int ammoCount) {
        this.ammoCount = ammoCount;
    }
}
