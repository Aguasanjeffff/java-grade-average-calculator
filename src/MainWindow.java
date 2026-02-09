import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Main Window for the Grade Calculator GUI
 */
public class MainWindow extends JFrame {
    private ArrayList<Student> students;
    private DefaultTableModel tableModel;
    private JTable studentsTable;
    private JTextArea reportArea;
    
    public MainWindow() {
        students = new ArrayList<>();
        initializeUI();
    }
    
    private void initializeUI() {
        setTitle("📚 Student Grade Calculator");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create main panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(240, 240, 245));
        
        // Header Panel
        JPanel headerPanel = createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Center Panel (Split: Table + Report)
        JSplitPane splitPane = createCenterPanel();
        mainPanel.add(splitPane, BorderLayout.CENTER);
        
        // Button Panel
        JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        setVisible(true);
    }
    
    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(70, 130, 180));
        panel.setPreferredSize(new Dimension(0, 80));
        panel.setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel("📚 Student Grade Calculator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        
        JLabel subtitleLabel = new JLabel("Track student grades and generate reports", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(230, 230, 230));
        
        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setOpaque(false);
        textPanel.add(titleLabel);
        textPanel.add(subtitleLabel);
        
        panel.add(textPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JSplitPane createCenterPanel() {
        // Left: Students Table
        JPanel tablePanel = new JPanel(new BorderLayout(5, 5));
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createTitledBorder("Students List"));
        
        String[] columnNames = {"Name", "Student ID", "Subjects", "Average", "Grade", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        studentsTable = new JTable(tableModel);
        studentsTable.setRowHeight(30);
        studentsTable.setFont(new Font("Arial", Font.PLAIN, 13));
        studentsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        studentsTable.getTableHeader().setBackground(new Color(70, 130, 180));
        studentsTable.getTableHeader().setForeground(Color.WHITE);
        studentsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Add selection listener
        studentsTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && studentsTable.getSelectedRow() != -1) {
                showStudentReport(studentsTable.getSelectedRow());
            }
        });
        
        JScrollPane tableScrollPane = new JScrollPane(studentsTable);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);
        
        // Right: Report Area
        JPanel reportPanel = new JPanel(new BorderLayout(5, 5));
        reportPanel.setBackground(Color.WHITE);
        reportPanel.setBorder(BorderFactory.createTitledBorder("Grade Report"));
        
        reportArea = new JTextArea();
        reportArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        reportArea.setEditable(false);
        reportArea.setMargin(new Insets(10, 10, 10, 10));
        reportArea.setText("Select a student to view detailed report");
        
        JScrollPane reportScrollPane = new JScrollPane(reportArea);
        reportPanel.add(reportScrollPane, BorderLayout.CENTER);
        
        // Split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tablePanel, reportPanel);
        splitPane.setDividerLocation(500);
        splitPane.setResizeWeight(0.5);
        
        return splitPane;
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(new Color(240, 240, 245));
        
        JButton addButton = createStyledButton("➕ Add Student", new Color(40, 167, 69));
        JButton deleteButton = createStyledButton("🗑️ Delete Student", new Color(220, 53, 69));
        JButton refreshButton = createStyledButton("🔄 Refresh", new Color(70, 130, 180));
        JButton aboutButton = createStyledButton("ℹ️ About", new Color(108, 117, 125));
        
        addButton.addActionListener(e -> addStudent());
        deleteButton.addActionListener(e -> deleteStudent());
        refreshButton.addActionListener(e -> refreshTable());
        aboutButton.addActionListener(e -> showAbout());
        
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(refreshButton);
        panel.add(aboutButton);
        
        return panel;
    }
    
    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(180, 40));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
        
        return button;
    }
    
    private void addStudent() {
        AddStudentDialog dialog = new AddStudentDialog(this);
        dialog.setVisible(true);
        
        Student newStudent = dialog.getStudent();
        if (newStudent != null) {
            students.add(newStudent);
            addStudentToTable(newStudent);
            JOptionPane.showMessageDialog(this, 
                "✅ Student added successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void addStudentToTable(Student student) {
        Object[] row = {
            student.getName(),
            student.getStudentId(),
            student.getSubjects().length,
            String.format("%.2f", student.getAverage()),
            student.getLetterGrade(),
            student.isPassed() ? "✓ PASS" : "✗ FAIL"
        };
        tableModel.addRow(row);
    }
    
    private void deleteStudent() {
        int selectedRow = studentsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select a student to delete", 
                "No Selection", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this student?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            students.remove(selectedRow);
            tableModel.removeRow(selectedRow);
            reportArea.setText("Select a student to view detailed report");
            JOptionPane.showMessageDialog(this, 
                "🗑️ Student deleted successfully!", 
                "Deleted", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Student student : students) {
            addStudentToTable(student);
        }
        JOptionPane.showMessageDialog(this, 
            "🔄 Table refreshed!", 
            "Refreshed", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showStudentReport(int index) {
        if (index < 0 || index >= students.size()) return;
        
        Student student = students.get(index);
        StringBuilder report = new StringBuilder();
        
        report.append("═══════════════════════════════════════════════════\n");
        report.append("              📊 GRADE REPORT\n");
        report.append("═══════════════════════════════════════════════════\n\n");
        report.append(String.format("Student: %s\n", student.getName()));
        report.append(String.format("ID: %s\n\n", student.getStudentId()));
        report.append("───────────────────────────────────────────────────\n");
        report.append("SUBJECTS:\n");
        report.append("───────────────────────────────────────────────────\n");
        
        for (Subject subject : student.getSubjects()) {
            report.append(String.format("%-20s : %.1f (%s)\n", 
                subject.getName(), 
                subject.getGrade(), 
                subject.getLetterGrade()));
        }
        
        report.append("───────────────────────────────────────────────────\n");
        report.append(String.format("Average         : %.2f\n", student.getAverage()));
        report.append(String.format("Letter Grade    : %s\n", student.getLetterGrade()));
        report.append(String.format("GPA (4.0 scale) : %.1f\n", student.getGPA()));
        report.append(String.format("Status          : %s\n", 
            student.isPassed() ? "✓ PASSED" : "✗ FAILED"));
        report.append(String.format("Classification  : %s\n", student.getClassification()));
        report.append("───────────────────────────────────────────────────\n");
        report.append(String.format("Highest Grade   : %.1f\n", 
            GradeCalculator.getHighestGrade(student.getSubjects())));
        report.append(String.format("Lowest Grade    : %.1f\n", 
            GradeCalculator.getLowestGrade(student.getSubjects())));
        report.append(String.format("Passed Subjects : %d/%d\n", 
            GradeCalculator.countPassedSubjects(student.getSubjects()),
            student.getSubjects().length));
        report.append("═══════════════════════════════════════════════════\n");
        
        reportArea.setText(report.toString());
    }
    
    private void showAbout() {
        String message = "📚 Student Grade Calculator v2.0\n\n" +
                        "GUI Version with Swing\n" +
                        "Built with Java - Object-Oriented Programming\n\n" +
                        "Features:\n" +
                        "• Add/Delete students\n" +
                        "• Automatic grade calculation\n" +
                        "• Pass/Fail determination\n" +
                        "• Detailed grade reports\n" +
                        "• Modern GUI interface\n\n" +
                        "Author: Aguasanjeffff\n" +
                        "Mini System #2 of 10";
        
        JOptionPane.showMessageDialog(this, message, "About", JOptionPane.INFORMATION_MESSAGE);
    }
}