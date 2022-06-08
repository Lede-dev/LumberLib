package me.lede.lumberlibforspigot.message;

import me.lede.lumberlibforspigot.color.Color;
import org.jetbrains.annotations.Nullable;

public class Message {

    private static @Nullable String joinMessage;
    private static @Nullable String quitMessage;

    public static void setJoinMessage(@Nullable String str) {
        joinMessage = Color.coloredLegacyString(str);
    }

    @Nullable
    public static String getJoinMessage() {
        return joinMessage;
    }

    public static void setQuitMessage(@Nullable String str) {
        quitMessage = Color.coloredLegacyString(str);
    }

    @Nullable
    public static String getQuitMessage() {
        return quitMessage;
    }

}
