package nl.codecentric.xmascodechallenge.domain;

import io.quarkus.test.junit.QuarkusTest;
import nl.codecentric.xmascodechallenge.shared.Colors;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

@QuarkusTest
class FirePlaceTest {

    @Test
    void printToCanvas() {
        //given
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        Mockito.when(graphics2DMock.getColor()).thenReturn(Colors.RED_BROWN.getColor());
        //when
        FirePlace firePlace = new FirePlace(0, 0);
        firePlace.printToCanvas(graphics2DMock);
        //then
        Mockito.verify(graphics2DMock, times(1)).setColor(Colors.DARK_GREEN.getColor());
        Mockito.verify(graphics2DMock, times(1)).setColor(Colors.BROWN.getColor());
        Mockito.verify(graphics2DMock, times(1)).setColor(Colors.RED_BROWN.getColor());
        Mockito.verify(graphics2DMock, times(104)).setColor(Colors.LIGHT_BROWN.getColor());
        Mockito.verify(graphics2DMock, times(106)).fillRect(anyInt(), anyInt(), anyInt(), anyInt());

    }
}
