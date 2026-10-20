public class Giocanumeri {
    public static void main(String[] args) {
        System.out.println("INIZIO GIOCO");

        var g1 = new Giocatore("Francesco", "Sasso");
        var g2 = new Giocatore("Matteo", "Gatto");
        Thread tg1 = new Thread(g1);
        Thread tg2 = new Thread(g2);
        tg1.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Errore nella transizione del main thread da RUNNING a SLEEPING " + e.getMessage());
        }

        tg2.start();

        try {
            tg1.join();
            tg2.join();
        } catch (InterruptedException e) {
            System.err.println("Errore nella transizione da RUNNING a WAITING " + e.getMessage());
        }

        System.out.println("FINE GIOCO");
    }
}
