package lab2;

public class Department {
    public String name;
    public Employee head;

    public Department(String name) {
        this.name = name;
    }

    public void setHead(Employee head) {
        this.head = head;
    }
    
    @Override 
    public String toString() {
        return "Начальник: " + head.name + ", отдел: " + name;
    }
}
