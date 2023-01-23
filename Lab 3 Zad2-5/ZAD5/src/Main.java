public class Main {

    public static void main(String[] args) {
        Czasomierz czasomierz = new Czasomierz();
        czasomierz.mierz();

        Samochod s1 = new Samochod("BI 12234", 6);
        Samochod s2 = new Samochod("RZE 3137", 9);
        Samochod s3 = new Samochod("GDA 1234", 12);
        s1.start();
        s2.start();
        s3.start();


        final Filozof[] filozofy = new Filozof[5];
        Object[] widelce = new Object[filozofy.length];

        for (int i = 0; i < widelce.length; i++) {
            widelce[i] = new Object();
        }

        for (int i = 0; i < filozofy.length; i++) {
            Object lewywidelec = widelce[i];
            Object prawywidelec = widelce[(i + 1) % widelce.length];

            if (i == filozofy.length - 1) {
                filozofy[i] = new Filozof(prawywidelec, lewywidelec);
            } else {
                filozofy[i] = new Filozof(lewywidelec, prawywidelec);
            }

            Thread t
                    = new Thread(filozofy[i], "Filozof " + (i + 1));
            t.start();
        }



    }
}

    /*"Czasomierz" który po uruchomieniu metody 'mierz'
        zaczyna liczyć czas w sekundach i wypisuje te wartości na ekranie.
        Kiedy upłynie 60 sekund, zatrzymuje się.
        Drugim procesem jest symulacja ruchu trzech samochodów,
        które są reprezentowane przez klasę "Samochod",
        każdy z nich ma swój unikalny numer rejestracyjny oraz prędkość.
        Trzecim procesem jest problem Dining Philosophers,
        który rozwiązuje problem synchronizacji i deadlock.
        W tej symulacji filozofowie są reprezentowani
        przez klasę "Filozof", którzy próbują jednocześnie korzystać z dwóch widełek.*/