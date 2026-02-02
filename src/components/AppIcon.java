package components;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppIcon extends JButton {

    private String name;
    private String extension;
    private String emuPath;
        
    public AppIcon(String name, String extension, String emuPath) {
        this.name = name;
        this.extension = extension;
        this.emuPath = emuPath;

        setToolTipText(name);
        setText(name);
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
    }

}