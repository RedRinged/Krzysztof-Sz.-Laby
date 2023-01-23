import java.util.concurrent.ThreadLocalRandom;

public class ObszarKola extends Thread{
    private int TRIALS;
    private double result;
    private double squareSide;
    private Pkt2D squareCenter;
    private double circleRadius;
    private double squareArea;

    public ObszarKola(int t, double squareSide, Pkt2D squareCenter, double circRadius, double squareArea) {
        this.squareSide = squareSide;
        this.squareCenter = squareCenter;
        this.circleRadius = circRadius;
        this.squareArea = squareArea;
        this.TRIALS = t;
    }

    public void run() {
        int insideCircle = 0;
        for (int i = 0; i < TRIALS; i++) {
            double x = ThreadLocalRandom.current().nextDouble(0, squareSide);
            double y = ThreadLocalRandom.current().nextDouble(0, squareSide);
            Pkt2D randomPoint = new Pkt2D(x, y);
            double distanceToCircleCenter = randomPoint.distanceFrom(squareCenter);
            if (distanceToCircleCenter <= circleRadius) {
                insideCircle += 1;
            }
        }

        double probabilityOfPointInCircle = (double)insideCircle / (double)TRIALS;
        double simulatedCircleArea = probabilityOfPointInCircle * squareArea;
        this.result = simulatedCircleArea;
    }

    public double getResult() {
        return this.result;
    }
}

//Klasa ObszarKola jest rozszerzeniem klasy Thread i służy do
   // obliczania powierzchni koła za pomocą metody Monte Carlo.
       // Zawiera ona pola prywatne, takie jak liczba prób (TRIALS),
      //  wynik, bok kwadratu (squareSide), środek kwadratu (squareCenter),
       // promień koła (circleRadius) i powierzchnię kwadratu (squareArea).
       // Klasa ta posiada konstruktor, który inicjuje te pola za pomocą
      //  przekazanych argumentów, oraz metodę run(), która jest uruchamiana,
       // gdy wywoływana jest metoda start() na obiekcie klasy ObszarKola.
       // Metoda run() generuje losowe punkty na kwadracie, sprawdza,
       // czy znajdują się one wewnątrz koła i oblicza powierzchnię
       // koła za pomocą metody Monte Carlo. Wynik jest zapisywany
       // w polu prywatnym "result" i dostępny za pomocą metody getResult().