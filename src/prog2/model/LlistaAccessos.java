package prog2.model;
import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos {
    private ArrayList<Acces> llistaAcces;

    public LlistaAccessos() {
        llistaAcces = new ArrayList<>();
    }

    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        if (llistaAcces.contains(acc)) {
            throw new ExcepcioCamping ("Aquest acces ja existeix");
        } else { llistaAcces.add(acc); }
    }

    @Override
    public void buidar() {
        llistaAcces.clear();
    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        boolean trobat = false;
        StringBuilder info = new StringBuilder();
        for (Acces acces : llistaAcces) {
            if (acces.isOperatiu() == estat) {
                info.append(acces.toString()).append("\n"); // Afegim un salt de línia per millorar la llegibilitat
                trobat = true;
            }
        }
        if (!trobat) { // Llança l'excepció només si cap accés compleix la condició, després de recórrer tota la llista
            throw new ExcepcioCamping("No hi ha accessos amb l'estat especificat.");
        }
        return info.toString();
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for (Acces acces:llistaAcces){
            acces.tancarAcces();
            LlistaAllotjaments llistaAllotjaments=acces.getLlista();
            if(llistaAllotjaments.containsAllotjamentOperatiu()){
                acces.obrirAcces();
            }
        }
    }

    @Override
    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        int accessosAccessibles=0;

        for (Acces acces:llistaAcces){
            if(acces.isAccessibilitat()){
                accessosAccessibles++;
            }
        }
        return accessosAccessibles;
    }

    @Override
    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        int metresTotals = 0;
        boolean trobat =false;
       for(Acces acces: llistaAcces) {
            if (acces instanceof AccesAsfalt) {
                metresTotals += ((AccesAsfalt)acces).getMetresQuadrats();
                trobat=true;
            }
       }
       if (!trobat){
           throw new ExcepcioCamping("No s'ha trobat ningun acces amb asfalt");
       }
        return metresTotals;
    }

    public ArrayList<Acces> getLlistaAcces() {
        return llistaAcces;
    }

    public void setLlistaAcces(ArrayList<Acces> llistaAcces) {
        this.llistaAcces = llistaAcces;
    }
}