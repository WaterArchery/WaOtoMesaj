package waterarchery.firedia.waotomesaj.WaterCore;

import org.bukkit.plugin.Plugin;

import java.util.List;

public abstract class ConfigGetters {

    public static String ConfigdenString(String path){
        return Methodlar.strDuzelt(WaterCore.getPl().getConfig().getString(path));
    }

    public static long ConfigdenLong(String path){
        return WaterCore.getPl().getConfig().getLong(path);
    }

    public static int ConfigdenInt(String path){
        return WaterCore.getPl().getConfig().getInt(path);
    }

    public static List<String> ConfigdenStrList(String path){
        return WaterCore.getPl().getConfig().getStringList(path);
    }

    public static double ConfigdenDouble(String path){
        return WaterCore.getPl().getConfig().getDouble(path);
    }

    public static Boolean ConfigdenBool(String path){
        return WaterCore.getPl().getConfig().getBoolean(path);
    }

    public static Object ConfigdenObje(String path){
        return WaterCore.getPl().getConfig().get(path);
    }
}
