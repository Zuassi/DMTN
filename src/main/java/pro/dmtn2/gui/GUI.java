/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.dmtn2.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import pro.dmtn2.utilities.SettingsFinder;
import pro.dmtn2.utilities.TemperatureFinder;

/**
 *
 * @author Lalli
 */
public class GUI implements Runnable {

    JWindow gui;
    ImageIcon mouthClosed;
    ImageIcon mouthOpened;
    JLabel icon = new JLabel();
    JLabel temp = new JLabel();
    UploadListener uploadListener = new UploadListener(this);
    HashMap<String,String> settings = new HashMap<String,String>();
        

    public GUI(HashMap<String,String> settings) throws IOException, Exception {
        this.settings = settings;
        File file = new File("osat/laku.png");
        mouthClosed = new ImageIcon(ImageIO.read(file));
        File file2 = new File("osat/laku2.png");
        mouthOpened = new ImageIcon(ImageIO.read(file2));
        
    }

    public void run() {
        
        gui = new JWindow();
        gui.setPreferredSize(new Dimension(650, 380));
        gui.setVisible(true);
        gui.setBackground(new Color(0, 0, 0, 0));
        addComponents(gui.getContentPane());
        int widgetX = Integer.parseInt(settings.get("widgetX"));
        int widgetY = Integer.parseInt(settings.get("widgetY"));
        gui.setBounds(widgetX,widgetY,0,0);
        gui.pack();
    }

    private void addComponents(Container contentPane) {
        contentPane.setLayout(new FlowLayout());
        temp.setFont(new Font(settings.get("font"), Font.PLAIN, Integer.parseInt(settings.get("fontsize"))));
        String[] colors = settings.get("fontcolor").split(",");  //color is xxx,xxx,xxx,xxx
        int c1 = Integer.parseInt(colors[0]);
        int c2 = Integer.parseInt(colors[1]);
        int c3 = Integer.parseInt(colors[2]);
        int c4 = Integer.parseInt(colors[3]);
        temp.setForeground(new Color(c1,c2,c3,c4));
         DragAndDropListener listener= new DragAndDropListener(this);
         DropTarget pudotus = new DropTarget(icon, listener);
        icon.setIcon(mouthClosed);
        icon.addMouseListener(uploadListener);
        contentPane.add(temp);
        contentPane.add(icon);
    }

    public void changeText(String text) {
        temp.setText(text);
    }

    public void openMouth() {
        icon.setIcon(mouthOpened);
    }
    
     public void closeMouth() {
        icon.setIcon(mouthClosed);
    }
}
