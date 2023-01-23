public class Filozof implements Runnable {


    private Object lewywidelec;
    private Object prawywidelec;

    public Filozof(Object leftFork, Object rightFork) {
        this.lewywidelec = leftFork;
        this.prawywidelec = rightFork;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    public void run() {
        try {
            while (true) {

                doAction(System.nanoTime() + ": mysli");
                synchronized (lewywidelec) {
                    doAction(
                            System.nanoTime()
                                    + ": podniosl lewy widelec");
                    synchronized (prawywidelec) {
                        doAction(
                                System.nanoTime()
                                        + ": podniosl prawy widelec i zaczal jesc");

                        doAction(
                                System.nanoTime()
                                        + ": odlozyl prawy widelec");
                    }

                    doAction(
                            System.nanoTime()
                                    + ": odlozyl lewy widelec - wraca do rozmyslania");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

}

    /*Kod jest implementacją problemu filozofów za pomocą wielu wątków.
        Klasa Filozof jest implementacją interfejsu Runnable, co oznacza,
        że można ją uruchomić jako wątek.
        W konstruktorze klasy Filozof przekazywane są dwa obiekty
        reprezentujące lewy i prawy widelec. W metodzie run()
        filozof myśli, podnosi lewy widelec, podnosi prawy widelec i zaczyna jeść,
        a następnie odkłada oba widelce i wraca do myślenia.
        Wątek jest synchronizowany przy użyciu synchronizowanych bloków,
        co oznacza, że tylko jeden filozof może używać danego widelca w danym momencie.*/