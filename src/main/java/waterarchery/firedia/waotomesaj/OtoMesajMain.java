package waterarchery.firedia.waotomesaj;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import waterarchery.firedia.waotomesaj.WaterCore.WaterCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class OtoMesajMain extends JavaPlugin {

    private static Plugin pl;
    private static WaterCore wapi;
    private static List<Mesaj> mesajlar = new ArrayList<>();
    private static ArrayList<BukkitTask> mesajTasklar = new ArrayList<>();

    @Override
    public void onEnable() {
        pl = this;
        wapi = new WaterCore(pl.getConfig().getString("Prefix"), pl);
        wapi.KonsolaMesajGonder("&7waOtoMesaj aktifleştiriliyor :)", true);
        wapi.KonsolaMesajGonder("&7Config dosyası kontrol ediliyor.", true);
        DataManager.ConfigKontrol();
        wapi.KonsolaMesajGonder("&7Komutlar ekleniyor.", true);
        pl.getServer().getPluginCommand("wom").setExecutor(new MainKomut());
        pl.getServer().getPluginCommand("waotomesaj").setExecutor(new MainKomut());
        wapi.KonsolaMesajGonder("&7Mesaj göndermeye başlanıyor.", true);
        MesajGondermeBaslat();
    }

    @Override
    public void onDisable() {
        wapi.KonsolaMesajGonder("&7WaOtoMesaj devre dışı bırakılıyor :(", true);
    }

    public static void MesajGondermeBaslat(){
        for (String path : pl.getConfig().getConfigurationSection("Mesajlar").getKeys(false)) {
            Mesaj mesaj = new Mesaj(path);
            mesajlar.add(mesaj);
        }
        int mesajArasiZaman = wapi.ConfigdenInt("MesajAraligi");
        int tumZaman = mesajArasiZaman * mesajlar.size();
        BukkitTask mainTask = new BukkitRunnable() {
            @Override
            public void run() {
                if (wapi.ConfigdenBool("Rastgele")) {
                    Collections.shuffle(mesajlar);
                }
                int i = 0;
                for (Mesaj mesaj : mesajlar) {
                    BukkitTask mesajTask = new BukkitRunnable() {
                        @Override
                        public void run() {
                            mesaj.MesajGonder();
                        }
                    }.runTaskLater(pl,i * 20L * mesajArasiZaman);
                    mesajTasklar.add(mesajTask);
                    i++;
                }
            }
        }.runTaskTimer(pl, 0, 20L * tumZaman);
        mesajTasklar.add(mainTask);
    }

    public static Plugin getPlugin() { return pl; }

    public static WaterCore getWapi() { return wapi; }

    public static ArrayList<BukkitTask> getTask(){ return mesajTasklar; }

    public static void setWapi(WaterCore wapi) { OtoMesajMain.wapi = wapi; }
}
