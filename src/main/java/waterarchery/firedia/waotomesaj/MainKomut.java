package waterarchery.firedia.waotomesaj;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import waterarchery.firedia.waotomesaj.WaterCore.WaterCore;

public class MainKomut implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("waotomesaj") || cmd.getName().equalsIgnoreCase("wom")) {
            WaterCore wapi = OtoMesajMain.getWapi();
            if (args.length == 0) {
                YardimYolla(sender);
                return false;
            } else if (args.length == 1){
                if (args[0].equalsIgnoreCase("reload")) {
                    if (sender.hasPermission("waoto.reload")) {
                        OtoMesajMain.getPlugin().reloadConfig();
                        OtoMesajMain.getTask().forEach(task -> task.cancel());
                        OtoMesajMain.MesajGondermeBaslat();
                        WaterCore yeniWapi = new WaterCore(OtoMesajMain.getPlugin().getConfig().getString("Prefix"), OtoMesajMain.getPlugin());
                        OtoMesajMain.setWapi(yeniWapi);
                        sender.sendMessage(wapi.ConfigdenString("Prefix") + " §7Config dosyası yenilendi");
                    } else {
                        sender.sendMessage(wapi.ConfigdenString("Prefix") + " §cYetkin yok");
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public void YardimYolla(CommandSender o){
        WaterCore wapi = OtoMesajMain.getWapi();
        o.sendMessage(wapi.ConfigdenString("Prefix") + " §7Config dosyasını yenilemek için: §6/wom reload");
    }
}
