
public class Prato {
    private int numSerie = 0;
    private nivelSujeira sujeira;
    

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public nivelSujeira getSujeira() {
        return sujeira;
    }

    public void setSujeira(nivelSujeira sujeira) {
        this.sujeira = sujeira;
    }
}
   
enum nivelSujeira {
     BAIXO, MEDIO, ENGORDURADO;
}