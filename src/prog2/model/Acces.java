package prog2.model;

public abstract class Acces implements InAcces {
    private String nom;
    private boolean estat;
    private LlistaAllotjaments llista;

    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.llista = new LlistaAllotjaments();
    }

    // GETTERS I SETTERS
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getEstat() {
        return estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    public LlistaAllotjaments getLlista() {
        return llista;
    }

    public void setLlista(LlistaAllotjaments llista) {
        this.llista = llista;
    }

    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return llista;
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        llista.afegirAllotjament(allotjament);
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
    public abstract boolean isAccessibilitat();

    @Override
    public String toString() {
        return "Nom=" + nom +
                ", accessibilitat=" + isAccessibilitat() +
                ", estat=" + estat +
                ", llista=" + llista;
    }
}