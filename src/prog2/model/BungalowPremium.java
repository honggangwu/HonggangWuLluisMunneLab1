package prog2.model;

public class BungalowPremium extends Bungalow {
    private boolean serveisExtra = true;
    private String codiWifi;

    public BungalowPremium(String nom, String idAllotjament, String mida,
                           int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv,
                           boolean aireFred, boolean serveisExtra,String codiWifi) {
        super(nom, idAllotjament, mida, habitacions, placesPersones,placesParquing,
                terrassa, tv, aireFred );
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    public boolean isServeisExtra(){
        return this.serveisExtra;
    }

    public String getCodiWifi(){
        return this.codiWifi;
    }

    public void setServeisExtra(boolean serveisExtra){
        this.serveisExtra=serveisExtra;
    }

    public void setCodiWifi(String codiWifi){
        this.codiWifi=codiWifi;
    }

    @Override
    public boolean correcteFuncionament() {
        return super.correcteFuncionament() && (this.codiWifi.length() >= 8 && this.codiWifi.length() <= 16);
    }


    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", serveis extra=" + isServeisExtra() +
                ", codi wifi=" + getCodiWifi() + " }";
    }

}
