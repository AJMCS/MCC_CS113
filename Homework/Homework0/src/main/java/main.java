
// import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Scanner;
// import org.junit.jupiter.api.Test;

public class StudentGradesCalculator {
    public static void main(String[] args) {

          double total;
          Scanner input = new Scanner(System.in);

          System.out.println("Please enter the number of students you have:");

          int numOfStudents = input.nextInt();
          input.nextLine();

          Student[] students = new Student[numOfStudents];

          for (int i = 0; i < students.length; i++) {
              int[] grades = new int[5];
              students[i] = new Student();
              System.out.print("Name: ");
              students[i].setName(input.nextLine());

              System.out.print("Grades: ");
              for (int j = 0; j < 5; j++) 
              {
                  grades[j] = input.nextInt();
              }
              input.nextLine();

              students[i].setGrades(grades);

              System.out.println("Average grade: " + students[i].getAverageGrade() + "\n");
          }

          total = 0;
          for (int i = 0; i < students.length; i++) {
              total += students[i].getAverageGrade();
          }

          System.out.println("Class Average Grade: " + total / students.length);
    }

}