package org.funty.deactend.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.funty.deactend.Main;

public class endCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0){
            sender.sendMessage(ChatColor.RED + "Use /end <on/off/reload/version>");
            sender.sendMessage(ChatColor.RED + "----------[End deactivation]----------");
            sender.sendMessage(ChatColor.RED + "Name: " + Main.getPlugin().getDescription().getFullName());
            sender.sendMessage(ChatColor.RED + "Version: " + Main.getPlugin().getDescription().getVersion());
            sender.sendMessage(ChatColor.RED + "Author: " + Main.getPlugin().getDescription().getAuthors().toString());
            sender.sendMessage(ChatColor.RED + "Github: https://github.com/FuntyGithub/deactend");
            sender.sendMessage(ChatColor.RED + "----------[End deactivation]----------");
        }else {
            String arg = args[0];
            if(arg.equals("reload")){
                if(sender.hasPermission("deactend.reload")){
                    Main.getPlugin().reloadConfig();
                    sender.sendMessage(ChatColor.GREEN + "[End deactivation] Config was reloaded");
                }else {
                    sender.sendMessage(ChatColor.RED + "[End deactivation] No Permmissions!");
                }
            }
            if(arg.equals("version")){
                sender.sendMessage(ChatColor.RED + "----------[End deactivation]----------");
                sender.sendMessage(ChatColor.RED + "Name: " + Main.getPlugin().getDescription().getFullName());
                sender.sendMessage(ChatColor.RED + "Version: " + Main.getPlugin().getDescription().getVersion());
                sender.sendMessage(ChatColor.RED + "Author: " + Main.getPlugin().getDescription().getAuthors().toString());
                sender.sendMessage(ChatColor.RED + "Github: https://github.com/FuntyGithub/deactend");
                sender.sendMessage(ChatColor.RED + "----------[End deactivation]----------");
            }
            if(arg.equals("on")){
                if(sender.hasPermission("deactend.reload")){
                    Main.getPlugin().getConfig().set("end", "allow");
                    Main.getPlugin().saveConfig();
                    sender.sendMessage(ChatColor.GREEN + "[End deactivation] End is now activated!");
                }else {
                    sender.sendMessage(ChatColor.RED + "[End deactivation] No Permmissions!");
                }
            }
            if(arg.equals("off")){
                if(sender.hasPermission("deactend.reload")){
                    Main.getPlugin().getConfig().set("end", "disallow");
                    Main.getPlugin().saveConfig();
                    sender.sendMessage(ChatColor.RED + "[End deactivation] End is now deactivated!");
                }else {
                    sender.sendMessage(ChatColor.RED + "[End deactivation] No Permmissions!");
                }
            }
        }
        return false;
    }
}
