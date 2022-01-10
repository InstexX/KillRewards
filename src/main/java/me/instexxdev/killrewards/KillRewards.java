package me.instexxdev.killrewards;

import me.instexxdev.killrewards.Listeners.KillListener;
import me.instexxdev.killrewards.Utils.ColorUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class KillRewards extends JavaPlugin {
    private static KillRewards instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new KillListener(), this);

        System.out.println(ColorUtil.color("&7[&bKill Rewards&7] &aPlugin Successfully loaded."));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static KillRewards getInstance() {
        return instance;
    }
}

