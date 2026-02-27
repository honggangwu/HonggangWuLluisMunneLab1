package prog2.model;

import prog2.vista.ExcepcioReserva;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;


public class Camping implements InCamping{
    private String nomCamping;
    private ArrayList<Allotjament> allotjaments;
    private ArrayList<Client> clients;
    private LlistaReserves reserves;

    public Camping(String nomCamping) {
        this.nomCamping = nomCamping;
        this.allotjaments = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.reserves = new LlistaReserves();
    }

    @Override
    public String getNom() {
        return nomCamping;
    }


    @Override
    public LlistaReserves getLlistaReserves() {
        return this.reserves;
    }


    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return allotjaments;
    }


    @Override
    public ArrayList<Client> getLlistaClients() {
        return clients;
    }


    @Override
    public int getNumAllotjaments() {
        return this.allotjaments.size();
    }


    @Override
    public int getNumReserves() {
        return this.reserves.getNumReserves();
    }


    @Override
    public int getNumClients() {
        return this.clients.size();
    }


    @Override
    public void afegirClient(String nom_, String dni_) throws ExcepcioReserva {
        Client nouClient = new Client(nom_, dni_);
        clients.add(nouClient);
    }


    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela novaParcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        allotjaments.add(novaParcela);
    }


    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow nouBungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        allotjaments.add(nouBungalow);
    }


    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        BungalowPremium nouBungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        allotjaments.add(nouBungalowPremium);
    }


    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        Glamping glamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        allotjaments.add(glamping);
    }


    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        MobilHome mobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        allotjaments.add(mobilHome);
    }


    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Client nouClient = buscarClient(dni_);
        Allotjament nouAllotjament = buscarAllotjament(id_);

        if (nouClient == null) {
            throw new ExcepcioReserva("No existeix aquest Client");
        }
        if (nouAllotjament == null) {
            throw new ExcepcioReserva("No existeix aquest Id");
        }

        // Afegir la reserva a la llista de reserves del càmping
        this.reserves.afegirReserva(nouAllotjament, nouClient, dataEntrada, dataSortida);
    }

    @Override
    public float calculMidaTotalParceles() {
        float midaTotal = 0; // Iniciamos la suma total de las parcelas

        // Usamos un iterador para recorrer la lista de allotjaments
        Iterator<Allotjament> it = allotjaments.iterator();

        while (it.hasNext()) {
            Allotjament espai = it.next();  // Obtenemos el siguiente allotjament

            // Comprobamos si el allotjament es una instancia de Parcela
            if (espai instanceof Parcela) {
                Parcela parcela = (Parcela) espai;  // Hacemos el casting a Parcela
                midaTotal += parcela.getMida();  // Sumamos la medida de la parcela al total
            }
        }

        return midaTotal;  // Retornamos la suma total de las parcel·les
    }

    @Override
    public int calculAllotjamentsOperatius() {
        int count = 0;
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.correcteFuncionament()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta() {
        if (reserves == null || reserves.getNumReserves() == 0) {
            return null; // Si no hi ha reserves, retornem null
        }

        Reserva reservaMesCurta = null;
        long minDies = Long.MAX_VALUE;

        // Recorrem totes les reserves per trobar la més curta
        for (Reserva reserva : reserves.getReserves()) {
            long diesEstada = ChronoUnit.DAYS.between(reserva.getDataEntrada(), reserva.getDataSortida());

            if (diesEstada < minDies) {
                minDies = diesEstada;
                reservaMesCurta = reserva;
            }
        }

        return (reservaMesCurta != null) ? reservaMesCurta.getAllotjament_() : null;
    }

    public Allotjament buscarAllotjament(String id_){
        for (Allotjament allotjament : allotjaments) {
            if (Objects.equals(allotjament.getId(), id_)){
                return allotjament;
            }
        }
        return null;
    }

    public Client buscarClient(String dni_){
        for (Client client : clients) {
            if (client.getDni().equals(dni_)){
                return client;
            }
        }
        return null;
    }

    public static InAllotjament.Temp getTemporada(LocalDate data){
        if (data==null){
            throw new IllegalArgumentException("Ha d'haver-hi una data");
        }
        int dia =data.getDayOfMonth(); // transforma la data en dies del mes(1-30)
        int mes =data.getMonthValue(); // transforma la data a mes(1-12)
        if ((mes> 3 && mes< 9) || (mes==3 && dia>=21) || (mes==9 && dia<=20)){
            return InAllotjament.Temp.ALTA;
        }
        else{
            return InAllotjament.Temp.BAIXA;
        }

    }
}


