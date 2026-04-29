package dev.dunkleente.command;

import dev.dunkleente.Main;
import dev.dunkleente.config.ConfigManager;
import dev.dunkleente.utility.ColorUtil;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AdminCommand
 *
 * @author DunkleEnte
 * @since 28.04.2026
 */
public class AdminCommand implements CommandExecutor, TabCompleter {

    public AdminCommand() {
        Objects.requireNonNull(Main.getInstance().getCommand("feather-admin")).setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if(!(sender instanceof final Player player)) return false;

        if(!player.hasPermission("feather.admin")) {
            player.sendRichMessage(ConfigManager.getConfiguration().getMessages().getNoPermission());
            player.sendActionBar(ColorUtil.parse(ConfigManager.getConfiguration().getMessages().getNoPermission()));

            player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP,1,1);
            return false;
        }

        if(args.length != 1) {
            player.sendRichMessage(ConfigManager.getConfiguration().getMessages().getWrongUsage() + "/feather-admin refresh");
            player.sendActionBar(ColorUtil.parse(ConfigManager.getConfiguration().getMessages().getWrongUsage() + "feather-admin refresh"));

            player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP,1,1);
            return false;
        }

        if(args[0].equalsIgnoreCase("refresh")) {
            ConfigManager.refresh();

            player.sendRichMessage(ConfigManager.getConfiguration().getMessages().getSuccess());
            player.sendActionBar(ColorUtil.parse(ConfigManager.getConfiguration().getMessages().getSuccess()));

            player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP,1,1);
            return false;
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        final List<String> completions = new ArrayList<>();
        if(!(sender.hasPermission("feather.admin"))) return completions;

        if(args.length == 1) {
            completions.add("refresh");
            return completions;
        }

        return completions;
    }
}
