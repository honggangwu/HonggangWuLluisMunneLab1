package prog2.model;

public abstract class AccesAsfalt extends Acces {
    private float asfalt;

    public AccesAsfalt(String nom, boolean estat, float asfalt) {
        super(nom,estat);
        this.asfalt = asfalt;
    }

    public float getMetresQuadrats(){ return this.asfalt;}

    public void setMetresQuadrats(float asfalt){this.asfalt=asfalt;}
}
