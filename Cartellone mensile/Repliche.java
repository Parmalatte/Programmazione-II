import java.util.Objects;

/**
 * E' una classe concreta che implementa l'interfaccia "Programmazione". Fornisce una programmazione con una proiezione con repliche.
 * In particolare, per "repliche" s'intende la ripetizione per un numero preciso di giorni di fila in cui è presente la proiezione.
 */

public class Repliche extends Programmazione{

    /**
     * IR: "dataInzio" non deve essere null e deve rientrare nel mese. La replica deve essere >= 2 e, insieme alla data,
     *  non devono oltrepassare il mese.
     * 
     * AF: "data" rappresenta la singola data in cui è presente la programmazione
     */

    private Integer dataInizio;
    private int replica;
    private final int durataMese;

    // COSTRUTTORE
    /** Costruisce una proiezione con repliche
     * @param data data di inizio della proiezione
     * @param replica numero di repliche della proiezione
     * @param durataMese giorni totali del mese
     * @throws NullPointerException la data non può essere null
     * @throws IllegalArgumentException se la data non rientra nel mese, se la proiezione supera il mese e se la replica è < 2
     */
    public Repliche(Integer dataInizio, int replica, int durataMese) throws IllegalArgumentException{

        Objects.requireNonNull(dataInizio, "La data non può essere null.");
        if (dataInizio<0 || dataInizio>durataMese) {
            throw new IllegalArgumentException("La data non rientra nel mese.");
        }
        if (dataInizio + replica-1 > durataMese) {
            throw new IllegalArgumentException("La data con le repliche non rientrano nel mese.");
        }

        if (replica < 2) {
            throw new IllegalArgumentException("La proiezione deve avere un numero minimo di repliche pari a 2.");
        }

        this.dataInizio = dataInizio;
        this.replica = replica;
        this.durataMese = durataMese;


        aggiungiDate();

    }

    // METODI
    /**
     * Aggiunge le date relative alla programmazione
     */
    private void aggiungiDate() {
        for (int i=1; i<=durataMese; i++) {
            if (i == dataInizio && replica != 0) {
                date.add(dataInizio);
                dataInizio++;
                replica--;
            }
        }
    }


}
