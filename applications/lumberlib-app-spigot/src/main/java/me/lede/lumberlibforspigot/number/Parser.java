package me.lede.lumberlibforspigot.number;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Parser {

    /**
     * Convert String to Integer. </br>
     * Return 0 if you catch an Exception.
     * @param str Integer string
     * @return String converted to integer
     */
    public static int parseInteger(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Convert String to Long. </br>
     * Return 0 if you catch an Exception.
     * @param str Long string
     * @return String converted to long
     */
    public static long parseLong(@NotNull String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return 0L;
        }
    }

    /**
     * Convert String to Double. </br>
     * Return 0 if you catch an Exception.
     * @param str Double string
     * @return String converted to double
     */
    public static double parseDouble(@NotNull String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return 0.0d;
        }
    }

    /**
     * Convert String to Float. </br>
     * Return 0 if you catch an Exception.
     * @param str Float string
     * @return String converted to float
     */
    public static float parseFloat(@NotNull String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            return 0.0f;
        }
    }

    /**
     * Convert String to Boolean. </br>
     * Return false if you catch an Exception.
     * @param str Boolean string
     * @return String converted to boolean
     */
    public static boolean parseBoolean(@NotNull String str) {
        try {
            return Boolean.parseBoolean(str);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Convert String to Byte. </br>
     * Return 0 if you catch an Exception.
     * @param str Byte string
     * @return String converted to byte
     */
    public static byte parseByte(@NotNull String str) {
        try {
            return Byte.parseByte(str);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Convert String to BigInteger. </br>
     * Return 0 if you catch an Exception.
     * @param str BigInteger string
     * @return String converted to BigInteger
     */
    public static BigInteger parseBigInteger(@NotNull String str) {
        try {
            return new BigInteger(str);
        } catch (Exception e) {
            return BigInteger.ZERO;
        }
    }

    /**
     * Convert String to BigDecimal. </br>
     * Return 0 if you catch an Exception.
     * @param str BigDecimal string
     * @return String converted to BigDecimal
     */
    public static BigDecimal parseBigDecimal(@NotNull String str) {
        try {
            return new BigDecimal(str);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

}
