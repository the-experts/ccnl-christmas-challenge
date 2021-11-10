package nl.codecentric.xmascodechallenge.domain;

import lombok.AllArgsConstructor;
import nl.codecentric.xmascodechallenge.shared.Colors;

import java.awt.*;

/**
 * @author Maik Kingma
 */

@AllArgsConstructor
public class FirePlace {

    private static final int COLUMN_WIDTH = 20;
    private static final int LINE_WIDTH = 10;

    private final int xRoot;
    private final int yRoot;

    public void printToCanvas(Graphics2D g2d) {
        g2d.setColor(Colors.DARK_GREEN.getColor());
        g2d.fillRect(xRoot, yRoot, 180, 10);
        g2d.setColor(Colors.BROWN.getColor());
        g2d.fillRect(xRoot, yRoot + 10, 180, 170);
        g2d.setColor(Colors.RED_BROWN.getColor());
        for (int x = xRoot + 10; x < xRoot + 170; x = x + COLUMN_WIDTH) {
            for (int y = yRoot + 40; y < yRoot + 170; y = y + LINE_WIDTH) {
                if (g2d.getColor().equals(Colors.RED_BROWN.getColor())) {
                    g2d.setColor(Colors.LIGHT_BROWN.getColor());
                } else {
                    g2d.setColor(Colors.RED_BROWN.getColor());
                }
                g2d.fillRect(x, y, COLUMN_WIDTH, LINE_WIDTH);
            }
        }
    }
}
