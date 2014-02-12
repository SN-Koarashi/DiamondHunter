package com.github.Jwoolley;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DhCommands implements CommandExecutor {
	
	private static DiamondHunter dh;
	private static BroadcastHandler bh;
	
	public DhCommands(DiamondHunter instance, BroadcastHandler instance2)
	{
		dh = instance;
	    bh = instance2;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String args[])
    {
		Player p = (Player) sender;
        String arg1 = "";
        if(command.getName().equalsIgnoreCase("dh"))
        {
            try
            {
                arg1 = args[0];
            }
            catch(ArrayIndexOutOfBoundsException arrayindexoutofboundsexception) { }
            if(arg1.equalsIgnoreCase("reload"))
            {
            	if(p.hasPermission("dh.reload"))
            	{
            		dh.reloadConfig();
            		sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "DH" + ChatColor.GOLD + "] " + ChatColor.GREEN + "DiamondHunter has successfully been reloaded!");
            		return true;
            	}
            	else
            	{
            		sender.sendMessage(ChatColor.RED + "You do not have permission to preform this command!");
            		return true;
            	}
            } 
            else if(arg1.equalsIgnoreCase("off"))
            {
            	if(p.hasPermission("dh.getnotice"))
            	{
            		if(!bh.containsPlayer(p))
            		{
            			bh.addPlayer(p);
            			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "DH" + ChatColor.GOLD + "] " + ChatColor.GREEN + "Notices have been turned off");
            		}
            		else
            		{
            			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "DH" + ChatColor.GOLD + "] " + ChatColor.GREEN + "You have already turned notices off");
            		}
            		return true;
            	}
            	else
            	{
            		sender.sendMessage(ChatColor.RED + "You do not have permission to preform this command!");
            		return true;
            	}
            }
            else if(arg1.equalsIgnoreCase("on"))
            {
            	if(p.hasPermission("dh.notice"))
            	{
            		if(bh.containsPlayer(p))
            		{
            			bh.removePlayer(p);
            			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "DH" + ChatColor.GOLD + "] " + ChatColor.GREEN + "Notices have been turned back on");
            		}
            		else
            		{
            			sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "DH" + ChatColor.GOLD + "] " + ChatColor.GREEN + "You already have notices on");
            		}
            		return true;
            	}
            	else
            	{
            		sender.sendMessage(ChatColor.RED + "You do not have permission to preform this command!");
            		return true;
            	}
            }
            else
            {
                sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "DH" + ChatColor.GOLD + "] " + "The following commands are available!");
                sender.sendMessage(ChatColor.RED + "/dh reload:" + ChatColor.AQUA + " Reloads the Diamond Hunter config.");
                sender.sendMessage(ChatColor.RED + "/dh off:" + ChatColor.AQUA + " Turns block notices off.");
                sender.sendMessage(ChatColor.RED + "/dh on:" + ChatColor.AQUA + " Turns block notices on.");
                sender.sendMessage("");
                sender.sendMessage(ChatColor.GOLD + "Please report any bugs or problems at");
                sender.sendMessage(ChatColor.AQUA + "http://dev.bukkit.org/server-mods/diamondhunter/");
                sender.sendMessage(ChatColor.GOLD + "Diamond Hunter created by Jwoolley.");
                return true;
            }
        } else
        {
            return false;
        }
    }


}
