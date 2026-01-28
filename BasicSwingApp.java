import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
public class BasicSwingApp {
    
    // Instance variables for our GUI components
    private JFrame frame;
    private JPanel panel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JButton submitButton;
    private JLabel resultLabel;
    
    /**
     * Constructor - sets up the GUI
     */
    public BasicSwingApp() {
        createAndShowGUI();
    }
    
    /**
     * Creates and displays the GUI
     */
    private void createAndShowGUI() {
        // Create the main window (JFrame)
        frame = new JFrame("My First Swing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        // Create a panel to hold our components
        panel = new JPanel();
        panel.setLayout(new FlowLayout()); // FlowLayout arranges components left-to-right
        
        // Create a label
        nameLabel = new JLabel("Enter your name:");
        panel.add(nameLabel);
        
        // Create a text field
        nameField = new JTextField(20); // 20 columns wide
        panel.add(nameField);
        
        // Create a button
        submitButton = new JButton("Submit");
        panel.add(submitButton);
        
        // Create a result label (initially empty)
        resultLabel = new JLabel("");
        resultLabel.setForeground(Color.BLUE);
        panel.add(resultLabel);
        
        // Add event listener to the button
        // This is called when the button is clicked
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick();
            }
        });
        
        // You can also listen for Enter key in the text field
        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick();
            }
        });
        
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
                new BasicSwingApp();
            }
        });
    }
}
