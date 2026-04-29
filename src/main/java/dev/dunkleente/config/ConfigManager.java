package dev.dunkleente.config;

import de.exlll.configlib.YamlConfigurationProperties;
import de.exlll.configlib.YamlConfigurations;
import dev.dunkleente.Main;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;
import de.exlll.configlib.ConfigLib;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * ConfigManager
 *
 * @author DunkleEnte
 * @since 28.04.2026
 */
@Getter
@UtilityClass
@SuppressWarnings("unused")
public class ConfigManager {

    @Getter
    private Configuration configuration;

    @NotNull
    public Optional<Throwable> initialize() {
        try {
            configuration = YamlConfigurations.update(
                    resolve().toPath(),
                    Configuration.class,
                    buildProperties()

            );
            return Optional.empty();
        } catch (final Throwable throwable) {
            return Optional.of(throwable);
        }
    }

    public void refresh() {
        configuration = YamlConfigurations.load(
                resolve().toPath(),
                Configuration.class,
                buildProperties()
        );
    }

    private File resolve() {
        final File dataFolder = Main.getInstance().getDataFolder();
        if(!dataFolder.exists() && !dataFolder.mkdirs()) {
            throw new IllegalStateException("Could not create data folder: " + dataFolder.getAbsolutePath());
        }
        return new File(dataFolder, "config.yml");
    }

    private YamlConfigurationProperties buildProperties() {
        return ConfigLib.BUKKIT_DEFAULT_PROPERTIES.toBuilder()
                .charset(StandardCharsets.UTF_8)
                .outputNulls(true)
                .inputNulls(false)
                .build();
    }
}
