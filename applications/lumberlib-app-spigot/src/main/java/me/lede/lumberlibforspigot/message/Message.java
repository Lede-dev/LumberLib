package me.lede.lumberlibforspigot.message;

import org.jetbrains.annotations.Nullable;

public class Message {

    private static @Nullable String joinMessage;
    private static @Nullable String quitMessage;

    public static void setJoinMessage(@Nullable String str) {
        joinMessage = str;
    }

    @Nullable
    public static String getJoinMessage() {
        return joinMessage;
    }

    public static void setQuitMessage(@Nullable String str) {
        quitMessage = str;
    }

    @Nullable
    public static String getQuitMessage() {
        return quitMessage;
    }

}
