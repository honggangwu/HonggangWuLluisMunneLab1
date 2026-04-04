package prog2.model;


public abstract class Casa extends Allotjament {
    private float mida;
    private int habitacions;
    private int placesPersones;


    public Casa(String nom, String idAllotjament,boolean estat, String iluminacio, long estadaMinAlta,
            long estadaMinBaixa, float mida, int habitacions, int placesPersones) {
        super(nom, idAllotjament,estat,iluminacio, estadaMinAlta, estadaMinBaixa);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }


    public float getMida(){
        return this.mida;
    }


    public int getHabitacions(){
        return this.habitacions;
    }


    public int getPlacesPersones(){
        return this.placesPersones;
    }


    public void setMida(float mida){
        this.mida = mida;
    }


    public void setHabitacions(int habitacions){
        this.habitacions = habitacions;
    }


    public void setPlacesPersones(int placesPersones){
        this.placesPersones = placesPersones;
    }

    public String toString() {
        return super.toString() +
                ", mida=" + getMida() +
                ", habitacions=" + habitacions +
                ", PlacesPersones=" + getPlacesPersones() + " }";
    }
}



