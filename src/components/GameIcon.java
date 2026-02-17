package components;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class GameIcon extends AppIcon {

    public GameIcon(String name) {
        super(name, IconPanel.getExtension(), IconPanel.getPath());
        
        main.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {  
                    File curDir = new File(System.getProperty("user.home"), "EmuHubGames\\" + name); 
                    ProcessBuilder pb = new ProcessBuilder(IconPanel.getPath() , curDir.getAbsolutePath());
                    pb.directory(new File(IconPanel.getPath()).getParentFile());
                    pb.start();
                } catch(IOException err) {
                    err.printStackTrace();
                }
            }
        });
    }
    
}

        