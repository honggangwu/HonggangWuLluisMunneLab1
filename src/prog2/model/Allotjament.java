package prog2.model;


public abstract class Allotjament implements InAllotjament{
    private String nom;
    private String idAllotjament;
    private long estadaMinAlta;
    private long estadaMinBaixa;


    public Allotjament(String nom, String idAllotjament, long estadaMinAlta, long estadaMinBaixa) {
        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.estadaMinAlta = estadaMinAlta;
        this.estadaMinBaixa = estadaMinBaixa;
    }


    // GETTERS I SETTERS
    @Override
    public String getNom() {
        return this.nom;
    }
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public String getId() {
        return this.idAllotjament;
    }
    @Override
    public void setId(String idAllotjament) {
        this.idAllotjament = idAllotjament;
    }
    @Override
    public long getEstadaMinima(Temp temp) {
        switch (temp) {
            case ALTA -> {return this.estadaMinAlta;}
            case BAIXA -> {return this.estadaMinBaixa;}
        }
        return 0;
    }
    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinAlta = estadaMinimaALTA_;
        this.estadaMinBaixa = estadaMinimaBAIXA_;
    }


    @Override
    public abstract boolean correcteFuncionament();
}




