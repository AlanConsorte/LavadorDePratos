public class App {

    public static PratosSujosFactory factory = new PratosSujosFactory();
    public static Escorredor escorredor = new Escorredor();
    public static Lavador lavador = new Lavador(escorredor, factory);
    public static Enxugador enxugador = new Enxugador(escorredor);
    
    public static void aguardar(long milis) {
        
		try {
			Thread.sleep(milis);

		} catch (InterruptedException ie) {
			ie.printStackTrace();

		}
	}
    
    public static void work(){
        Thread t1 = new Thread(lavador);
        Thread t2 = new Thread(enxugador);
        
        t1.start();
        t2.start();

    }
    
    public static void stop(){
        lavador.done();
        enxugador.done();
        
    }
    
    public static void main(String[] args) {     
        work();
        
        aguardar(1000 * 60 * 2);
        
        stop();
        
    }
}