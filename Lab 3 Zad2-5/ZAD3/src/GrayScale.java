import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class GrayScale {
    BufferedImage image;
    int width;
    int height;
    public GrayScale() {
        try {
            int NUM_OF_THREADS = 4;
            //odczyt obrazu z pliku
            File input = new File("laka.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
            int widthPerThread = image.getWidth() / NUM_OF_THREADS;
            for (int i = 0; i < NUM_OF_THREADS; i++) {
                int start = i * widthPerThread;
                int end = (i + 1) * widthPerThread + 1;
                ChangeToGrayScale thread = new ChangeToGrayScale(image, start, end);
                thread.start();
                thread.join();
            }

            File ouptut = new File("grayscale.jpg");
            ImageIO.write(image, "jpg", ouptut);
        } catch (Exception e) {}
    }
    static public void main(String args[]) throws Exception
    {
        GrayScale obj = new GrayScale();
    }
}

   /* Klasa GrayScale jest klasą, która służy do zmiany koloru obrazu na skalę szarości.
        Wczytuje ona obraz z pliku, tworzy wiele wątków klasy ChangeToGrayScale,
        które przetwarzają obraz na skalę szarości, a następnie zapisuje go do pliku.
        Klasa ta posiada pola prywatne, takie jak obraz (image),
        szerokość (width) i wysokość (height) obrazu.
        Konstruktor klasy GrayScale odczytuje obraz z pliku,
        przydziela obszary obrazu do przetwarzania przez poszczególne wątki,
        uruchamia te wątki i po zakończeniu ich pracy zapisuje obraz do pliku.
        Używa on także klas File, ImageIO z pakietu java.io,
        java.awt.image.BufferedImage oraz javax.imageio.ImageIO
        do przetwarzania i przechowywania obrazów.*/
