package dev.dunkleente.listener;

import dev.dunkleente.config.ConfigManager;
import net.digitalingot.feather.serverapi.api.FeatherAPI;
import net.digitalingot.feather.serverapi.api.event.player.PlayerHelloEvent;
import net.digitalingot.feather.serverapi.api.meta.DiscordActivity;
import net.digitalingot.feather.serverapi.api.player.FeatherPlayer;
import org.jetbrains.annotations.NotNull;

/**
 * PlayerJoinListener
 *
 * @author DunkleEnte
 * @since 28.04.2026
 */
public final class PlayerJoinListener {

    public PlayerJoinListener() {
        registerFeatherEvents();
    }

    private void registerFeatherEvents() {
        FeatherAPI.getEventService().subscribe(PlayerHelloEvent.class, event -> {
            final @NotNull FeatherPlayer player = event.getPlayer();

            final DiscordActivity activity = DiscordActivity.builder()
                    .withImage(ConfigManager.getConfiguration().getPresence().getImageUrl())
                    .withImageText(ConfigManager.getConfiguration().getPresence().getImageText())
                    .withState(ConfigManager.getConfiguration().getPresence().getState())
                    .withDetails(ConfigManager.getConfiguration().getPresence().getDetails())
                    .withStartTimestamp(System.currentTimeMillis())
                    .build();

            FeatherAPI.getMetaService().updateDiscordActivity(player, activity);
        });
    }
}