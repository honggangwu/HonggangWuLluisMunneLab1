package prog2.model;

public abstract class  Acces implements InAcces {
    private String nom;
    private boolean accessibilitat;
    private boolean estat;
    private LlistaAllotjaments llista;

    public Acces(String nom,boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.llista = new LlistaAllotjaments();
        this.accessibilitat=false;
    }

    // GETTERS I SETTERS
    public String getNom(){ return this.nom;}
    public void setNom(String nom){this.nom=nom;}
    public boolean isAccessibilitat(){return accessibilitat;}
    public void setAccessibilitat(boolean accessibilitat){this.accessibilitat=accessibilitat;}
    public boolean isOperatiu(){return this.estat;}
    public void setEstat(boolean estat){this.estat=estat;}
    public LlistaAllotjaments getLlista(){return this.llista;}
    public void setLlista(LlistaAllotjaments llista){this.llista=llista;}

    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        this.llista.afegirAllotjament(allotjament);
    }

    @Override
    public void tancarAcces() {
        estat = false;
    }

    @Override
    public void obrirAcces() {
        estat = true;
    }

    @Override
    public String toString() {
        return "Nom=" + getNom() + ", accessibilitat=" + isAccessibilitat() +
                ", estat: " + isOperatiu()+
                ", llista " + getLlista();
    }
}