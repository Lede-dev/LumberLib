package me.lede.lumberlibforspigot.color;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum HexColor {

    BLACK("#000000"),
    TULIP_NOIR("#392f31"),
    MARIE_ROUGE("#edacb1"),
    ROSE("#8d192b"),
    MAGENTA("#dc143c"),
    CORAL("#f29886"),
    MAROON("#800000"),
    RED("#ff0000"),
    ORANGE("#ff7f00"),
    APRICOT("#fbceb1"),
    BROWN("#964b00"),
    MANDARIN("#f89b00"),
    OCHER("#c68a12"),
    KHAKI("#8f784b"),
    YELLOW("#ffd400"),
    GOLD("#ffd700"),
    FORSYTHIA("#f7e600"),
    LIGHT_IVORY("#eee6c4"),
    IVORY("#ece6cc"),
    OLIVE("#808000"),
    BEIGE("#f5f5dc"),
    GRASS("#6a8518"),
    LIME("#bfff00"),
    LIGHT_GREEN("#81c147"),
    GREEN("#009900"),
    GREENNESS("#008000"),
    EMERALD("#008d62"),
    JADE("#83dcb7"),
    DARK_BLUE("#008080"),
    MARINE("#0099a4"),
    TURQUOISE("#005666"),
    SKY_BLUE("#50bcdf"),
    CYAN("#00a3d2"),
    CYAN_BLUE("#3e91b5"),
    CERULEAN_FLASH("#0096c6"),
    LIGHT_BLUE("#4aa8d8"),
    AQUAMARINE("#5e7e9b"),
    SHEFFIELD_STEEL("#437299"),
    BLUE("#0067a3"),
    PRUSSIAN_BLUE("#003458"),
    COBALT_BLUE("#00498c"),
    SEA_BLUE("#0080ff"),
    ULTRAMARINE("#464964"),
    WHITE("#ffffff"),
    GRAY("#808080"),
    SILVER("#c0c0c0"),
    LIGHT_PURPLE("#8977ad"),
    INDIGO("#000080"),
    BLUE_PURPLE("#6937a1"),
    PURPLE("#8b00ff"),
    AMETHYST("#660099"),
    CLARET("#ff00ff"),
    PINK("#ff3399")
    ;

    private static final Pattern PATTERN = Pattern.compile("&#([A-Za-z_]*)#");

    private final String hex;

    HexColor(String hex) {
        this.hex = hex;
    }

    /**
     * 미리 정의된 HexString을 반환합니다.
     * @return Hex String
     */
    public String getHexString() {
        return hex;
    }

    /**
     * 미리 정의된 HexString에 Minecraft Color Code를 부착하여 반환합니다.
     * @return Minecraft Hex String
     */
    public String getMinecraftHexString() {
        return "&" + hex;
    }

    /**
     * 문자열에 포함된 HexColor 를 HexString으로 변환하여 반환합니다. <br>
     * 입력받은 text가 null이라면 빈 문자열을 반환합니다.<br><br>
     *
     * 미리 정의된 HexColor를 입력하여 Text내의 색상 코드를 변환할 수 있습니다. <br>
     * 정의되지 않은 HexColor를 입력하면 WIHTE 색상으로 적용하여 반환됩니다. <br><br>
     * 입력 패턴 예시) <br>
     *  - "&#GREEN#", "&#RED#", "&#PINK#" => O <br>
     *  - "&#MOL_RU#" => X (정의되지 않은 컬러, WHITE로 변환하여 적용)<br>
     *  - "&#RED#안녕하신가! &#BLUE#힘세고 &#PINK#강한 아침" => O <br>
     * @param text String
     * @return HexColor 가 HexString으로 변환된 문자열
     */
    @NotNull
    public static String convertHexColorToHexString(@Nullable String text) {
        if (text == null)
            return "";

        Matcher matcher = PATTERN.matcher(text);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String matched = matcher.group(1);
            HexColor color = getMatchedHexColor(matched);
            matcher.appendReplacement(buffer, color.getHexString());
        }

        return matcher.appendTail(buffer).toString();
    }

    /**
     * 문자열에 포함된 HexColor를 Minecraft HexString으로 변환하여 반환합니다. <br>
     * 입력받은 text가 null이라면 빈 문자열을 반환합니다. <br><br>
     *
     * 미리 정의된 HexColor를 입력하여 Text내의 색상 코드를 변환할 수 있습니다. <br>
     * 정의되지 않은 HexColor를 입력하면 WIHTE 색상으로 적용하여 반환됩니다. <br><br>
     * 입력 패턴 예시) <br>
     *  - "&#GREEN#", "&#RED#", "&#PINK#" => O <br>
     *  - "&#MOL_RU#" => X (정의되지 않은 컬러, WHITE로 변환하여 적용)<br>
     *  - "&#RED#안녕하신가! &#BLUE#힘세고 &#PINK#강한 아침" => O <br>
     * @param text String
     * @return HexColor가 Minecraft HexString으로 변환된 문자열
     */
    @NotNull
    public static String convertHexColorToMinecraftHexString(@Nullable String text) {
        if (text == null)
            return "";

        Matcher matcher = PATTERN.matcher(text);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String matched = matcher.group(1);
            HexColor color = getMatchedHexColor(matched);
            matcher.appendReplacement(buffer, color.getMinecraftHexString());
        }

        return matcher.appendTail(buffer).toString();
    }

    /**
     * 문자열에서 HexColor를 추출하여 반환합니다. <br>
     * 추출할 수 있는 패턴 - "&#([A-Za-z])#" <br>
     * 문자열에 "&#RED&"가 포함되어 있다면, RED를 추출하여 반환합니다. <br>
     * 추출할 수 없는 문자를 포함한다면 WHITE 컬러를 반환합니다. <br><br>
     * ex) <br>
     *  - "&#GREEN#" => GREEN을 추출하여 반환합니다. <br>
     *  - "&#MOL_RU#" => 정상적이지 않은 HexColor이므로 WHITE를 반환합니다.
     * @param matched HexColor가 포함된 문자열
     * @return HexColor
     */
    @NotNull
    private static HexColor getMatchedHexColor(@NotNull String matched) {
        matched = matched.replace("&#", "").replace("#", "");
        try {
            return HexColor.valueOf(matched.toUpperCase());
        } catch (Exception ignored) {}
        return WHITE;
    }

}
