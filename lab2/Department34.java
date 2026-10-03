package lab2;

import java.util.ArrayList;

public class Department34 {
    public String name;
    public Employee34 head;
    public ArrayList<Employee34> employees = new ArrayList<>();

    public Department34(String name) {
        this.name = name;
    }

    public void setHead(Employee34 head) {
        this.head = head;
    }

    public void addEmployee(Employee34 employee) {
        employees.add(employee);
    }

    @Override
    public String toString() {
        return "Отдел " + name + ", начальник: " + head.name;
    }
}
