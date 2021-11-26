package nl.codecentric.xmascodechallenge.domain;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.awt.*;

@QuarkusTest
class SockTest {

    @Test
    void printToCanvas() {
        //given
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        //when
        Sock sock = new Sock(0, 0);
        sock.printToCanvas(graphics2DMock);
        //then
        InOrder inOrder = Mockito.inOrder(graphics2DMock);
        inOrder.verify(graphics2DMock).setColor(Color.white);
        inOrder.verify(graphics2DMock).fillRect(0, 0, 20, 10);
        inOrder.verify(graphics2DMock).setColor(Color.red);
        inOrder.verify(graphics2DMock).fillRect(0, 10, 20, 20);
        inOrder.verify(graphics2DMock).fillRect(0, 30, 30, 10);
    }
}
