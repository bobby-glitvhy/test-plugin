package com.example.myplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("MyPlugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MyPlugin disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("hello")) {
            sender.sendMessage("Hello from MyPlugin!");
            return true;
        }

        return false;
    }
}
