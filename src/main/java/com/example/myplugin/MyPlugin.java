package com.example.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("NameChanger enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("NameChanger disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("setname")) {

            if (!sender.hasPermission("namechanger.setname")) {
                sender.sendMessage(ChatColor.RED + "You don't have permission!");
                return true;
            }

            if (args.length < 2) {
                sender.sendMessage(ChatColor.RED + "Usage: /setname <player> <newname>");
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Player not found!");
                return true;
            }

            String newName = ChatColor.translateAlternateColorCodes('&', args[1]);
            
            target.setDisplayName(newName);
            target.setPlayerListName(newName);

            sender.sendMessage(ChatColor.GREEN + "Changed " + target.getName() + "'s name to " + newName);
            target.sendMessage(ChatColor.YELLOW + "Your display name has been changed to " + newName);

            return true;
        }

        return false;
    }
}
