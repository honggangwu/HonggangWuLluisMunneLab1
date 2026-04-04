package prog2.model;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String idAllotjament;
    private long estadaMinAlta;
    private long estadaMinBaixa;

    private boolean estat;          // true = operatiu
    private String iluminacio;      // "100%", "50%" o "0%"

    public Allotjament(String nom, String idAllotjament, boolean estat, String iluminacio,
                       long estadaMinAlta, long estadaMinBaixa) {

        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.estadaMinAlta = estadaMinAlta;
        this.estadaMinBaixa = estadaMinBaixa;
        this.estat = estat;
        this.iluminacio = iluminacio;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getId() {
        return idAllotjament;
    }

    @Override
    public void setId(String idAllotjament) {
        this.idAllotjament = idAllotjament;
    }

    @Override
    public long getEstadaMinima(Temp temp) {
        switch (temp) {
            case ALTA:
                return estadaMinAlta;
            case BAIXA:
                return estadaMinBaixa;
            default:
                return 0;
        }
    }

    @Override
    public void setEstadaMinima(long estadaMinAlta, long estadaMinBaixa) {
        this.estadaMinAlta = estadaMinAlta;
        this.estadaMinBaixa = estadaMinBaixa;
    }

    public boolean isOperatiu() {
        return estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    public String getIluminacio() {
        return iluminacio;
    }

    public void setIluminacio(String iluminacio) {
        this.iluminacio = iluminacio;
    }

    public void tancarAllotjament(TascaManteniment tasca) {
        this.estat = false;
        this.iluminacio = tasca.getIluminacioAllotjament();
    }

    public void obrirAllotjament() {
        this.estat = true;
        this.iluminacio = "100%";
    }

    @Override
    public String toString() {
        return "Nom=" + nom +
                ", Id=" + idAllotjament +
                ", estada mínima temp. ALTA=" + estadaMinAlta +
                ", estada mínima temp. BAIXA=" + estadaMinBaixa +
                ", estat=" + (estat ? "Operatiu" : "No operatiu") +
                ", il·luminació=" + iluminacio;
    }
}

