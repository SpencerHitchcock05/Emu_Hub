import javax.swing.*;
import java.awt.*;
import components.*;
import java.io.File;
import java.net.URL;

public class Main {
    
    private JFrame frame;
    private JPanel panel;
    
    public Main() {
        createAndShowGUI();
    }
    
   
    private void createAndShowGUI() {
        
        
        frame = new JFrame("Emu Hub");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.getRootPane().setBorder(
            BorderFactory.createEmptyBorder()
        );
        frame.setBackground(new Color(57, 212, 109));
        frame.getContentPane().setBackground(new Color(57, 212, 109));
        URL iconURL = Main.class.getResource("/resources/emu_icon.png");
        if (iconURL != null) {
            frame.setIconImage(new ImageIcon(iconURL).getImage());
        }
        

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
