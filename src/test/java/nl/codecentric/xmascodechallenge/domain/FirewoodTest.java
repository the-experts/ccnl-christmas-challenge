package nl.codecentric.xmascodechallenge.domain;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.awt.*;

@QuarkusTest
class FirewoodTest {

    @Test
    void printToCanvas() {
        //given
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        //when
        Firewood firewood = new Firewood(0, 0);
        firewood.printToCanvas(graphics2DMock);

        InOrder inOrder = Mockito.inOrder(graphics2DMock);
        inOrder.verify(graphics2DMock).setColor(Color.pink);
        inOrder.verify(graphics2DMock).fillRect(0, 0, 100, 70);
        inOrder.verify(graphics2DMock).setColor(Color.black);
        inOrder.verify(graphics2DMock).fillRect(10, 10, 80, 50);
        inOrder.verify(graphics2DMock).setColor(Color.red);
        inOrder.verify(graphics2DMock).fillRect(20, 50, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(30, 40, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(30, 30, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(40, 20, 20, 10);
        inOrder.verify(graphics2DMock).fillRect(60, 30, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(60, 40, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(70, 50, 10, 10);
        inOrder.verify(graphics2DMock).setColor(Color.pink);
        inOrder.verify(graphics2DMock).fillRect(40, 30, 20, 10);
        inOrder.verify(graphics2DMock).fillRect(60, 50, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(30, 50, 10, 10);
        inOrder.verify(graphics2DMock).setColor(Color.yellow);
        inOrder.verify(graphics2DMock).fillRect(40, 40, 20, 20);
    }
}
