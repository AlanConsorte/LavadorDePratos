
public class Enxugador implements Runnable {

    private Escorredor escorredor;
    private Boolean sair;

    public Enxugador(Escorredor escorredor) {
        this.escorredor = escorredor;
    }

    public void sair(){
        this.sair = true;
    }

    @Override
    public void run() {
        while (true) {
            
        }
    }

}
