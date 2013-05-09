/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.dmtn2.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Lalli
 */
public class SettingsFinder {

    HashMap<String, String> settings = new HashMap<String, String>();
    File asetuksetFile = new File("asetukset.txt");

    public HashMap<String, String> getSettings() throws FileNotFoundException {
        Scanner scanner = new Scanner(asetuksetFile, "UTF-8");

       
        while (scanner.hasNext()) {
            String asetus = scanner.nextLine();
            asetus = asetus.replace("﻿", "");
         
            String[] asetusSplit = asetus.split(":");
            settings.put(asetusSplit[0].replace("﻿", ""), asetusSplit[1]);

        }

        return settings;

    }
}
