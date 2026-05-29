import java.util.LinkedList;
import java.util.logging.Logger;

public class Escorredor {

    private static final Logger logger = Logger.getLogger(Escorredor.class.getName());

    private final int max = 100;
    private final LinkedList<Prato> pratos = new LinkedList<>();

    public void colocarPrato(Prato p) {
        if (pratos.size() >= max) {
            logger.severe("Limite Máximo violado: O escorredor está cheio!!");
            return;
        }

        pratos.addFirst(p);

        logger.info("LAVADOR: Prato ID " + p.getNumSerie() + " foi lavado e colocado no escorredor. Total atual: "
                + pratos.size());

        this.status("LAVADOR: ");

    }

    public void retirarPrato() {

        if (pratos.isEmpty()) {
            logger.severe("Limite Mínimo violado: Não há pratos para secar!!");
            return;

        }

        Prato p = pratos.removeLast();

        logger.info("SECADOR: Prato ID " + p.getNumSerie()
                + " foi retirado do escorredor e esta sendo seco. Total restante: " + pratos.size());

        this.status("SECADOR: ");
    }

    public void status(String origem) {
        if (pratos.size() == max) {
            logger.info(origem + "Escorredor CHEIO - " + pratos.size() + " pratos!!!");

        } else if (pratos.isEmpty()) {
            logger.info(origem + "Escorredor VAZIO - " + pratos.size() + " pratos!!!");

        }
    }

    public int getMax() {
        return max;

    }

    public LinkedList<Prato> getPratos() {
        return pratos;

    }
}