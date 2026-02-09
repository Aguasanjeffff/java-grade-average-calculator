# 📚 Java Student Grade Calculator

A feature-rich student grade calculator built with Java, featuring both **Console (CLI)** and **GUI (Swing)** interfaces to demonstrate Object-Oriented Programming concepts.

## ✨ Features

### Console Version
- ✅ Add multiple students
- ✅ Input multiple subjects per student
- ✅ Automatic GPA calculation
- ✅ Pass/Fail determination
- ✅ Detailed grade reports

### GUI Version (NEW!)
- ✅ **Modern Swing interface**
- ✅ **Interactive table view** of all students
- ✅ **Real-time grade reports**
- ✅ **Add/Delete students** with dialogs
- ✅ **Color-coded status** (Pass/Fail)
- ✅ **Split-pane view** for easy navigation
- ✅ **Beautiful UI** with hover effects

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

### GUI Version (Recommended)

```bash
# Compile
javac src/*.java

# Run
java -cp src MainGUI
```

### Console Version

```bash
# Compile
javac src/*.java

# Run
java -cp src Main
```

### Using VS Code

#### GUI Version:
1. Open `src/MainGUI.java`
2. Click **"Run"** above the `main` method

#### Console Version:
1. Open `src/Main.java`
2. Click **"Run"** above the `main` method

## 📂 Project Structure

```
src/
├── Main.java                # Console entry point
├── MainGUI.java            # GUI entry point (NEW)
├── MainWindow.java         # Main GUI window (NEW)
├── AddStudentDialog.java   # Add student dialog (NEW)
├── Student.java            # Student entity class
├── Subject.java            # Subject entity class
└── GradeCalculator.java    # Calculator logic class
```

## 🎓 Learning Objectives

### Classes & Objects (OOP)
- `Student` class - represents a student entity
- `Subject` class - represents a subject entity
- `GradeCalculator` class - handles calculations
- `MainWindow` class - GUI main window
- `AddStudentDialog` class - dialog for adding students

### Methods
- Constructor methods
- Getter/Setter methods
- Static methods
- Event handler methods (GUI)

### Arrays
- `Subject[]` - array of objects
- Array iteration and manipulation

### GUI Programming (NEW)
- **Swing components**: JFrame, JPanel, JTable, JDialog
- **Layout managers**: BorderLayout, GridLayout, BoxLayout
- **Event handling**: ActionListeners, MouseListeners
- **Custom UI**: Styled buttons, colors, fonts

### Java Concepts
- Encapsulation
- Scanner for input (Console)
- ArrayList for dynamic lists
- String formatting
- Exception handling

## 🎨 GUI Features

| Component | Description |
|-----------|-------------|
| **Header** | Branded title with gradient background |
| **Students Table** | View all students at a glance |
| **Report Panel** | Detailed grade report for selected student |
| **Add Button** | Opens dialog to add new student |
| **Delete Button** | Remove selected student |
| **Refresh Button** | Refresh the table view |
| **About Button** | Show app information |

## 🔧 Requirements

- **Java 8 or higher**
- **No external dependencies** (uses built-in Swing)

## 📖 Usage Examples

### GUI Version

1. **Launch the application**: Run `MainGUI.java`
2. **Add a student**: Click "➕ Add Student"
3. **Fill in details**: Name, ID, and subjects with grades
4. **View report**: Click on any student in the table
5. **Delete student**: Select and click "🗑️ Delete Student"

### Console Version

1. **Launch**: Run `Main.java`
2. **Follow menu**: Select options 1-5
3. **Add students**: Enter details when prompted
4. **View reports**: Choose from menu options

## 🚀 Future Enhancements

- [ ] Save/Load data to files
- [ ] Edit student information
- [ ] Search/Filter students
- [ ] Export reports to PDF
- [ ] Charts and graphs
- [ ] Dark mode toggle
- [ ] Database integration

## 📝 License

MIT License - Feel free to use for learning!

## 👨‍💻 Author

**Aguasanjeffff** - 2nd of 10 Mini Systems 🎯

---

**Version 2.0** - Now with GUI! 🎨✨
```