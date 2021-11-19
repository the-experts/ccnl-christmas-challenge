package nl.codecentric.xmascodechallenge.domain;

import lombok.AllArgsConstructor;
import nl.codecentric.xmascodechallenge.shared.Colors;

import java.awt.*;

/**
 * @author Maik Kingma
 */
@AllArgsConstructor
public class ChristmasTree {

    private static final int MAX_WIDTH = 300;
    private static final int LINE_WIDTH = 20;
    private static final int MAX_HEIGHT = 220;
    private static final int COLUMN_WIDTH = 10;

    private final int xRoot;
    private final int yRoot;

    public void printToCanvas(Graphics2D g2d) {
        // prints Tree Stump
        g2d.setColor(Colors.BROWN.getColor());
        g2d.fillRect(xRoot - 30 + (MAX_WIDTH / 2) , yRoot + MAX_HEIGHT + 20, 30, 20);
        g2d.fillRect(xRoot - 40 + (MAX_WIDTH / 2) , yRoot + MAX_HEIGHT + 40, 50, 10);

        // prints Tree
        g2d.setColor(Colors.DARK_GREEN.getColor());
//        g2d.fillRect(xRoot, yRoot, 250, 10);
        int treeWidth = 30;
        int xStart = xRoot - 30 + (MAX_WIDTH / 2) ;
        g2d.fillRect(xStart, yRoot + 20, 30, 10);
        g2d.fillRect(xStart + 10, yRoot, 10, 20);

        for (int y = yRoot + 30; y < (yRoot + MAX_HEIGHT); y = y + LINE_WIDTH) {
            xStart -= COLUMN_WIDTH;
            treeWidth = treeWidth + 20;
            g2d.fillRect(xStart, y, treeWidth, 20);
        }
        g2d.fillRect(xStart - 10, yRoot + MAX_HEIGHT + 10, MAX_WIDTH - 50, 10);

    }
}
