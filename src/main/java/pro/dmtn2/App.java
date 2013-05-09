package pro.dmtn2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import javax.swing.SwingUtilities;
import pro.dmtn2.gui.GUI;
import pro.dmtn2.utilities.SettingsFinder;
import pro.dmtn2.utilities.TemperatureFinder;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws IOException, InterruptedException, InvocationTargetException, Exception {
        HashMap<String, String> settings = new HashMap<String, String>();
        SettingsFinder settingsFinder = new SettingsFinder();
        settings = settingsFinder.getSettings();
        GUI gui = new GUI(settings);
        SwingUtilities.invokeAndWait(gui);
        TemperatureFinder tempFinder = new TemperatureFinder(gui, settings.get("weatherlocation"));
        tempFinder.run();

    }
}
