# Programmazione II

### Introduzione - Java

Java è un linguaggio a orientato ad oggetti. Per **oggetti** s'intende un'istanza di classi, che contengono lo stato e le operazioni (metodi). In particolare, i programmi interagiscono con gli oggetti invocando i loro metodi. Questi accedono allo stato, consentendo l'utilizzo del codice per osservare lo stato corrente di un oggetto o di modificarlo.

##### La struttura dei programmi

I programmi di Java sono creati da **classi** e **interfacce**:

- Le classi vengono utilizzati in due modi:
  
  1. Per definire le collezioni di procedure 
  
  2. Per definire nuovi tipi di dati

- Le interfacce sono anche loro utilizzate per definire nuovi tipi di dati.

Tuttavia, l'utilizzo di classi e interfacce permette di definire i **metodi**: 

- una classe che definisce un gruppo di procedure fornisce un metodo per ognuna di esse. 

- una classe o interfacca che definisce un tipo di dato fornisce un metodo per le operazioni associate a quell'oggetto di quel tipo

Un metodo prende zero o più argomenti e restituisce un singolo risultato. Tale informazione viene indicata dall'header. Gli argomenti vengono associate come *parametri formali* (ossia con i valori) o *formals* (ossia con le variabili) della chiamata. Un metodo può anche terminare passando un eccezione. Nel caso in cui non viene restituito alcun risultato, viene utilizzata `void`.

##### Packages

Le classi e le interfacce sono raggruppate in pacchetti. I pacchetti hanno due scopi:

1. Sono dei meccanismi di incapsulazione

2. Forniscono un modo di condividere le informazioni all'interno del pacchetto, prevenendo il suo utilizzo al di fuori

Ogni classe e interfaccia hanno una visibilità dichiarata (ossia viene consentito l'accesso da tutti). Solo le classi e le interfacce dichiarate `public` possono essere utilizzate dal codice in altri pacchetti. La medesima situazione accade con le dichiarazioni all'interno delle classi.

Un altro utilizzo dei pacchetti è per `naming`. Ogni pacchetto ha un nome gerarchico che lo distingue dagli altri pacchetti. Classe e interfacce presenti nel pacchetto hanno nomi che si riferiscono al nome del pacchetto. Questo significa non ci possono essere conflitti tra classi e interfacce tra pacchetti diversi. Due modi per poter definire una classe presente in un altro pacchetto è:

- La forma completa

- Importando il pacchetto. In questo modo è possibile utilizzare nomi corti. Tuttavia è possibile riscontrare un conflitto di nomi.

Tuttavia, alcune volte è presente un conflitto tra l'incapsulamento e naming. E' conveniente raggruppare molte definizioni (di classi) nello stesso pacchetto così che il codice esterno al pacchetto ha l'accesso ad ogni classe (ad esso associato) importando l'intero pacchetto. Tuttavia, il codice all'interno del pacchetto può alcune volte accedere alle informazioni interne di altre definizioni interne al pacchetto. In generale, questo tipo di conflitto dovrebbe essere risolto in favore dell'incapsulamento.

##### Oggetti e variabili

Tutti i dati sono accessibili tramite ***variabili***. Le *variabili locali*, come quelle dichiarate all'interno dei metodi, risiedono nello stack di runtime: lo spazio viene allocato per esse quando il metodo viene chiamato e deallocato quando il metodo ritorna.

Ogni variabili ha una dichiarazione che ne indica il tipo, che può definire un insieme di valori (*tipo primitivo*) o un *oggetto*.

**Nota bene:** le variabili di tipi primitivi contengono i valori, mentre gli altri contengono riferimenti ad oggetti che risiedono nell'heap. Gli oggetti vengono creati nell'heap mediante l'uso dell'operatore `new`.

```java
// Es.
int i = 6;
int j; // non inizializzato

int[] a = {1,3,5,7,9}; // crea un array da 5 elementi
int[] b = new int[3];

String s = "abcdef"; // crea una nuova stringa
String t = null;
```

Tutti gli oggetti sono ***mutabili*** o ***non mutabili***. Lo stato di un oggetto *immutabile* non cambia mai, mentre quello di un oggetto *mutabile* sì. Ad esempio, le stringhe sono immutabili, dal momento che non ci sono metodi String che fanno cambiare lo stato di un oggetto String. Invece gli array sono mutabili.

**Nota bene:** Un oggetto è ***condiviso*** da due variabili se è possibile accedervi tramite una di esse. Se un oggetto mutabile è condiviso da due variabili, le modifiche apportate tramite una di esse saranno visibili quando l'oggetto viene utilizzato attraverso l'altro.

##### Controllo del tipo

Java è un linguaggio ***fortemente tipizzato*** e fornisce la gestione automatica dell'archiviazione per tutti gli oggetti. Inoltre, Java controlla tutti gli accessi all'array per assicurarsi che rientrino nei limiti. Queste tecniche assicurano che non si verifichino mancate corrispondenza di tipo in fase di esecuzione. 

Java supporta la ***gerarchia dei tipi***, in cui un tipo può essere il *supertipo* di altri tipi, ossia i suoi *sottotipi*. Gli oggetti di un sottotipo hanno tutti i metodi definiti dal supertipo. Tutti i tipi di oggetti sono sottotipi di `Object`, che è al verticee della gerarchia dei tipi. `Object` definisce una serie di metodi, inclusi `equals` e `toString`. 

Java permette la ***conversione implicita*** di valori di alcuni tipi in altri (es. da carattere a valori numerici). Inoltre, Java permette l'***overloading***.

##### Dispatching

Quando un metodo viene chiamato su un oggetto, è essenziale che la chiamata vada al codice fornito da quell'oggetto per quel metodo, perché solo quel codice può far la cosa giusta.

##### Tipi

- **Tipi di oggetti *primitivi*** (es. `int` e `char`): non sono sottotipi di `Object` e il loro valori non possono essere utilizzati in contesti in cui sono richiesti oggetti. I valori primitivi possono essere utilizzati in contesti che richiedono oggetti avvolgendoli in oggetti. Infatti, ogni tipo primitivo ha un tipo di oggetto associato (es. `Interger` per `int`, `Character` per `char`). Tale tipo fornisce un costruttoore per produrre uno dei suoi oggetti. Vi sono molti metodi di tali oggetti e sono possibili consultarli nel pacchetto `java.lang`.

- **Vettori**: sono array estendibili; sono vuoti quando creati per la prima volta e possono crescere e ridursi nella fascia alta. I vettori sono definiti nel pacchetto `java.util`. Ha molti metodi, tra cui `add`, `get`, `set` e `remove` 

##### Flusso Input/Output

Il pacchetto `java.io` fornisce una serie di tipi di flussi di input e output. L'input/output viene eseguito utilizzando flussi di caratteri: 

- L'**input** viene eseguito utilizzando oggetti che appartengono al tipo `Reader` o a uno dei suoi sottotipi (es. `BufferReader` o `FileReader`).

- L'**output** si verifica su oggetti di tipo `Writer` o sui suoi sottotipi (es. `PrintWriter`, che stampa valori e oggetti su un dispositivo di output, e `FileWriter`). 

Java fornisce anche alcuni oggetti predefiniti per eseguire lo standard I/O, questi oggetti sono definiti nella classe `System` del package `java.lang`: `System.in`, `System.out`, `System.err`. Questi oggetti non sono oggetti flusso di caratteri, ma, in particolare:

- `System.in` è un `InputStreams`

- `System.out` e `System.err` sono `PrintStreams`.

##### Applicazioni Java

Esistono due tipi di applicazioni Java: quelle eseguite dalla riga di comando nel terminale e quelle eseguite interagendo con un'interfaccia utente. Le applicazioni che vengono eseguite da riga di comando forniscono un metodo principale. Questo metodo accetta un array di righe come argomento:

```java
public static void main(String[])
```

dove l'array di argomenti contiene gli argomenti della riga di comando. 

---

### Astrazione procedurale

L'***astrazione procedurale***, o *procedura*, è una mappatura molti-a-uno da un set di argomenti presi in input che producono output. Ci sono due tipologie di astrazione:

- **Astrazione attraverso *parametrizzazione***: astraiamo dall'identità (presenza, numero e tipo) dei dati utilizzati. Viene definita in termini di parametri formali. La parametrizzazione generalizza l'astrazione;

- **Astrazione attraverso *specifica***: ci concentriamo sul comportamento da cui l'utente può dipendere e astraiamo dai dettagli dell'implementazione di tale comportamento. Ciò rende irrilevante il metodo di realizzazione del comportamento.  
  
  Due *vantaggi* che si basano sulla distinzione tra un'astrazione e le sue implementazioni:
  
  - ***Località***: l'implementazione di un astrazione può essere letta o scritta senza il bisogno di esaminare le implementazioni di ogni altra astrazione. In altre parole, per scrivere un programma che utilizza un'astrazione, un programmatore ha bisogno di **capire solo il suo comportamento** e non i suoi dettagli implementativi. E' utile non solo per il programmatore, ma anche per chi cerca di capire l'astrazione o la ragione del suo comportamento
  
  - ***Modificabilità***: un astrazione può essere reimplementata senza richiedere cambiamenti per ogni astrazione che la utilizza, migliorando le prestazioni.

##### Specifica

E' essenziale che alle astrazioni vengano date definizioni precise. Definiremo le astrazioni per mezzo di specifiche, che sono scritte in un ***linguaggio di specificazione*** che può essere formale (vantaggio: hanno un significato preciso) o informale (vantaggio: sono più facili da leggere e scrivere, utilizzaremo queste).

La specifica di una procedura è costituita da un'**intestazione** e da una **descrizione degli effetti**. 

- L'*intestazione* fornisce il nome della procedura, il numero, l'ordine e i tipi dei suoi parametri e il tipo del risultato. (Elenca anche tutte le eccezioni generate dalla procedura). Inoltre, i nomi devono essere dati per parametri.
  
  ```java
  void removeDupls (Vector v);
  
  float sqrt (float x);
  ```
  
  *Nota bene*: le informazioni nell'intestazione sono sintetiche; descrive la "forma" della procedura

- La parte della *semantica* di una specifica è composta da **tre clausole**, mostrate come commenti, che descrivono la relazione tra gli input e i risultati delle procedure.
  
  - **Richiesta** (`REQUIRES`):  indica i vincoli in base ai quali è definita l'astrazione. E' necessaria se la procedura è parziale, cioè se il suo comportamento non è definito per alcuni input. Nel caso in cui la procedura è totale, può essere omessa;
  
  - **Modifiche** (`MODIFIES`): elenca i nomi di tutti gli input (compresi gli input impliciti) modificati dalla procedura. Se alcuni input vengono modificati, possiamo dire che la procedura ha un *effetto collaterale*. Può essere omessa se non ci sono input che vengono modificati;
  
  - **Effetti** (`EFFECTS`): descrive il comportamento della procedura per tutti gli input non esclusi dalla clausola `required`.  Definisce quali output vengono prodotti e anche quali modifiche vengono appportate agli input elencati nella clausola di `modifica`. Questa clausola è scritta presupponendo che la clausola `require` sia soddisfatta e non dice nulla sul comportamento della procedura quando essa non viene soddisfatta.
  
  In Java, le procedure atomiche sono definite come metodi statici di classi. Per utilizzare tale metodo, è necessario conoscere la classe, aggiungendo una breve descrizione del suo scopo.
  
  ```java
  visibility cname {
      // OVERVIEW: This clause defines the purpose of the class ad a whole
  
      visibility static p1 ...
      visibility static p2 ...
  }
  ```

Es.

```java
public class Arrays {
// OVERVIEW This class provides a number of standalone procedures that
// are useful for manipulating arrays of ints

    public static int search (int [] a, int x) {
        // EFFECTS: if x is in a, returns an index where x is stored;
        //     otherwise, returns -1.
    }

    public static int searchSorted (int[] a, int x){
        // REQUIRES: a is sorted in ascending order
        // EFFECTS: if x in a, returns an index where x is stored;
        //    otherwise, returns -1
    }

    public static void sort (int[] a) {
        // MODIFIES: a
        // EFFECTS: Rearranges the elements of a into ascending order
        // e.g. if a = [3,1,6,1] before the call, on return a = [1,1,3,6]
    }


}


// Esempio di una procedura che ha input impliciti, ossia System.in e System.out:
public static void copyLine() {
    // REQUIRES: System.in contains a line of text
    // MODIFIES: System.in and System.out
    // EFFECTS: Reads a line of the line, and writes the line on System.out

}
```

**Nota bene**: la specifica funge da contratto tra utenti e implementatori.

##### Implementing Procedures

L'implementazione di una procedura dovrebbe produrre il comportamento definito dalla sua specifica. In particoolare, dovrebbe modificare solo gli input presenti nella clausola `MODIFIES`, e, se tutti gli input soddisfano la clausola `REQUIRES`, dovrebbe produrre il risultato in accordo con la clausola `EFFECTS`.

##### Designing Procedural Abstractions

Le procedure dovrebbero essere progettate per essere *minimamente vincolate*. Importanti proprietà delle specifiche che devono caratterizzare una procedura sono:

- **Minimalità**: una specifica è più minima di un'altra se contiene meno vincoli sul comportamento consentito. Ciò è utile dal per l'utente dal momento che questo ignora algoritmo utilizzato nell'implementazione. 
  
  Tuttavia, una procedura si dice ***sottodeterminata*** se per certi input la sua specificazione permette più di un possibile risultato. Inoltre, una implementazione di una procedura si dice ***deterministica*** se per gli stessi input produce sempre lo stesso risultato. Le implementazioni di procedure sottodeterminate sono quasi sempre deterministiche

- **Generalità**: una specifica è più generale di un'altra se può gestirne una più ampia classe di input; viene ottenuta utilizzando parametri invece di specifiche variabili o assunzioni. Tuttavia, generalizzare una procedura è utile solo nel momento in cui aumenta la sua utilità (es. eliminazione delle assunzioni sulla dimensione)

- **Semplicità**: una procedura dovrebbe uno scopo ben definito e facilmente spiegabile, indipendente dal suo contesto di utilizzo. Un buon controllo per la semplicità consiste nell'assegnare alla procedura un nome che ne descriva lo scopo.

Due tipologie di procedure. Si parla di procedura **totale**, se il suo comportamento è specificato per tutti gli input, altrimenti si chiama procedura **parziale**. La specifica di una procedura parziale contiene sempre una clausola `REQUIRE`. La differenza tra le due:

- **Sicurezza**: Le procedure parziali sono meno sicure rispetto a quelle totale, dal momento che lasciano all'utente il compito di soddisfare i vincoli della clausola `REQUIRE`.  Pertanto, dovrebbero essere utilizzate solo quando il contesto di utilizzo è limitato o quando consentono un beneficio sostanziale, come prestazioni migliori

- **Efficienza**: Le procedure parziali possono essere più efficienti da implementare rispetto a quelli totali

La scelta tra le due si basa sul contesto in cui la procedura viene utilizzata. Quando possibile, l'implementazione dovrebbe controllare i vincoli nella clausola `REQUIRE` e lanciare un'eccezione se non sono soddisfatti.

---

### Eccezioni

Le procedure parziali possono causare la presenza di programmi *non robusti*, ossia programmi che continuano a comportarsi ragionevolmente anche in presenza di errori. Idealmente, in presenza di essi, il programma dovrebbe continuare fornendo un'approssimazione del suo comportamento in assenza di errori. In questo caso si dice che un programma fornisce un *graceful degradation* (= grazioso degrado). Nel peggiore dei casi, dovrebbe interrompersi con un messaggio di errore significatico e senza causare danni permanenti ai dati.

Un metodo che migliora la robustezza consiste nell'utilizzo di procedure totali: nel caso in cui la procedura non è in grado di eseguire la sua funzione "destinata" per alcuni input, può almeno informare il chiamante del problema, che potrebbe essere in grado di risolverlo o almeno evitare conseguenze dannose. Per poter avvisare il chiamante è possibile utilizzare un *particolare risultato* per trasmettere le informazioni, ma non è soddisfacente, poiché, essendo probabilmente la chiamata con argomenti illegali un errore, è più costruttivo trattare esso come un caso particolare. Inoltre, restituire un risultato speciale potrebbe essere scomodo per la chiamata tramite codice e, se ogni valore del tipo restituito è un possibile risultato della procedura, la soluzione di restituire un risultato speciale è impossibile.

Ciò che serve è un approccio che trasmetta informazioni su situazioni insolite in tutti i casi. Inoltre, è auspicabile che l'approccio distingua le situazioni, in modo tale che gli utenti non possano ignorarle per errore. Ciò viene fornito da un ***meccanismo di eccezione***, che consente a una procedura di terminare normalmente, ritornando un risultato, o eccezionalmente. In Java, ogni terminazione eccezionale corrisponde a un diverso *tipo di eccezione*.

##### Specifiche

Una procedura che può terminare eccezionalmente è indicata con una *throws clause* nella sua intestazione:

```java
throws <list_of_types>
```

**Nota bene**: una procedura può generare più di un tipo di eccezione.

La specifica di una procedura che genera eccezioni deve rendere chiaro agli utenti cosa sta succedendo:

- Nell'intestazione devono essere elencati tutte le eccezione che può lanciare come parte del suo comportamento "ordinatio"
- La clausola `EFFECTS` deve spiegare cosa provoca la generazione di ogni eccezione

```java
// Es.

public static int fact (int n) throws NonPositiveException
// EFFECTS: If n is non-positive, throws NonPositiveException, else
// returns the factorial of n

public static int search (int[] a, int x) 
    throws NullPointerException, NotFoundException
// REQUIRES: a is sorted
// EFFECTS: If a is null throws NullPointerException; else if x is not
// in a, throws NotFoundException; else returns i such that a[i] = x
```

**Nota bene**: la sezione `MODIFIES` di una specifica indica che un argomento può essere modificato, ma non dice quando ciò accadrà. Ciò che accade esattamente deve essere descritto nella sezione `EFFECTS`

```java
public static void addMax (Vector v, Integer x)
    throws NullPointerException, NullSmallException
// REQUIRES: All elements of v are Integers
// MODIFIES: v
// EFFECTS: If v is null throws NullPointerException; if
// v contains an element larger than x throws NotSmallException;
// else adds x to v
```

##### Meccanismo di Eccezioni in Java

I tipi di eccezione sono sottotipi di `Exception` o `RuntimeException`, entrambi sottotipi del tipo `Throwable`.

<img title="" src="file:///home/dorian/Pictures/Screenshot_20230512_232444.png" alt="Screenshot_20230512_232444.png" data-align="center" width="211">

Da notare la presenza di due tipi di eccezioni:

- **Eccezioni controllate**: sono sottotipi di `Exception`, ma non di `RuntimeException`

- **Eccezioni non controllate**: sono sottotipi di `RuntimeException`

Ci sono due differenze nel *modo* in cui le eccezioni controllate e non controllate possono essere utilizzate in Java:

1. Se una procedura potrebbe generare un'*eccezione controllata*, Java richiede che l'eccezione sia **elencata nell'intestazione** della procedura; in caso contrario, si verificherà un errore in fase di compilazione. Le *eccezioni non controllate* non hanno bisogno di essere elencate nell'intestazione.
2. Se il codice chiama una procedura che potrebbe generare un'*eccezione controllata*, Java richiede che **gestisca l'eccezione**; in caso contrario, ci sarà un errore in fase di compilazione. Le *eccezioni non controllate* non devono essere gestite nel codice chiamante.

**Nota bene**: è possibile ottenere le informazioni dalla clausola degli effetti della specifica, ma includere le informazioni nell'intestazione le porta all'attenzione dell'utente in modo diretto (oltre ad assicurarsi che la cluasola `EFFECTS` le spieghi).

Quando viene definito un nuovo tipo di eccezione, la sua dichiarazione indica se è *controllata* o *non controllata*, indicando il suo **supertipo**: se il supertipo è `Exception` è controllato, mentre se il supertipo è `RuntimeException` non è controllato.

```java
public class NewKindOfException extends Exception {
    public NewKindOfException() { super(); }
    public NewKindOfException(String s) { super(s); }
}

/*
L'intestazione della classe indica che il nuovo tipo NewKindOfException è 
un sottotipi del tipo Exception (*extends*).
Pertando, l'eccezione definita è un'eccezione controllata
*/
```

Come viene mostrato, una classe che definisce un nuovo tipo di eccezione deve solo definire i costruttori. La definizione di un nuovo tipo di eccezione richiede poco lavoro, perché la maggior parte del codice per il nuovo tipo viene ereditato dalla classe che implementa il suo supertipo.

**Ricorda**: i costruttori sono metodi speciali utilizzati per inizializzare gli oggetti appena creati della classe. 

Il tipo eccezione fornisce due costruttori:

- Il secondo costruttore inizializza l'oggetto eccezione per contenere la stringa fornita come suo argomento:
  
  ```java
  Exception e1 = new NewKingOfException("This is the reason");
  // Fa sì che l'oggetto eccezione e1 contenga la stringa "This is the reason"
  ```

- Il primo costruttore inizializza l'oggetto per contenere la stringa vuota:
  
  ```java
  Exception e2 = new NewKingOfException();
  ```

La stringa, insieme al tipo eccezione, può essere ottenuta chiamando il metodo `toString` sull'oggetto eccezione:

```java
String s = e1.toString()
// Fa sì che s contenga la stringa "NewKindOfException: this is the reason"
```

I tipi eccezione devono essere definiti in alcuni pacchetti. Per definirli, è consigliato avere un *pacchetto* che definisca i tipi eccezione definiti per altre procedure, anziché nello stesso pacchetto che contiene la classe dei metodi che li lanciano (nome più lungo). Ciò consente di utilizzare lo stesso tipo di eccezione in molte routines.

Una procedura Java può terminare generando un'eccezione, attraverso l'istruzione `throw`:

```java
if (n <= 0) throw new NonPositiveException("Num.fact");

// Stiamo lanciando un oggetto di tipo "NonPositiveException".
// In realtà costruiamo questo oggetto come parte del lancio, chiamando new
```

Il problema principale quando si lanciano eccezioni è cosa usare come argomento `string`. In particolare, la stringa viene utilizzata per trasmettere informazioni all'utente quando il programma non è in grado di gestire l'eccezione. Solitamente vengono forniti il nome della classe e del metodo. Nel caso in cui il metodo è sovraccarico, devono essere forniti anche i tipi dei suoi argomenti.

Quando una procedura termina con un'eccezione, il controllo viene trasfeirto a un codice che gestisce l'eccezione. Il codice tratta l'eccezione in due modi:

1. L'eccezione viene gestito in modo *esplicito* utilizzando l'istruzione `try`
   
   ```java
   try { x = Num.fact(y); }
   catch (NonPositiveException e) {
       // in here can use e
   }
   
   /*
   Se la chiamata `fact` genera `NonPositiveException`, 
   viene eseguita la clausola `catch`: l'oggetto eccezione è 
   assegnato alla variabile `e` in modo che questo oggetto 
   possa essere utilizzato durante la gestione dell'eccezione.
   */
   ```
   
   Inoltre, è possibile allegare diverse clausole `catch` per gestire diverse eccezioni. Se un'eccezione generata dal corpo dell'intruzione `try` interna non viene rilevata da una delle relative clausole `catch`, può essere rilevata da una delle clausole dell'istruzione `try` esterna:
   
   ```java
   try { ...;
       try { x = Arrays.search(v,7); }
       catch (NullPointerException e) {
           throw new NotFoundException(); }
   } catch (NotFoundException b) { ... }
   ```
   
   Le clausole `catch` non devono identificare il tipo effettivo di un'eccezione oggetto. Al contrario, la clausola può elencare un supertipo del tipo.
   
   ```java
   try {x = Arrays.search(v,y); }
   catch (Exception e) { s.println(e); return; }
   
   /*
   La clausola catch gestirà sia "NullPointerException" 
   sia "NotFoundException".
   */
   ```

2. L'eccezione viene **propagata**. Ciò si verifica quando una chiamata all'interno di una procedura $P$ segnala un'eccezione che non è gestita da una clausola `catch` di qualsiasi istruzione contenente `try` in $P$. In questo caso, Java propaga automaticamente l'eccezione al chiamante di $P$ a condizione che si verifichi una delle seguenti condizioni:
   
   - Quel tipo di eccezione o uno dei suoi supertipi è elencato nell'intestazione di $P$
   - Il tipo di eccezione è *non controllato*
   
   In caso contrario, c'è un errore in fase di compilazione.

Qualsiasi chiamata può potenzialmente generare qualsiasi eccezione non controllata, ma rappresentano un problema dal momento che è difficile conoscere la loro provenienza. L'unico modo per poter essere certi dell'origine di un'eccezione *non controllata* è restringere l'ambito dell'istruzione `try`.

```java
// Es.

// E' consigliato passare da:
try { x = y[n]; i = Arrays.search(z,x); }
catch (IndexOutOfBoundsException e) {
    // gestire IndexOutOfBoundsException dall'accesso all'array y[n]
}
// continuo del codice, supponendo che il problema sia risolto


// a

try { x = y[n]; }
catch (IndexOutOfBoundsException e) {
    // gestire IndexOutOfBoundsException dall'accesso all'array y[n]
}
i = Arrays.search(z,x);
```

##### Programmare con eccezioni

Esistono due modi per gestire un'eccezione:

- ***Reflecting***: anche il chiamante termina lanciando un'eccezione. Tale riflesso può essere ottenuto mediante propagazione automatica o catturando esplicitamente un'eccezione e quindi generando un'eccezione. Il primo è più limitato perché viene lanciato lo stesso oggetto eccezione. Più comunemente, vogliamo lanciare un oggetto diverso (di un diverso tipo di eccezione), perché il significato dell'informazione è cambiato. Inoltre, prima di riflettere l'eccezione, il chiamante potrebbe dover eseguire un'elaborazione locale per soddisfare le sue specifiche

- ***Masking***: il chiamante maschera l'eccezione, cioè gestisce l'eccezione stessa, permettendo la continuazione del flusso normale.

**Nota bene**: le eccezioni possono essere utilizzate per evitare altro lavoro.

##### Problemi di progettazione

Esistono due problemi principali: quando utilizzare un'eccezione e se utilizzare un'eccezione *controllata* o *non controllata*.

**Nota bene**: le eccezioni non sono sinonimo di errori; le eccezioni sono un meccanismo che consente a un metodo di portare alcune informazioni all'attenzione del chiamante.

Le eccezioni dovrebbero essere utilizzate per eliminare la maggior parte dei vincoli elencati nelle clausole `REQUIRE`, che dovrebbe rimanere solo per motivi di efficienza o se il contesto di utilizzo è così limitato da poter essere certi che il vincolo sia soddisfatto. Inoltre, le eccezioni dovrebbero essere utilizzate per evitare di codificare informazioni nei risultati ordinari (es. inserire -1 se un elemento non è presente in un array). Pertanto, possiamo affermare che è consigliato l'utilizzo delle eccezioni in un contesto non locale.

La scelta tra eccezioni controllate e non controllate è basata su come l'eccezione verrà utilizzata: se vogliamo utilizzare il codice per evitare chiamate che generano l'eccezione, è necessario utilizzare un'eccezione *non controllata*. In caso contrario, le eccezioni dovrebbero essere *controllate*. Spesso, la questione se l'eccezione sia "solitamente" evitata ha a che fare con il costo e la convenienza ad evitarla.

##### Programmazione difensiva

E' una buona idea esercitarsi nella programmazione difensiva s'intende un tipo di programmazione che si occupa della scrittura di procedure per difendersi dagli errori. Ad esempio, se non viene soddisfatta la clausola `REQUIRE`, è utile utilizzare `FailureException`, un'eccezione *non controllata*. La programmazione difensiva è particolarmente preziosa durante la produzione perché può evitare che un piccolo errore causi un grosso problema, come un database danneggiato.

---

### Astrazione dei dati

L'**astrazione dei dati** ci consente di estendere il linguaggio di programmazione in uso con nuovi tipi di dati. I nuovi tipi di dati dovrebbero incorporare l'astrazione per *parametrizzazione* e per *specificazione*. L'astrazione per *parametrizzazione* può essere ottenuta allo stesso modo delle procedure, mentre per l'astrazione per *specificazione* è necessario rendere le operazioni parte del tipo.

L'astrazione dei dati ci consente di rinviare le decisioni sulle strutture dei dati fino a quando l'utilizzo dei dati non sarà completamente compreso. La scelta delle giuste strutture dati è fondamentale per ottenere un programma efficiente. 

Inoltre, usiamo la struttura dati per evitare di definire immediatamente la struttura: introduciamo il tipo astratto con i suoi oggetti e operazioni. Le decisioni su come implementare il tipo vengono fatte successivamente, quando tutti i suoi utilizzi sono chiari. 

L'astrazione dei dati è anche utile durante la modifica e la manutenzione. In questa fase, è particolarmente probabile che le strutture dati cambino, sia per migliorare le prestazioni che per soddisfare requisiti mutevoli.

##### Specifiche per le astrazioni di dati

Come per le procedure, anche per il tipo il significato non dovrebbe essere dato da nessuna delle sue implementazioni. In Java i nuovi tipi sono definiti da classi o interfacce.

Ogni classe definisce un tipo definendo un *nome* per tipo, un *insieme di costruttori* e un *insieme di metodi o metodi di istanza*. Una volta che un oggetto è stato creato (e inizializzato da un costruttore), gli utenti possono accedervi chiamando i suoi *metodi*. La forma di una specifica di astrazione di dati è:

```java
visibility class dname {
    /* OVERVIEW: Una breve descriizione del comportanto degli oggetti del tipo
     Solitamente presenta un modello per gli oggetti, cioè descrive gli oggetti
     in termini di altri oggetti
    */

    // costructors: definisce i costruttori che inizializzano nuovi oggetti

    /* methods: definisce i metodi che consentono l'accesso agli oggetti una volta
     che sono stati creati
    */
}
```

L'intestazione `class dname` indica che un nuovo tipo di dato chiamato `dname` è stato definito.

**Nota  bene:** costruttori e metodi sono procedure:

- Metodi e costruttori appartengono entrambi a oggetti, piuttosto che a classi. Pertanto, la parola chiave `static` non apparirà nelle intestazioni dei metodi, poiché questa parola chiave significa che il metodo appartiene alla classe piuttosto che ad un oggetto della classe.

- L'oggetto a cui appartiene un metodo o un costruttore è disponibile come argomento implicito e questo oggetto può essere indicato nella specifica del metodo o del costruttore come `this`.

```java
// Es.
public class IntSet {
    // OVERVIEW: IntSets sono insiemi di numeri interi e mutabili.
    // Un tipico IntSet è [x_1,...,x_n]

    // costructors
    public IntSet()
    // EFFECTS: Inizializza "this" per essere vuoto

    // methods
    public void insert(int x)
    // MODIFIES: this
    // EFFECTS: Aggiunge x agli elementi di this, i.e. this_point = this + {x}

    public void remove(int x)
    // MODIFIES: this
    // EFFECTS: Rimuove x da this, i.e. this_point = this - {x}

    public boolean isIn(int x)
    // EFFECTS: se x è un numero ritorna true altrimenti ritorna false

    public int size()
    // EFFECTS: Ritorna la cardinalità di this

    public int choose() throws EmptyException
    // EFFECTS: se questo è vuoto, genera EmptyException, altrimenti ritorna
    // un elementi arbitrario di this

}
```

```java
// Es: L'astrazione di un polinomio

public class Poly {
    // OVERVIEW: Polys sono polinomi immutabili con coefficienti interi
    // Un tipico polinomio è c_0 + c_1 + ...

    // costructors
    public Poly()
    // EFFECTS: inizializza this in un polinomio zero

    public Poly (int c, int n) throws NegativeExponentException
    // EFFECTS: se n<0 genera NegativeExponentException altrimenti inizializza
    // this come Poly cx^n

    // methods
    public int degree()
    // EFFECTS:  ritorna il grado di this, i.e. il più grande esponente 
    // con un coefficiente non-zero. Ritorna 0 se this è un polinomio zero

    public int coeff(int d)
    // EFFECTS: ritorna il coefficiente del termine di this il cui esponente è d

    public Poly add(Poly q) throws NullPointerException
    // EFFECTS: se q è nullo genera NullPointerException altrimenti
    // ritorna il polinomio di this +q

    public Poly mul(Poly q) throws NullPointerException
    // EFFECTS: se q è nullo genera NullPointerException altrimenti
    // ritorna il polinomio di this *q

    public Poly sub(Poly q) throws NullPointerException
    // EFFECTS: se q è nullo genera NullPointerException altrimenti
    // ritorna il polinomio di this -q

    public Poly minus()
    // EFFECTS: ritorna il polinomio - this

}
```

**Nota bene:** Java consente non solo l'overload dei costruttori, ma anche dei metodi. Entrambi però devono differirsi tra  di loro dal numero di argomento e/o dai loro tipi, in caso contrario si verifica errore in caso di compilazione.

##### Utilizzo di astrazioni di dati

```java
// Es.

public static Poly diff(Poly p) throws NullPointerException {
    // EFFECTS: se p è nullo genera NullPointerException
    // altrimenti ritorna il polinomio ottenuto facendo la differenza con p

    Poly q = new Poly();
    for (int i-1; i<=p.degree(); i++) {
        q = q.add(new Poly(p.coeff(i)+1, i-1));
    }

    return q;
}
```

##### Implementazione dell'astrazione di dati

Una classe definisce un nuovo tipo e ne fornisce un'implementazione. La specifica costituisce la definizione del tipo. Il resto della classe fornisce l'implementazione.

Per implementare un'astrazione di dati, selezioniamo una *rappresentazione*, o *rappresentante*, per i suoi oggetti.  Implementiamo quindi i costruttori per inizializzare correttamente la rappresentazione dei metodi per utilizzare/modificare correttamente la rappresentazione. Questa deve consentire lo svolgimento di tutte le operazioni.

Una rappresentazione ha tipicamente un numero di componenti; in Java, ognuna di queste è una variabile di istanza della classe che implementa l'astrazione dei dati. Le implementazioni dei costruttori e dei metodi accedono e manipolano le variabili di istanza. Per supportare l'astrazione, tuttavia, è importante limitare l'acccesso alle variabili di istanza all'implementazione dei metodi e dei costruttori. Per fare ciò è necessario dichiarare private le variabili di istanza.

**Nota bene:** per memorizzare più informazioni allineate, è preferibile invece che creare due array, utilizzare un *record*, attraverso le classi (per quanto riguarda Java). Un *record* è una raccolta di campi, ognuno con un nome e tipo.

##### Metodi aggiuntivi

Tutte le classi definiscono sottotipi di Object e, pertanto, devono fornire tutti i metodi Object. L'ereditarietà dei metodi Object va bene se l'implementazione ereditata è corretta per il nuovo tipo, altrimenti la classe deve fornire la propria implementazione. 

**Ricorda:**

- Due oggetti sono `equals` se sono comportamentalmente equivalenti. Gli oggetti mutabili sono uguali solo se sono lo stesso oggetto, tali tipi possono ereditare `equals` da Object. Gli oggetti immutabili sono uguali se hanno lo stesso stato: i tipi immutabili devono implementare `equals` separatamente, dal momento che essendo i tipi immutabili avranno sempre lo stesso stato. La stessa cosa vale per `hashCode`.

- `Clone` dovrebbe restituire un oggetto che ha lo stesso stato del suo oggetto. I tipi immutabili possono ereditare il clone da Object, ma i tipi mutabili devono implementarlo separatamente, perché l'implementazione predefinita da Object assegna semplicemente delle variabili di istanza del vecchio oggetto a quelle del nuovo (nel caso di IntSet, `clone` copia lo stesso vettore in un altro ma, nel caso in cui assistiamo ad una modifica di uno dei due, vedremo il medesimo cambiamento anche nell'altro).

- `toString` dovrebbe restituire una stringa che mostra il tipo e lo stato corrente del suo oggetto. Tutti i tipi devono implementare `toString` da soli.

**Nota bene:** due oggetti sono *simili* se non è possibile distinguerli tra di loro usando degli osservatori del loro tipo. Per i tipi immutabili, `similar` e `equals` sono la stessa cosa. Tuttavia, per i itipi mutabili, la somiglianza è più debole dell'equivalenza.

##### Aiuti per comprendere le implementazioni

- **Funzione di astrazione** ($AF$): definisce il *significato della rappresentazione*, il modo in cui gli oggetti della classe dovrebbero implementare gli oggetti astratti.
  
  Ogni implimentazione di astrazione dei dati deve definire come gli oggetti appartenenti al tipo vengono rappresentati. Nella scelta della rappresentazione,  l'implementatore ha in mente una relazione tra rappresentante e gli oggetti astratti. Tale relazione può essere definita da una funzione chiamata *funzione di astrazione*, che mappa dalle variabili di istanza, che costituiscono la rappresentazione di un oggetto, all'oggetto astratto che viene rappresentato. 
  
  $$
  AF: C \rightarrow A
  $$
  
  Nello specifico, la funzione di astrazione $AF$ mappa da uno stato concreto (cioè lo stato di un oggetto della classe $C$) ad uno astratto (cioè lo stato di un oggetto astratto).
  
  **Ricorda:** è implementato dal metodo `toString`

- **Invarianza di rappresentazione** ($IF$): cattura i presupposti comuni su cui si basano le implementazioni dei costruttori e dei metodi. 
  
  **Nota bene:** ogni volta che ci sono informazioni ridondanti nel rappresentante, la relazione di queste informazioni con il resto del rappresentante dovrebbe essere spiegata nell'invarianza di rappresentazione. Non è necessario fornire l'invarianza di rappresentazione ai tipi record, perché tutte queste classi hanno esattamente la stessa invarianza di rappresentazione
  
  **Ricorda:** è implementato dal metodo `repOk`

Insieme, forniscono una documentazione preziosa, sia per l'implementatore originale che per gli altri che leggono il codice. Entrambi vengono scritti come commento.

Oltra a fornire la funzione di astrazione e l'invarianza di rappresentazione come commenti, nel codice è necessario fornire anche metodi per implementarli (tranne per i record). Questi metodi sono utili per trovare errori nel codice; inoltre l'implementazione della funzione di astrazione può essere utilizzata per eseguire l'output.

##### Proprietà delle implementazioni dell'astrazione dei dati

- Un'implementazione produce un effetto collaterale benevolo se modifica la rappresentante senza influenzando lo stato astratto del suo oggetto. Effetti collaterali benefici sono possibili quando la funzione di astrazione è molto a uno

- Un'implementazione espone il rappresentante se fornisce agli utenti dei suoi oggetti un modo per accedere a qualche componente mutabile del rappresentante. Un modo per esporre il rappresentante consiste nell'avere dichiarazioni di variabili di istanza che non sono dichiarate come private (ma è comunque possibile esporre il rappresentante anche se le variabili di istanza sono tutte private, come nel caso in cui i componenti  siano mutabili).

##### Ragionamento sulle astrazione di dati

- Per valutare se un'implementazione conserva l'*invarianza di rappresentazione*, ossia se l'invarianza di rappresentazione vale per tutti gli oggetti della classe, viene utilizzata l'**induzione del tipo di dati**. Per ogni operazione, assumiamo che l'invarianza di rappresentazione valga per tutti gli input del tipo e mostriamo che mantiene il ritorno per ogni input del tipo e ogni nuovo oggetto del tipo

- Per dimostrare la correttezza di un'*operazione*, utilizziamo la **funzione di astrazione** per mettere in relazione gli oggetti astratti menzionati nella sua specifica con gli oggetti concreti che li rappresentano

- L'induzione del tipo di dati viene utilizzata anche per *ragionare sugli invarianti astratti*. Tuttavia, in questo caso, il ragionamento si basa sulla specifica, ignorando l'implementazione.

##### Proprietà delle astrazioni di dati

- **Mutabilità**: un'astrazione di dati è mutabile se dispone di metodi mutatori, altrimenti è immutabile;

- **Tipi di operazioni**: esistono quattro tipi di operazioni fornite dalle astrazioni di dati:
  
  1. ***Creatori***: producono nuovi oggetti "da zero";
  
  2. ***Produttori***: producono altri oggetti con il tipo di oggetti presi come input (possono essere costruttori o metodi);
  
  3. ***Mutatori***: modificano lo stato del loro oggetto;
  
  4. ***Osservatori***: forniscono informazioni sullo stato del loro oggetto, ritornandone i risultati. 

- **Adeguatezza**: un tipo di dati è adeguato se fornisce operazioni sufficienti in modo tale che tutto ciò che gli utenti devono fare con i suoi oggetti possa essere fatto convenientemente e con ragionevole efficienza. Avere troppe operazioni rende un'astrazione più difficile sia da capire che da implementare con relativai manutenzione.

##### Località e modificabilità

- Un'implementazione di un'astrazione dei dati fornisce la **località** se l'utilizzo del codice non modifica i componenti della rappresentazione; 

- Un'implemplementazione di astrazione di dati fornisce **modificabilità** se non c'è modo utilizzando il codice di accedere a qualsiasi parte della rappresentazione.

---

### Astrazione di iterazione

Gli **iteratori** sono una generalizzazione dei meccanismi di iterazione disponibili nella maggior parte dei linguaggi di programmazione. Consentono agli utenti di iterare su tipi arbitrari di dati in modo comodo ed efficiente.

##### Iterazione in Java

java non fornisce supporto diretto per l'astrazione dell'iterazione. Invece, forniremo l'iterazione mediante un tipo speciale di procedura, che chiameremo **iteratore**. Alcuni iteratori sono metodi di astrazione dei dati e un'astrazione dei dati può fornire diversi metodi iteratori. Inoltre possono essereci iteratori autonomi.

Un iteratore restituisce un tipo speciale di data object chiamato **generatore**. Un *generatore* tiene traccia dello stato di un'iterazione nella sua rappresentazione. Ha un metodo `hasNext`, che può essere utilizzato per determinare se devono essere prodotti più elementi, e un metodo `next` per ottenere l'elemento successivo e far avanzare lo stato dell'oggetto *generatore* per registrare la restituzione di quell'elemento.

Tutti i generatori appartengono a tipi che sono sottotipi dell'interfaccia `Iterator`, che è definita dal pacchetto `java.util`. 

**Nota bene:** `NoSuchElementException` è un'eccezione non verificata a causa dell'aspettativa che la maggior parte degli usi di un generatore potrebbe causare la generazione dell'eccezione.

##### Specifica degli iteratori

La specifica di un iteratore definisce il comportamento generico del generatore: non spiega esattamente cosa fa ogni generatore. La specifica dell'iteratore include spesso una clausola `require` alla fine che vincola il codice che utilizza il generatore.

##### Uso dei generatori

- L'utilizzo del codice interagisce con un generatore tramite interfaccia `Iterator`

- L'utilizzo del codice deve rispettare il vincolo impostogli dalla clausola `require` dell'iteratore

- I generatori possono essere passati come argomenti e restituiti come risultati

- A volte è utile *avviare* il generatore: consumare una parte degli elementi prodotti prima di passare in rassegna il resto di loro

##### Implementazione degli iteratori

- L'implementazione di un iteratore richiede l'implementazione di una classe per il generatore associato

- La classe generatore è una classe interna statica (`static private class`); viene utilizzata all'interno della classe contenente l'iteratore e può accedere alle informazioni private della sua classe contenente

- La classe generatore definisce un sottotipo di `Iterator`

- L'implementazione del generatore presuppone che l'utilizzo del codice obbedisca ai vincoli imposti dalla clausola `require` dell'iteratore.

##### Invarianza di rappresentazione e Funzioni di astrazione per i generatori

- L'invarianza di rappresentazione per i generatori è simile a quella per i tipi ordinari astratti. La sola differenza è che non forniremo un metodo per controllarli.

- La funzione di astrazione deve mappare la rappresentazione alla sequenza degli elementi che restano da generare.

##### Problemi di progettazione

Gli iteratori sono spesso necessari per l'adeguatezza: rendono gli elementi della collezione accessibili in modo che sia efficiente e conveniente.

---

### Gerarchia di tipi

- La ***gerarchia dei tipi*** viene utilizzata per definire famiglie di tipi costruite da un ***supertipo*** e dai relativi ***sottotipi***. La gerarchia può estendersi attraverso diversi livelli

- Alcune famiglie di tipi vengono utilizzate per fornire **implementazioni multiple** di un tipo: i sottotipi forniscono diverse implementazioni del loro supertipo

- Tuttavia, più in generale i sottotipi estendono il comportamento del loro supertipo, ad esempio fornendo metodi aggiuntivi

- ***Principio di sostituzione***: dal momento che il comportamento del supertipo deve essere supportato dai sottotipi, gli oggetti dei sottotipi possono essere sostituiti agli oggetti del supertipo senza influenzare il comportamento del codice che li utilizza.

- Il *principio di sostituzione* fornisce l'astrazione per specifica per le famiglie dei tipi

##### Assegnazione and Dispatching

- **Assegnazione**: una variabile dichiarata appartenente a un tipo può far riferimento a un oggetto appartenente a un sottotipo di quel tipo.
  
  **Nota bene:** il *tipo effettivo* è il tipo che l'oggetto possiede realmente. Quindi il tipo effettivo di un oggetto sarà sempre il sottotipo del suo tipo apparente.
  
  Quindi, il compilatore deduce un tipo apparente per ogni oggetto, utilizzando le informazioni presenti nelle dichiarazioni di variabili e metodi. Ogni oggetto ha un tipo effettivo che riceve quando viene creato: questo è il tipo definito dalla classe che lo costruisce. Il compilatore garantisce che il tipo apparente che deduce per un oggetto sia sempre un supertipo del tipo effettivo dell'oggetto. Il compilatore determina quali chiamate sono legate in base al tipo apparente dell'oggetto.

- **Dispatching**: il compilatore genera codice per trovare il codice del metodo per poi diramarsi da esso. In particolare, il *dispatching* fa sì che le chiamate al metodo vadano al codice effettivo dell'oggetto, ovvero il codice fornito dalla sua classe.

##### Definizione di gerarchie in Java

Le gerarchie di tipo sono definite in Java usando il ***meccanismo ereditario***. Questo meccanismo consente a una classe di essere una *sottoclasse* di un'altra classe (la sua *superclasse*) e di implementare zero o più *interfacce*.

I supertipi in Java sono definiti sia dalle *classi* che dalle *interfacce*. In entrambi i casi, la classe o l'interfaccia fornisce una specifica per il tipo. 

- Un ***interfaccia*** definisce solo una specifica; non contiene alcun codice che implementa il supertipo.

- La ***classe*** può fornire, oltre alla specifica, un'implementazione *completa* o *parziale*.

In Java esistono due tipi di classi:

- **Classi *concrete***: forniscono un'implementazione *concreta* del tipo

- **Classi *astratte***: forniscono al massimo un'implementazione *parziale* del tipo. Non hanno nè oggetti (poiché alcuni dei loro metodi non sono ancora implementati) nè costruttori che gli utenti possono chiamare.

Per quanto riguarda i metodi:

- **Metodi *normali*** e **Metodi *finali***: possono essere presenti in entrambi i tipi di classi

- **Metodi *astratti***: possono essere presenti nelle classi *astratte*. Si tratta di metodi che non sono implementati dalla superclasse e, quindi, devono essere implementati da qualche sottoclasse.

**Nota bene:** la distinzione tra queste categorie di metodi è di interesse solo per gli implementatori di sottoclassi, non dell'utente.

Quindi, una sottoclasse *concreta*:

- contiene implementazioni dei costruttori della sottoclasse e dei metodi aggiuntivi

- deve implementare i metodi astratti della sua superclasse

- può reimplementare o sovrascrivere i metodi normali

- eredita dalla sua superclasse le implementazioni dei metodi finali e tutti i metodi normali che non sovrascrive

La rappresentazione di una classe è costituita dalle proprie variabili di istanza e da quelle della sua superclasse, ma può accedere alle variabili di istanza della superclasse solo se dichiarate *protette*.

**Nota bene:** viene utilizzato `super()` nel costruttore per inizializzare le variabili di istanza della superclasse. Nel caso venisse a mancare, Java inserirà automaticamente una chiamata al costruttore della superclasse senza argomenti.

Per quanto riguarda l'*invarianza di rappresentazione* e *funzione di astrazione* per sottoclassi di superclassi concrete:

- La funzione di astrazione per una sottoclasse `AF_sub` è tipicamente definita usando `AF_super`, la funzione di astrazione della superclasse

- L'invarianza di rappresentazione della sottoclasse `I_sub` deve includere un controllo sull'invariante di rappresentanza della superclasse `I_super`, solo se la superclasse ha dei membri protetti. Tuttavia, il `repOk` per le sottoclassi dovrebbe sempre controllare `repOk` per la superclasse

##### Tipi eccezione

I tipi di eccezione sono sottotipi di `Throwable` e l'implementazione di `Throwable` fornisce metodi che accedono alla stringa all'interno dell'oggetto eccezione. Nuovi tipi di eccezione possono essere quindi implementati semplicamente definendo i loro costruttori.

##### Classi astratte

Una ***classe astratta***  viene utilizzata per poter dichiarare caratteristiche comuni fra classi di una determinata geratchia. Pur definendo il nome di un tipo, la classe astratta non può essere instanziata, ossia non può avere oggetti: i costruttori possono essere usati dalle sottoclassi per inizializzare la parte della superclasse della rappresentazione.

Tipicamente una classe astratta può dichiarare dei campi e dei metodi sia astratti che normali. Un ***metodo astratto*** è un metodo che può essere dichiarato, ma per il quale non viene fornita un'implementazione. 

Quando estendiamo (o deriviamo) da una classe astratta, la classe derivata deve fornire una implementazione per tutti i metodi astratti dichiarati nella classe genitrice; se così non dovesse essere, anche la sotto-classe deve essere dichiarata come `abstract`.

Lo scopo e l'utilità delle classi astratte è di **gestire** il comportamento di base delle classi che la derivano e che può essere ampliato e specializzato da queste ultime.

**Nota bene:** nel caso che la definizione di una classe sia derivata da un'altra classe, tutti ***membri protetti***  vengono ereditate. 

##### Interfacce

Un'interfaccia è un insieme di nomi di metodi astratti che possono essere implementati su più classi. Ogni classe che implementa l'interfaccia definisce i metodi in modo diverso dalle altre classi che implementano la stessa interfaccia.

**Nota bene:** le interfaccie non possono essere usate per creare oggetti, dal momento che sono classi astratte con metodi senza corpo. Inoltre non possono contenere costruttori né variabili di istanza

##### Il significato dei sottotipi

I sottotipi devono soddisfare il *principio di sostituzione* in modo che gli utenti possano scrivere e ragionare sul codice semplicemeente utilizzando la specifica del supertipo. Il principio di sostituzione richiede che la specifica del sottotipo supporti il ragionamento basato sulla specifica del supertipo. 

Sono presenti tre proprietà che devono essere supportate perché avvenga il principio di sostituzione:

- ***Signature Rule*** *(regola della firma)*:  se un programma è corretto per il tipo in base alla specificazione del supertipo, lo è anche rispetto alla specifica del sottotipo. In particolare, gli oggetti del sottotipo devono avere tutti i metodi del supertipo e le *signature* dei metodi del sottotipo devono essere compatibili con quelle dei corrispondenti metodi del supertipo.

- ***Methods Rule*** *(regola dei metodi)*: il ragionamento sulle chiamate dei metodi di supertipo è valido anche se le chiamate vanno effettivamente al codice che implementa un sottotipo. Le chiamate di questi metodi di sottotipi devono "comportarsi come" chiamate ai corrispondenti metodi di supertipo.

- ***Properties Rule*** *(regola della proprietà)*: il ragionamento sulle proprietà degli oggetti basato sulla specifica del supertipo è ancora valida quando gli oggetti appartengono a un sottotipo; il sottotipo deve preservare tutte le proprietà che possono essere dimostrate sugli oggetti supertipo. Le proprietà devono essere indicate nella sezione `overview` della specifica del supertipo.

Tutte queste regole riguardano solo le specifiche.

Per quanto riguarda l'*uguaglianza*, come detto precedentemente, i tipi mutabili sono uguali se sono lo stesso oggetto, mentre i tipi immutabili sono uguali se hanno lo stesso stato. Quando sono presenti sottotipi di tipi immutabili, gli oggetti sottotipo potrebbero avere più stati o potrebbero anche essere mutabili. Pertanto, gli oggetti di sottotipo potrebbero essere distinguibili, anche se il codice che li utilizza tramite l'interfaccia di supertipo non può distinguerli.

##### Tipologie di Supertipi

Ci sono tre diversi tipi di supertipi:

- ***Supertipi incompleti***: stabiliscono convenzioni di denominazione per metodi di sottotipi, ma non forniscono specifiche utili per tali metodi.

- ***Supertipi completi***: forniscono intere astrazioni di dati, con specifiche utili per tutti i metodi.

- ***Snippets***: forniscono solo pochi metodi, non sufficienti per qualificarsi come un'intera astrazione di dati. Tuttavia, questi metodi sono specificati in modo da consentire la scrittura del codice in termini di supertipo.

---

### Astrazioni polimorfiche

Le ***astrazioni polimorfiche*** sono astrazioni che funzionano per molti tipi. In particolare, il polimorfismo generalizza le astrazioni in modo che funzionino per molti tipi. Ci permette di evitare di dover ridefinire le astrazioni quando vogliamo usarle per più tipi. 

Una procedura o un iteratore può essere polimorfico rispetto ai tipi di uno o più argomenti. Un'astrazione di dati può essere polifmorfica rispetto ai tipi di elementi che contentono i suoi oggetti.

In Java, il polimorfismo è espresso attraverso la gerarchia.

##### Utilizzo di astrazioni polimorfiche di dati

Le astrazioni poliformiche di dati vengono utilizzate in modo simile dalle loro controparti non polimorfiche, con due differenze principali:

- Solo gli oggetti possono essere archiviati nella raccolta e, pertanto, i valori primitivi come `int` devono essere racchiusi nel tipo di oggetto corrispondente

- Gli osservatori che restituiscono elementi della raccolta restituiranno `Object` e quindi il codice utilizzato dovrà eseguire il lancio al tipo previsto.

##### Più flessibilità

Quasi tutte le astrazioni polimorfiche devono utilizzare metodi sui loro parametri, ma a volte sono necessari solo metodi di oggetto. In questo caso, le astrazioni polimorfiche che richiedono più metodi `Object` utilizzano un'interfaccia associata per definire i loro requisiti.

Ci sono due metodi diversi per definire questa interfaccia:

1. **Approccio del sottotipo dell'elemento**: tutti i potenziali tipi di elemento devono essere sotttotipi dell'interfaccia associata. Il problema con questo approccio è che richiede una pianificazione preliminare. 

2. **Approccio del sottotipo correlato**: utilizza un sottotipo dell'interfaccia per ogni potenziale tipo di elemento. Gli oggetti che appartengono a un sottotipo dell'interfaccia che hanno metodi che forniscono la funzionalità necessaria per gli oggetti del tipo di elemento correlato.

L'approccio del sottotipo correlato è meno conveniente rispetto a quello del sottotipo dell'elemento a causa della necessità di definire i sottotipi aggiuntivi. Inoltre, quando i tipi di elementi sono definiti dopo l'astrazione polimorfica, l'approccio del sottotipi correlato funzionerà. Pertanto, a volte le astrazioni polimorfiche consentono entrambi gli approcci; l'utilizzo del codice seleziona l'approccio quando costruisce la raccolta polimorfica o chiama la procedura polimorfica.
