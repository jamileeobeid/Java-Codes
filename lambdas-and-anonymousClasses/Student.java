import java.util.*;

public class Student {
    private int grade;

    interface School {
        boolean goodStudent(Student myStudent);
    }

    //constructor
    public Student(int grade) {
        this.grade = grade;
    }

    //getter
    public int getGrade() {
        return grade;
    }

    public static void main(String[] args) {

        List<Student> myStudent = new ArrayList<>();
        myStudent.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getGrade(), o2.getGrade());
            }
        });

        School lambda = (Student myStudent2) -> myStudent2.getGrade() > 70;

        School anonymous = new School() {
            @Override
            public boolean goodStudent(Student myStudent) {
                return myStudent.getGrade() > 70;
            }
        };

        Student student1 = new Student(65);
        Student student2 = new Student(92);
        myStudent.add(student1);
        myStudent.add(student2);
        System.out.println(lambda.goodStudent(myStudent.get(0))); //false
        System.out.println(anonymous.goodStudent(myStudent.get(1))); //true
    }
}