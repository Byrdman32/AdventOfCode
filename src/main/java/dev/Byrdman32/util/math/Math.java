package dev.Byrdman32.util.math;

public class Math {
    public static Long toDecimal(String binary) {
        return Long.parseLong(binary, 2);
    }
}