package ru.vozhakov.main;

import java.util.Arrays;
import java.util.Scanner;

import ru.vozhakov.geometry.Point;
import ru.vozhakov.names.Names;
import ru.vozhakov.phonebook.PhoneBook;
import ru.vozhakov.weapons.AutomaticRifle;
import ru.vozhakov.weapons.Pistol;
import ru.vozhakov.weapons.Weapon;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1.5");

        //Pistol pistol = readPistolFromInput();
        //System.out.println(pistol);

        //reloadFromInput(pistol);
        //shootFromInput(pistol);
        //reloadFromInput(pistol);
        //shootFromInput(pistol);

        //int removed = pistol.discharge();
        //System.out.println("Разряжаем. Достали патронов: " + removed);
        //System.out.println("Заряжен: " + (pistol.isLoaded() ? "да" : "нет"));

       // System.out.println("Контрольный выстрел:");
        //pistol.shoot();

        
        //System.out.println();
        System.out.println("1.7");
        Names first = readNameFromInput();
        System.out.println("Создано имя: " + first);
        System.out.println("Фамилия: " + first.getLastName() + ", имя: " + first.getFirstName()
                + ", отчество: " + first.getPatronymic());
        Names second = readNameFromInput();
        System.out.println("Создано имя: " + second);

        System.out.println();
        System.out.println("2.3");
        phoneBookMenu();

        System.out.println();
        System.out.println("3.4");
        System.out.println("Без параметров: " + new AutomaticRifle());

        System.out.println("Только вместимость, скорострельность будет половиной:");
        AutomaticRifle halfRateRifle = readRifleByCapacity();
        System.out.println(halfRateRifle);

        System.out.println("Вместимость и скорострельность:");
        AutomaticRifle rifle = readRifle();
        System.out.println(rifle);
        System.out.println("Скорострельность: " + rifle.getFireRate() + ", вместимость: " + rifle.getMaxAmmo());

        reloadFromInput(rifle);
        System.out.println("Одна очередь:");
        rifle.shoot();
        System.out.println(rifle);

        shootSecondsFromInput(rifle);
        System.out.println(rifle);

        System.out.println("Разряжаем. Достали патронов: " + rifle.discharge());
        System.out.println("Заряжен: " + (rifle.isLoaded() ? "да" : "нет"));

        System.out.println();
        System.out.println("4.1");
        Pistol weaponPistol = readPistolFromInput();
        reloadFromInput(weaponPistol);
        Weapon weapon = weaponPistol;
        System.out.println("Через ссылку Weapon: патронов " + weapon.ammo());
        System.out.println("Выстрел через ссылку Weapon:");
        weapon.shoot();
        System.out.println(weapon);
        // new Weapon(5) не скомпилируется: Weapon абстрактный

        System.out.println();
        System.out.println("5.8");
        Shooter unarmed = new Shooter(readLine("Имя стрелка без оружия: "));

        Shooter withPistol = new Shooter(readLine("Имя стрелка с пистолетом: "));
        Pistol shooterPistol = readPistolFromInput();
        reloadFromInput(shooterPistol);
        withPistol.setWeapon(shooterPistol);

        Shooter withRifle = new Shooter(readLine("Имя стрелка с автоматом: "));
        AutomaticRifle shooterRifle = readRifle();
        reloadFromInput(shooterRifle);
        withRifle.setWeapon(shooterRifle);

        Shooter[] shooters = {unarmed, withPistol, withRifle};
        for (Shooter shooter : shooters) {
            System.out.println(shooter);
            shooter.shoot();
        }

        System.out.println(withPistol.getName() + " отдаёт пистолет стрелку " + unarmed.getName());
        unarmed.setWeapon(withPistol.getWeapon());
        withPistol.setWeapon(null);
        unarmed.setName(readLine("Новое имя для " + unarmed.getName() + ": "));
        for (Shooter shooter : shooters) {
            System.out.println(shooter);
            shooter.shoot();
        }

        System.out.println();
        System.out.println("6.2");
        System.out.println("Первая точка:");
        Point firstPoint = readPoint();
        System.out.println("Вторая точка:");
        Point secondPoint = readPoint();
        System.out.println("Точки: " + firstPoint + " и " + secondPoint);
        System.out.println("Один и тот же объект (==): " + (firstPoint == secondPoint ? "да" : "нет"));
        System.out.println("Одинаковые координаты (equals): " + (firstPoint.equals(secondPoint) ? "да" : "нет"));
        System.out.println("Точка с самой собой (equals): " + (firstPoint.equals(firstPoint) ? "да" : "нет"));
        System.out.println("Точка и null (equals): " + (firstPoint.equals(null) ? "да" : "нет"));

        System.out.println();
        System.out.println("7.3");
        if (args.length < 2) {
            System.out.println("Запустите программу с двумя аргументами, например: java ru.vozhakov.main.Main 2 10");
        } else {
            try {
                System.out.println(args[0] + " в степени " + args[1] + " = " + Power.power(args[0], args[1]));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: аргументы должны быть целыми числами");
            }
        }
    }

    private static Pistol readPistolFromInput() {
        while (true) {
            int capacity = readInt("Вместимость пистолета: ");
            try {
                return new Pistol(capacity);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Это не число. " + prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static void reloadFromInput(Pistol pistol) {
        while (true) {
            int count = readInt("Сколько патронов зарядить: ");
            try {
                int extra = pistol.reload(count);
                System.out.println("Лишних: " + extra);
                System.out.println(pistol);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

     private static void shootFromInput(Pistol pistol) {
        int shots = readInt("Сколько раз выстрелить: ");
        while (shots < 0) {
            System.out.println("Число выстрелов не может быть отрицательным");
            shots = readInt("Сколько раз выстрелить: ");
        }
        for (int i = 0; i < shots; i++) {
            pistol.shoot();
        }
    }




    private static Names readNameFromInput() {
        while (true) {
            String lastName = readLine("Фамилия: ");
            String firstName = readLine("Имя: ");
            String patronymic = readLine("Отчество: ");
            try {
                return new Names(firstName, lastName, patronymic);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static Point readPoint() {
        int x = readInt("X: ");
        int y = readInt("Y: ");
        return new Point(x, y);
    }

    private static void phoneBookMenu() {
        PhoneBook book = new PhoneBook();
        while (true) {
            System.out.println();
            System.out.println("1 - добавить, 2 - удалить, 3 - найти телефон по имени");
            System.out.println("4 - есть ли имя, 5 - есть ли телефон, 6 - имена по началу");
            System.out.println("7 - показать справочник, 0 - выход");
            int choice = readInt("Действие: ");
            switch (choice) {
                case 1:
                    String phone = readLine("Телефон: ");
                    String name = readLine("Имя: ");
                    try {
                        String oldPhone = book.add(phone, name);
                        if (oldPhone == null) {
                            System.out.println("Контакт добавлен");
                        } else {
                            System.out.println("Телефон заменён, старый: " + oldPhone);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 2:
                    String removedPhone = book.remove(readLine("Имя: "));
                    System.out.println(removedPhone == null ? "Такого имени нет" : "Удалён контакт с телефоном " + removedPhone);
                    break;
                case 3:
                    String foundPhone = book.getPhone(readLine("Имя: "));
                    System.out.println(foundPhone == null ? "Такого имени нет" : "Телефон: " + foundPhone);
                    break;
                case 4:
                    String checkedName = readLine("Имя: ");
                    System.out.println(book.containsName(checkedName)
                            ? "Есть, телефон: " + book.getPhone(checkedName)
                            : "Нет");
                    break;
                case 5:
                    System.out.println(book.containsPhone(readLine("Телефон: ")) ? "Есть" : "Нет");
                    break;
                case 6:
                    String[] names = book.findNamesByPrefix(readLine("Начало имени: "));
                    System.out.println("Найдено: " + Arrays.toString(names));
                    break;
                case 7:
                    System.out.println(book);
                    System.out.println("Контактов: " + book.size());
                    System.out.println("Пары: " + Arrays.toString(book.getPairs()));
                    System.out.println("Телефоны: " + Arrays.toString(book.getPhones()));
                    System.out.println("Имена: " + Arrays.toString(book.getNames()));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Нет такого действия");
            }
        }
    }

    private static AutomaticRifle readRifleByCapacity() {
        while (true) {
            int capacity = readInt("Вместимость автомата: ");
            try {
                return new AutomaticRifle(capacity);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static AutomaticRifle readRifle() {
        while (true) {
            int capacity = readInt("Вместимость автомата: ");
            int fireRate = readInt("Скорострельность: ");
            try {
                return new AutomaticRifle(capacity, fireRate);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static void shootSecondsFromInput(AutomaticRifle rifle) {
        while (true) {
            int seconds = readInt("Сколько секунд стрелять: ");
            try {
                rifle.shoot(seconds);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
