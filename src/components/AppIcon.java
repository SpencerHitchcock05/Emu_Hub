package components;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class AppIcon extends JLayeredPane {

    private String name;
    private String extension;
    private String emuPath;
    protected JButton main;
    protected  JButton deleteButton;
        
    public AppIcon(String name, String extension, String emuPath) {
        this.name = name;
        this.extension = extension;
        this.emuPath = emuPath;

        main = new JButton();
        main.setToolTipText(name);
        main.setText(name);
        main.setBounds(0,0,80,80);
        main.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        main.setBackground(Color.WHITE);
        main.setCursor(new Cursor(Cursor.HAND_CURSOR));

        main.addMouseListener(new MouseAdapter() {
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

        deleteButton = new JButton("✕");
        deleteButton.setMargin(new Insets(0, 0, 0, 0));
        deleteButton.setFocusable(false);
        deleteButton.setBounds(50, 5, 25, 25);

        deleteButton.addActionListener(e -> {

            File inputFile = new File("Emulators.csv");
            List<String> lines = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",", -1);

                    // keep everything EXCEPT the one we want to delete
                    if (!(parts[0].equals(name) && parts[1].equals(extension) && parts[2].equals(emuPath))) {
                        lines.add(line);
                    }
                }
            } catch (IOException err) {
                err.printStackTrace();
            }

            // overwrite file
            try (PrintWriter pw = new PrintWriter(new FileWriter(inputFile))) {
                for (String l : lines) {
                    pw.println(l);
                }
            } catch (IOException err) {
                err.printStackTrace();
            }


            Container parent = this.getParent();
            parent.remove(this);
            parent.revalidate();
            parent.repaint();
        });


        setPreferredSize(new Dimension(80, 80));
        add(main, Integer.valueOf(0));
        add(deleteButton, Integer.valueOf(1));
    }

}