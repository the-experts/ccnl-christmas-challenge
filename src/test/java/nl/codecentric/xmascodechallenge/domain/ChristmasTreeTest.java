package nl.codecentric.xmascodechallenge.domain;

import io.quarkus.test.junit.QuarkusTest;
import nl.codecentric.xmascodechallenge.shared.Colors;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.awt.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

@QuarkusTest
class ChristmasTreeTest {

/*
*         // prints Tree Stump
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

*
* */

    @Test
    void printToCanvas() {
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        ChristmasTree christmasTree = new ChristmasTree(0, 0);

        christmasTree.printToCanvas(graphics2DMock);
        InOrder inOrder = Mockito.inOrder(graphics2DMock);

        inOrder.verify(graphics2DMock).setColor(Colors.BROWN.getColor());
        inOrder.verify(graphics2DMock).fillRect( 120 , 240, 30, 20);
        inOrder.verify(graphics2DMock).fillRect(110, 260, 50, 10);
        inOrder.verify(graphics2DMock).setColor(Colors.DARK_GREEN.getColor());
        inOrder.verify(graphics2DMock).fillRect(120, 20, 30, 10);
        inOrder.verify(graphics2DMock).fillRect(130, 0, 10, 20);

        inOrder.verify(graphics2DMock, times(11)).fillRect(anyInt(), anyInt(), anyInt(), anyInt());
        //TODO replace with actual value assertions
//        inOrder.verify(graphics2DMock).fillRect(10, 230, 250, 10);
//        inOrder.verify(graphics2DMock).fillRect(120, -230, 10, 20);


    }
}