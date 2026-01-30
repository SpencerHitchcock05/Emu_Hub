import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import components.*;

/**
 * BasicSwingApp - A simple Java Swing application demonstrating core concepts
 * 
 * This application shows:
 * - JFrame (main window)
 * - JPanel (container for components)
 * - JButton, JLabel, JTextField (basic components)
 * - Event handling (responding to button clicks)
 * - Layout managers (organizing components)
 */
public class Main {
    
    // Instance variables for our GUI components
    private JFrame frame;
    private JPanel panel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JButton submitButton;
    private JLabel resultLabel;
    
    public Main() {
        createAndShowGUI();
    }
    
   
    private void createAndShowGUI() {
        // Create the main window (JFrame)
        frame = new JFrame("My First Swing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        
        // Create a panel to hold our components
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        Header header = new Header();
        panel.add(header, BorderLayout.NORTH);

        IconPanel iconPanel = new IconPanel();

        iconPanel.add(new AppIcon("iconPanel"));
        iconPanel.add(new AppIcon("iconPanel"));
        iconPanel.add(new AppIcon("iconPanel"));

        panel.add(iconPanel, BorderLayout.CENTER);

        // Add the panel to the frame
        frame.add(panel);
        
        // Center the window on screen
        frame.setLocationRelativeTo(null);
        
        // Make the window visible
        frame.setVisible(true);
    }
    
    /**
     * Handles the button click event
     */
    private void handleButtonClick() {
        String name = nameField.getText();
        
        if (name.trim().isEmpty()) {
            resultLabel.setText("Please enter a name!");
            resultLabel.setForeground(Color.RED);
        } else {
            resultLabel.setText("Hello, " + name + "!");
            resultLabel.setForeground(Color.BLUE);
        }
    }
    
    /**
     * Main method - entry point of the application
     */
    public static void main(String[] args) {
        // It's important to create and update Swing components on the Event Dispatch Thread (EDT)
        // This ensures thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
