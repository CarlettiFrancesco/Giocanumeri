import java.time.Instant;
import java.util.Random;

public class Giocatore implements Runnable {
    private final String nome;
    private final String parola;
    private int punteggio;

    public Giocatore(String nome, String parola) {
        this.nome = nome;
        this.parola = parola;
        this.punteggio = 0;
    }

    @Override
    public void run() {
        int numero = new Random().nextInt(50) + 5;

        for (int i = 0; i < numero; i++) {
            var start = Instant.now();

            System.out.println("Giocatore " + this.nome + ", i: " + i);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Errore nella transizione da RUNNING a SLEEPING " + e.getMessage());
            }

            var end = Instant.now();
            if (start.compareTo(end) < 1)
                this.punteggio += numero / 10;

            if (i % 2 == 0)
                this.punteggio++;
        }

        System.out.println("Giocatore " + nome + ", parola: " + this.parola + ", punteggio: " + this.punteggio);
    }
}
