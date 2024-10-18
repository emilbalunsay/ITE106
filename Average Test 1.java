import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        String[] names = new String[numStudents];
        double[][] scores = new double[numStudents][];
        double[] averages = new double[numStudents];
        char[] letterGrades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            names[i] = scanner.nextLine();

            System.out.print("Enter the number of assignments for " + names[i] + ": ");
            int numAssignments = scanner.nextInt();
            scores[i] = new double[numAssignments];

            System.out.println("Enter the scores for " + names[i] + ": ");
            for (int j = 0; j < numAssignments; j++) {
                scores[i][j] = scanner.nextDouble();
            }
            scanner.nextLine();
        }

        for (int i = 0; i < numStudents; i++) {
            double total = 0;
            for (int j = 0; j < scores[i].length; j++) {
                total += scores[i][j];
            }
            averages[i] = total / scores[i].length;
            letterGrades[i] = assignLetterGrade(averages[i]);
        }

        System.out.println("\nStudent Grades:");
        System.out.printf("%-15s %-10s %-10s\n", "Name", "Average", "Grade");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-15s %-10.2f %-10c\n", names[i], averages[i], letterGrades[i]);
        }

        scanner.close();
    }

    public static char assignLetterGrade(double average) {
        if (average >= 90) return 'A';
        else if (average >= 80) return 'B';
        else if (average >= 70) return 'C';
        else if (average >= 60) return 'D';
        else return 'F';
    }
}
