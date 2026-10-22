package ru.vozhakov.weapons;

public class Pistol extends Weapon {
    private final int maxAmmo;

    public Pistol(int maxAmmo) {
        super(0);
        if (maxAmmo <= 0) {
            throw new IllegalArgumentException("Вместимость должна быть больше нуля");
        }
        this.maxAmmo = maxAmmo;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public int reload(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
        }

        int total = ammo + count;
        if (total > maxAmmo) {
            ammo = maxAmmo;
            return total - maxAmmo;
        }
        ammo = total;
        return 0;
    }

    public int discharge() {
        int removed = ammo;
        ammo = 0;
        return removed;
    }

    @Override
    public int load(int ammo) {
        if (ammo > maxAmmo) {
            throw new IllegalArgumentException("Больше " + maxAmmo + " патронов не помещается");
        }
        return super.load(ammo);
    }

    public boolean isLoaded() {
        return ammo > 0;
    }

    @Override
    public void shoot() {
        if (getAmmo()) {
            System.out.println("Бах!");
        } else {
            System.out.println("Клац!");
        }
    }

    @Override
    public String toString() {
        return "Пистолет: заряжено " + ammo + " из " + maxAmmo + " патронов";
    }
}
