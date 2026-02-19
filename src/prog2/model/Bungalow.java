package prog2.model;

public class Bungalow extends Casa {
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    public Bungalow(String nom, String idAllotjament,
                    String mida, int habitacions, int placesPersones, int placesParquing,
                    boolean terrassa, boolean tv, boolean aireFred) {
        super(nom, idAllotjament, 7, 4, mida, habitacions, placesPersones);
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

    public void setPlacesParquing(int PlacesParquing){
        this.placesParquing = PlacesParquing;
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

    @Override
    public boolean correcteFuncionament() {
        return this.aireFred;
    }

    public String toString() {
        return "Nom=" + getNom() + ", Id=" + getId() +
                ", estada mínima en temp ALTA: " + getEstadaMinima(Temp.ALTA) +
                ", estada mínima en temp BAIXA: " + getEstadaMinima(Temp.BAIXA) +
                " Bungalow { mida=" + getMida() +
                ", habitacions=" + getHabitacions() +
                ", places persones=" + getPlacesPersones() +
                ", places parquing=" + getPlacesParquing() +
                ", Terrassa=" + isTerrassa() +
                ", Tv=" + isTv() +
                ", aire fred=" + isAireFred() + " }";
    }

}

