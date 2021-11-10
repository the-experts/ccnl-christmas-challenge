package nl.codecentric.xmascodechallenge.domain;


import lombok.AllArgsConstructor;

import java.awt.*;

@AllArgsConstructor
public class Sock {

    private final int x;

    private final int y;

    public void printSock(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(x, y, 20, 10);
        g2d.setColor(Color.red);
        g2d.fillRect(x, y+10, 20, 20);
        g2d.fillRect(x, y+30, 30, 10);
    }
}
