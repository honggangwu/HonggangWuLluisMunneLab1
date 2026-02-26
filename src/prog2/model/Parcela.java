package prog2.model;


public class Parcela extends Allotjament {
    float mida;
    boolean connexioElectrica;


    public Parcela(String nom, String idAllotjament,
                   float mida, boolean connexioElectrica) {
        super(nom, idAllotjament,4,2);
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }

    public float getMida(){
        return this.mida;
    }
    public void setMida(float mida){
        this.mida = mida;
    }
    public boolean isConnexioElectrica(){
        return this.connexioElectrica;
    }
    public void setConnexioElectrica(boolean connexio){
        this.connexioElectrica = connexio;
    }

    @Override
    public boolean correcteFuncionament() {
        return this.connexioElectrica;
    }

    public String toString() {
        return "Nom=" + getNom() + ", Id=" + getId() +
                ", estada mínima en temp ALTA: " + getEstadaMinima(Temp.ALTA) +
                ", estada mínima en temp BAIXA: " + getEstadaMinima(Temp.BAIXA) +".";
    }

}

