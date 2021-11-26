package nl.codecentric.xmascodechallenge.domain;


import lombok.AllArgsConstructor;
import nl.codecentric.xmascodechallenge.shared.Colors;

import java.awt.*;

@AllArgsConstructor
public class Logo {

    private final int x;

    private final int y;

    public void printToCanvas(Graphics2D g2d) {
        printIcon(g2d);
        setLetterC(g2d, x+100);
        setLetterO(g2d, x+150);
        setLetterD(g2d, x+200);
        setLetterE(g2d, x+260);
        setLetterC(g2d, x+330);
        setLetterE(g2d, x+360);
        setLetterN(g2d, x+410);
        setLetterT(g2d, x+460);
        setLetterR(g2d, x+520);
        setLetterI(g2d, x+580);
        setLetterC(g2d, x+620);
    }

    public void printIcon(Graphics2D g2d) {
        g2d.setColor(Colors.LOGO_BLUE.getColor());
        g2d.fillRect(x, y, 40, 10);
        g2d.fillRect(x-10, y+10, 10, 10);
        g2d.fillRect(x+40, y+10, 10, 10);
        g2d.fillRect(x-20, y+20, 10, 30);
        g2d.fillRect(x+10, y+20, 30, 10);
        g2d.fillRect(x-10, y+50, 10, 10);
        g2d.fillRect(x, y+60, 40, 10);

        g2d.setColor(Colors.LOGO_GREEN.getColor());
        g2d.fillRect(x, y+30, 10, 10);
        g2d.fillRect(x+10, y+40, 40, 10);
        g2d.fillRect(x+20, y-20, 40, 10);
        g2d.fillRect(x+60, y-10, 10, 10);
        g2d.fillRect(x+60, y+20, 10, 10);
        g2d.fillRect(x+50, y+30, 10, 10);
        g2d.fillRect(x+70, y, 10, 20);
    }

    public void setLetterC(Graphics2D g2d, int startX) {
        g2d.setColor(Colors.LOGO_TEXT.getColor());
        g2d.fillRect(startX, y+10, 20, 10);
        g2d.fillRect(startX-10, y+20, 10, 10);
        g2d.fillRect(startX-20, y+30, 10, 20);
        g2d.fillRect(startX-10, y+50, 10, 10);
        g2d.fillRect(startX, y+60, 20, 10);
    }

    public void setLetterO(Graphics2D g2d, int startX) {
        g2d.setColor(Colors.LOGO_TEXT.getColor());
        g2d.fillRect(startX, y+10, 20, 10);
        g2d.fillRect(startX-10, y+20, 10, 10);
        g2d.fillRect(startX-20, y+30, 10, 20);
        g2d.fillRect(startX-10, y+50, 10, 10);
        g2d.fillRect(startX, y+60, 20, 10);
        g2d.fillRect(startX+20, y+20, 10, 10);
        g2d.fillRect(startX+30, y+30, 10, 20);
        g2d.fillRect(startX+20, y+50, 10, 10);
    }

    public void setLetterD(Graphics2D g2d, int startX) {
        g2d.setColor(Colors.LOGO_TEXT.getColor());
        g2d.fillRect(startX, y+10, 10, 60);
        g2d.fillRect(startX+10, y+10, 20, 10);
        g2d.fillRect(startX+10, y+60, 20, 10);
        g2d.fillRect(startX+30, y+20, 10, 10);
        g2d.fillRect(startX+30, y+50, 10, 10);
        g2d.fillRect(startX+40, y+30, 10, 20);
    }

    public void setLetterE(Graphics2D g2d, int startX) {
        g2d.setColor(Colors.LOGO_TEXT.getColor());
        g2d.fillRect(startX, y+10, 10, 60);
        g2d.fillRect(startX+10, y+10, 30, 10);
        g2d.fillRect(startX+10, y+30, 30, 10);
        g2d.fillRect(startX+10, y+60, 30, 10);
    }

    public void setLetterN(Graphics2D g2d, int startX) {
        g2d.setColor(Colors.LOGO_TEXT.getColor());
        g2d.fillRect(startX, y+10, 10, 60);
        g2d.fillRect(startX+10, y+10, 20, 10);
        g2d.fillRect(startX+30, y+10, 10, 60);
    }

    public void setLetterT(Graphics2D g2d, int startX) {
        g2d.setColor(Colors.LOGO_TEXT.getColor());
        g2d.fillRect(startX, y+10, 50, 10);
        g2d.fillRect(startX+20, y+20, 10, 50);
    }

    public void setLetterR(Graphics2D g2d, int startX) {
        g2d.setColor(Colors.LOGO_TEXT.getColor());
        g2d.fillRect(startX, y+10, 10, 60);
        g2d.fillRect(startX+10, y+30, 10, 10);
        g2d.fillRect(startX+20, y+20, 10, 10);
        g2d.fillRect(startX+30, y+10, 20, 10);
    }

    public void setLetterI(Graphics2D g2d, int startX) {
        g2d.setColor(Colors.LOGO_TEXT.getColor());
        g2d.fillRect(startX, y, 10, 10);
        g2d.fillRect(startX, y+20, 10, 50);
    }
}
