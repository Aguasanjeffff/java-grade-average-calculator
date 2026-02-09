import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Dialog for adding a new student
 */
public class AddStudentDialog extends JDialog {
    private JTextField nameField;
    private JTextField idField;
    private JSpinner subjectCountSpinner;
    private ArrayList<JTextField> subjectNameFields;
    private ArrayList<JSpinner> gradeSpinners;
    private Student student;
    private JPanel subjectsPanel;
    
    public AddStudentDialog(JFrame parent) {
        super(parent, "Add New Student", true);
        student = null;
        subjectNameFields = new ArrayList<>();
        gradeSpinners = new ArrayList<>();
        
        initializeUI();
    }
    
    private void initializeUI() {
        setSize(500, 600);
        setLocationRelativeTo(getParent());
        setLayout(new BorderLayout(10, 10));
        
        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Student info panel
        JPanel infoPanel = createInfoPanel();
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        
        // Subjects panel with scroll
        subjectsPanel = new JPanel();
        subjectsPanel.setLayout(new BoxLayout(subjectsPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(subjectsPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Subjects"));
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Student Information"));
        
        // Name
        panel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(nameField);
        
        // ID
        panel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        idField.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(idField);
        
        // Subject count
        panel.add(new JLabel("Number of Subjects:"));
        subjectCountSpinner = new JSpinner(new SpinnerNumberModel(3, 1, 15, 1));
        subjectCountSpinner.setFont(new Font("Arial", Font.PLAIN, 14));
        subjectCountSpinner.addChangeListener(e -> updateSubjectsPanel());
        panel.add(subjectCountSpinner);
        
        return panel;
    }
    
    private void updateSubjectsPanel() {
        subjectsPanel.removeAll();
        subjectNameFields.clear();
        gradeSpinners.clear();
        
        int count = (Integer) subjectCountSpinner.getValue();
        
        for (int i = 0; i < count; i++) {
            JPanel subjectPanel = new JPanel(new GridLayout(2, 2, 5, 5));
            subjectPanel.setBorder(BorderFactory.createTitledBorder("Subject " + (i + 1)));
            subjectPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
            
            // Subject name
            subjectPanel.add(new JLabel("Name:"));
            JTextField nameField = new JTextField();
            nameField.setFont(new Font("Arial", Font.PLAIN, 13));
            subjectNameFields.add(nameField);
            subjectPanel.add(nameField);
            
            // Grade
            subjectPanel.add(new JLabel("Grade (0-100):"));
            JSpinner gradeSpinner = new JSpinner(new SpinnerNumberModel(75.0, 0.0, 100.0, 0.5));
            gradeSpinner.setFont(new Font("Arial", Font.PLAIN, 13));
            gradeSpinners.add(gradeSpinner);
            subjectPanel.add(gradeSpinner);
            
            subjectsPanel.add(subjectPanel);
            subjectsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        
        subjectsPanel.revalidate();
        subjectsPanel.repaint();
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        
        JButton saveButton = new JButton("💾 Save");
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
        saveButton.setBackground(new Color(40, 167, 69));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveButton.addActionListener(e -> saveStudent());
        
        JButton cancelButton = new JButton("✗ Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton.setBackground(new Color(108, 117, 125));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelButton.addActionListener(e -> dispose());
        
        panel.add(saveButton);
        panel.add(cancelButton);
        
        return panel;
    }
    
    private void saveStudent() {
        // Validate input
        String name = nameField.getText().trim();
        String id = idField.getText().trim();
        
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter student name", 
                "Validation Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter student ID", 
                "Validation Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Create subjects array
        Subject[] subjects = new Subject[subjectNameFields.size()];
        for (int i = 0; i < subjects.length; i++) {
            String subjectName = subjectNameFields.get(i).getText().trim();
            if (subjectName.isEmpty()) {
                subjectName = "Subject " + (i + 1);
            }
            double grade = (Double) gradeSpinners.get(i).getValue();
            subjects[i] = new Subject(subjectName, grade);
        }
        
        // Create student
        student = new Student(name, id, subjects);
        dispose();
    }
    
    public Student getStudent() {
        return student;
    }
}