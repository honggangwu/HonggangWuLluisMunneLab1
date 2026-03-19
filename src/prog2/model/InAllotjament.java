
package prog2.model;

/**
 * Interfície que defineix les operacions bàsiques per als allotjaments.
 */
public interface InAllotjament {

    /**
     * Obté el nom de l'allotjament.
     * @return el nom de l'allotjament.
     */
    String getNom();

    /**
     * Estableix el nom de l'allotjament.
     * @param nom el nom a assignar.
     */
    void setNom(String nom);

    /**
     * Obté l'identificador únic de l'allotjament.
     * @return l'identificador únic de l'allotjament.
     */
    String getId();

    /**
     * Estableix l'identificador únic de l'allotjament.
     * @param id l'identificador a assignar.
     */
    void setId(String id);

    /**
     * Obté l'estada mínima segons la temporada.
     * @param temp la temporada (ALTA o BAIXA).
     * @return el valor de l'estada mínima per a la temporada indicada.
     */
    long getEstadaMinima(Temp temp);

    /**
     * Estableix l'estada mínima per a cada temporada.
     * @param estadaMinimaALTA_ l'estada mínima en temporada alta.
     * @param estadaMinimaBAIXA_ l'estada mínima en temporada baixa.
     */
    void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_);

    /**
     * Enumeració que representa les diferents temporades possibles.
     */
    public enum Temp {
        ALTA,
        BAIXA
    }

    /**
     * Modifica l'estat de l'allotjament a No Operatiu i la il·luminació depenent de la tasca rebuda com a paràmetre
     * @param tasca Objecte de tipus TascaManteniment.
     */
    public void tancarAllotjament(TascaManteniment tasca);

    /**
     * Modifica l'estat de l'allotjament a Operatiu i la il·luminació al 100%
     */
    public void obrirAllotjament();

    abstract class  Acces implements InAcces {
        private String nom;
        private boolean accessibilitat;
        private boolean estat;
        private LlistaAllotjaments llista;

        public Acces(String nom,boolean estat) {
            this.nom = nom;
            this.estat = estat;
            this.llista = new LlistaAllotjaments();
            this.accessibilitat=false;
        }

        // GETTERS I SETTERS
        public String getNom(){ return this.nom;}
        public void setNom(String nom){this.nom=nom;}
        public boolean isAccessibilitat(){return accessibilitat;}
        public void setAccessibilitat(boolean accessibilitat){this.accessibilitat=accessibilitat;}
        public boolean isOperatiu(){return this.estat;}
        public void setEstat(boolean estat){this.estat=estat;}
        public LlistaAllotjaments getLlista(){return this.llista;}
        public void setLlista(LlistaAllotjaments llista){this.llista=llista;}

        @Override
        public void afegirAllotjament(Allotjament allotjament) {
            this.llista.afegirAllotjament(allotjament);
        }

        @Override
        public void tancarAcces() {
            estat = false;
        }

        @Override
        public void obrirAcces() {
            estat = true;
        }

        @Override
        public String toString() {
            return "Nom=" + getNom() + ", accessibilitat=" + isAccessibilitat() +
                    ", estat: " + isOperatiu()+
                    ", llista " + getLlista();
        }
    }
}