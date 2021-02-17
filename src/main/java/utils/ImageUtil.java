package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class ImageUtil {

    public static void displayImage(String image) {
        byte[] decodedImg = Base64.getDecoder()
                .decode(image.getBytes(StandardCharsets.UTF_8));
        String name = String.format("image%s.jpg", System.currentTimeMillis());
        String path = "images";
        Path destinationFile = Paths.get(path, name);
        try {
            Files.write(destinationFile, decodedImg);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path + "/" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(img);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(1000, 1000);
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
    }

}
