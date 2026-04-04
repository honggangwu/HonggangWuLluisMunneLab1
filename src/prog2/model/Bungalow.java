package prog2.model;

public class Bungalow extends Casa {
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    public Bungalow(String nom, String idAllotjament,boolean estat, String iluminacio,
                    float mida, int habitacions, int placesPersones, int placesParquing,
                    boolean terrassa, boolean tv, boolean aireFred) {
        super(nom, idAllotjament, estat,iluminacio,7, 4, mida,habitacions, placesPersones);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    public int getPlacesParquing(){
        return this.placesParquing;
    }

    public boolean isTerrassa(){
        return this.terrassa;
    }

    public boolean isTv(){
        return this.tv;
    }

    public boolean isAireFred(){
        return this.aireFred;
    }

    public void setPlacesParquing(int placesParquing){
        this.placesParquing = placesParquing;
    }

    public void setTerrassa(boolean terrassa){
        this.terrassa= terrassa;
    }

    public void setTv(boolean tv){
        this.tv= tv;
    }

    public void setAireFred(boolean aireFred){
        this.aireFred=aireFred;
    }

    public boolean correcteFuncionament() {
        return this.aireFred;
    }

    public String toString() {
        return super.toString() +
                ", places parquing=" + getPlacesParquing() +
                ", Terrassa=" + isTerrassa() +
                ", Tv=" + isTv() +
                ", aire fred=" + isAireFred() + " }";
    }

}

