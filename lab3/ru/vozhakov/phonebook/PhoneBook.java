package ru.vozhakov.phonebook;

public class PhoneBook {
    private String[] phones;
    private String[] names;

    public PhoneBook() {
        phones = new String[0];
        names = new String[0];
    }

    public String add(String phone, String name) {
        if (phone == null || phone.isBlank() || name == null || name.isBlank()) {
            throw new IllegalArgumentException("Телефон и имя не могут быть пустыми");
        }
        int nameIndex = indexOf(names, name);
        int phoneIndex = indexOf(phones, phone);
        if (phoneIndex != -1 && phoneIndex != nameIndex) {
            throw new IllegalArgumentException("Телефон " + phone + " уже записан на другое имя");
        }
        if (nameIndex != -1) {
            String oldPhone = phones[nameIndex];
            phones[nameIndex] = phone;
            return oldPhone;
        }
        phones = resize(phones, phones.length + 1);
        names = resize(names, names.length + 1);
        phones[phones.length - 1] = phone;
        names[names.length - 1] = name;
        return null;
    }

    public String remove(String name) {
        int index = indexOf(names, name);
        if (index == -1) {
            return null;
        }
        String removedPhone = phones[index];
        for (int i = index; i < names.length - 1; i++) {
            phones[i] = phones[i + 1];
            names[i] = names[i + 1];
        }
        phones = resize(phones, phones.length - 1);
        names = resize(names, names.length - 1);
        return removedPhone;
    }

    public String getPhone(String name) {
        int index = indexOf(names, name);
        return index == -1 ? null : phones[index];
    }

    public boolean containsName(String name) {
        return indexOf(names, name) != -1;
    }

    public boolean containsPhone(String phone) {
        return indexOf(phones, phone) != -1;
    }

    public int size() {
        return names.length;
    }

    public String[] getPairs() {
        String[] pairs = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            pairs[i] = phones[i] + " - " + names[i];
        }
        return pairs;
    }

    public String[] getPhones() {
        return resize(phones, phones.length);
    }

    public String[] getNames() {
        return resize(names, names.length);
    }

    public String[] findNamesByPrefix(String prefix) {
        int count = 0;
        for (String name : names) {
            if (name.startsWith(prefix)) {
                count++;
            }
        }
        String[] found = new String[count];
        int j = 0;
        for (String name : names) {
            if (name.startsWith(prefix)) {
                found[j] = name;
                j++;
            }
        }
        return found;
    }

    private static int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private static String[] resize(String[] source, int newLength) {
        String[] result = new String[newLength];
        for (int i = 0; i < Math.min(source.length, newLength); i++) {
            result[i] = source[i];
        }
        return result;
    }

    @Override
    public String toString() {
        return "Справочник: [" + String.join(", ", getPairs()) + "]";
    }
}
