package SchoolSystem;

public class Student extends Person{
    private int grade;

    public Student() {
        grade = 0;
    }

    public Student(int grade){
        this.grade = grade;
    }

    public Student(String name, int age, int grade){
        super(name, age);  // вызов конструктора родителя
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
