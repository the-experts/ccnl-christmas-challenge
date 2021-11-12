package nl.codecentric.xmascodechallenge.domain;

import lombok.AllArgsConstructor;
import nl.codecentric.xmascodechallenge.shared.Colors;

import java.awt.*;

@AllArgsConstructor
public class Rug {

    private final int x;

    private final int y;

    public void printRug(Graphics2D g2d){
        g2d.setColor(Colors.DARK_RED.getColor());
        for (int xVar = x - 10; xVar < x + 240; xVar = xVar + 10) {
            for (int yVar = y - 10; yVar < y + 60; yVar = yVar + 10) {
                System.out.println("" + xVar + "" +yVar);
                if (g2d.getColor().equals(Colors.DARK_RED.getColor())) {
                    g2d.setColor(Colors.WHITE.getColor());
                } else {
                    g2d.setColor(Colors.DARK_RED.getColor());
                }
                g2d.fillRect(xVar, yVar, 10, 10);
            }
        }
        g2d.setColor(Colors.DARK_RED.getColor());
        g2d.fillRect(x, y, 230, 50);
        g2d.setColor(Colors.DARK_GRAY_BROWN.getColor());
        g2d.fillRect(x+10,  y+10, 210, 30);

    }
}
