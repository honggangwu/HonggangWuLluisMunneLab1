package prog2.model;

public class TascaManteniment implements InTascaManteniment {

    public static enum TipusTascaManteniment {
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    }

    private TipusTascaManteniment _tipus;
    private String data;
    private int numTasca;
    private Allotjament _allotjament;
    private int dies;

    // Constructor complet que inicialitza tots els atributs
    public TascaManteniment(int numTasca, Allotjament allotjament,
                            TipusTascaManteniment tipus, String data, int dies) {
        this.numTasca = numTasca;
        this._allotjament = allotjament;
        this._tipus = tipus;
        this.data = data;
        this.dies = dies;
    }

    // GETTERS
    @Override
    public int getNum() {
        return numTasca;
    }

    @Override
    public TipusTascaManteniment getTipus() {
        return _tipus;
    }

    @Override
    public Allotjament getAllotjament() {
        return _allotjament;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public int getDies() {
        return dies;
    }

    // SETTERS
    @Override
    public void setNum(int num_) {
        this.numTasca = num_;
    }

    @Override
    public void setTipus(TipusTascaManteniment tipus_) {
        this._tipus = tipus_;
    }

    @Override
    public void setAllotjament(Allotjament allotjament_) {
        this._allotjament = allotjament_;
    }

    @Override
    public void setData(String data_) {
        this.data = data_;
    }

    @Override
    public void setDies(int dies_) {
        this.dies = dies_;
    }

    // Retorn d'il·luminació de l'allotjament (per si ho demana la interfície)
    @Override
    public String getIluminacioAllotjament() {
        return "";
    }
}