package lab2;

public class Names45 {
    public String last_name;
    public String first_name;
    public String patronymic;

    public Names45(String first_name) {
        this(first_name, null, null);
    }

    public Names45(String first_name, String last_name) {
        this(first_name, last_name, null);
    }

    public Names45(String first_name, String last_name, String patronymic) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        String result = "";
        if (last_name != null) {
            result += last_name + " ";
        }
        if (first_name != null) {
            result += first_name + " ";
        }
        if (patronymic != null) {
            result += patronymic;
        }
        return result.trim();
    }
}
