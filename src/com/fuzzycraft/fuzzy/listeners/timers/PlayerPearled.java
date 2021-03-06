package com.fuzzycraft.fuzzy.listeners.timers;

import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import com.fuzzycraft.fuzzy.HCFScoreboard;
import com.fuzzycraft.fuzzy.constants.Defaults;
import com.fuzzycraft.fuzzy.constants.Paths;
import com.fuzzycraft.fuzzy.listeners.Timer;
import com.fuzzycraft.fuzzy.utilities.ColorRegex;

/**
 * 
 * @author FuzzyStatic (fuzzy@fuzzycraft.com)
 *
 */

public class PlayerPearled extends Timer implements Listener {

	/**
	 * Constructor
	 * @param plugin
	 */
	public PlayerPearled(HCFScoreboard plugin) {
		super(plugin);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (!(event.getEntity() instanceof EnderPearl) || !(event.getEntity().getShooter() instanceof Player) || event.isCancelled()) {
            return;
        }
        
        Player player = (Player) event.getEntity().getShooter();
        
        if(this.map.containsKey(player) && this.map.get(player) != null) {
    		super.cancel(super.map.get(player));
    	}
        
    	super.cooldown(player, 16, "§eEnderpearl");
    }
}
