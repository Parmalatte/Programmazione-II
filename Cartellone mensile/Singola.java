import java.util.Objects;

/**
 * E' una classe concreta che implementa l'interfaccia "Programmazione". Fornisce una sola data per la programmazione di una proiezione
 */
public class Singola extends Programmazione {

    /**
     * IR: la data non deve essere null e deve rientrare nel mese.
     * 
     * AF: "data" rappresenta la singola data in cui è presente la programmazione
     */


    // COSTRUTTORE
    /** Costruisce una programmazione singola
     * @param dataInizio
     * @throws NullPointerException se la data è null
     * @throws IllegalArgumentException se la data non rientra nel mese
     */
    public Singola(Integer dataInizio, int durataMese) throws IllegalArgumentException{

        Objects.requireNonNull(dataInizio, "La data non può essere null.");
        if (dataInizio < 0 || dataInizio > durataMese) {
            throw new IllegalArgumentException("La data non rientra nel mese.");
        }
 
        date.add(dataInizio);
    }
    

    
}
