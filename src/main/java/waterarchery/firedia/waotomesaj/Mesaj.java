package waterarchery.firedia.waotomesaj;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.plugin.Plugin;
import waterarchery.firedia.waotomesaj.WaterCore.WaterCore;

import java.util.List;

public class Mesaj {

    protected List<String> mesajlar;
    Plugin pl;

    public Mesaj(String path) {
        pl = OtoMesajMain.getPlugin();
        WaterCore wapi = OtoMesajMain.getWapi();
        mesajlar = wapi.ConfigdenStrList("Mesajlar." + path);
        String basSonMesaj = pl.getConfig().getString("BasVeSonMesaj");
        if (!basSonMesaj.equalsIgnoreCase("yok")) {
            mesajlar.add(0, basSonMesaj);
            mesajlar.add(mesajlar.size(), basSonMesaj);
        }
    }

    public void MesajGonder() {
        WaterCore wapi = OtoMesajMain.getWapi();
        for (String mesaj : mesajlar) {
            mesaj = mesaj.replace("&", "§")
                    .replace("%prefix%", wapi.ConfigdenString("Prefix"));
            if (mesaj.contains("<ortala>")) {
                mesaj = getOrtalanmisMesaj(mesaj);
            }
            wapi.BroadcastGonder(mesaj, false);
        }
        SesGonder();
    }

    public void SesGonder(){
        WaterCore wapi = OtoMesajMain.getWapi();
        try {
            String sesStr = wapi.ConfigdenString("Ses");
            if (sesStr.equalsIgnoreCase("yok")) {
                return;
            }
            Sound ses = Sound.valueOf(sesStr);
            Bukkit.getOnlinePlayers().forEach(o -> o.playSound(o.getLocation(), ses, 1, 1));
        }catch(Exception e) {
            wapi.KonsolaMesajGonder("&cLütfen configdeki ses ayarını değiştirin veya kapatmak için", true);
            wapi.KonsolaMesajGonder("&cAyarı 'yok' olarak değiştirin.", true);
        }
    }

    String getOrtalanmisMesaj(String mesaj) {
        int maxHarf = 78;
        mesaj = mesaj.replace("<ortala>", "");
        int mesajBoyut = mesaj.length();
        for (int i = 0; i < mesaj.length() - 1; i++) {
            if (mesaj.substring(i,i+1).equalsIgnoreCase("§")) {
                mesajBoyut = mesajBoyut - 2;
            }
        }
        int eklenecekSpace = (maxHarf - mesajBoyut) / 2;
        String spaceler = "";
        for (int i = 0; i < eklenecekSpace; i++) {
            spaceler = spaceler + " ";
        }
        return spaceler + mesaj;
    }

}
