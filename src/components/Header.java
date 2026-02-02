package components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

public class Header extends JPanel {

    public Header(JFrame frame, IconPanel iconPanel) {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(0, 50));
        add(new HeaderAddEmu(frame, iconPanel));

        HeaderButton backButton = new HeaderButton(frame, iconPanel);
        backButton.addActionListener(act -> {
            IconPanel.setExtension("");
            IconPanel.setPath("");
            iconPanel.refreshIcons();
        });
        add(backButton);
    }
}