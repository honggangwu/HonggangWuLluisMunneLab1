package prog2.model;

public class MobilHome extends Casa{
    private boolean barbacoa;

    public MobilHome(String nom, String idAllotjament,boolean estat, String iluminacio,
                     float mida, int habitacions, int placesPersones, boolean barbacoa) {
        super(nom ,idAllotjament ,estat,iluminacio,5,3,mida,habitacions,placesPersones);
        this.barbacoa=barbacoa;
    }

    public boolean isBarbacoa(){
        return this.barbacoa;
    }

    public void setBarbacoa(boolean barbacoa){
        this.barbacoa=barbacoa;
    }


    public boolean correcteFuncionament() {
        return this.barbacoa;
    }


    public String toString() {
        return super.toString().replace("}", "") +
                ", barbacoa=" + isBarbacoa() + " }";
    }

}
