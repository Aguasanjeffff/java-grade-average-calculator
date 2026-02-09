/**
 * GradeCalculator class handles all calculation logic.
 * This demonstrates the Single Responsibility Principle.
 */
public class GradeCalculator {
    
    // Calculate average from array of subjects
    public static double calculateAverage(Subject[] subjects) {
        if (subjects == null || subjects.length == 0) {
            return 0.0;
        }
        
        double sum = 0;
        for (Subject subject : subjects) {
            sum += subject.getGrade();
        }
        
        return sum / subjects.length;
    }
    
    // Convert numeric grade to letter grade
    public static String getLetterGrade(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    // Get grade classification
    public static String getClassification(double average) {
        if (average >= 90) {
            return "Excellent";
        } else if (average >= 80) {
            return "Good";
        } else if (average >= 70) {
            return "Fair";
        } else if (average >= 60) {
            return "Poor";
        } else {
            return "Failed";
        }
    }
    
    // Check if student passed (average >= 60)
    public static boolean isPassed(double average) {
        return average >= 60;
    }
    
    // Calculate GPA (4.0 scale)
    public static double calculateGPA(double average) {
        if (average >= 90) {
            return 4.0;
        } else if (average >= 80) {
            return 3.0;
        } else if (average >= 70) {
            return 2.0;
        } else if (average >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
    
    // Get number of passed subjects
    public static int countPassedSubjects(Subject[] subjects) {
        int count = 0;
        for (Subject subject : subjects) {
            if (subject.isPassed()) {
                count++;
            }
        }
        return count;
    }
    
    // Get highest grade
    public static double getHighestGrade(Subject[] subjects) {
        double highest = 0;
        for (Subject subject : subjects) {
            if (subject.getGrade() > highest) {
                highest = subject.getGrade();
            }
        }
        return highest;
    }
    
    // Get lowest grade
    public static double getLowestGrade(Subject[] subjects) {
        double lowest = 100;
        for (Subject subject : subjects) {
            if (subject.getGrade() < lowest) {
                lowest = subject.getGrade();
            }
        }
        return lowest;
    }
}