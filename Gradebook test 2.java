import java.util.Scanner;
import java.util.Arrays;

public class StudentGradebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: Array Storage
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        String[] studentNames = new String[numStudents];
        double[][] grades = new double[numStudents][];
        
        // Step 2: Input
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();
            
            System.out.print("Enter number of assignments for " + studentNames[i] + ": ");
            int numAssignments = scanner.nextInt();
            grades[i] = new double[numAssignments];
            
            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Enter grade for assignment " + (j + 1) + ": ");
                grades[i][j] = scanner.nextDouble();
            }
            scanner.nextLine(); // consume newline
        }
        
        // Step 3: Calculation
        double[] averages = new double[numStudents];
        for (int i = 0; i < numStudents; i++) {
            double total = 0;
            for (int j = 0; j < grades[i].length; j++) {
                total += grades[i][j];
            }
            double average = total / grades[i].length;
            averages[i] = average;
            
            char letterGrade;
            if (average >= 90) {
                letterGrade = 'A';
            } else if (average >= 80) {
                letterGrade = 'B';
            } else if (average >= 70) {
                letterGrade = 'C';
            } else if (average >= 60) {
                letterGrade = 'D';
            } else {
                letterGrade = 'F';
            }
            
            System.out.printf("%s: Average = %.2f, Grade = %c%n", studentNames[i], average, letterGrade);
        }
        
        // Step 4: Output
        System.out.println("\nFormatted Table:");
        System.out.printf("%-15s", "Student Name");
        for (int j = 0; j < grades[0].length; j++) {
            System.out.printf("%10s%d", "Assignment", (j + 1));
        }
        System.out.printf("%15s%10s%n", "Average", "Grade");
        
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-15s", studentNames[i]);
            for (int j = 0; j < grades[i].length; j++) {
                System.out.printf("%10.2f", grades[i][j]);
            }
            char letterGrade;
            if (averages[i] >= 90) {
                letterGrade = 'A';
            } else if (averages[i] >= 80) {
                letterGrade = 'B';
            } else if (averages[i] >= 70) {
                letterGrade = 'C';
            } else if (averages[i] >= 60) {
                letterGrade = 'D';
            } else {
                letterGrade = 'F';
            }
            System.out.printf("%15.2f%10c%n", averages[i], letterGrade);
        }
        
        // Step 5: Array Manipulation
        // Find highest and lowest average scores
        double highest = averages[0];
        double lowest = averages[0];
        for (int i = 1; i < numStudents; i++) {
            if (averages[i] > highest) {
                highest = averages[i];
            }
            if (averages[i] < lowest) {
                lowest = averages[i];
            }
        }
        System.out.printf("%nHighest average score: %.2f%n", highest);
        System.out.printf("Lowest average score: %.2f%n", lowest);

        // Sort students by average score (bubble sort for simplicity)
        for (int i = 0; i < numStudents - 1; i++) {
            for (int j = 0; j < numStudents - i - 1; j++) {
                if (averages[j] < averages[j + 1]) {
                    // Swap averages
                    double tempAvg = averages[j];
                    averages[j] = averages[j + 1];
                    averages[j + 1] = tempAvg;
                    
                    // Swap student names
                    String tempName = studentNames[j];
                    studentNames[j] = studentNames[j + 1];
                    studentNames[j + 1] = tempName;
                    
                    // Swap grades array
                    double[] tempGrades = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = tempGrades;
                }
            }
        }

        // Display sorted student information
        System.out.println("\nStudents sorted by average score:");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%s: Average = %.2f%n", studentNames[i], averages[i]);
        }

        scanner.close();
    }
}
