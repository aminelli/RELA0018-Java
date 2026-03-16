# ArrayDemo - Guida Completa agli Array in Java

## 📋 Panoramica

- **Package**: `com.corso.samples.datatypes`
- **Classe**: `ArrayDemo`
- **Metodo principale**: `run()`
- **Scopo**: Apprendimento completo degli array in Java

Gli **Array** sono strutture dati fondamentali in Java che permettono di memorizzare collezioni ordinate di elementi dello stesso tipo con dimensione fissa e accesso diretto tramite indice.

---

## 🎯 Obiettivi di Apprendimento

Dopo aver completato questo modulo, sarai in grado di:

1. **Comprendere** cosa sono gli array e le loro caratteristiche (omogenei, dimensione fissa, indicizzati, contigui)
2. **Padroneggiare** dichiarazione e inizializzazione di array (sintassi, array initializer, valori default)
3. **Utilizzare** array di tipi primitivi (int, double, boolean, char, long)
4. **Gestire** array di oggetti (String, wrapper types, oggetti custom, null safety)
5. **Lavorare con** array multidimensionali (2D, 3D, jagged arrays)
6. **Accedere e modificare** elementi (indici, bounds checking, swap)
7. **Iterare** su array (classic for, enhanced for-each, while, stream API)
8. **Copiare** array (copyOf, copyOfRange, arraycopy, clone, shallow vs deep)
9. **Ordinare** array (Arrays.sort, comparatori custom, ordinamento naturale/decrescente)
10. **Ricercare** elementi (linear search, binary search, stream API)
11. **Confrontare** array (equals, deepEquals, compare, mismatch)
12. **Convertire** tra array e Collection (asList, toArray, boxing/unboxing)
13. **Usare** utility della classe Arrays (toString, fill, stream, setAll)
14. **Applicare** best practices professionali per codice robusto e manutenibile

---

## 📚 Contenuto del Modulo

Il modulo è organizzato in **14 sezioni complete**:

### 1. Introduzione e Concetti Base
- Cosa sono gli array
- Caratteristiche fondamentali (omogenei, dimensione fissa, indicizzati, contigui, reference type)
- Sintassi base (dichiarazione, creazione, inizializzazione)
- Indici 0-based e accesso elementi
- ArrayIndexOutOfBoundsException
- Quando usare array vs ArrayList

### 2. Dichiarazione e Inizializzazione
- Sintassi raccomandata (`int[] arr`) vs alternativa (`int arr[]`)
- Dichiarazioni multiple
- Creazione con `new` (valori di default)
- Inizializzazione diretta (array initializer)
- Inizializzazione anonima
- Valori di default per tipo (0, false, null, ecc.)

### 3. Array di Tipi Primitivi
- Array di `int`, `double`, `boolean`, `char`, `long`
- Caratteristiche array primitivi (memoria efficiente, no boxing, valori default)
- Esempi pratici (calcolo media, conteggio, conversione char[] → String)

### 4. Array di Oggetti (Reference Types)
- Array di String
- Array con elementi null
- NullPointerException e null safety
- Array di wrapper types (Integer, Double, ecc.)
- Array di oggetti custom
- Differenze array primitivi vs oggetti (tabella comparativa)

### 5. Array Multidimensionali
- Array 2D (matrici): dichiarazione, creazione, accesso
- Creazione con `new` (righe e colonne)
- Jagged arrays (array irregolari con righe di lunghezza diversa)
- Array 3D (cubi)
- Iterazione array 2D con nested loops

### 6. Accesso e Modifica Elementi
- Accesso lettura tramite indice
- Primo e ultimo elemento (`arr[0]`, `arr[length-1]`)
- Modifica elementi
- Incremento/decremento
- Scambio elementi (swap con variabile temporanea)
- Bounds checking automatico in Java

### 7. Iterazione su Array
- Classic for loop (con indice, accesso a posizione, modifica elementi)
- Enhanced for-each loop (conciso, sicuro, solo lettura efficace)
- While loop
- Iterazione inversa (da ultimo a primo)
- Stream API (`Arrays.stream()`, `forEach`, operazioni)
- Iterazione array 2D (nested loops, for-each)

### 8. Copia di Array
- ⚠️ Assegnamento NON copia (stesso riferimento)
- `Arrays.copyOf()` - copia completa, parziale, estesa
- `Arrays.copyOfRange()` - copia sottosezione
- `System.arraycopy()` - performance ottimale
- `clone()` - shallow copy
- Manual loop
- Shallow vs Deep Copy per oggetti

### 9. Ordinamento
- `Arrays.sort()` - ordinamento naturale crescente
- Ordinamento di range specifico
- Ordinamento String (alfabetico)
- Ordinamento decrescente con `Comparator.reverseOrder()`
- Ordinamento custom con Comparator (per lunghezza, per età, ecc.)
- Algoritmi usati (Dual-Pivot Quicksort, TimSort)

### 10. Ricerca
- Ricerca lineare sequenziale (O(n))
- `Arrays.binarySearch()` - ricerca binaria (O(log n), array ordinato richiesto)
- Ricerca su range
- Ricerca String
- Ricerca con Stream API (`anyMatch`, `filter`, `findFirst`)
- Tabella comparativa Linear vs Binary Search

### 11. Confronto di Array
- ⚠️ Operatore `==` confronta riferimenti, non contenuto
- `Arrays.equals()` - confronto elemento per elemento
- `Arrays.deepEquals()` - confronto array multidimensionali
- `Arrays.compare()` - confronto lessicografico (restituisce negativo/zero/positivo)
- `Arrays.mismatch()` - trova primo elemento diverso

### 12. Conversioni Array ↔ Collection
- Array → List fixed-size con `Arrays.asList()`
- Array → ArrayList mutable con `new ArrayList<>(Arrays.asList())`
- List → Array con `toArray()` e `toArray(T[])`
- Primitivi → List con boxing (`Arrays.stream().boxed().toList()`)
- List → Primitivi con unboxing (`stream().mapToInt().toArray()`)
- Tabella riepilogativa conversioni

### 13. Utility Classe Arrays
- `Arrays.toString()` - stampa array leggibile
- `Arrays.deepToString()` - stampa array multidimensionali
- `Arrays.fill()` - riempimento di array o range
- `Arrays.stream()` - operazioni funzionali (sum, average, max, filter)
- `Arrays.setAll()` - generazione funzionale con lambda
- `Arrays.parallelSort()` - ordinamento parallelo multi-thread
- `IntStream.range()` / `rangeClosed()` - generazione range

### 14. Best Practices
- 10 regole professionali con esempi Corretto vs Evita
- Checklist finale con 10 domande di verifica
- Regola d'oro per uso corretto array

---

## 🔍 Caratteristiche Fondamentali degli Array

| Caratteristica | Descrizione |
|---------------|-------------|
| **Omogenei** | Tutti gli elementi sono dello stesso tipo |
| **Dimensione Fissa** | La lunghezza non può cambiare dopo creazione |
| **Indicizzati** | Accesso diretto tramite indice (0-based) |
| **Contigui** | Elementi memorizzati sequenzialmente in memoria |
| **Reference Type** | Anche array di primitivi sono oggetti |

---

## 📊 Array Primitivi vs Array di Oggetti

| Aspetto | Array Primitivi (`int[]`) | Array Oggetti (`Integer[]`) |
|---------|--------------------------|------------------------------|
| **Null** | ✗ No | ✓ Sì |
| **Default** | 0, false, ecc. | null |
| **Memoria** | Minore (no overhead boxing) | Maggiore |
| **Performance** | Migliore | Leggermente inferiore |
| **Metodi** | ✗ No (sono primitivi) | ✓ Sì |

---

## 🔢 Valori di Default

| Tipo | Valore Default |
|------|---------------|
| `byte`, `short`, `int`, `long` | `0`, `0`, `0`, `0L` |
| `float`, `double` | `0.0f`, `0.0` |
| `char` | `'\u0000'` (null character) |
| `boolean` | `false` |
| **Oggetti** | `null` |

---

## 📖 Reference Rapido: Metodi Arrays Class

### Copia
| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `Arrays.copyOf(arr, len)` | Copia completa/parziale/estesa | `int[] copy = Arrays.copyOf(original, 5);` |
| `Arrays.copyOfRange(arr, from, to)` | Copia sottosezione [from, to) | `int[] range = Arrays.copyOfRange(arr, 1, 4);` |
| `System.arraycopy(src, srcPos, dest, destPos, len)` | Copia performance | `System.arraycopy(src, 0, dest, 0, len);` |
| `arr.clone()` | Shallow copy | `int[] clone = arr.clone();` |

### Ordinamento
| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `Arrays.sort(arr)` | Ordinamento crescente | `Arrays.sort(numbers);` |
| `Arrays.sort(arr, from, to)` | Ordinamento range | `Arrays.sort(arr, 1, 4);` |
| `Arrays.sort(arr, comparator)` | Ordinamento custom | `Arrays.sort(nums, Comparator.reverseOrder());` |
| `Arrays.parallelSort(arr)` | Ordinamento parallelo | `Arrays.parallelSort(largeArray);` |

### Ricerca
| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `Arrays.binarySearch(arr, key)` | Ricerca binaria (array ordinato) | `int idx = Arrays.binarySearch(sorted, 50);` |
| `Arrays.binarySearch(arr, from, to, key)` | Ricerca in range | `int idx = Arrays.binarySearch(arr, 2, 7, 50);` |

### Confronto
| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `Arrays.equals(arr1, arr2)` | Contenuto uguale? | `boolean eq = Arrays.equals(a, b);` |
| `Arrays.deepEquals(arr1, arr2)` | Confronto deep (multidim) | `boolean eq = Arrays.deepEquals(m1, m2);` |
| `Arrays.compare(arr1, arr2)` | Confronto lessicografico | `int cmp = Arrays.compare(a, b);` |
| `Arrays.mismatch(arr1, arr2)` | Primo elemento diverso | `int idx = Arrays.mismatch(x, y);` |

### Utility
| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `Arrays.toString(arr)` | Stringa leggibile | `System.out.println(Arrays.toString(arr));` |
| `Arrays.deepToString(arr)` | Stringa multidim | `System.out.println(Arrays.deepToString(matrix));` |
| `Arrays.fill(arr, val)` | Riempi con valore | `Arrays.fill(arr, 7);` |
| `Arrays.fill(arr, from, to, val)` | Riempi range | `Arrays.fill(arr, 1, 4, 99);` |
| `Arrays.setAll(arr, generator)` | Genera con lambda | `Arrays.setAll(arr, i -> i * 10);` |
| `Arrays.stream(arr)` | Converti a Stream | `int sum = Arrays.stream(arr).sum();` |

---

## 🔄 Tabella Conversioni Array ↔ Collection

| Da | A | Metodo |
|----|---|--------|
| `T[]` | `List<T>` fixed | `Arrays.asList(array)` |
| `T[]` | `List<T>` mutable | `new ArrayList<>(Arrays.asList(array))` |
| `List<T>` | `Object[]` | `list.toArray()` |
| `List<T>` | `T[]` | `list.toArray(new T[0])` |
| `int[]` | `List<Integer>` | `Arrays.stream(arr).boxed().toList()` |
| `List<Integer>` | `int[]` | `list.stream().mapToInt(Integer::intValue).toArray()` |

---

## 💡 Esempi Pratici

### Esempio 1: Calcolo Media Array
```java
double[] values = {10.5, 20.3, 15.7, 30.2, 8.9};
double sum = 0;
for (double v : values) {
    sum += v;
}
double average = sum / values.length;
System.out.println("Media: " + average);  // 17.12
```

### Esempio 2: Trova Massimo in Array
```java
int[] numbers = {45, 23, 78, 12, 90, 34};
int max = numbers[0];
for (int i = 1; i < numbers.length; i++) {
    if (numbers[i] > max) {
        max = numbers[i];
    }
}
System.out.println("Massimo: " + max);  // 90
```

### Esempio 3: Copia Defensive per Immutabilità
```java
public class Data {
    private final int[] values;
    
    // Costruttore con defensive copy
    public Data(int[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }
    
    // Getter con defensive copy
    public int[] getValues() {
        return Arrays.copyOf(values, values.length);
    }
}

// Uso
int[] original = {1, 2, 3, 4, 5};
Data data = new Data(original);
original[0] = 999;  // Non modifica data.values (copia difensiva)
```

### Esempio 4: Ordinamento Custom per Lunghezza String
```java
String[] words = {"banana", "kiwi", "apple", "strawberry", "grape"};
Arrays.sort(words, Comparator.comparingInt(String::length));
System.out.println(Arrays.toString(words));
// Output: [kiwi, apple, grape, banana, strawberry]
```

### Esempio 5: Ricerca Binaria con Gestione "Not Found"
```java
int[] sorted = {10, 20, 30, 40, 50, 60, 70};
int target = 55;
int result = Arrays.binarySearch(sorted, target);

if (result >= 0) {
    System.out.println("Trovato all'indice: " + result);
} else {
    int insertionPoint = -(result + 1);
    System.out.println("Non trovato. Insertion point: " + insertionPoint);
}
// Output: Non trovato. Insertion point: 5
```

### Esempio 6: Somma Elementi Pari con Stream
```java
int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int sumEven = Arrays.stream(numbers)
                    .filter(n -> n % 2 == 0)
                    .sum();
System.out.println("Somma pari: " + sumEven);  // 30
```

### Esempio 7: Matrice Trasposta (Array 2D)
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

// Crea matrice trasposta (3x2)
int[][] transposed = new int[3][2];
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        transposed[j][i] = matrix[i][j];
    }
}

System.out.println(Arrays.deepToString(transposed));
// Output: [[1, 4], [2, 5], [3, 6]]
```

---

## ✅ Best Practices

### 1. ✅ Preferisci `[]` dopo tipo (più chiaro)

**✓ RACCOMANDATO:**
```java
int[] numbers;
String[] names;
```

**✗ EVITA:**
```java
int numbers[];   // Meno chiaro
```

---

### 2. ✅ Inizializza sempre array prima dell'uso

**✓ CORRETTO:**
```java
int[] arr = new int[10];        // Inizializzato a 0
String[] names = new String[5]; // Inizializzato a null
```

**⚠️ ERRORE:**
```java
int[] arr;
arr[0] = 10;  // Compile ERROR! Non inizializzato
```

---

### 3. ✅ Controlla bounds manualmente quando necessario

**✓ SICURO:**
```java
if (index >= 0 && index < array.length) {
    int value = array[index];
} else {
    System.err.println("Indice fuori range!");
}
```

---

### 4. ✅ Usa enhanced for quando possibile (solo lettura)

**✓ LEGGIBILE:**
```java
for (int num : numbers) {
    System.out.println(num);
}
```

**✓ CLASSIC (quando serve indice o modifica):**
```java
for (int i = 0; i < numbers.length; i++) {
    numbers[i] *= 2;  // Modifica array
}
```

---

### 5. ✅ Defensive Copy per immutabilità

**✓ IMMUTABILE:**
```java
public class Data {
    private final int[] values;
    
    public Data(int[] values) {
        // COPIA in ingresso
        this.values = Arrays.copyOf(values, values.length);
    }
    
    public int[] getValues() {
        // COPIA in uscita
        return Arrays.copyOf(values, values.length);
    }
}
```

**✗ VULNERABILE:**
```java
this.values = values;  // Client può modificare array interno!
return values;         // Espone array mutabile interno!
```

---

### 6. ✅ Usa `Arrays.equals()` per confronto contenuto

**✓ CORRETTO:**
```java
if (Arrays.equals(arr1, arr2)) {
    System.out.println("Array uguali");
}
```

**✗ SBAGLIATO:**
```java
if (arr1 == arr2) {  // Confronta RIFERIMENTI, non contenuto!
    System.out.println("Stesso oggetto");
}
```

---

### 7. ✅ `Arrays.toString()` per debug e stampa

**✓ UTILE:**
```java
System.out.println(Arrays.toString(arr));
// Output: [10, 20, 30, 40, 50]
```

**✗ INUTILE:**
```java
System.out.println(arr);
// Output: [I@15db9742 (hash code, illeggibile!)
```

---

### 8. ✅ Usa varargs per flessibilità

**✓ FLESSIBILE:**
```java
public static int sum(int... numbers) {
    return Arrays.stream(numbers).sum();
}

sum(1, 2, 3);        // OK
sum(1, 2, 3, 4, 5);  // OK
sum();               // OK (array vuoto)
```

---

### 9. ✅ Considera Collections per dinamicità

**✓ ARRAY (dimensione fissa):**
- Dimensione nota e immutabile
- Performance critiche
- Tipi primitivi (no boxing)

**✓ ArrayList (dimensione dinamica):**
- Dimensione variabile
- Add/remove frequenti
- Più flessibile e ricco di metodi

---

### 10. ✅ Null safety per array di oggetti

**✓ SICURO:**
```java
String[] names = getNames();
if (names != null && names.length > 0) {
    for (String name : names) {
        if (name != null) {
            System.out.println(name.toUpperCase());
        }
    }
}
```

---

## 📝 Checklist Finale

Prima di usare array nel tuo codice, verifica:

- ☑ **Array è la struttura giusta?** (vs ArrayList per dimensione variabile)
- ☑ **Dimensione nota e fissa?** (altrimenti usa Collection)
- ☑ **Inizializzato correttamente?** (con `new` o array initializer)
- ☑ **Controllo bounds dove necessario?** (evita ArrayIndexOutOfBoundsException)
- ☑ **Enhanced for per sola lettura?** (classic for quando serve indice)
- ☑ **Defensive copy se mutabile?** (per immutabilità classe)
- ☑ **Arrays.equals() per confronti?** (non `==`)
- ☑ **Arrays.toString() per debug?** (non `toString()` diretto)
- ☑ **Null check per array di oggetti?** (array != null, elementi != null)
- ☑ **Considerato Stream API?** (operazioni funzionali moderne)

---

## 💎 Regola d'Oro

> **"Array = dimensione FISSA. ArrayList = dimensione DINAMICA."**
>
> **"Usa enhanced for quando possibile. Classic for quando serve indice."**
>
> **"Arrays.equals() per confronto, Arrays.toString() per stampa."**

---

## 🚀 Come Eseguire

### Opzione 1: Dal Menu Principale
```bash
mvn clean compile
mvn exec:java
```
Seleziona l'opzione **[8] Array** dal menu.

### Opzione 2: Esecuzione Diretta
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.corso.samples.datatypes.ArrayDemo"
```

---

## 📂 Struttura del Codice

```
ArrayDemo
├── run()                           // Metodo principale
├── demoIntroduction()              // 1. Introduzione e concetti base
├── demoDeclarationInitialization() // 2. Dichiarazione e inizializzazione
├── demoPrimitiveArrays()           // 3. Array di tipi primitivi
├── demoObjectArrays()              // 4. Array di oggetti
├── demoMultidimensionalArrays()    // 5. Array multidimensionali
├── demoAccessModification()        // 6. Accesso e modifica elementi
├── demoIteration()                 // 7. Iterazione su array
├── demoCopyingArrays()             // 8. Copia di array
├── demoSorting()                   // 9. Ordinamento
├── demoSearching()                 // 10. Ricerca
├── demoComparison()                // 11. Confronto di array
├── demoConversions()               // 12. Conversioni Array ↔ Collection
├── demoArraysUtilities()           // 13. Utility Arrays class
├── demoBestPractices()             // 14. Best Practices
└── Utility methods:
    ├── printHeader()
    ├── printSection()
    ├── printSubSection()
    ├── printFooter()
    ├── waitForEnter()
    ├── printArray()
    ├── calculateAverage()
    ├── countTrue()
    └── linearSearch()
```

---

## 📚 Riferimenti

1. [Java Arrays Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Arrays.html)
2. [Java Language Specification - Arrays](https://docs.oracle.com/javase/specs/jls/se21/html/jls-10.html)
3. [Effective Java (3rd Edition) - Item 28: Prefer lists to arrays](https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/)
4. [Java Tutorials - Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
5. [Stream API Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/package-summary.html)
6. [IntStream Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/IntStream.html)
7. [System.arraycopy() JavaDoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#arraycopy(java.lang.Object,int,java.lang.Object,int,int))
8. [Java Collections Framework](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/doc-files/coll-overview.html)

---

**✓ Completato questo modulo, avrai una padronanza completa degli array in Java!**
