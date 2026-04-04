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
        for (Acces a : llistaAcces) {
            if (a.getNom().equals(acc.getNom())) {
                throw new ExcepcioCamping("Aquest accés ja existeix: " + acc.getNom());
            }
        }
        llistaAcces.add(acc);
    }

    @Override
    public void buidar() {
        llistaAcces.clear();
    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        StringBuilder info = new StringBuilder();
        boolean trobat = false;
        int i = 1;

        for (Acces acces : llistaAcces) {
            if (acces.getEstat() == estat) {
                info.append(i++).append(". ").append(acces.toString()).append("\n");
                trobat = true;
            }
        }

        if (!trobat) {
            throw new ExcepcioCamping("No hi ha accessos amb l'estat especificat.");
        }

        return info.toString();
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for (Acces acces : llistaAcces) {
            acces.tancarAcces();
            if (acces.getLlista().containsAllotjamentOperatiu()) {
                acces.obrirAcces();
            }
        }
    }

    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        int count = 0;
        for (Acces acces : llistaAcces) {
            if (!acces.isAccessibilitat()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        float total = 0;
        boolean trobat = false;
        for (Acces acces : llistaAcces) {
            if (acces instanceof AccesTerra) {
                total += ((AccesTerra) acces).getLongitud();
                trobat = true;
            }
        }
        if (!trobat) {
            throw new ExcepcioCamping("No s'ha trobat cap accés de terra.");
        }
        return total;
    }

    // GETTERS I SETTERS
    public ArrayList<Acces> getLlistaAcces() {
        return llistaAcces;
    }

    public void setLlistaAcces(ArrayList<Acces> llistaAcces) {
        this.llistaAcces = llistaAcces;
    }
}