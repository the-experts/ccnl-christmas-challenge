package nl.codecentric.xmascodechallenge.shared;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * My own implementation of Color.
 * Not that mine is any better, I just spend too much time building it before noticing java.awt.Color
 * had the same stuff.
 */
@Slf4j
public class CustomColor {

    @Getter
    private int color;

    public CustomColor(int color) {
        this.color = color;
        if (getAlphaValue() == -1) {
            throw new RuntimeException("Creating color with no alpha channel is not allowed");
        }
    }

    /**
     * Safely adds (or subtracts in case of negative values) values from ARGB channel of this color
     * @param a to be added alpha
     * @param r to be added red
     * @param g to be added green
     * @param b to be added blue
     */
    public void addColor(int a, int r, int g, int b) {
        int clampedA = clampToColorRangeBounds(getAlphaValue() + a);
        int clampedR = clampToColorRangeBounds(getRedValue() + r);
        int clampedG = clampToColorRangeBounds(getGreenValue() + g);
        int clampedB = clampToColorRangeBounds(getBlueValue() + b);

        color = (clampedA << 24) + (clampedR << 16) + (clampedG << 8) + clampedB;
    }

    public int getBlueValue() {
        return (color & 0xFF);
    }

    public int getGreenValue() {
        return (color & 0xFF00) >> 8;
    }

    public int getRedValue() {
        return (color & 0xFF0000) >> 16;
    }

    public int getAlphaValue() {
        return (color >> 24) & 0xFF;
    }

    private int clampToColorRangeBounds(int value) {
        if (value < 0 || value > 255) {
            log.warn("Value '{}' is clamped! This will cause data loss!", value);
        }
        return Math.max(0, Math.min(255, value));
    }
}
