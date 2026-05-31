import java.util.Random;
import java.util.logging.Logger;

public class PratosSujosFactory {
    private int i = 1;

    private static final Logger logger = Logger.getLogger(PratosSujosFactory.class.getName());

    Random r = new Random();

    public Prato entregaPrato() {
        Prato p = new Prato();

        p.setNumSerie(i);
        i++;

        int x = r.nextInt(100);

        if (x < 10) {
            p.setSujeira(nivelSujeira.ENGORDURADO);
        } else if (x >= 10 && x <= 70) {
            p.setSujeira(nivelSujeira.MEDIO);
        } else if (x > 70) {
            p.setSujeira(nivelSujeira.BAIXO);
        }

        logger.info("FÁBRICA: Novo prato criado! ID: " + p.getNumSerie() + " | Sujeira: " + p.getSujeira());

        return p;
    }
}