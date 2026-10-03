package lab2;

public class Pistol {
    public int ammo;

    public Pistol(int ammo) {
        this.ammo = ammo;
    }

    public Pistol() {
        this(5);
    }

    public void shoot() {
        if (ammo > 0) {
            System.out.println("Бах!");
            ammo--;
        } else {
            System.out.println("Клац!");
        }
    }

    @Override
    public String toString() {
        return "Пистолет, патронов: " + ammo;
    }
}
