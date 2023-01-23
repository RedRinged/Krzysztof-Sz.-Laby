import java.awt.*;
import java.awt.image.BufferedImage;

public class ChangeToGrayScale extends Thread{
    public BufferedImage image;
    int widthStart;
    int widthEnd;

    public ChangeToGrayScale(BufferedImage b, int widthStart, int widthEnd) {
        this.image = b;
        this.widthStart = widthStart;
        this.widthEnd = widthEnd;
    }

    @Override
    public void run(){
        if (this.image != null) {
            for(int i=1; i<this.image.getHeight()-1; i++){
                for(int j=this.widthStart; j<this.widthEnd-1; j++){

                    //odczyt składowych koloru RGB
                    Color c = new Color(image.getRGB(j, i));
                    int red = (int)(c.getRed());
                    int green = (int)(c.getGreen());
                    int blue = (int)(c.getBlue());

                    int final_red, final_green, final_blue;

                    //negatyw
                    final_red = 255-red;
                    final_green = 255-green;
                    final_blue = 255-blue;
                    Color newColor = new Color(final_red, final_green, final_blue);
                    image.setRGB(j,i,newColor.getRGB());
                } //koniec dwóch pętli po kolumnach i wierszach obrazu
            }
        }
    }
}
 /*Klasa ChangeToGrayScale jest rozszerzeniem klasy Thread
    i służy do zmiany koloru obrazu na skalę szarości.
        Zawiera ona pola prywatne, takie jak obraz (image),
        początek szerokości (widthStart) i koniec szerokości (widthEnd).
        Klasa ta posiada konstruktor, który inicjuje te pola za pomocą
        przekazanych argumentów, oraz metodę run(), która jest uruchamiana,
        gdy wywoływana jest metoda start() na obiekcie klasy ChangeToGrayScale.
        Metoda run() sprawdza czy obraz jest nullem, następnie przechodzi
        przez każdy piksel na obrazie i odczytuje składowe koloru RGB,
        a następnie wykonuje negatyw koloru na każdej składowej i zapisuje nowy kolor w obrazie.
        Używa on także klas Color i BufferedImage z pakietu java.awt.*
        oraz java.awt.image do przetwarzania i przechowywania obrazów.*/