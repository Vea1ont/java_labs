package ru.vozhakov.names;

public class Names {
    private final String last_name;
    private final String first_name;
    private final String patronymic;

    public Names(String first_name) {
        this(first_name, null, null);
    }

    public Names(String first_name, String last_name) {
        this(first_name, last_name, null);
    }

    public Names(String first_name, String last_name, String patronymic) {
        if (isEmptyPart(first_name) && isEmptyPart(last_name) && isEmptyPart(patronymic)) {
            throw new IllegalArgumentException("Хотя бы одна часть имени должна быть заполнена");
        }
        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
    }

    private static boolean isEmptyPart(String part) {
        return part == null || part.isBlank();
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        String result = "";
        if (!isEmptyPart(last_name)) {
            result += last_name + " ";
        }
        if (!isEmptyPart(first_name)) {
            result += first_name + " ";
        }
        if (!isEmptyPart(patronymic)) {
            result += patronymic;
        }
        return result.trim();
    }
}
