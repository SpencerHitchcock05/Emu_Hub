package components;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.*;
import java.nio.file.*;
import javax.swing.*;

public class IconPanel extends JPanel {
    
    private static String Extension = "";
    private static String EmuPath = "";

    public IconPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 16, 16));
        setBackground(new Color(24, 240, 96));
        setOpaque(true);
        refreshIcons();
    }    

    public void refreshIcons() {
        removeAll();

        if (Extension.equals("")) {
            try {
                Path emulatorsPath = Paths.get(System.getProperty("user.home"), "\\EmuHubGames\\Emulators\\Emulators.csv");
                Files.createDirectories(emulatorsPath.getParent());
                if (Files.notExists(emulatorsPath)) {
                    Files.createFile(emulatorsPath);
                }
                BufferedReader br = new BufferedReader(new FileReader(emulatorsPath.toFile()));
                String line;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    add(new EmuIcon(this, parts[0], parts[1], parts[2]));
                }
            } catch (IOException err) {
                err.printStackTrace();
            }
        } else {
            try {

                String[] extensionsList = Extension.split("\\|");

                File dir = new File(System.getProperty("user.home"), "EmuHubGames");

                for (int i = 0; i < extensionsList.length; i++) {       

                    final int index = i;      
                    String[] files = dir.list((d, name) -> name.toLowerCase().endsWith(extensionsList[index]));

                    if (files != null) {
                        for (String name : files) {
                            add(new GameIcon(name));
                        }
                    }
                }
                
            } catch (Exception err) {
                err.printStackTrace();
            }
            
        }
        revalidate();
        repaint();
    }

    public static String getExtension() {
        return Extension;
    }

    public static void setExtension(String newExtension) {
        Extension = newExtension;
    }

    public static String getPath() {
        return EmuPath;
    }

    public static void setPath(String newPath) {
        EmuPath = newPath;
    }
}