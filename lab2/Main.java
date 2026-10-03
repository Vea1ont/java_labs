package lab2;

public class Main {
    public static void main(String[] args) {
        System.out.println("1.2");
        Human human = new Human("Клеопатра", 152);
        Human human2 = new Human("Пушкин", 167);
        Human human3 = new Human("Владимир", 189);

        System.out.println(human);
        System.out.println(human2);
        System.out.println(human3);

        System.out.println("1.3");
        Names names = new Names("Клеопатра");
        Names names2 = new Names("Пушкин", "Александр", "Сергеевич");
        Names names3 = new Names("Маяковский", "Владимир");
        
        System.out.println(names);
        System.out.println(names2);
        System.out.println(names3);

        System.out.println("2.4");
        Department department = new Department("IT");
        Employee employee = new Employee("Петров", department);
        Employee employee2 = new Employee("Козлов", department);
        Employee employee3 = new Employee("Сидоров", department);

        department.setHead(employee2);

        System.out.println(employee);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(department);

        System.out.println("3.4");
        Department34 department34 = new Department34("IT");
        Employee34 petrov = new Employee34("Петров", department34);
        Employee34 kozlov = new Employee34("Козлов", department34);
        Employee34 sidorov = new Employee34("Сидоров", department34);

        department34.setHead(kozlov);

        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);
        System.out.println(department34);

        System.out.println("Сотрудники отдела:");
        for (Employee34 employee34 : kozlov.getDepartmentEmployees()) {
            System.out.println(employee34.name);
        }

        System.out.println("4.5");
        Names45 kleopatra = new Names45("Клеопатра");
        Names45 pushkin = new Names45("Александр", "Пушкин", "Сергеевич");
        Names45 mayakovsky = new Names45("Владимир", "Маяковский");
        Names45 khristofor = new Names45("Христофор", "Бонифатьевич");

        System.out.println(kleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovsky);
        System.out.println(khristofor);

        
        System.out.println("5.1");
        Pistol pistol = new Pistol(3);
        System.out.println(pistol);

        for (int i = 0; i < 5; i++) {
            pistol.shoot();
        }

        System.out.println(pistol);

        Pistol pistol2 = new Pistol();
        System.out.println(pistol2);


    }
}