package dev.dunkleente.utility;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;

/**
 * ColorUtil
 *
 * @author DunkleEnte
 * @since 28.04.2026
 */
public final class ColorUtil {
    public static Component parse(String input){
        return MiniMessage.miniMessage().deserialize(input).decoration(TextDecoration.ITALIC, false);
    }
    public static String color(String input) {
        return MiniMessage.miniMessage().serialize(parse(input));
    }

    public static Component empty(){
        return Component.empty();
    }
}
