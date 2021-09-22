package waterarchery.firedia.waotomesaj.WaterCore;

import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Methodlar {

    public static void KonsolaMesajGonder(String mesaj, boolean b, String prefix){
        getServer().getConsoleSender().sendMessage(Methodlar.strDuzelt((b ? prefix + " " : "") + mesaj));
    }

    public static void BroadcastGonder(String mesaj, boolean b, String prefix){
        getServer().broadcastMessage(Methodlar.strDuzelt((b ? prefix + " " : "") + mesaj));
    }

    public static void OyuncuyaMesajGonder(Player p, String mesaj, boolean b, String prefix){
        p.sendMessage(Methodlar.strDuzelt((b ? prefix + " " : "") + mesaj));
    }

    public static String strDuzelt(String str){
        return str.replace("&", "§");
    }


}
