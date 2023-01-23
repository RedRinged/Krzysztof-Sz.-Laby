import java.util.concurrent.ThreadLocalRandom;

public class Samochod extends Thread {

    private String nrRej;
    private int pojZbiornika;
    private int paliwo;

    public Samochod(String nr, int poj){
        this.nrRej = nr;
        this.pojZbiornika = poj;
        this.paliwo = poj;
    }

    public void run() {
        try {
            boolean maPaliwo = true;
            while(maPaliwo) {
                // doo
                if (this.paliwo == 0) {
                    System.out.println("Brak paliwa, samochod "+this.nrRej+" stanął");
                    // Zatrzymujemy watek
                    maPaliwo = false;
                } else if (this.paliwo / this.pojZbiornika < 0.4 ) {
                    System.out.println("Poziom paliwa ponizej 40% w samochodzie " + this.nrRej);
                }
                System.out.println("Poziom paliwa " + this.paliwo + " w samochodzie " + this.nrRej);
                this.paliwo -= 1;
                sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void start() {
        super.start();
    }
}

    /*W metodzie run() znajduje się pętla, w której sprawdzane jest czy samochód ma jeszcze paliwo,
    jeśli poziom paliwa jest mniejszy niż 0, wątek zostaje zatrzymany i wypisuje komunikat
        "Brak paliwa, samochod "nrRej" stanął", jeśli poziom paliwa jest poniżej 40% wypisuje komunikat
        "Poziom paliwa ponizej 40% w samochodzie" + this.nrRej.
        W pętli przed każdym przejściem wypisuje aktualny poziom
        paliwa w samochodzie oraz zmniejsza poziom paliwa o 1.
        Po każdym przejściu pętli wątek jest uśpiony na 1000 milisekund.*/