package com.github.Jwoolley;

import java.util.ArrayList;
import org.bukkit.entity.Player;

public class BroadcastHandler
{
	
	public static ArrayList<Player> blockListener = new ArrayList<Player>();

    public BroadcastHandler()
    {
    }

    public void addPlayer(Player p)
    {
        blockListener.add(p);
    }

    public void removePlayer(Player p)
    {
        blockListener.remove(p);
    }

    public boolean containsPlayer(Player p)
    {
        return blockListener.contains(p);
    }
}
