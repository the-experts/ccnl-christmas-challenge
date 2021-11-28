package nl.codecentric.xmascodechallenge.shared;

import java.awt.*;

/**
 * @author Maik Kingma
 */

public enum Colors {
    BROWN(new Color(99, 53, 14, 255)),
    LIGHT_BROWN(new Color(134, 77, 29, 255)),
    RED_BROWN(new Color(151, 49, 13, 255)),
    DARK_RED(new Color(87, 7, 7, 255)),
    WHITE(new Color(255, 255, 255, 255)),
    DARK_GREEN(new Color(39, 99, 14, 255)),
    DARK_GRAY_BROWN(new Color(80, 60, 46, 255)),
    LOGO_GREEN(new Color(150, 209, 174, 255)),
    LOGO_BLUE(new Color(22, 181, 210, 255)),
    LOGO_TEXT(new Color(73, 97, 101, 255));

    private final Color color;

    Colors(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
