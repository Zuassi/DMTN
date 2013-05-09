/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.dmtn2.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pro.dmtn2.utilities.FileSender;

/**
 *
 * @author Lalli
 */
class UploadListener implements MouseListener {

    GUI gui;
    FileSender sender;

    public UploadListener(GUI gui) {
        this.gui = gui;
        sender =  new FileSender(gui);
    }

    public void mouseClicked(MouseEvent e) {
        
        try {        
            sender.doInBackground();
        } catch (Exception ex) {
            Logger.getLogger(UploadListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mousePressed(MouseEvent e) {
   gui.openMouth();

    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
