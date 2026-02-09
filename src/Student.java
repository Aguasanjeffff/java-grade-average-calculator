/**
 * Student class represents a student with multiple subjects.
 * This demonstrates composition (Student HAS-A Subject).
 */
public class Student {
    // Private fields
    private String name;
    private String studentId;
    private Subject[] subjects;
    
    // Constructor
    public Student(String name, String studentId, Subject[] subjects) {
        this.name = name;
        this.studentId = studentId;
        this.subjects = subjects;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public Subject[] getSubjects() {
        return subjects;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }
    
    // Calculate average grade
    public double getAverage() {
        return GradeCalculator.calculateAverage(subjects);
    }
    
    // Get letter grade based on average
    public String getLetterGrade() {
        return GradeCalculator.getLetterGrade(getAverage());
    }
    
    // Check if student passed
    public boolean isPassed() {
        return GradeCalculator.isPassed(getAverage());
    }
    
    // Get classification
    public String getClassification() {
        return GradeCalculator.getClassification(getAverage());
    }
    
    // Get GPA
    public double getGPA() {
        return GradeCalculator.calculateGPA(getAverage());
    }
    
    // Display grade report
    public void displayGradeReport() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📊 GRADE REPORT");
        System.out.println("=".repeat(50));
        System.out.printf("Student: %s (ID: %s)%n", name, studentId);
        System.out.println("-".repeat(50));
        
        // Display all subjects
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
        
        System.out.println("-".repeat(50));
        
        // Display statistics
        System.out.printf("Average        : %.2f%n", getAverage());
        System.out.printf("Letter Grade   : %s%n", getLetterGrade());
        System.out.printf("GPA (4.0 scale): %.1f%n", getGPA());
        System.out.printf("Status         : %s %s%n", 
            isPassed() ? "PASSED ✓" : "FAILED ✗",
            isPassed() ? "" : "(Average below 60)");
        System.out.printf("Classification : %s%n", getClassification());
        
        // Additional stats
        System.out.println("-".repeat(50));
        System.out.printf("Highest Grade  : %.1f%n", 
            GradeCalculator.getHighestGrade(subjects));
        System.out.printf("Lowest Grade   : %.1f%n", 
            GradeCalculator.getLowestGrade(subjects));
        System.out.printf("Passed Subjects: %d/%d%n", 
            GradeCalculator.countPassedSubjects(subjects), subjects.length);
        System.out.println("=".repeat(50));
    }
    
    // Display summary (for multiple students)
    public void displaySummary() {
        System.out.printf("%-20s | %-12s | %.2f | %s | %s%n",
            name, studentId, getAverage(), getLetterGrade(),
            isPassed() ? "PASS" : "FAIL");
    }
}