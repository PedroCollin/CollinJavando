import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    


    public void cria(InputStream inputStream, String nomeArqv) throws Exception{

        // Read a image
        // InputStream inputStream = new FileInputStream("entrada/filme.jpg");
        // InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Create a image in memory at transparent and new size
        int width = imagemOriginal.getWidth();
        int height = imagemOriginal.getHeight();
        int newSize = height + 200;
        BufferedImage newImage = new BufferedImage(width, newSize, BufferedImage.TRANSLUCENT);

        // copy a default image to new memory image
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Set Font text
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.MAGENTA);
        graphics.setFont(font);

        // write a text
        graphics.drawString("NAOTOINTENDENDO", 0, newSize-100);

        // Write a new image in a file
        ImageIO.write(newImage, "png", new File(nomeArqv));

    }

}
