package nu.gumi.perfume;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener {

	public Perfume plugin;
	
	public EventListener(Perfume instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		
		Player player = event.getPlayer();
		
		Location loc = player.getLocation();
		loc.setY(loc.getY() - 1);
	    World world = loc.getWorld();
	    Block currentBlock = world.getBlockAt(loc);
	    
	    if (currentBlock.getType() != Material.AIR && currentBlock.getType() != Material.LONG_GRASS && currentBlock.getType() != Material.WATER 
	    		&& currentBlock.getType() != Material.STATIONARY_WATER && currentBlock.getType() != Material.STATIONARY_LAVA
	    		&& currentBlock.getType() != Material.YELLOW_FLOWER && currentBlock.getType() != Material.RED_ROSE && currentBlock.getType() != Material.BED 
	    		&& currentBlock.getType() != Material.BIRCH_WOOD_STAIRS && currentBlock.getType() != Material.BRICK_STAIRS 
	    		&& currentBlock.getType() != Material.CHEST && currentBlock.getType() != Material.CROPS
	    		&& currentBlock.getType() != Material.DARK_OAK_STAIRS && currentBlock.getType() != Material.ACACIA_STAIRS 
	    		&& currentBlock.getType() != Material.CARPET){
	    	currentBlock.setType(Material.GRASS);
	    	loc.setY(loc.getY() + 1);
	    	currentBlock = world.getBlockAt(loc);
	    	currentBlock.setType(Material.YELLOW_FLOWER);
	    	loc.getWorld().playEffect(loc, Effect.SMOKE, 100);
	    }
	}
}

