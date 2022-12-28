package me.ryanlogan.diamondscanner;

import commandspackage.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class DiamondScanner extends JavaPlugin {

    @Override
    public void onEnable() {

        Scan scan = new Scan();

        Objects.requireNonNull(getCommand("scanfordiamond")).setExecutor(scan);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Diamond Scanner is Enabled [plugin]");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Diamond Scanner is Disabled [plugin]");
    }
}
