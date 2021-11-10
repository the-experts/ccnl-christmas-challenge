package nl.codecentric.xmascodechallenge.domain;

import lombok.AllArgsConstructor;
import nl.codecentric.xmascodechallenge.shared.Colors;

import java.awt.*;

@AllArgsConstructor
public class Rug {

    private final int x;

    private final int y;

    public void printRug(Graphics2D g2d){
        g2d.setColor(Colors.LIGHT_GRAY_BROWN.getColor());
        g2d.fillRect(x, y, 240, 50);
        g2d.setColor(Colors.DARK_GRAY_BROWN.getColor());
        g2d.fillRect(x+10,  y+10, 220, 30);
    }
}
