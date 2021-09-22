package waterarchery.firedia.waotomesaj;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public abstract class DataManager {


    public static void ConfigKontrol(){
        File configFile = new File(OtoMesajMain.getPlugin().getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            OtoMesajMain.getPlugin().saveResource("config.yml", false);
        }
        OtoMesajMain.getPlugin().saveDefaultConfig();
    }

}
