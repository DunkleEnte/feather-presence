package dev.dunkleente.listener;

import dev.dunkleente.Main;
import net.digitalingot.feather.serverapi.api.FeatherAPI;
import net.digitalingot.feather.serverapi.api.player.FeatherPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


/**
 * PlayerQuitListener
 *
 * @author DunkleEnte
 * @since 28.04.2026
 */
public class PlayerQuitListener implements Listener {

    public PlayerQuitListener() {
        Main.getInstance().getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        final FeatherPlayer player = FeatherAPI.getPlayerService().getPlayer(event.getPlayer().getUniqueId());

        if(player != null) {
            FeatherAPI.getMetaService().clearDiscordActivity(player);
        }
    }
}
