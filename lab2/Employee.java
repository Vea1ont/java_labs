package lab2;

public class Employee {
    public String name;
    public Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Override 
    public String toString() {
        if (this == department.head) {
            return name + " начальник отдела " + department.name;
        } else {
            return name + " работает в отделе " + department.name + ", начальник которого " + department.head.name;
        }
    }
}
