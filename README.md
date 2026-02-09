# 📚 Java Student Grade Calculator

A console-based student grade calculator built with Java to demonstrate **Object-Oriented Programming (OOP)** concepts including classes, objects, methods, and arrays.

## ✨ Features

- ✅ Add multiple students
- ✅ Input multiple subjects per student
- ✅ Input grades for each subject
- ✅ Automatic GPA calculation
- ✅ Pass/Fail determination
- ✅ Grade classification (Excellent, Good, Fair, Poor)
- ✅ Display detailed grade reports
- ✅ Support for multiple grading scales

## 🎯 Grading System

### Grade Scale
- **A**: 90-100 (Excellent)
- **B**: 80-89 (Good)
- **C**: 70-79 (Fair)
- **D**: 60-69 (Poor)
- **F**: Below 60 (Fail)

### Pass/Fail Criteria
- **Pass**: Average ≥ 60
- **Fail**: Average < 60

## 🚀 How to Run

### Using Command Line

1. **Compile all Java files:**
```bash
javac src/*.java
```

2. **Run the program:**
```bash
java -cp src Main
```

### Using VS Code

1. **Install Java Extension Pack** (if not installed)
2. **Open the project folder**
3. **Press F5** or click **"Run"** above the `main` method in `Main.java`

### Using Command Prompt (Windows)

```cmd
cd java-grade-average-calculator
javac src\*.java
java -cp src Main
```

## 📖 Usage Examples

### Example 1: Single Student
```
Enter student name: Juan Dela Cruz
Enter student ID: 2024001

How many subjects? 3

Subject 1 name: Mathematics
Subject 1 grade: 95

Subject 2 name: Science
Subject 2 grade: 88

Subject 3 name: English
Subject 3 grade: 92

===== GRADE REPORT =====
Student: Juan Dela Cruz (ID: 2024001)
----------------------------------
Mathematics    : 95.0 (A)
Science        : 88.0 (B)
English        : 92.0 (A)
----------------------------------
Average        : 91.67
Letter Grade   : A
Status         : PASSED ✓
Classification : Excellent
```

### Example 2: Multiple Students
See `docs/usage-examples.md` for more examples.

## 🎓 Learning Objectives

This project teaches:

### 1. **Classes & Objects (OOP)**
- `Student` class - represents a student entity
- `Subject` class - represents a subject entity
- `GradeCalculator` class - handles calculations

### 2. **Methods**
- Constructor methods
- Getter/Setter methods
- Calculation methods
- Display methods

### 3. **Arrays**
- Array of objects (`Subject[]`)
- Array iteration
- Dynamic array sizing

### 4. **Java Concepts**
- Scanner for input
- String formatting
- Conditionals (if-else)
- Loops (for, while)
- Exception handling

## 📂 Project Structure

```
src/
├── Main.java              # Entry point, user interface
├── Student.java           # Student entity class
├── Subject.java           # Subject entity class
└── GradeCalculator.java   # Calculator logic class
```

## 🔧 Class Descriptions

### **Student.java**
Represents a student with:
- Name, ID, subjects array
- Methods: calculate average, get grade, pass/fail status

### **Subject.java**
Represents a subject with:
- Subject name and grade
- Methods: get letter grade, validation

### **GradeCalculator.java**
Handles:
- Grade calculations
- Letter grade conversion
- Classification determination

### **Main.java**
- User interface
- Input handling
- Menu system

## 🎨 Features Breakdown

| Feature | Description |
|---------|-------------|
| **Multiple Students** | Add and track multiple students |
| **Multiple Subjects** | Each student can have any number of subjects |
| **Auto Calculate** | Automatically calculates average GPA |
| **Letter Grades** | Converts numeric grades to letter grades |
| **Pass/Fail** | Determines if student passed or failed |
| **Grade Report** | Beautiful formatted output |
| **Input Validation** | Validates grade ranges (0-100) |

## 🚀 Future Enhancements

- [ ] Save/Load data from files
- [ ] Edit student information
- [ ] Delete students
- [ ] Search functionality
- [ ] Export to CSV
- [ ] GUI version with JavaFX
- [ ] Weighted grades
- [ ] Semester-based tracking

## 🐛 Error Handling

The program handles:
- Invalid numeric input
- Out-of-range grades (< 0 or > 100)
- Empty student names
- Invalid menu choices

## 📝 License

MIT License - Feel free to use for learning!

## 👨‍💻 Author

**Aguasanjeffff** - 2nd of 10 Mini Systems 🎯

---

**Happy Coding! 📚✨**
```