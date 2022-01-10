package me.instexxdev.killrewards.Listeners;

import me.instexxdev.killrewards.KillRewards;
import me.instexxdev.killrewards.Utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import sun.plugin2.message.Message;


public class KillListener implements Listener {

    @EventHandler
    public void onKillPlayer(PlayerDeathEvent event){

        if (event.getEntity().getKiller() != null) {

            Player player = event.getEntity().getKiller();

            for (String command:KillRewards.getInstance().getConfig().getStringList("CommandOnKill")) {
                String cmd = command.replaceAll("%player%", player.getName());
                if(cmd.contains("Message:")){
                    String MessageToSend = ColorUtil.color(cmd).replaceAll("Message:", "");
                    player.sendMessage(MessageToSend);
                } else {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),cmd);
                }

            }

        }
    }
}

