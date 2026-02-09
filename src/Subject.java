/**
 * Subject class represents a single subject with its name and grade.
 * This demonstrates encapsulation and object-oriented design.
 */
public class Subject {
    // Private fields (encapsulation)
    private String name;
    private double grade;
    
    // Constructor
    public Subject(String name, double grade) {
        this.name = name;
        setGrade(grade); // Use setter for validation
    }
    
    // Getter for subject name
    public String getName() {
        return name;
    }
    
    // Setter for subject name
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter for grade
    public double getGrade() {
        return grade;
    }
    
    // Setter for grade with validation
    public void setGrade(double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("⚠️ Warning: Grade should be between 0 and 100. Setting to 0.");
            this.grade = 0;
        } else {
            this.grade = grade;
        }
    }
    
    // Method to get letter grade
    public String getLetterGrade() {
        return GradeCalculator.getLetterGrade(this.grade);
    }
    
    // Method to check if subject is passed
    public boolean isPassed() {
        return this.grade >= 60;
    }
    
    // Override toString for easy printing
    @Override
    public String toString() {
        return String.format("%-15s: %.1f (%s)", name, grade, getLetterGrade());
    }
}