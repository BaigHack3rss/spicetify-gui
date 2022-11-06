package spicetify;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.image.Image;

public class OperatingSystem {
    private String operatingSystem, slashType, configDirectory;
    private String[] themes;

    // constructor
    public OperatingSystem(String OS) {
        if (OS.toLowerCase().contains("win")){
            operatingSystem = "Windows";
            slashType = "\\";
            configDirectory = System.getenv("APPDATA") + slashType + "Spotify";
        }
        else if (OS.toLowerCase().contains("mac")){
            operatingSystem = "MacOS";
            slashType = "/";
            configDirectory = System.getProperty("user.home") + slashType + ".config" + slashType + "spicetify";

        }
        else if (OS.toLowerCase().contains("nix") || OS.toLowerCase().contains("nux") || OS.toLowerCase().contains("aix")){
            operatingSystem = "Linux";
            slashType = "/";
            configDirectory = System.getProperty("user.home") + slashType + ".config" + slashType + "spicetify";
        }
        else {
            operatingSystem = "Unknown";
        }
    }

    // tests weather the program's dependencies are met
    public boolean readyToGo() {
        try{
            File cD = new File(configDirectory);
            File cF = new File(configDirectory + slashType + "config-xpui.ini");
            ProcessBuilder pb = new ProcessBuilder("spicetify", "-v");
            Process p = pb.start();
            Scanner s = new Scanner(p.getInputStream());
            String spicetifyVersion = s.nextLine();
            s.close();
            String[] spicetifyVersionArray = spicetifyVersion.split(".");
            boolean validVersion = true;
            // if parsing the spicetify version array as int is unsuccessful, set validVersion to false
            for (int i = 0; i < spicetifyVersionArray.length; i++) {
                try {
                    Integer.parseInt(spicetifyVersionArray[i]);
                }
                catch (NumberFormatException e) {
                    validVersion = false;
                }
            }
            if (cD.exists() && cF.exists() && validVersion) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }
    }

    // reads the config file and returns a specific field
    public String readConfig(String field) {
        try{
            Scanner configScanner = new Scanner(new File(configDirectory + slashType + "config-xpui.ini"));
            String value = "";
            while (configScanner.hasNextLine()) {
                String line = configScanner.nextLine();
                if (line.contains(field)) {
                    value = line.substring(line.indexOf("=") + 1);
                }
            }

            value = value.replaceAll("\\s", "");
            return value;

        } catch (FileNotFoundException e) {
            return null;
        }
    }

    // gets the current theme's preview image that the user has set through spicetify
    public Image getThemePreview(String themeName, String variant) throws IOException {
        String themePath = configDirectory + slashType + "Themes" + slashType + themeName;
        Image image = new Image(getClass().getResourceAsStream("images/essentials/icon.png"));
        File themeFolder = new File(themePath);
        // if theme folder doesn't exist, change themeName to lowercase and try again
        if (!themeFolder.exists()) {
            themeName = themeName.toLowerCase();
            themePath = configDirectory + slashType + "Themes" + slashType + themeName;
            themeFolder = new File(themePath);
            // if it still doesn't exist, return the default preview image
            if (!themeFolder.exists()) {
                image = new Image(getClass().getResourceAsStream("images/essentials/Preview.png"));
            }
        } else {
            // check if there is a screenshots folder
            File screenshotsFolder = new File(themePath + slashType + "screenshots");
            if (screenshotsFolder.exists()) {
                // check set image to the image that matches the variant
                File[] screenshots = screenshotsFolder.listFiles();
                for (File screenshot : screenshots) {
                    if (screenshot.getName().contains(variant) || screenshot.getName().contains(variant.toLowerCase())) {
                        image = new Image(screenshot.toURI().toString());
                    }
                }
            }
            else {
                // if there is no screenshots folder, check if there is a preview image
                File[] themeFiles = themeFolder.listFiles();
                for (File themeFile : themeFiles) {
                    if (themeFile.getName().contains(variant) || themeFile.getName().contains(variant.toLowerCase())) {
                        image = new Image(themeFile.toURI().toString());
                    }
                }
            }
        }
        return image;
    }

    // getters
    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getSlashType() {
        return slashType;
    }

    public String getConfigDirectory() {
        return configDirectory;
    }

    public String[] getThemes() {
        return themes;
    }
}
