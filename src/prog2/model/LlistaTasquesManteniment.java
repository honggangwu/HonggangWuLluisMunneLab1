package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment {

    private ArrayList<TascaManteniment> llistaTasques;

    public LlistaTasquesManteniment() {
        llistaTasques = new ArrayList<>();
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
        // Comprovar que l'allotjament no té ja una tasca
        for (TascaManteniment t : llistaTasques) {
            if (t.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("Aquest allotjament ja té una tasca de manteniment.");
            }
        }

        // Convertir String a enum TipusTascaManteniment
        TascaManteniment.TipusTascaManteniment tipusEnum;
        try {
            tipusEnum = TascaManteniment.TipusTascaManteniment.valueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("Tipus de tasca no vàlid: " + tipus);
        }

        // Crear la tasca
        TascaManteniment novaTasca = new TascaManteniment(num, allotjament, tipusEnum, data, dies);

        // Afegir-la a la llista
        llistaTasques.add(novaTasca);

        // Tancar l'allotjament (no operatiu)
        allotjament.tancarAllotjament(novaTasca);
    }

    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        if (!llistaTasques.remove(tasca)) {
            throw new ExcepcioCamping("No existeix la tasca indicada.");
        }
        // Obrir l'allotjament després de completar la tasca
        tasca.getAllotjament().obrirAllotjament();
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        if (llistaTasques.isEmpty()) {
            throw new ExcepcioCamping("No hi ha tasques de manteniment.");
        }
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (TascaManteniment t : llistaTasques) {
            sb.append(i++).append(". ").append(t.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        for (TascaManteniment t : llistaTasques) {
            if (t.getNum() == num) {
                return t;
            }
        }
        throw new ExcepcioCamping("No existeix cap tasca amb número: " + num);
    }

    // Getter per depuració o ús futur
    public ArrayList<TascaManteniment> getLlistaTasques() {
        return llistaTasques;
    }
}