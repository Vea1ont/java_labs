package ru.vozhakov.weapons;

public class AutomaticRifle
        extends Pistol {

    private final int fireRate;

    // Без параметров
    public AutomaticRifle() {
        this(30, 30);
    }

    // С указанием кол-ва патронов
    public AutomaticRifle(int capacity) {
        this(capacity, capacity / 2);
    }

    // С указанием кол-ва патронов и скорострельности
    public AutomaticRifle(int capacity, int fireRate) {
        super(capacity);
        if (fireRate <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть больше нуля");
        }
        this.fireRate = fireRate;
    }

    public int getFireRate() {
        return fireRate;
    }

    @Override
    public void shoot() {
        for (int i = 0; i < fireRate; i++) {
            super.shoot();
        }
    }

    public void shoot(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Количество секунд не может быть отрицательным");
        }
        for (int i = 0; i < seconds; i++) {
            shoot();
        }
    }
    
    @Override
    public String toString() {
        return "Автомат: заряжено " + ammo() + " из " + getMaxAmmo() + " патронов, скорострельность: " + fireRate;
    }
}