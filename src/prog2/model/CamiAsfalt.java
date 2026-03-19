package prog2.model;

public class CamiAsfalt extends AccesAsfalt {
    public CamiAsfalt(String nom, boolean estat, float asfalt) {
        super(nom, estat,asfalt);
    }

    @Override
    public boolean isAccessibilitat() {return false;}

    @Override
    public String toString() {
        return super.toString() + ", metres quadrats: "+ getMetresQuadrats();
    }
}