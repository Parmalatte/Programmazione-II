# Programmazione II 
### Tips
#### Record
E' una raccolta di dati tipizzati immutabili
```java
// Inizializzarlo
public record MercatoDellePulci(String nomeMercato, int pulci){} 
// --------------------------------------

public record MercatoDellePulci(String nomeMercato, int pulci){
  public MercatoDellePulci(){} // Il costruttore compatto
}

```
E' possibile aggiungere dei field e metodi statici, ma non "private", in quanto è una raccolta di oggetti immutabili.
Possiamo creare un record dentro un record. 
**Nota bene**: non sono estendibili, perché sono già estesi, e neanche ereditare, ma implementare sì.
Possiamo creare delle interfacce, ma non possiamo fare l'override.

#### Static
Condividere un metodo o un attributo tra tutti. Non riguarda l'istanza ma la classe (dove è presente `static`).

#### Iteratore
Un iteratore è un oggetto che consente di accedere sequenzialmente agli elementi di una collezione, senza la necessità di conoscerne la struttura o l'implementazione sottostante. In altre parole, un iteratore fornisce un'interfaccia per eseguire l'iterazione su una collezione.

Per implementare un iteratore, è necessario seguire alcune fasi:

Creare una classe che rappresenti l'iteratore. Questa classe dovrebbe avere un riferimento alla collezione su cui si sta iterando e mantenere lo stato corrente dell'iterazione.

Implementare almeno due metodi: uno per ottenere l'elemento successivo nella sequenza (ad esempio next()), e un altro per verificare se ci sono ancora elementi disponibili (ad esempio hasNext()).

Nel metodo next(), è necessario restituire il prossimo elemento nella sequenza e spostare lo stato corrente dell'iterazione in avanti.

Nel metodo hasNext(), è necessario controllare se ci sono ancora elementi disponibili nella sequenza. Se sì, restituirà true; altrimenti, restituirà false.

All'interno della classe della collezione, è necessario implementare un metodo per restituire un'istanza dell'iteratore, ad esempio getIterator(), che restituirà un nuovo oggetto iteratore ogni volta che viene chiamato.

Ecco un esempio di implementazione di un iteratore in linguaggio Java:
```java
import java.util.Iterator;

public class MyCollection implements Iterable<Integer> {
    private int[] elements;

    public MyCollection(int[] elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Integer> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < elements.length;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                int element = elements[index];
                index++;
                return element;
            }
            return null;
        }
    }
}
```
In questo esempio, MyCollection rappresenta la collezione su cui si desidera eseguire l'iterazione. Implementa l'interfaccia `Iterable`, che richiede l'implementazione di un metodo `iterator()` che restituisce un'istanza dell'iteratore.

La classe interna MyIterator implementa l'interfaccia Iterator, fornendo l'implementazione dei metodi hasNext() e next(). hasNext() controlla se ci sono ancora elementi disponibili nella sequenza, mentre next() restituisce il prossimo elemento nella sequenza e sposta lo stato corrente dell'iterazione in avanti.

Infine, quando si desidera iterare sulla collezione MyCollection, è possibile utilizzare un ciclo for-each o un ciclo while insieme al metodo iterator() per ottenere un'istanza dell'iteratore e accedere sequenzialmente agli elementi della collezione:

```java
int[] elements = {1, 2, 3, 4, 5};
MyCollection collection = new MyCollection(elements);

for (int element : collection) {
    System.out.println(element);
}
```
Questo esempio stamperebbe tutti gli elementi della collezione uno alla volta.

#### Eccezioni (le più utilizzate)
- `IllegalArgumentException`: argomento non rispetta
- `IndexOutOfBoundException`: nel caso in cui la posizione sia un indice che eccede i limiti legittimi
- `NonNullException`: viene lanciata quando viene evocato `Objects.requireNonNull(durata, "La durata non può essere null")`
