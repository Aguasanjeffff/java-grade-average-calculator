import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main class - Entry point of the Student Grade Calculator application.
 * Handles user interaction and menu system.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Student> students = new ArrayList<>();
    
    public static void main(String[] args) {
        displayWelcome();
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice (1-5): ");
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    viewStudentReport();
                    break;
                case 4:
                    displayAbout();
                    break;
                case 5:
                    System.out.println("\n👋 Thank you for using Grade Calculator!");
                    System.out.println("Happy learning! 🚀");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please enter 1-5.");
            }
        }
        
        scanner.close();
    }
    
    // Display welcome message
    private static void displayWelcome() {
        System.out.println("=".repeat(60));
        System.out.println("📚 STUDENT GRADE CALCULATOR");
        System.out.println("=".repeat(60));
        System.out.println("Calculate student grades and generate reports");
        System.out.println("Built with Java - Mini System #2");
        System.out.println("=".repeat(60));
    }
    
    // Display main menu
    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("MAIN MENU");
        System.out.println("=".repeat(60));
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students (Summary)");
        System.out.println("3. View Student Grade Report");
        System.out.println("4. About");
        System.out.println("5. Exit");
        System.out.println("=".repeat(60));
    }
    
    // Add a new student
    private static void addStudent() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("➕ ADD NEW STUDENT");
        System.out.println("=".repeat(60));
        
        // Get student info
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        
        if (name.isEmpty()) {
            System.out.println("❌ Name cannot be empty!");
            return;
        }
        
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine().trim();
        
        if (studentId.isEmpty()) {
            System.out.println("❌ Student ID cannot be empty!");
            return;
        }
        
        // Get number of subjects
        int numSubjects = getIntInput("\nHow many subjects? ");
        
        if (numSubjects <= 0) {
            System.out.println("❌ Number of subjects must be positive!");
            return;
        }
        
        // Create array of subjects
        Subject[] subjects = new Subject[numSubjects];
        
        // Input each subject
        System.out.println();
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("--- Subject " + (i + 1) + " ---");
            
            System.out.print("Subject name: ");
            String subjectName = scanner.nextLine().trim();
            
            double grade = getDoubleInput("Subject grade (0-100): ");
            
            // Validate grade
            while (grade < 0 || grade > 100) {
                System.out.println("❌ Grade must be between 0 and 100!");
                grade = getDoubleInput("Subject grade (0-100): ");
            }
            
            subjects[i] = new Subject(subjectName, grade);
            System.out.println("✓ Subject added successfully!\n");
        }
        
        // Create student object
        Student student = new Student(name, studentId, subjects);
        students.add(student);
        
        System.out.println("✅ Student added successfully!");
        
        // Ask if user wants to see the report
        System.out.print("\nView grade report now? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        
        if (response.equals("y") || response.equals("yes")) {
            student.displayGradeReport();
        }
    }
    
    // View all students (summary)
    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("\n📝 No students in the system yet.");
            return;
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("📊 ALL STUDENTS SUMMARY");
        System.out.println("=".repeat(60));
        System.out.printf("%-20s | %-12s | %-7s | %-5s | %-6s%n",
            "Name", "Student ID", "Average", "Grade", "Status");
        System.out.println("-".repeat(60));
        
        for (Student student : students) {
            student.displaySummary();
        }
        
        System.out.println("=".repeat(60));
        System.out.printf("Total Students: %d%n", students.size());
    }
    
    // View detailed grade report for a specific student
    private static void viewStudentReport() {
        if (students.isEmpty()) {
            System.out.println("\n📝 No students in the system yet.");
            return;
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Select a student:");
        System.out.println("=".repeat(60));
        
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%d. %s (ID: %s)%n", 
                i + 1, 
                students.get(i).getName(), 
                students.get(i).getStudentId());
        }
        
        int choice = getIntInput("\nEnter student number: ");
        
        if (choice < 1 || choice > students.size()) {
            System.out.println("❌ Invalid student number!");
            return;
        }
        
        students.get(choice - 1).displayGradeReport();
    }
    
    // Display about information
    private static void displayAbout() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ℹ️ ABOUT");
        System.out.println("=".repeat(60));
        System.out.println("Student Grade Calculator v1.0");
        System.out.println("Built with Java - Object-Oriented Programming");
        System.out.println();
        System.out.println("Features:");
        System.out.println("  • Add multiple students and subjects");
        System.out.println("  • Automatic average calculation");
        System.out.println("  • Pass/Fail determination");
        System.out.println("  • Letter grade conversion (A-F)");
        System.out.println("  • Detailed grade reports");
        System.out.println("  • GPA calculation (4.0 scale)");
        System.out.println();
        System.out.println("Grading Scale:");
        System.out.println("  A: 90-100 (Excellent)");
        System.out.println("  B: 80-89  (Good)");
        System.out.println("  C: 70-79  (Fair)");
        System.out.println("  D: 60-69  (Poor)");
        System.out.println("  F: <60    (Fail)");
        System.out.println();
        System.out.println("Author: Aguasanjeffff");
        System.out.println("Mini System #2 of 10");
        System.out.println("=".repeat(60));
    }
    
    // Helper method to get integer input
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("❌ Invalid input! Please enter a number: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return value;
    }
    
    // Helper method to get double input
    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print("❌ Invalid input! Please enter a number: ");
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        return value;
    }
}