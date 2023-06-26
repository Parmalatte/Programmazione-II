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

#### Eccezioni (le più utilizzate)
- `IllegalArgumentException`: argomento non rispetta
- `IndexOutOfBoundException`: nel caso in cui la posizione sia un indice che eccede i limiti legittimi
- `NonNullException`: viene lanciata quando viene evocato `Objects.requireNonNull(durata, "La durata non può essere null")`
