package ru.vozhakov.weapons;

public abstract class Weapon {
    protected int ammo;

    public Weapon(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException("Количество патронов не может быть отрицательным");
        }
        this.ammo = ammo;
    }

    public abstract void shoot();

    public int ammo() {
        return ammo;
    }

    public boolean getAmmo() {
        if (ammo == 0) {
            return false;
        }
        ammo--;
        return true;
    }

    public int load(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException("Количество патронов не может быть отрицательным");
        }
        int tmp = this.ammo;
        this.ammo = ammo;
        return tmp;
    }

    @Override
    public String toString() {
        return "Оружие: заряжено " + ammo + " патронов";
    }
}
