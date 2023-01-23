import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class Main extends Thread {
    final static int N = 4096;
    final static int CUTOFF = 100;
    static int[][] set = new int[N][N];
    private static final double ZOOM = 1;
    private static final double CX = -0.75;
    private static final double CY = 0.27015;
    private static final double MOVE_X = 0;
    private static final double MOVE_Y = 0;

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Main thread0 = new Main(0);
        Main thread1 = new Main(1);
        Main thread2 = new Main(2);
        Main thread3 = new Main(3);
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread0.join();
        thread1.join();
        thread2.join();
        thread3.join();
        long endTime = System.currentTimeMillis();
        System.out.println("Obliczenia zakończone w czasie " + (endTime - startTime) + " millisekund");
        BufferedImage img = new BufferedImage(N, N, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = set[i][j];
                float level;
                if (k < CUTOFF) {
                    level = (float) k / CUTOFF;
                } else {
                    level = 0;
                }
                Color c = new Color(level, 0, 0); // czerwony
                img.setRGB(i, j, c.getRGB());
            }
        }
        ImageIO.write(img, "PNG", new File("Mandelbrot.png"));
    }

    int me;

    public Main(int me) {
        this.me = me;
    }
    public void run() {
        int begin = 0, end = 0;
        if (me == 0) {
            begin = 0;
            end = (N / 4) * 1;
        } else if (me == 1) {
            begin = (N / 4) * 1;
            end = (N / 4) * 2;
        } else if (me == 2) {
            begin = (N / 4) * 2;
            end = (N / 4) * 3;
        } else if (me == 3) {
            begin = (N / 4) * 3;
            end = N;
        }
        for (int i = begin; i < end; i++) {
            for (int j = 0; j < N; j++) {
                double zx = 1.5 * (i - (N) / 2) / (0.5 * ZOOM * (N)) + MOVE_X;
                double zy = (j - N / 2) / (0.5 * ZOOM * N) + MOVE_Y;
                int k = 0;
                float ip = CUTOFF;
                while (zx * zx + zy * zy < 4 && ip > 0) {
                    double tmp = zx * zx - zy * zy + CX;
                    zy = 2.0 * zx * zy + CY;
                    zx = tmp;
                    ip--;
                    k++;
                }
                set[i][j] = k;
            }
        }
    }
}


    /*W klasie Main zdefiniowano kilka stałych, takich jak N (rozmiar obrazu),
    CUTOFF (liczba iteracji dla której sprawdzane jest czy dana
            liczba jest członkiem zbioru Mandelbrota) i kilka parametrów
    kontrolujących skalowanie i przesunięcie fraktala.
        W metodzie main tworzone są 4 obiekty klasy Main,
        każdy z nich reprezentujący jeden wątek.
        Każdy z tych wątków jest uruchamiany i czekanie na
        zakończenie działania wszystkich wątków.
        Następnie, program tworzy obraz BufferedImage i uzupełnia
        go pikselami na podstawie danych z tablicy set.
        W końcu, obraz jest zapisywany do pliku "Mandelbrot.png".
        Każdy wątek wykonuje pętle po wierszach i kolumnach obrazu,
        dla każdego punktu obliczając czy dana liczba jest członkiem
        zbioru Mandelbrota i zapisując wynik do tablicy set.*/