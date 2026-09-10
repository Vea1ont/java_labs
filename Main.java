import java.util.Arrays;
import java.util.Scanner;

/**
 * Лабораторная работа №1. Задание 1 "Методы".
 * Вариант 4: задачи 2, 4, 6, 8, 10.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Задание 1. Методы ===");

        System.out.println();
        System.out.println("2.");
        System.out.println("x = 4568");
        System.out.println("результат: " + sumLastNums(4568));

        System.out.println();
        System.out.println("4.");
        System.out.println("x = 3");
        System.out.println("результат: " + isPositive(3));

        System.out.println();
        System.out.println("6.");
        System.out.println("x = 'D'");
        System.out.println("результат: " + isUpperCase('D'));

        System.out.println();
        System.out.println("8.");
        System.out.println("a = 3, b = 6");
        System.out.println("результат: " + isDivisor(3, 6));

        System.out.println();
        System.out.println("10.");
        int total = 5;

        System.out.print(total + "+11 это ");
        total = lastNumSum(total, 11);
        System.out.println(total);

        System.out.print(total + "+123 это ");
        total = lastNumSum(total, 123);
        System.out.println(total);

        System.out.print(total + "+14 это ");
        total = lastNumSum(total, 14);
        System.out.println(total);

        System.out.print(total + "+1 это ");
        total = lastNumSum(total, 1);
        System.out.println(total);

        System.out.println("Итого " + total);


        System.out.println("=== Задание 2. Условия ===");

        System.out.println();
        System.out.println("2.");
        System.out.println("x = 5, y = 0");
        System.out.println("результат: " + safeDiv(5, 0));

        System.out.println();
        System.out.println("4.");
        System.out.println("x = 5, y = 7");
        System.out.println("результат: " + makeDecision(5, 7));

        System.out.println();
        System.out.println("6.");
        System.out.println("x = 5, y = 7, z = 2");
        System.out.println("результат: " + sum3(5, 7, 2));

        System.out.println();
        System.out.println("8.");
        System.out.println("x = 31");
        System.out.println("результат: " + age(31));

        System.out.println();
        System.out.println("10.");
        System.out.println("x = \"четверг\"");
        System.out.println("результат:");
        printDays("четверг");


        System.out.println("=== Задание 3. Циклы ===");

        System.out.println();
        System.out.println("2.");
        System.out.println("x = 5");
        System.out.println("результат: " + reverseListNums(5));

        System.out.println();
        System.out.println("4.");
        System.out.println("x = 2, y = 5");
        System.out.println("результат: " + pow(2, 5));

        System.out.println();
        System.out.println("6.");
        System.out.println("x = 1111");
        System.out.println("результат: " + equalNum(1111));

        System.out.println();
        System.out.println("8.");
        System.out.println("x = 4");
        System.out.println("результат:");
        leftTriangle(4);

        System.out.println();
        System.out.println("10.");
        guessGame();

            System.out.println("=== Задание 4. Массивы ===");

        System.out.println();
        System.out.println("2.");
        System.out.println("arr = [1, 2, 3, 4, 2, 2, 5], x = 2");
        System.out.println("результат: " + findLast(new int[]{1, 2, 3, 4, 2, 2, 5}, 2));

        System.out.println();
        System.out.println("4.");
        System.out.println("arr = [1, 2, 3, 4, 5], x = 9, pos = 3");
        System.out.println("результат: " + Arrays.toString(add(new int[]{1, 2, 3, 4, 5}, 9, 3)));

        System.out.println();
        System.out.println("6.");
        System.out.println("arr = [1, 2, 3, 4, 5]");
        System.out.print("результат: ");
        reverse(new int[]{1, 2, 3, 4, 5});

        System.out.println();
        System.out.println("8.");
        System.out.println("arr1 = [1, 2, 3], arr2 = [7, 8, 9]");
        System.out.println("результат: " + Arrays.toString(concat(new int[]{1, 2, 3}, new int[]{7, 8, 9})));

        System.out.println();
        System.out.println("10.");
        System.out.println("arr = [1, 2, -3, 4, -2, 2, -5]");
        System.out.println("результат: " + Arrays.toString(deleteNegative(new int[]{1, 2, -3, 4, -2, 2, -5})));
    }

    // 2
    public static int sumLastNums(int x) {
        int x1 = x % 10;
        int x2 = x / 10 % 10;
        return x1 + x2;
    }

    // 4
    public static boolean isPositive(int x) {
        return x > 0;
    }

    // 6
    public static boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

    // 8
    public static boolean isDivisor(int a, int b) {
        return a % b == 0 || b % a == 0;
    }

    // 10
    public static int lastNumSum(int a, int b) {
        return a % 10 + b % 10;
    }

    // 2
    public static double safeDiv(int x, int y) {
        if (y == 0) {
            return 0;
        }
        return (double) x / y;
    }

    // 4
    public static String makeDecision(int x, int y) {
        if (x < y) {
            return x + " < " + y;
        } else if (x > y) {
            return x + " > " + y;
        } else {
            return x + " == " + y;
        }
    }

    // 6
    public static boolean sum3(int x, int y, int z) {
        return x + y == z || x + z == y || y + z == x;
    }

    // 8
    public static String age(int x) {
        if (x % 10 == 1 && x != 11) {
            return x + " год";
        } else if ((x % 10 == 2 || x % 10 == 3 || x % 10 == 4) && x != 12 && x != 13 && x != 14) {
            return x + " года";
        } else {
            return x + " лет";
        }
    }

    // 10
    public static void printDays(String x) {
        switch (x) {
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
        }
    }



    // 2
    public static String reverseListNums(int x) {
        String res = "";
        if (x > 0) {
            while (x != -1) {
                res += x + " ";
                x--;
            }
        } else {
            while (x != 1) {
                res += x + " ";
                x++;
            }
        }
        return res;
    }

    // 4
    public static int pow(int x, int y) {
        int result = 1;
        while (y != 0) {
            result *= x;
            y--;
        }
        return result;
    }

    // 6
    public static boolean equalNum(int x) {
        int lastNum = x % 10;
        x = x / 10;

        while (x != 0) {
            if (x % 10 != lastNum) {
                return false;
            }
            x = x / 10;
        }
        return true;
    }

    // 8
    public static void leftTriangle(int x) {
        for (int i = 0; i != x; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    // 10
    public static void guessGame() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int secretNum = (int) (Math.random() * 10);
        System.out.print("Введите число от 0 до 9: ");

        while (true) {
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Это не число. Введите число от 0 до 9: ");
            }
            int userNum = scanner.nextInt();
            attempts++;

            if (userNum == secretNum) {
                System.out.println("Вы угадали!");
                System.out.println("Количество попыток: " + attempts);
                break;
            }
            System.out.print("Вы не угадали, введите число от 0 до 9: ");
        }
    }


    // 2
    public static int findLast(int[] arr, int x) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                index = i;
            }
        }
        return index;
    }

    // 4
    public static int[] add(int[] arr, int x, int pos) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }
        newArr[pos] = x;

        for (int i = pos; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    // 6
    public static void reverse(int[] arr) {
        int archieve = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            archieve = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = archieve;
        }
        System.out.println(Arrays.toString(arr));
    }

    // 8
    public static int[] concat(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            newArr[i] = arr1[i];
        }
        for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
            newArr[i] = arr2[i - arr1.length];
        }
        return newArr;
    }

    // 10
    public static int[] deleteNegative(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                count++;
            }
        }
        int[] newArr = new int[count];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                newArr[index] = arr[i];
                index++;
            }
        }
        return newArr;
    }

}
