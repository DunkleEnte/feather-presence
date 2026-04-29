package dev.dunkleente;

import dev.dunkleente.command.AdminCommand;
import dev.dunkleente.config.ConfigManager;
import dev.dunkleente.listener.PlayerJoinListener;
import dev.dunkleente.listener.PlayerQuitListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;


@Getter
public final class Main extends JavaPlugin {

    @Getter
    private static Main instance;

    public Main() {
        instance = this;
    }

    @Override
    public void onEnable() {
        final Optional<Throwable> result = ConfigManager.initialize();
        if (result.isPresent()) {
            getLogger().severe("Failed to initialize config: " + result.get().getMessage());
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        new PlayerJoinListener();
        new PlayerQuitListener();
        new AdminCommand();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
