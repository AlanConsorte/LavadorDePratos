
import java.util.LinkedList;

public class Escorredor {

    private final int max = 10;
    LinkedList<Prato> pratos = new LinkedList<>();

    //Lavador chama
    public void colocarPrato(Prato p) {
        if (pratos.size() >= max) {
            System.out.println("Limite Máximo violado: O escorredor está cheio!!");
            System.exit(1);
        }
        pratos.addFirst(p);
        this.status("LAVADOR: ");
    }

    //Enxugador chama
    public void retirarPrato() {
        if (pratos.size() <= 0) {
            System.out.println("Limite Mínimo violado: Não há pratos para secar!!");
            System.exit(1);
        }
        Prato p = pratos.removeLast();
        this.status("SECADOR: ");

    }

    public void status(String s) {
        if (pratos.size() == max) {
            System.out.println(s + "Escorredor CHEIO - " + pratos.size() + " pratos!!!");
        } else if (pratos.isEmpty()) {
            System.out.println(s + "Escorredor VAZIO - " + pratos.size() + " pratos!!!");
        }
    }

    public int getMax() {
        return max;
    }

    public LinkedList<Prato> getPratos() {
        return pratos;
    }

}