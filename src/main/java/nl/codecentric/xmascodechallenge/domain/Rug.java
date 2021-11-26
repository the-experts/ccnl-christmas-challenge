package nl.codecentric.xmascodechallenge.domain;

import lombok.AllArgsConstructor;
import nl.codecentric.xmascodechallenge.shared.Colors;

import java.awt.*;

@AllArgsConstructor
public class Rug {

    private final int x;

    private final int y;

    public void printToCanvas(Graphics2D g2d){
        g2d.setColor(Colors.WHITE.getColor());
        for (int xVar = x; xVar < x + 250; xVar = xVar + 10) {
            for (int yVar = y +3; yVar < y + 50; yVar = yVar + 5) {
                if (g2d.getColor().equals(Colors.DARK_RED.getColor())) {
                    g2d.setColor(Colors.WHITE.getColor());
                } else {
                    g2d.setColor(Colors.DARK_RED.getColor());
                }
                g2d.fillRect(xVar, yVar, 10, 5);
            }
        }
        g2d.setColor(Colors.DARK_RED.getColor());
        g2d.fillRect(x + 10, y, 230, 50);
        g2d.setColor(Colors.DARK_GRAY_BROWN.getColor());
        g2d.fillRect(x+20,  y+10, 210, 30);

    }
}
