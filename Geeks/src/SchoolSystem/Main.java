package SchoolSystem;

public class Main {
    public static void main(String[] args){
        Student s = new Student("Anna", 15, 9);

        // Доступ к защищённому полю name (protected) напрямую
        System.out.println(s.name); // Anna

        // Доступ к private полю age через getter
        System.out.println(s.getAge()); // 15

        // Изменение возраста через setter
        s.setAge(16);
        System.out.println(s.getAge()); // 16

        // Доступ к private полю grade через getter
        System.out.println(s.getGrade()); // 9

        // Изменение grade через setter
        s.setGrade(10);
        System.out.println(s.getGrade()); // 10

        // Пробуем задать некорректный grade
        s.setGrade(20); // не изменится
        System.out.println(s.getGrade()); // 10
    }
}
