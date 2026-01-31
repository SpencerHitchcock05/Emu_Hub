package components;
import java.awt.FlowLayout;
import java.io.*;
import javax.swing.*;

public class IconPanel extends JPanel {
    
    public IconPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 16, 16));
        refreshIcons();
    }    

    public void refreshIcons() {
        removeAll();
        try (BufferedReader br = new BufferedReader(new FileReader("Emulators.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                add(new AppIcon(parts[0]));
            }
        } catch (IOException err) {
            err.printStackTrace();
        }

        revalidate();
        repaint();
    }
}