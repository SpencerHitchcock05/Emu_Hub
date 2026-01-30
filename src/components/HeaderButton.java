package components;
import java.awt.*;
import javax.swing.*;

public class HeaderButton extends JButton {

    public HeaderButton() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(30, 30));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}