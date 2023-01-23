public class Czasomierz extends Thread{

    int start=0;
    boolean petla = true;

    public void mierz(){
        System.out.println("zaczynamy liczyc czas");
        while (petla) {
            try {
                sleep(1000);
            } catch (Exception e) {

            }
            start++;
            System.out.println(start);
            if (start == 60){
                System.out.println("Minuta na zegarze");
                petla = false;
            }
        }
    }

}

    /*Tutaj znajduje się pętla while, która działa dopóki zmienna petla jest ustawiona na true.
        W pętli używana jest funkcja sleep(1000), która powoduje zatrzymanie działania
        pętli na 1 sekundę, co pozwala na odmierzanie sekund.
        Zmienna start jest zwiększana o 1 za każdym przebiegiem pętli.
        Jeśli start jest równy 60, oznacza to, że minuta została odmierzona i
        wypisuje się komunikat "Minuta na zegarze", a zmienna petla jest ustawiona na false,
        co kończy działanie pętli.*/