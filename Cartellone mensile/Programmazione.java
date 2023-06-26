import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * E' una classe astratta che dati di interi compresi tra 1 e 31 rappresentano i giorni del mese in cui si svolge la proiezione.
 */

public abstract class Programmazione{
 
    public final List<Integer> date;

    // COSTRUTTORE
    public Programmazione(){
        date = new ArrayList<Integer>();
    }
    
    // METODI
    @Override
    public String toString() {
        Iterator<Integer> it = date.iterator();

        String s = "";
            while(it.hasNext()) {
                s += it.next();
                if (it.hasNext()) {
                    s+= ", ";
                }
            }

        return s;
    }


}
