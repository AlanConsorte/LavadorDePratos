
import java.util.Random;

public class Enxugador implements Runnable {

    private final Escorredor escorredor;
    private Boolean done;

    public Enxugador(Escorredor escorredor) {
        this.escorredor = escorredor;
    }

    public void done() {
        this.done = true;
    }

    @Override
    public void run() {
        done = false;
        Random r = new Random();

        while (!done) {
            synchronized (escorredor) {
                while (escorredor.getPratos().isEmpty()) {
                    try {
                        escorredor.wait();
                    } catch (InterruptedException ex) {
                    }
                }
                escorredor.retirarPrato();
                if (escorredor.getPratos().isEmpty()) {
                    escorredor.notify();

                }
            }

            try {
                Thread.sleep(r.nextInt(3, 11));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}