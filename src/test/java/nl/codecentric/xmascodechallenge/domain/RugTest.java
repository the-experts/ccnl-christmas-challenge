package nl.codecentric.xmascodechallenge.domain;

import io.quarkus.test.junit.QuarkusTest;
import nl.codecentric.xmascodechallenge.shared.Colors;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.awt.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

@QuarkusTest
class RugTest {

    @Test
    void printToCanvas() {
        //given
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        Mockito.when(graphics2DMock.getColor()).thenReturn(Colors.WHITE.getColor());
        //when
        Rug rug = new Rug(0, 0);
        rug.printToCanvas(graphics2DMock);
        //then
        Mockito.verify(graphics2DMock, times(1)).setColor(Colors.WHITE.getColor());
        Mockito.verify(graphics2DMock, times(251)).setColor(Colors.DARK_RED.getColor());
        Mockito.verify(graphics2DMock, times(1)).setColor(Colors.DARK_GRAY_BROWN.getColor());
        Mockito.verify(graphics2DMock, times(252)).fillRect(anyInt(), anyInt(), anyInt(), anyInt());

    }
}
