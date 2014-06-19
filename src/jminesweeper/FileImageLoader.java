package jminesweeper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FileImageLoader {

    public static GameController controller;

    public static void setController(GameController controller) {
        FileImageLoader.controller = controller;
    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            controller.couldNotOpenFile();
            return null;
        }
    }
}
