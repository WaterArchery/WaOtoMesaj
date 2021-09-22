package waterarchery.firedia.waotomesaj.WaterCore;


import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public final class WaterCore {

    public String prefix = "";
    private static Plugin pl;

    public WaterCore(String prefix, Plugin pl){
        this.prefix = prefix;
        WaterCore.pl = pl;
    }

    public static Plugin getPl(){
        return pl;
    }

    public void KonsolaMesajGonder(String mesaj, boolean b){
        Methodlar.KonsolaMesajGonder(mesaj, b, prefix);
    }

    public void BroadcastGonder(String mesaj, boolean b){
        Methodlar.BroadcastGonder(mesaj, b, prefix);
    }

    public String StringCevir(String str){ return Methodlar.strDuzelt(str); }

    public String ConfigdenString(String path) { return ConfigGetters.ConfigdenString(path); }

    public long ConfigdenLong(String path) { return ConfigGetters.ConfigdenLong(path); }

    public double ConfigdenDouble(String path) { return ConfigGetters.ConfigdenDouble(path); }

    public List<String> ConfigdenStrList(String path){
        return ConfigGetters.ConfigdenStrList(path);
    }

    public int ConfigdenInt(String path) { return ConfigGetters.ConfigdenInt(path); }

    public boolean ConfigdenBool(String path) { return ConfigGetters.ConfigdenBool(path); }

    public Object ConfigdenObje(String path) { return ConfigGetters.ConfigdenObje(path); }

    public void OyuncuyaMesajGonder(Player p, String mesaj, boolean b){
        Methodlar.OyuncuyaMesajGonder(p, mesaj, b, prefix);
    }

    public void Reload(){
        pl.reloadConfig();
    }


}
