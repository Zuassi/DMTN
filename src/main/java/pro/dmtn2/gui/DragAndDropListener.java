/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.dmtn2.gui;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pro.dmtn2.utilities.FileSender;

class DragAndDropListener implements DropTargetListener {

    private GUI gui;
    private FileSender fileSender;

    public DragAndDropListener(GUI gui) {
        this.gui = gui;
        fileSender = new FileSender(gui);
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {

        this.gui.openMouth();

    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        this.gui.closeMouth();
    }

    @Override
    public void drop(DropTargetDropEvent event) {
        try {
            event.acceptDrop(DnDConstants.ACTION_COPY);
            Transferable transferable = event.getTransferable();
            List<File> pudotetut = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
            fileSender.setFileList(pudotetut);
            fileSender.doInBackground();
        } catch (Exception ex) {
            Logger.getLogger(DragAndDropListener.class.getName()).log(Level.SEVERE, null, ex);
        }



    }
}