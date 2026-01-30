package components;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppIcon extends JButton {
        
    public AppIcon(String name) {
        setToolTipText(name);
        setPreferredSize(new Dimension(80, 80));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        setBackground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            Color originalBorder = getBorder() != null ? Color.DARK_GRAY : Color.GRAY;
            
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(originalBorder, 2));
            }
        });

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                
                setBackground(new Color(230, 255, 230));
                Timer timer = new Timer(200, evt -> setBackground(Color.WHITE));
                timer.setRepeats(false);
                timer.start();
            }
        });
        
    }

}