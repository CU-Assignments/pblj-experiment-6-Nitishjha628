import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private double marks;
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class Filterexp {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int numStudents = obj.nextInt();
        obj.nextLine(); 

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = obj.nextLine();
            System.out.print("Marks (%): ");
            double marks = obj.nextDouble();
            obj.nextLine();
            students.add(new Student(name, marks));
        }
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getMarks() > 75) {
                filteredStudents.add(student);
            }
        }
        filteredStudents.sort((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()));

        System.out.println("\nStudents scoring above 75%, sorted by marks (highest to lowest):");
        for (Student student : filteredStudents) {
            System.out.println(student.getName() + " - " + student.getMarks() + "%");
        }
    }
}