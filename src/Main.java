import javax.swing.*;
import java.awt.*;
import components.*;


public class Main {
    
    private JFrame frame;
    private JPanel panel;
    
    public Main() {
        createAndShowGUI();
    }
    
   
    private void createAndShowGUI() {
        frame = new JFrame("My First Swing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());


        IconPanel iconPanel = new IconPanel();
        Header header = new Header(frame, iconPanel);
        panel.add(header, BorderLayout.NORTH);
        panel.add(iconPanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.setLocationRelativeTo(null);        
        frame.setVisible(true);
    }
    

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
