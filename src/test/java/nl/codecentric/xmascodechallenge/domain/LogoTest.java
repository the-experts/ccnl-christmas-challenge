package nl.codecentric.xmascodechallenge.domain;

import io.quarkus.test.junit.QuarkusTest;
import nl.codecentric.xmascodechallenge.shared.Colors;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.awt.*;

@QuarkusTest
class LogoTest {

    @Test
    void printIcon() {
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        Logo logo = new Logo(0, 0);
        logo.printIcon(graphics2DMock);
        InOrder inOrder = Mockito.inOrder(graphics2DMock);
        inOrder.verify(graphics2DMock).setColor(Colors.LOGO_BLUE.getColor());
        inOrder.verify(graphics2DMock).fillRect(0,0, 40, 10);
        inOrder.verify(graphics2DMock).fillRect(-10, 10, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(40, 10, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(-20, 20, 10, 30);
        inOrder.verify(graphics2DMock).fillRect(10, 20, 30, 10);
        inOrder.verify(graphics2DMock).fillRect(-10, 50, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(0, 60, 40, 10);

        inOrder.verify(graphics2DMock).setColor(Colors.LOGO_GREEN.getColor());
        inOrder.verify(graphics2DMock).fillRect(0,30, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(+10, 40, 40, 10);
        inOrder.verify(graphics2DMock).fillRect(+20, -20, 40, 10);
        inOrder.verify(graphics2DMock).fillRect(+60, -10, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(+60, 20, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(+50, 30, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(+70, 0, 10, 20);
    }
    
    @Test
    void printLetterC() {
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        Logo logo = new Logo(0, 0);
        logo.setLetterC(graphics2DMock, 0);
        InOrder inOrder = Mockito.inOrder(graphics2DMock);

        inOrder.verify(graphics2DMock).setColor(Colors.LOGO_TEXT.getColor());
        inOrder.verify(graphics2DMock).fillRect(0, 10, 20, 10);
        inOrder.verify(graphics2DMock).fillRect(-10, 20, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(-20, 30, 10, 20);
        inOrder.verify(graphics2DMock).fillRect(-10, 50, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(0, 60, 20, 10);
    }
    
    @Test
    void printLetterO() {
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        Logo logo = new Logo(0, 0);
        logo.setLetterO(graphics2DMock, 0);
        InOrder inOrder = Mockito.inOrder(graphics2DMock);
        inOrder.verify(graphics2DMock).setColor(Colors.LOGO_TEXT.getColor());
        inOrder.verify(graphics2DMock).fillRect(0, 10, 20, 10);
        inOrder.verify(graphics2DMock).fillRect(-10, 20, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(-20, 30, 10, 20);
        inOrder.verify(graphics2DMock).fillRect(-10, 50, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(0, 60, 20, 10);
        inOrder.verify(graphics2DMock).fillRect(20, 20, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(30, 30, 10, 20);
        inOrder.verify(graphics2DMock).fillRect(20, 50, 10, 10);
    }
    
    @Test
    void printLetterD() {
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        Logo logo = new Logo(0, 0);
        logo.setLetterD(graphics2DMock, 0);
        InOrder inOrder = Mockito.inOrder(graphics2DMock);
        inOrder.verify(graphics2DMock).setColor(Colors.LOGO_TEXT.getColor());
        inOrder.verify(graphics2DMock).fillRect(0, 10, 10, 60);
        inOrder.verify(graphics2DMock).fillRect(10, 10, 20, 10);
        inOrder.verify(graphics2DMock).fillRect(10, 60, 20, 10);
        inOrder.verify(graphics2DMock).fillRect(30, 20, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(30, 50, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(40, 30, 10, 20);
    }
    
    @Test
    void printLetterE() {
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        Logo logo = new Logo(0, 0);
        logo.setLetterE(graphics2DMock, 0);
        InOrder inOrder = Mockito.inOrder(graphics2DMock);
        inOrder.verify(graphics2DMock).setColor(Colors.LOGO_TEXT.getColor());
        inOrder.verify(graphics2DMock).fillRect(0, 10, 10, 60);
        inOrder.verify(graphics2DMock).fillRect(10, 10, 30, 10);
        inOrder.verify(graphics2DMock).fillRect(10, 30, 30, 10);
        inOrder.verify(graphics2DMock).fillRect(10, 60, 30, 10);
    }
    
    @Test
    void printLetterN() {
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        Logo logo = new Logo(0, 0);
        logo.setLetterN(graphics2DMock, 0);
        InOrder inOrder = Mockito.inOrder(graphics2DMock);
        inOrder.verify(graphics2DMock).setColor(Colors.LOGO_TEXT.getColor());
        inOrder.verify(graphics2DMock).fillRect(0, 10, 10, 60);
        inOrder.verify(graphics2DMock).fillRect(10, 10, 20, 10);
        inOrder.verify(graphics2DMock).fillRect(30, 10, 10, 60);
    }
    
    @Test
    void printLetterT() {
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        Logo logo = new Logo(0, 0);
        logo.setLetterT(graphics2DMock, 0);
        InOrder inOrder = Mockito.inOrder(graphics2DMock);
        inOrder.verify(graphics2DMock).setColor(Colors.LOGO_TEXT.getColor());
        inOrder.verify(graphics2DMock).fillRect(0, 10, 50, 10);
        inOrder.verify(graphics2DMock).fillRect(20, 20, 10, 50);
    }
    
    @Test
    void printLetterR() {
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        Logo logo = new Logo(0, 0);
        logo.setLetterR(graphics2DMock, 0);
        InOrder inOrder = Mockito.inOrder(graphics2DMock);
        inOrder.verify(graphics2DMock).setColor(Colors.LOGO_TEXT.getColor());
        inOrder.verify(graphics2DMock).fillRect(0, 10, 10, 60);
        inOrder.verify(graphics2DMock).fillRect(10, 30, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(20, 20, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(30, 10, 20, 10);
    }
    
    @Test
    void printLetterI() {
        Graphics2D graphics2DMock = Mockito.mock(Graphics2D.class);
        Logo logo = new Logo(0, 0);
        logo.setLetterI(graphics2DMock, 0);
        InOrder inOrder = Mockito.inOrder(graphics2DMock);
        inOrder.verify(graphics2DMock).setColor(Colors.LOGO_TEXT.getColor());
        inOrder.verify(graphics2DMock).fillRect(0, 0, 10, 10);
        inOrder.verify(graphics2DMock).fillRect(0, 20, 10, 50);
    }
}
