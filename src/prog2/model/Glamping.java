package prog2.model;

public class Glamping extends Casa {
    private String material;
    private boolean casaMascotes;

    public Glamping(String nom, String idAllotjament, boolean estat, String iluminacio,
                    float mida, int habitacions, int placesPersones,
                    String material, boolean casaMascotes) {
        super(nom, idAllotjament, estat,iluminacio,5, 3, mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascotes = casaMascotes;
    }

    public String getMaterial() {
        return material;
    }

    public boolean isCasaMascotes() {
        return casaMascotes;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setCasaMascotes(boolean casaMascotes) {
        this.casaMascotes = casaMascotes;
    }

    public boolean correcteFuncionament() {
        // Comprovem que hi ha material i que hi ha habitacions
        return getMaterial() != null && !getMaterial().isEmpty() && getHabitacions() > 0;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", material=" + getMaterial() +
                ", casa mascotes=" + isCasaMascotes() + " }";
    }
}