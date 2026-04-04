package prog2.model;

public abstract class AccesAsfalt extends Acces {
    private float metresQuadrats;

    public AccesAsfalt(String nom, boolean estat, float metresQuadrats) {
        super(nom, estat);
        this.metresQuadrats = metresQuadrats;
    }

    public float getMetresQuadrats() {
        return metresQuadrats;
    }

    public void setMetresQuadrats(float metresQuadrats) {
        this.metresQuadrats = metresQuadrats;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", metresQuadrats=" + metresQuadrats;
    }
}