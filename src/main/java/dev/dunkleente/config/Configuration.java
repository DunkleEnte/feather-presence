package dev.dunkleente.config;

import lombok.Getter;

/**
 * Configuration
 *
 * @author DunkleEnte
 * @since 28.04.2026
 */
@de.exlll.configlib.Configuration
@Getter
@SuppressWarnings("FieldMayBeFinal")
public final class Configuration {

    private Presence presence = new Presence();
    private Messages messages = new Messages();

    @de.exlll.configlib.Configuration
    @Getter
    public static class Presence {
        private String imageUrl = "paste-your-image-url-in";
        private String imageText = "hover-text";
        private String state = "current-state";

        private String details = "footer";
    }

    @de.exlll.configlib.Configuration
    @Getter
    public static class Messages {
        private String success = "<#8DFB08>Success <#CACACA>⏵ <white>You successfully reloaded the plugin!";
        private String noPermission = "<#FF0000>Error <#CACACA>⏵ <white>You don't have permission to use this command.";
        private String wrongUsage = "<#FF0000>Error <#CACACA>⏵ <white>Wrong Usage!";
    }
}