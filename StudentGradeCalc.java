import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Classroom classroom = new Classroom();

        System.out.println("Enter the number of students:");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter student name:");
            String name = scanner.nextLine();

            System.out.println("Enter student ID:");
            String studentID = scanner.nextLine();

            System.out.println("Enter the number of grades:");
            int numGrades = scanner.nextInt();
            double[] grades = new double[numGrades];

            for (int j = 0; j < numGrades; j++) {
                System.out.println("Enter grade " + (j + 1) + ":");
                grades[j] = scanner.nextDouble();
            }
            scanner.nextLine(); // Consume the newline character

            // Create a new student and add to the classroom
            Student student = new Student(name, studentID, grades);
            classroom.addStudent(student);
        }

        // Display all students' information
        classroom.displayAllStudents();

        // Display the class average
        System.out.println("Class Average Grade: " + classroom.calculateClassAverage());

        scanner.close();
    }
}

// Student class definition
class Student {
    private String name;
    private String studentID;
    private double[] grades;

    public Student(String name, String studentID, double[] grades) {
        this.name = name;
        this.studentID = studentID;
        this.grades = grades;
    }

    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return grades.length > 0 ? sum / grades.length : 0;
    }

    public void displayGrades() {
        System.out.println("Grades for " + name + " (ID: " + studentID + "):");
        for (double grade : grades) {
            System.out.println("Grade: " + grade);
        }
    }

    public boolean hasPassed() {
        return calculateAverage() >= 50; // 50% is the pass mark
    }

    // Getter for grades array
    public double[] getGrades() {
        return grades;
    }
}

// Classroom class definition
class Classroom {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to calculate the class average
    public double calculateClassAverage() {
        double totalSum = 0;
        int totalGrades = 0;
        for (Student student : students) {
            totalSum += student.calculateAverage() * student.getGrades().length;
            totalGrades += student.getGrades().length;
        }
        return totalGrades > 0 ? totalSum / totalGrades : 0;
    }

    public void displayAllStudents()
    {
        for (Student student : students)
        {
            student.displayGrades();
            System.out.println("Average Grade: " + student.calculateAverage());
            System.out.println("Pass Status: " + (student.hasPassed() ? "Class has Passed" : "Class has Failed"));
            System.out.println();
        }
    }
} 
    

