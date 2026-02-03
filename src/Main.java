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
        frame.getRootPane().setBorder(
            BorderFactory.createEmptyBorder()
        );
        frame.setBackground(new Color(57, 212, 109));
        frame.getContentPane().setBackground(new Color(57, 212, 109));
        
        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(57, 212, 109));


        IconPanel iconPanel = new IconPanel();
        Header header = new Header(frame, iconPanel);
        panel.add(header, BorderLayout.NORTH);
        panel.add(iconPanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.setLocationRelativeTo(null);        
        frame.setVisible(true);
    }
    

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName()
        );
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
