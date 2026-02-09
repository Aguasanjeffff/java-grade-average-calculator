import javax.swing.*;

/**
 * GUI Entry point for the Student Grade Calculator
 * Uses Java Swing for the interface
 */
public class MainGUI {
    public static void main(String[] args) {
        // Set system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Run GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new MainWindow();
        });
    }
}