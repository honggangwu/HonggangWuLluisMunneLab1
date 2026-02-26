package prog2.model;

public class MobilHome extends Casa{
    private boolean barbacoa;

    public MobilHome(String nom, String idAllotjament,
                     String mida, int habitacions, int placesPersones,boolean barbacoa) {
        super(nom ,idAllotjament ,5,3,mida,habitacions,placesPersones);
        this.barbacoa=barbacoa;
    }

    public boolean isBarbacoa(){
        return this.barbacoa;
    }

    public void setBarbacoa(boolean barbacoa){
        this.barbacoa=barbacoa;
    }

    @Override
    public boolean correcteFuncionament() {
        return this.barbacoa;
    }


    public String toString() {
        return super.toString().replace("}", "") +
                ", barbacoa=" + isBarbacoa() + " }";
    }

}
