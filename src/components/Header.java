package components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class Header extends JPanel {

    public Header(JFrame frame, IconPanel iconPanel) {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setBackground(new Color(57, 212, 109));
        setPreferredSize(new Dimension(0, 60));
        add(new HeaderAddEmu(frame, iconPanel));
        setOpaque(true);

        HeaderButton backButton = new HeaderButton("<", "Back");
        backButton.setFont(new Font("Roboto", Font.PLAIN, 48));
        backButton.addActionListener(act -> {
            IconPanel.setExtension("");
            IconPanel.setPath("");
            iconPanel.refreshIcons();
        });
        add(backButton);
    }
}