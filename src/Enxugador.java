
import java.util.Random;
import java.util.logging.Logger;

public class Enxugador implements Runnable {

    private static final Logger logger = Logger.getLogger(Enxugador.class.getName());

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

        while (!done || !escorredor.getPratos().isEmpty()) {
            synchronized (escorredor) {

                while (escorredor.getPratos().isEmpty() && !done) {
                    try {
                        escorredor.wait();
                    } catch (InterruptedException ex) {
                    }
                }

                if (escorredor.getPratos().isEmpty() && done) {
                    break;
                }

                escorredor.retirarPrato();

                if (escorredor.getPratos().isEmpty()) {
                    escorredor.notify();

                }
            }

            if (done && escorredor.getPratos().isEmpty()) {
                logger.info("SECADOR: O tempo acabou e todos os pratos pendentes foram secos. Finalizando!");
                break;
            }

            try {
                Thread.sleep(r.nextInt(3, 10));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

}