package lab2;

import java.util.ArrayList;

public class Employee34 {
    public String name;
    public Department34 department;

    public Employee34(String name, Department34 department) {
        this.name = name;
        this.department = department;
        department.addEmployee(this);
    }

    public ArrayList<Employee34> getDepartmentEmployees() {
        return department.employees;
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
