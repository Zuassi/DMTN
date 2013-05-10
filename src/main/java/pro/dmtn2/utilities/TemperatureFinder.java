/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.dmtn2.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pro.dmtn2.gui.GUI;

/**
 *
 * @author Lalli
 */
public class TemperatureFinder extends Thread {

    private GUI gui;
    private String location;

    public TemperatureFinder(GUI gui, String location) {
        this.gui = gui;
        this.location = location;
    }

    private String findTemperature(String location) throws MalformedURLException, IOException {
        URL url = new URL("http://ilmatieteenlaitos.fi/saa/" + location);
        Scanner lukija = new Scanner(url.openStream());
        String rivi = "";

        while (lukija.hasNext()) {
            rivi = lukija.nextLine();
            if (rivi.contains("L&auml;mp&ouml;tila</span> <span class=\"parameter-value\">")) {
                break;
            }
        }
        String[] katko1 = rivi.split("L&auml;mp&ouml;tila</span> <span class=\"parameter-value\">");
        String[] katko2 = katko1[1].split("&");
        return katko2[0];
    }

    public void run() {
        while (true) {
            try {
               
                gui.changeText(findTemperature(location));
              
                try {
                    this.sleep(300000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TemperatureFinder.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(TemperatureFinder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TemperatureFinder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
