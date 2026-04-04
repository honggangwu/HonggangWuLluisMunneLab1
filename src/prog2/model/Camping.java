package prog2.model;

import prog2.vista.ExcepcioCamping;
import prog2.vista.ExcepcioReserva;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Camping implements InCamping {

    private String nomCamping;
    private LlistaAllotjaments llistaAllotjaments;
    private ArrayList<Client> clients;
    private ArrayList<TascaManteniment> tasques;
    private LlistaAccessos accessos;

    public Camping(String nomCamping) {
        this.nomCamping = nomCamping;
        this.clients = new ArrayList<>();
        this.tasques = new ArrayList<>();
        this.accessos = new LlistaAccessos();
        this.llistaAllotjaments = new LlistaAllotjaments();
    }

    @Override
    public String getNomCamping() {
        return nomCamping;
    }

    @Override
    public void inicialitzaDadesCamping() {

        accessos.buidar();

        float asfalt = 200;
        Acces Acc1 = new CamiAsfalt("A1", true, asfalt);
        accessos.afegirAcces(Acc1);

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfalt("A2", true, asfalt, pesMaxim);
        accessos.afegirAcces(Acc2);

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        accessos.afegirAcces(Acc3);

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        accessos.afegirAcces(Acc4);

        asfalt = 350;
        Acces Acc5 = new CamiAsfalt("A5", true, asfalt);
        accessos.afegirAcces(Acc5);

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfalt("A6", true, asfalt, pesMaxim);
        accessos.afegirAcces(Acc6);

        asfalt = 100;
        Acces Acc7 = new CamiAsfalt("A7", true, asfalt);
        accessos.afegirAcces(Acc7);

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfalt("A8", true, asfalt, pesMaxim);
        accessos.afegirAcces(Acc8);

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        accessos.afegirAcces(Acc9);

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        accessos.afegirAcces(Acc10);

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        accessos.afegirAcces(Acc11);

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        accessos.afegirAcces(Acc12);


        /* Pistes */
        llistaAllotjaments.buidar();


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL1);

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL2);

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.afegirAllotjament(ALL3);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.afegirAllotjament(ALL4);

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.afegirAllotjament(ALL5);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.afegirAllotjament(ALL6);

        /* Accés */
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);


    }
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        boolean operatiu = estat.equalsIgnoreCase("Operatiu");
        StringBuilder sb = new StringBuilder();

        for (Allotjament a : llistaAllotjaments.getAllotjaments()) {
            if (a.isOperatiu() == operatiu) {
                sb.append(a).append("\n");
            }
        }

        if (sb.isEmpty()) {
            throw new ExcepcioCamping("No hi ha allotjaments amb l'estat " + estat);
        }

        return sb.toString();
    }

    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        boolean obert = infoEstat.equalsIgnoreCase("Obert");
        return accessos.llistarAccessos(obert);
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        if (tasques.isEmpty()) {
            throw new ExcepcioCamping("No hi ha tasques de manteniment");
        }

        StringBuilder sb = new StringBuilder();

        for (TascaManteniment t : tasques) {
            sb.append(t).append("\n");
        }

        return sb.toString();
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {
        Allotjament allotjament = buscarAllotjament(idAllotjament);

        if (allotjament == null) {
            throw new ExcepcioCamping("No existeix l'allotjament " + idAllotjament);
        }

        TascaManteniment.TipusTascaManteniment tipusTasca;

        try {
            tipusTasca = TascaManteniment.TipusTascaManteniment.valueOf(tipus.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("Tipus de tasca incorrecte");
        }

        TascaManteniment tasca = new TascaManteniment(num, allotjament, tipusTasca, data, dies);
        tasques.add(tasca);
        allotjament.tancarAllotjament(tasca);
    }

    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {
        TascaManteniment trobada = null;

        for (TascaManteniment t : tasques) {
            if (t.getNum() == num) {
                trobada = t;
                break;
            }
        }

        if (trobada == null) {
            throw new ExcepcioCamping("No existeix cap tasca amb número " + num);
        }

        trobada.getAllotjament().obrirAllotjament();
        tasques.remove(trobada);
    }

    @Override
    public int calculaAccessosNoAccessibles() {
        return accessos.calculaAccessosNoAccessibles();
    }

    @Override
    public float calculaMetresTerra() {
        return accessos.calculaMetresTerra();
    }

    public Allotjament buscarAllotjament(String id) {
        for (Allotjament a : llistaAllotjaments.getAllotjaments()) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
    @Override
    public void save(String camiDesti) throws ExcepcioCamping {
        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream(camiDesti));

            out.writeObject(this);
            out.close();

        } catch (IOException e) {
            throw new ExcepcioCamping("No s'ha pogut guardar el fitxer.");
        }
    }
    public static Camping load(String camiOrigen) throws ExcepcioCamping {
        try {
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream(camiOrigen));

            Camping c = (Camping) in.readObject();
            in.close();

            return c;

        } catch (IOException | ClassNotFoundException e) {
            throw new ExcepcioCamping("No s'ha pogut carregar el fitxer.");
        }
    }
}
