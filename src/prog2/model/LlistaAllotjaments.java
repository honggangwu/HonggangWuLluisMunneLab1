package prog2.model;
import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    private ArrayList<Allotjament> allotjaments;

    public LlistaAllotjaments() { allotjaments = new ArrayList<>(); }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (allotjaments.contains(allotjament)) {
            throw new ExcepcioCamping ("Aquest allotjament ja existeix");
        } else {
            allotjaments.add(allotjament);
        }
    }

    @Override
    public void buidar() {
        allotjaments.clear();
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        StringBuilder info = new StringBuilder(); // Usamos StringBuilder para eficiencia

        // Convertimos el String 'estat' a un boolean 'estatB'
        boolean estatB = false;  // Por defecto, 'estatB' es 'false' (no operatiu)

        if (estat.equals("Operatiu")) {
            estatB = true;  // Si el estado es "Operatiu", lo marcamos como 'true'
        } else if (estat.equals("No Operatiu")) {
            estatB = false;  // Si el estado es "No Operatiu", lo dejamos como 'false'
        } else if (!estat.equals("Tots")) {
            // Si no es un estado válido, lanzamos una excepción
            throw new ExcepcioCamping("El tipus d'estat indicat no és vàlid.");
        }

        // Recorremos la lista de alojamientos
        for (Allotjament allotjament : allotjaments) {
            // Si el estado es "Tots", mostramos todos los alojamientos
            // Si el estado es "Operatiu" o "No Operatiu", mostramos según el estado del alojamiento
            if (estat.equals("Tots") || allotjament.isOperatiu() == estatB) {
                info.append(allotjament.toString()).append("\n");
            }
        }

        // Si no hay alojamientos que cumplirían con el filtro, lanzamos una excepción
        if (info.length() == 0) {
            throw new ExcepcioCamping("No hi ha allotjaments amb aquest estat.");
        }

        return info.toString();
    }




    @Override
    public boolean containsAllotjamentOperatiu() {
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.isOperatiu()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        for (Allotjament i : allotjaments) {
            if (i.getId().equals(allotjament.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Allotjament getAllotjament(String nom) throws ExcepcioCamping {
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.getNom().equals(nom)) {
                return allotjament;
            }
        }
        throw new ExcepcioCamping("No existeix");
    }

    public ArrayList<Allotjament> getAllotjaments() {
        return allotjaments;
    }

    public void setAllotjaments(ArrayList<Allotjament> allotjaments) {
        this.allotjaments = allotjaments;
    }
}