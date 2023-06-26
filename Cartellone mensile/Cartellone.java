import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * La classe "cartellone" rappresenta un cartellone mensile di un cinema è caratterizzato da:
 * - nome del cinema, 
 * - durata del mese in giorni,
 * - elenco di proiezioni
 */
public class Cartellone {

    /**
     * IR: il nome del cinema non deve essere vuoto; la durata del mese deve essere compreso tra 28 e 31 giorni
     * 
     * AF: "cinema" rappresenta il nome del cinema, "durataMese" rappresenta la durata di un mese, "listaProiezioni" 
     * indica la lista delle proiezioni
     * 
     */

    public final String cinema;
    public final int durataMese;
    private List<Proiezione> listaProiezioni = new ArrayList<Proiezione>();

    // COSTRUTTORE
    /** Crea un Cartellone
     * @param cinema il nome del cinema
     * @param durataMese la durata in giorni del mese
     * @param listaProiezioni lista di proiezioni
     * @throws NullPointerException se il nome del cinema è nullo
     * @throws IllegalArgumentException se il nome del cinema è vuoto e se la durata del mese non è compresa tra 28 e 31
     */
    public Cartellone(String cinema, int durataMese, String[] listaProiezioniStr) {
              
        if (Objects.requireNonNull(cinema, "Il nome del cinema non può essere null.").isEmpty()) {
            throw new IllegalArgumentException("Il nome del cinema non può essere vuoto.");
        }

        if (durataMese<28 || durataMese>31) {
            throw new IllegalArgumentException("La durata del mese deve essere compreso tra 28 e 31 giorni");
        }

        this.cinema = cinema;
        this.durataMese = durataMese;
        for (int i=0; i<listaProiezioniStr.length; i++) {
            aggiungi(listaProiezioniStr[i]);
        }

    }

    // METODI
    /** Aggiunge una nuova proiezione nella lista delle proiezioni
     * @param p nuova proiezione
     */
    public void aggiungi(String p) {
    
        String[] proiezioneStr = p.split(String.valueOf('"'));
        Proiezione proiezione = new Proiezione(proiezioneStr[1], proiezioneStr[2].substring(1));
        
        if (!interseca(proiezione)) {
            listaProiezioni.add(proiezione);
        }

    }

    private boolean interseca(Proiezione proiezione) {
        Iterator<Proiezione> it = listaProiezioni.iterator();

        while(it.hasNext()) {
            Proiezione proiezioneLista = it.next();

            for (int i=0; i<proiezione.programmazione.date.size(); i++) {
                for (int j=0; j<proiezioneLista.programmazione.date.size();j++) {
                    if (proiezione.programmazione.date.get(i).equals(proiezioneLista.programmazione.date.get(j))) {
                        return true;
                    }
                }
            }
            
        }

        return false;
    }

    /**
     * Elenca le proiezioni per ciascun giorno del mese (con eventuali ripetizioni nei vari giorni)
     */
    public void elencaProiezioniPerGiorno() {

        System.out.println("CARTELLONE\n");
        String intestazioneCartellone = "Cinema: " + cinema + ", giorni: " + durataMese + ", proiezioni: " + listaProiezioni.size() + "\n";
        System.out.println(intestazioneCartellone);

        for (Integer i=1; i<= durataMese; i++) {
            String stampaGiorno = i + " - ";
            System.out.print(stampaGiorno);

            boolean toWrite = true;
            Iterator<Proiezione> it = listaProiezioni.iterator();
            while(it.hasNext() && toWrite) {
                Proiezione proiezioneLista = it.next();
                for(int j=0; j<proiezioneLista.programmazione.date.size(); j++) {
                    if ((proiezioneLista.programmazione.date.get(j)).equals(i)) {
                        System.out.print(proiezioneLista.titolo);
                        toWrite = false;
                        break;
                    }
                }
            }
            
            System.out.println("");

        }

        System.out.println("");

    }


    /**
     * Elenca le proiezioni nell'ordine in cui sono state aggiunte (a prescindere dalle date in cui hanno luogo, una sola volta ciascuna)
     */
    public void elencaProiezioniOrdineAggiunta() {
        Iterator<Proiezione> it = listaProiezioni.iterator();

        System.out.println("PROIEZIONI\n");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("");
    }

    /**
     * La classe interna "Proiezione" rappresenta una proiezione, caratterizzata da:
     * - un titolo (non vuoto)
     * - una programmazione che descrive le date in cui si verifica una proiezione. Essa è non vuota
     * 
     * Ogni proiezione può avvenire in uno o più giorni del mese, per semplicità considereremo solo il caso in cui ci sia al più una 
     * proiezione al giorno (che avvenga, nel caso ad un orario prefissato).
     */
    public class Proiezione {

        /**
         * IR: titolo non deve essere null
         * 
         * AF: "titolo" rappresenta il titolo di una proiezione, "programmazione" rappresenta le date in cui si verifica una proiezione
         */

        public final String titolo;
        public final Programmazione programmazione;
        
        /** Crea una proiezione
         * @param titolo titolo della proiezione
         * @param programmazione la programmazione della proiezione
         * @throws NullPointerException se il titolo è nullo
         * @throws IllegalArgumentException se il titolo è vuoto
         */
        public Proiezione(String titolo, String programmazione) throws IllegalArgumentException {
            
            if (Objects.requireNonNull(titolo, "Il titolo non può essere null.").isEmpty()) {
                throw new IllegalArgumentException("Il titolo non può essere vuoto.");
            }

            if (Objects.requireNonNull(programmazione, "La programmazione non può essere null.").isEmpty()) {
                throw new IllegalArgumentException("La programmazione non può essere vuota.");
            }

            String[] parametri = programmazione.split(" ");

            if (parametri.length == 1) {
                this.programmazione = new Singola(Integer.valueOf(parametri[0]), durataMese);
            } else if (parametri.length > 3 || parametri.length == 2) {
                throw new IllegalArgumentException("Formato errato: devono essere presenti 1 o 3 parametri");
            } else if (parametri[1].equals("R")) {
                this.programmazione = new Repliche(Integer.valueOf(parametri[0]), Integer.valueOf(parametri[2]), durataMese);
            } else if (parametri[1].equals("P")) {
                this.programmazione = new Periodica(Integer.valueOf(parametri[0]), Integer.valueOf(parametri[2]), durataMese);
            } else {
                throw new IllegalArgumentException("Formato errato");
            }

            this.titolo = titolo;
        }

        @Override
        public String toString() {
            return "Cinema: " + cinema + ", " + "titolo: " + '"' + titolo + '"' + ", " + "date: " + programmazione;
        }

        

    }

    
}
