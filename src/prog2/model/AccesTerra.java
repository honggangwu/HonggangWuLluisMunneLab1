package prog2.model;

public abstract class AccesTerra extends Acces {
    private float longitud;

    public AccesTerra(String nom, boolean estat, float longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    public float getLongitud(){ return this.longitud;}

    public void setLongitud(float longitud){this.longitud=longitud;}
}