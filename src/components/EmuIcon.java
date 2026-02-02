package components;
import java.awt.event.*;

public class EmuIcon extends AppIcon {


    public EmuIcon(IconPanel parent, String name, String extension, String emuPath) {
        super(name, extension, emuPath);
        
        main.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                
                IconPanel.setExtension(extension);
                IconPanel.setPath(emuPath);
                parent.refreshIcons();
            }
        });
    }
}

        