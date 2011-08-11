package me.fugos.texture;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.util.config.Configuration;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.packet.PacketTexturePack;
import org.getspout.spoutapi.player.SpoutPlayer;
import org.bukkit.entity.Player;

import me.fugos.texture.TexturedSpout;


public class pListener extends PlayerListener{
		
		public static TexturedSpout plugin; public pListener(TexturedSpout instance) {
	        plugin = instance;
	}
			
		
public boolean Dtod;
		
		public void onPlayerJoin(PlayerJoinEvent event,  World world, SpoutPlayer splayer,SpoutCraftEnableEvent sevent, Configuration config, Player player) {
			doWorldBasedActions(event.getPlayer().getWorld(),
					SpoutPlayer splayer = SpoutManager.getPlayer(event.getPlayer());
					TexturedSpout.instance.getConfiguration();
			
			Bukkit.getServer()
			.getScheduler()
			.scheduleSyncDelayedTask(TexturedSpout.instance,
			new TSPlayerTask(event.getPlayer().getName(), this), 1);

		}

		public void onPlayerTeleport(PlayerTeleportEvent event, SpoutPlayer splayer) {
			if (event.getFrom().getWorld() != event.getTo().getWorld()) {
			doWorldBasedActions(event.getTo().getWorld(),
			SpoutPlayer splayer = SpoutManager.getPlayer(event.getPlayer());
			TexturedSpout.instance.getConfiguration();
			}
		}
		public void onPlayerRespawn(PlayerRespawnEvent event) {
			Bukkit.getServer()
			.getScheduler()
			.scheduleSyncDelayedTask(TexturedSpout.instance,
			new TSPlayerTask(event.getPlayer().getName(), this), 1);
		}

			private static class TSPlayerTask implements Runnable {
			private final String playerName;
			private final pListener listener;
			
			public TSPlayerTask(String playerName, pListener listener) {
			this.playerName = playerName;
			this.listener = listener;
			}

			@Override
			public void run() {
				Player player = Bukkit.getServer().getPlayer(playerName);
				if (player != null) {
				listener.doPlayerBasedActions(
				SpoutPlayer splayer = SpoutManager.getPlayer(null);
				TexturedSpout.instance.getConfiguration();
				
			}
			}
			public void doWorldActions(World world, SpoutPlayer player,Configuration config) {
					String texturePackUrl = config.getString(
					"texturepack" + world.getName(),
					config.getString("texturepack.default"));
					if (texturePackUrl != null) {
					try {
					player.setTexturePack(texturePackUrl);
					} catch (IllegalArgumentException ex) {
					TexturedSpout.log
					.severe("[TexturedSpout] Error with texture pack for world "
					+ player.getWorld().getName()
					+ " : "
					+ ex.getMessage());
					}
			
					}
				}
			}

			}