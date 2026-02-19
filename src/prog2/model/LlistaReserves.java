package prog2.model;

import prog2.vista.ExcepcioReserva;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class LlistaReserves implements InLlistaReserves {
    private ArrayList<Reserva> reserves;
    private Camping camping;  // S'ha de posar per tenir una referència al càmping

    // Constructor que inicialitza la llista de reserves
    public LlistaReserves() {
        this.reserves = new ArrayList<>();
    }

    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        // Comprovar si l'allotjament està disponible
        if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("L'allotjament amb identificador " + allotjament.getId() + " no està disponible en la data demanada " + dataEntrada + " pel client " + client.getNom() + " amb DNI: " + client.getDni() + ".");
        }

        // Comprovar si l'estada mínima es compleix
        if (!isEstadaMinima(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("Les dates sol·licitades pel client " + client.getNom() + " amb DNI: " + client.getDni() + " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId() + ".");
        }

        // Si tot és correcte, creem la nova reserva
        Reserva novaReserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        reserves.add(novaReserva);
    }

    // Comprovar si l'allotjament està disponible
    public boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        if (allotjament == null || dataEntrada == null || dataSortida == null) {
            throw new IllegalArgumentException("Ha de tenir allotjament, data entrada i data sortida");
        }
        for (Reserva reserva : reserves) {
            if (reserva.getAllotjament_().equals(allotjament)) {
                LocalDate entradaDataExistent = reserva.getDataEntrada();
                LocalDate sortidaDataExistent = reserva.getDataSortida();

                boolean hihaSolapament = !(dataSortida.isBefore(entradaDataExistent) || dataEntrada.isAfter(sortidaDataExistent));
                if (hihaSolapament) {
                    return false;  // No està disponible
                }
            }
        }
        return true;  // Està disponible
    }

    // Comprovar si l'estada mínima es compleix per la temporada
    public boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        // Calcular la duració de l'estada en dies
        long diesEstada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);

        // Obtenir la temporada segons la data d'entrada (utilitzant el mètode estàtic de Camping)
        InAllotjament.Temp temporada = Camping.getTemporada(dataEntrada);  // Obtenim la temporada directament de la classe Camping

        // Obtenir l'estada mínima per a l'allotjament segons la temporada
        long estadaMinima = allotjament.getEstadaMinima(temporada);  // Obtenim l'estada mínima de l'allotjament

        // Verificar si l'estada sol·licitada és igual o més llarga que la mínima
        return diesEstada >= estadaMinima;
    }

    @Override
    public int getNumReserves() {
        return reserves.size();
    }

    public ArrayList<Reserva> getReserves() {
        return reserves;
    }
}
