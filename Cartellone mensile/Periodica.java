import java.util.Objects;
/**
 * E' una classe concreta che implementa l'interfaccia "Programmazione". Fornisce una programmazione con una proiezione con intervalli.
 * In particolare, per "intervalli" s'intende la distanza da una proiezione ad un'altra.
 */
public class Periodica extends Programmazione{

    /**
     * IR: la data non può essere null e deve rientrare nel mese. Se l'intervallo 
     */

    private Integer dataInizio;
    private final int intervallo, durataMese;

    // COSTRUTTORE:

    /** Crea una programmazione periodica
     * @param dataInizio data di inizio della proiezione
     * @param intervallo intervallo tra una proezione e un'altra
     * @param durataMese giorni totali del mese
     * @throws NullPointerException la data non può essere null
     * @throws IllegalArgumentException se la data non rientra nel mese e se l'intervallo è < 2
     */
    public Periodica(Integer dataInizio, int intervallo, int durataMese) {
        Objects.requireNonNull(dataInizio, "La data non può essere null.");
        if (dataInizio<0 || dataInizio>durataMese) {
            throw new IllegalArgumentException("La data non rientra nel mese.");
        }

        if (intervallo < 2) {
            throw new IllegalArgumentException("L'intervallo deve essere >= 2.");
        }
 
        this.dataInizio = dataInizio;
        this.intervallo = intervallo;
        this.durataMese = durataMese;

        aggiungiDate();

    }

    // METODI
    /**
     * Aggiunge le date relative alla programmazione
     */
    private void aggiungiDate() {

        for (int i=1; i<=durataMese; i++) {
            if (i == dataInizio) {
                date.add(dataInizio);
                dataInizio += intervallo;
            }
        }
    }

}
