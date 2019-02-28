package Misc;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AsciiArt {

    public static void main(String[] args) throws IOException {

        int width = 60;
        int height = 60;

        //BufferedImage image = ImageIO.read(new File("/Users/mkyong/Desktop/logo.jpg"));
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("sans", Font.CENTER_BASELINE,12));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("你好", 18, 34);

        //save this image
        //ImageIO.write(image, "png", new File("/users/mkyong/ascii-art.png"));

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "¤");
            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }
            System.out.println(sb);
            
        }

    }

}