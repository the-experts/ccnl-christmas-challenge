package nl.codecentric.xmascodechallenge.domain;

import lombok.AllArgsConstructor;
import nl.codecentric.xmascodechallenge.shared.Colors;

import java.awt.*;

/**
 * @author Maik Kingma
 */
@AllArgsConstructor
public class ChristmasTree {

    private static final int MAX_WIDTH = 250;
    private static final int LINE_WIDTH = 20;
    private static final int MAX_HEIGHT = 110;
    private static final int COLUMN_WIDTH = 10;

    private final int xRoot;
    private final int yRoot;

    public void printToCanvas(Graphics2D g2d) {
        // prints Tree Stump
        g2d.setColor(Colors.BROWN.getColor());
        g2d.fillRect(xRoot + 110, yRoot + 10, 30, 20);
        g2d.fillRect(xRoot + 100, yRoot + 30, 50, 10);

        // prints Tree
        g2d.setColor(Colors.DARK_GREEN.getColor());
        g2d.fillRect(xRoot, yRoot, 250, 10);
        int currentY = MAX_WIDTH;
        int xStart = xRoot;
        for (int y = yRoot - LINE_WIDTH; y > MAX_HEIGHT; y = y - LINE_WIDTH) {
            xStart += COLUMN_WIDTH;
            currentY = currentY - LINE_WIDTH;
            g2d.fillRect(xStart, y, currentY, LINE_WIDTH);
        }
        g2d.fillRect(xRoot + 110, yRoot - 210, 30, 10);
        g2d.fillRect(xRoot + 120, yRoot - 230, 10, 20);
    }
}
