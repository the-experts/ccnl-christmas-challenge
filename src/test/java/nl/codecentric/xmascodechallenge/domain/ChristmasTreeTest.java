package nl.codecentric.xmascodechallenge.domain;

import io.quarkus.test.junit.QuarkusTest;
import nl.codecentric.xmascodechallenge.shared.Colors;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.awt.*;

@QuarkusTest
class ChristmasTreeTest {

    /*
    *         // prints Tree Stump
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
    * */

    @Test
    void printToCanvas() {
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        ChristmasTree christmasTree = new ChristmasTree(0, 0);

        christmasTree.printToCanvas(graphics2DMock);
        InOrder inOrder = Mockito.inOrder(graphics2DMock);

        inOrder.verify(graphics2DMock).setColor(Colors.BROWN.getColor());
        inOrder.verify(graphics2DMock).fillRect(110, 10, 30, 20);
        inOrder.verify(graphics2DMock).fillRect(100,  30, 50, 10);
        inOrder.verify(graphics2DMock).setColor(Colors.DARK_GREEN.getColor());
        inOrder.verify(graphics2DMock).fillRect(0, 0, 250, 10);
//        inOrder.verify(graphics2DMock, times(2)).fillRect(anyInt(), anyInt(), anyInt(), anyInt());
//        inOrder.verify(graphics2DMock).fillRect(110, -210, 30, 10);
//        inOrder.verify(graphics2DMock).fillRect(120, -230, 10, 20);


    }
}