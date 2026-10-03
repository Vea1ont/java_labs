package lab2;

public class Human {
    public String first_name;
    public Integer height;

    public Human(String first_name, Integer height) {
        this.first_name = first_name;
        this.height = height;
    }

    @Override 
    public String toString() {
        return first_name + ", рост: " + height;
    }
}
