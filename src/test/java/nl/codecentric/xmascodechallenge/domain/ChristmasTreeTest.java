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
    }
}