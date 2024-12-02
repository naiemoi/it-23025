import java.util.Scanner;

public class StudentCGPACalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Student ID: ");
        String studentID = scanner.nextLine();

        System.out.print("No. of Courses: ");
        int numCourses = scanner.nextInt();

        int totalCredits = 0;
        int totalEarnedCredits = 0;
        double totalGradePoints = 0.0;

        for (int i = 1; i <= numCourses; i++) {
            System.out.println("C" + i + ":");

            System.out.print("  Credit (Max 3): ");
            int credit = scanner.nextInt();
            if (credit < 0 || credit > 3) {
                System.out.println("Invalid credit value. Please enter between 0 and 3.");
                return;
            }

            System.out.print("  CT (Max 30): ");
            int ct = scanner.nextInt();

            System.out.print("  AT (Max 10): ");
            int at = scanner.nextInt();

            System.out.print("  FE (Max 60): ");
            int fe = scanner.nextInt();

            if (ct < 0 || ct > 30 || at < 0 || at > 10 || fe < 0 || fe > 60) {
                System.out.println("Invalid score entered. Exiting program.");
                return;
            }

            totalCredits += credit;

            int totalMarks = ct + at + fe;
            double gradePoint = calculateGradePoint(totalMarks);
            totalGradePoints += gradePoint * credit;

            if (gradePoint > 0) {
                totalEarnedCredits += credit;
            }
        }
        double cgpa = totalGradePoints / totalCredits;
        String finalGrade = calculateGrade(cgpa);

      
        System.out.println("Student ID: " + studentID);
        System.out.println("Credit Taken: " + totalCredits);
        System.out.println("Credit Earned: " + totalEarnedCredits);
        System.out.printf("CGPA: %.2f%n", cgpa);
        System.out.println("Grade: " + finalGrade);

        scanner.close();
    }

    private static double calculateGradePoint(int totalMarks) {
        if (totalMarks >= 90) return 4.0;
        if (totalMarks >= 85) return 3.7;
        if (totalMarks >= 80) return 3.3;
        if (totalMarks >= 75) return 3.0;
        if (totalMarks >= 70) return 2.7;
        if (totalMarks >= 65) return 2.3;
        if (totalMarks >= 60) return 2.0;
        if (totalMarks >= 50) return 1.0;
        return 0.0;
    }

    private static String calculateGrade(double cgpa) {
        if (cgpa >= 3.7) return "A";
        if (cgpa >= 3.3) return "A-";
        if (cgpa >= 3.0) return "B+";
        if (cgpa >= 2.7) return "B";
        if (cgpa >= 2.3) return "B-";
        if (cgpa >= 2.0) return "C+";
        if (cgpa >= 1.0) return "C";
        return "F";
    }
}
