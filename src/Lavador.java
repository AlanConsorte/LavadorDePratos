public class Lavador implements Runnable {

    private final Escorredor escorredor;
    private final PratosSujosFactory factory;
    private Boolean done;

    public Lavador(Escorredor escorredor, PratosSujosFactory factory) {
        this.escorredor = escorredor;
        this.factory = factory;

    }

    public void done() {
        this.done = true;

    }

    @Override
    public void run() {

        done = false;

        while (!done) {

            Prato p = factory.entregaPrato();
            long tempo = 0;

            switch (p.getSujeira()) {
                case BAIXO:
                    tempo = 300;
                    break;
                case MEDIO:
                    tempo = 500;
                    break;
                case ENGORDURADO:
                    tempo = 1000;
                    break;
                default:
                    tempo = 1000;
                    break;
            }
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            synchronized (escorredor) {
                while (escorredor.getPratos().size() == escorredor.getMax()) {
                    try {
                        escorredor.wait();
                    } catch (InterruptedException ex) {
                    }
                }
                escorredor.colocarPrato(p);
                if (escorredor.getPratos().size() == 1) {
                    escorredor.notify();
                    
                }
            }
        }

    }
}