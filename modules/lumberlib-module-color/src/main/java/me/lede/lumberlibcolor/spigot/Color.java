package me.lede.lumberlibcolor.spigot;

import com.google.common.collect.Lists;
import me.lede.lumberlibcolor.common.HexColor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public class Color {

    @NotNull
    public static List<Component> colored(@Nullable String... messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<Component> colored = Lists.newArrayListWithCapacity(messages.length);
        for (String message : messages) {
            colored.add(colored(message));
        }
        return colored;
    }

    /**
     * Add hex color to String[]
     * @param messages String[] with hex code
     * @return Colored String List
     */
    @NotNull
    public static List<Component> colored(@Nullable TextComponent... messages) {
        if (messages == null)
            return Lists.newArrayList();
        List<Component> colored = Lists.newArrayListWithCapacity(messages.length);
        for (TextComponent message : messages) {
            colored.add(colored(message));
        }
        return colored;
    }

    @NotNull
    public static List<Component> coloredString(@Nullable Collection<String> messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<Component> colored = Lists.newArrayListWithCapacity(messages.size());
        for (String message : messages) {
            colored.add(colored(message));
        }
        return colored;
    }

    /**
     * Add hex color to String Collection
     * @param messages String Collection with hex code
     * @return Colored String List
     */
    @NotNull
    public static List<Component> colored(@Nullable Collection<TextComponent> messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<Component> colored = Lists.newArrayListWithCapacity(messages.size());
        for (TextComponent message : messages) {
            colored.add(colored(message));
        }
        return colored;
    }

    /**
     * Add hex color to String
     * @param message String with hex code
     * @return Colored String
     */
    @NotNull
    public static Component colored(@Nullable TextComponent message) {
        if (message == null)
            return Component.text("");

        String legacy = message.content();
        return colored(legacy);
    }

    @NotNull
    public static Component colored(@Nullable String message) {
        if (message == null)
            return Component.text("");

        message = HexColor.convertHexColorToMinecraftHexString(message);
        Component component = LegacyComponentSerializer.legacy('&').deserialize(message);
        return component.decoration(TextDecoration.ITALIC, false);
    }

    @NotNull
    public static List<Component> uncolored(@Nullable String... messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<Component> uncolored = Lists.newArrayListWithCapacity(messages.length);
        for (String message : messages) {
            uncolored.add(uncolored(message));
        }
        return uncolored;
    }

    /**
     * Remove hex color from String[]
     * @param messages Colored String[]
     * @return Uncolored String List
     */
    @NotNull
    public static List<Component> uncolored(@Nullable TextComponent... messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<Component> uncolored = Lists.newArrayListWithCapacity(messages.length);
        for (TextComponent message : messages) {
            uncolored.add(uncolored(message));
        }
        return uncolored;
    }

    @NotNull
    public static List<Component> uncoloredString(@Nullable Collection<String> messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<Component> uncolored = Lists.newArrayListWithCapacity(messages.size());
        for (String message : messages) {
            uncolored.add(uncolored(message));
        }
        return uncolored;
    }

    /**
     * Remove hex color from String Collection
     * @param messages Colored String Collection
     * @return Uncolored String List
     */
    @NotNull
    public static List<Component> uncolored(@Nullable Collection<TextComponent> messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<Component> uncolored = Lists.newArrayListWithCapacity(messages.size());
        for (TextComponent message : messages) {
            uncolored.add(uncolored(message));
        }
        return uncolored;
    }

    @NotNull
    public static Component uncolored(@Nullable String message) {
        if (message == null)
            return Component.text("");
        return uncolored(Component.text(message));
    }

    /**
     * Remove hex color from String
     * @param message Colored String
     * @return Uncolored String
     */
    @NotNull
    public static Component uncolored(@Nullable TextComponent message) {
        if (message == null)
            return Component.text("");
        return Component.text(PlainTextComponentSerializer.plainText().serialize(message));
    }

}
