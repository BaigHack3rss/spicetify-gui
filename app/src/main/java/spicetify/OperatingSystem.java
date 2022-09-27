package spicetify;

public class OperatingSystem {
    private String OperatingSystem;
    private String configDirectory;

    public void setOperatingSystem(String OS){
        if (OS.toLowerCase().contains("win")){
            this.OperatingSystem = "Windows";
        }
        else if (OS.toLowerCase().contains("mac")){
            this.OperatingSystem = "MacOS";
        }
        else if (OS.toLowerCase().contains("nix") || OS.toLowerCase().contains("nux") || OS.toLowerCase().contains("aix")){
            this.OperatingSystem = "Linux";
        }
        else {
            this.OperatingSystem = "Unknown";
        }
    } 

    public String getOperatingSystem(){
        return this.OperatingSystem;
    }

    public void setConfigDirectory(String OS){
        if (OS.equals("Windows")){
            this.configDirectory = System.getenv("APPDATA") + "\\spicetify";
        }
        else if (OS.equals("Linux") || OS.equals("MacOS")){
            this.configDirectory = System.getProperty("user.home") + "/.config/spicetify";
        }
    }

    public String getConfigDirectory(){
        return this.configDirectory;
    }
}
