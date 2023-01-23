import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        final int THREADS = 4;
        final int TRIALS = 100000;
        final double CIRCLE_RADIUS = 3;
        final Pkt2D squareCenter = new Pkt2D(CIRCLE_RADIUS, CIRCLE_RADIUS);
        final double squareSide = 2 * CIRCLE_RADIUS;
        final double squareArea = Math.pow(squareSide, 2);
        final double PRECISE_CIRCLE_AREA = Math.PI * Math.pow(CIRCLE_RADIUS, 2);

        final int TRIALS_IN_THREAD = TRIALS / THREADS;

        ArrayList<ObszarKola> monteCarloThreads = new ArrayList<>();
        for (int i = 0; i < THREADS; i++) {
            ObszarKola t = new ObszarKola(TRIALS_IN_THREAD, squareSide, squareCenter, CIRCLE_RADIUS, squareArea);
            monteCarloThreads.add(t);
            monteCarloThreads.get(i).start();
            monteCarloThreads.get(i).join();
        }

        double sumOfAreas = 0;
        for (ObszarKola monteCardloResult: monteCarloThreads
        ) {
            sumOfAreas += monteCardloResult.getResult();
        }

        double predictedCircleArea = (double)sumOfAreas / (double)THREADS;

        System.out.println("Dokladne pole kola: " + PRECISE_CIRCLE_AREA);
        System.out.println("Pole kola obliczone za pomoca symulacji: " + predictedCircleArea);
    }
}

    /*Metoda main() inicjuje kilka stałych,
    takich jak liczba wątków (THREADS), liczba prób (TRIALS),
        promień koła (CIRCLE_RADIUS), środek kwadratu (squareCenter),
        bok kwadratu (squareSide) i powierzchnię kwadratu (squareArea),
        oraz dokładną powierzchnię koła (PRECISE_CIRCLE_AREA).
        Następnie tworzy listę obiektów klasy ObszarKola,
        które są uruchamiane jako wątki i wykonują obliczenia
        dotyczące powierzchni koła. Po zakończeniu działania
        wszystkich wątków, sumują one wyniki i obliczają średnią
        powierzchnię koła, która jest wypisywana na ekranie.
        Program używa także metody ThreadLocalRandom.current().nextDouble()
        z java.util.concurrent.ThreadLocalRandom do generowania
        losowych punktów na kwadracie, a także ArrayList do przechowywania wątków.*/