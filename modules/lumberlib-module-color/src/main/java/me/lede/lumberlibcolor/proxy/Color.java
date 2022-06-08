package me.lede.lumberlibcolor.proxy;

import com.google.common.collect.Lists;
import me.lede.lumberlibcolor.common.HexColor;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Color {

    private static final Pattern HEX_PATTERN = Pattern.compile("&(#\\w{6})");

    @NotNull
    public static List<BaseComponent[]> colored(@Nullable String... messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<BaseComponent[]> colored = Lists.newArrayListWithCapacity(messages.length);
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
    public static List<BaseComponent[]> colored(@Nullable TextComponent... messages) {
        if (messages == null)
            return Lists.newArrayList();
        List<BaseComponent[]> colored = Lists.newArrayListWithCapacity(messages.length);
        for (TextComponent message : messages) {
            colored.add(colored(message));
        }
        return colored;
    }

    @NotNull
    public static List<BaseComponent[]> coloredString(@Nullable Collection<String> messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<BaseComponent[]> colored = Lists.newArrayListWithCapacity(messages.size());
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
    public static List<BaseComponent[]> colored(@Nullable Collection<TextComponent> messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<BaseComponent[]> colored = Lists.newArrayListWithCapacity(messages.size());
        for (TextComponent message : messages) {
            colored.add(colored(message));
        }
        return colored;
    }

    @NotNull
    public static BaseComponent[] colored(@Nullable String message) {
        if (message == null)
            return TextComponent.fromLegacyText("");

        String msg = HexColor.convertHexColorToMinecraftHexString(message);
        Matcher matcher = HEX_PATTERN.matcher(ChatColor.translateAlternateColorCodes('&', msg));
        StringBuilder builder = new StringBuilder();

        while (matcher.find()) {
            matcher.appendReplacement(builder, ChatColor.of(matcher.group(1)).toString());
        }

        String colored = matcher.appendTail(builder).toString();
        return TextComponent.fromLegacyText(colored);
    }

    /**
     * Add hex color to String
     * @param message String with hex code
     * @return Colored String
     */
    public static BaseComponent[] colored(@Nullable TextComponent message) {
        if (message == null)
            return TextComponent.fromLegacyText("");

        String msg = HexColor.convertHexColorToMinecraftHexString(message.toLegacyText());
        Matcher matcher = HEX_PATTERN.matcher(ChatColor.translateAlternateColorCodes('&', msg));
        StringBuilder builder = new StringBuilder();

        while (matcher.find()) {
            matcher.appendReplacement(builder, ChatColor.of(matcher.group(1)).toString());
        }

        String colored = matcher.appendTail(builder).toString();
        return TextComponent.fromLegacyText(colored);
    }

    @NotNull
    public static List<BaseComponent[]> uncolored(@Nullable String... messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<BaseComponent[]> uncolored = Lists.newArrayListWithCapacity(messages.length);
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
    public static List<BaseComponent[]> uncolored(@Nullable TextComponent... messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<BaseComponent[]> uncolored = Lists.newArrayListWithCapacity(messages.length);
        for (TextComponent message : messages) {
            uncolored.add(uncolored(message));
        }
        return uncolored;
    }

    @NotNull
    public static List<BaseComponent[]> uncoloredString(@Nullable Collection<String> messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<BaseComponent[]> uncolored = Lists.newArrayListWithCapacity(messages.size());
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
    public static List<BaseComponent[]> uncolored(@Nullable Collection<TextComponent> messages) {
        if (messages == null)
            return Lists.newArrayList();

        List<BaseComponent[]> uncolored = Lists.newArrayListWithCapacity(messages.size());
        for (TextComponent message : messages) {
            uncolored.add(uncolored(message));
        }
        return uncolored;
    }

    public static BaseComponent[] uncolored(@Nullable String message) {
        if (message == null)
            return TextComponent.fromLegacyText("");
        return TextComponent.fromLegacyText(ChatColor.stripColor(message));
    }

    /**
     * Remove hex color from String
     * @param message Colored String
     * @return Uncolored String
     */
    public static BaseComponent[] uncolored(@Nullable TextComponent message) {
        if (message == null)
            return TextComponent.fromLegacyText("");
        return TextComponent.fromLegacyText(message.toPlainText());
    }

}
