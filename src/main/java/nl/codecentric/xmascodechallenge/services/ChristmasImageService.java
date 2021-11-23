package nl.codecentric.xmascodechallenge.services;

import nl.codecentric.xmascodechallenge.domain.ChristmasTree;
import nl.codecentric.xmascodechallenge.domain.FirePlace;
import nl.codecentric.xmascodechallenge.domain.Firewood;
import nl.codecentric.xmascodechallenge.domain.Logo;
import nl.codecentric.xmascodechallenge.domain.Rug;
import nl.codecentric.xmascodechallenge.domain.Sock;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Maik Kingma / Roger de Jager
 */

@Service
public class ChristmasImageService {

    private static final String CHRISTMAS_IMAGE_JPG = "christmasImage.jpg";
    private static final String JPG = "jpg";
    private static final int WIDTH = 700;
    private static final int HEIGHT = 520;

    public byte[] getChristmasImage() throws IOException {
        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();

        // fill all the image with white
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        setChristmasTree(g2d);
        setRug(g2d);
        setFireplace(g2d);
        setFirewood(g2d);
        setSocks(g2d);
        setLogo(g2d);

        // Disposes of this graphics context and releases any system resources that it is using.
        g2d.dispose();

        // Save as JPEG
        File file = new File(CHRISTMAS_IMAGE_JPG);
        ImageIO.write(bufferedImage, JPG, file);
        InputStream in = new FileInputStream(file);
        byte[] bytes = in.readAllBytes();
        in.close();
        return bytes;
    }

    private void setRug(Graphics2D g2d) {
        Rug rug = new Rug(370, 330);
        rug.printRug(g2d);
    }

    private void setFireplace(Graphics2D g2d) {
        FirePlace firePlace = new FirePlace(400, 120);
        firePlace.printToCanvas(g2d);
    }


    private void setFirewood(Graphics2D g2d) {
        Firewood firewood = new Firewood(440, 200);
        firewood.printFirewood(g2d);
    }

    private void setSocks(Graphics2D g2d) {
        Sock sock = new Sock(430, 130);
        sock.printToCanvas(g2d);
        Sock sock2 = new Sock(470, 130);
        sock2.printToCanvas(g2d);
        Sock sock3 = new Sock(510, 130);
        sock3.printToCanvas(g2d);
    }

    private void setChristmasTree(Graphics2D g2d) {
        ChristmasTree christmasTree = new ChristmasTree(50, 50);
        christmasTree.printToCanvas(g2d);
    }

    private void setLogo(Graphics2D g2d) {
        Logo logo = new Logo(40, 440);
        logo.printLogo(g2d);
    }
}
