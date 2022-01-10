package me.instexxdev.killrewards.Utils;

import org.bukkit.ChatColor;

public class ColorUtil {
    public static String color(final String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
