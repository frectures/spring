# Vorbereitung

## Eclipse [Download](https://www.eclipse.org/downloads/packages)
```
Download Eclipse IDE for Java EE Developers 64 bit
Extract contents to home directory
```

## Tomcat [Download](https://tomcat.apache.org/download-90.cgi)
```
Binary Distributions / Core / zip
Extract contents to home directory

Optionally download Source Code Distributions / zip
Move (NOT extract!) zip into tomcat directory
```

## Configure Tomcat in Eclipse
```
Window / Preferences / Server / Runtime Environments / Add...
Select the type of runtime environment: Apache Tomcat v9.0
Next
Tomcat installation directory: /home/fred/apache-tomcat-9.0
Finish
Apply and Close

Window / Show View / Other...
Server / Servers
Open

No servers are available. Click this link to create a new server...
Select the server type: Tomcat v9.0 Server
Finish
```

## Clone Projects from GitHub
```
cd ~/git
git clone https://github.com/frectures/spring
```

## Import Projects into Eclipse
```
File / Import...
Maven / Existing Maven Projects / Next
Root directory: /home/fred/git/spring
Finish
```

## Start Project for the first time
```
Project Explorer / geizhals (right-click) / Run As / Run on Server
[x] Always use this server when running this project
Finish
```

# Aufgaben

## Aufgabe 1

Im View `Geizhals.jsp` wird bisher eine statische Tabelle mit 3 fantasielosen Discountern/Produkten sowie unbekannten Preisen dargestellt. Die unbekannten Preise kannst du erst mal so lassen, aber die Discounter und Produkte sollen dynamisch aus den Daten generiert werden, die der `GeizhalsController` im Modell ablegt.

## Aufgabe 2

Macht es einen Unterschied, ob man `<c:out value="${expression}" />` oder einfach nur `${expression}` im View verwendet? Füge probehalber im `PriceInfoRepositoryDb` einen Discounter namens `<b>Test</b>` hinzu.

## Aufgabe 3

Ersetze die Fragezeichen in der Tabelle durch die tatsächlichen Preise.

Hinweis: Die Syntax zum Zugriff auf eine `map` mittels `key` lautet `map[key]`, und die Syntax zum Zugriff auf eine Property eines `object`s, für die es eine Methode `getProperty()` gibt, lautet `object.property`

## Aufgabe 4

Der jeweils günstigste Preis eines Produkts soll blau hervorgehoben werden. Dazu existiert im `GeizhalsService` bereits eine hilfreiche Methode, welche jedoch leider fehlerhaft ist. (Der Fehler wird dir spätestens dann ins Auge springen, wenn du die blaue Herhorhebung fertig implementiert hast.) **Ignoriere diesen Fehler bitte zunächst!**

## Aufgabe 5a

Bevor wir den Fehler aus der vorhigen Aufgabe beheben, wollen wir einen JUnit-Test schreiben, der diesen Fehler aufdeckt. Leider erzeugt `GeizhalsService` sich aktuell sein eigenes `PriceInfoRepositoryDb`. Wir würden den Service aber gerne unabhängig von dem Repository testen.

Eliminiere diese Abhängigkeit, indem du den `new`-Ausdruck aus `GeizhalsService` entfernst und ganz altbacken einen Konstruktor anbietest, der den Interfacetyp als Parameter verwendet und eine manuelle Zuweisung im Rumpf vornimmt. (Den `new`-Ausdruck brauchst du jetzt natürlich im Controller beim Erzeugen des Service.)

## Aufgabe 5b

Nun können wir den `GeizhalsService` isoliert testen, indem wir das Repository durch ein Mock-Objekt ersetzen. Dafür brauchen wir dank Mockito nicht einmal eine neue Klasse schreiben! Orientiere dich an der folgenden Vorlage, die eine Klasse `Foo` testet, welche eine Abhängigkeit zu einer Klasse `Bar` hat, die wir mocken wollen:
```
@RunWith(MockitoJUnitRunner.class)
public class FooTest {
    @Mock
    private BarInterface bar;

    @InjectMocks
    private Foo foo;

    @Before
    public void before() {
        Mockito.when(bar.someMethodCall()).thenReturn(someMockResult);
    }

    @Test
    public void businessAsUsual() {
        // ...
        assertEquals(someExpectedValue, foo.someMethodCall());
    }
}
```
(Der JUnit-Test muss ganz normal lokal gestartet werden, und nicht etwa auf dem Tomcat-Server.)

Das gemockte Repository sollte mindestens 2 Discounter und Produkte enthalten. Welche aussagekräftigen Testfälle kommen dir in den Sinn?

## Aufgabe 6a

Ersetze den `new`-Aufruf im `GeizhalsController` analog zu Aufgabe 5a. Nun sollte die Anwendung nicht mehr laufen, weil Spring nicht klar ist, mit welchem Repository der Controller verdrahtet werden soll. Wenn du die Klasse `PriceInfoRepositoryDb` mit der Annotation `@org.springframework.stereotype.Repository` versiehst, sollte es wieder klappen. (Leider habe ich zu spät gemerkt, dass mein eigenes Interface `Repository` mit der gleichnamigen Annotation aus Spring kollidiert.)

## Aufgabe 6b

Alternativ zur Lösung aus Aufgabe 6a kannst du den Konstruktor auch wieder entfernen und einfach `@Autowired` direkt über die Exemplarvariable schreiben. Dafür darf sie allerdings nicht `final` sein. Damit Spring den Service zur Laufzeit findet, muss die Klasse `GeizhalsService` zuletzt noch mit `@Service` annotiert werden.

(Der Nachteil dieser simpleren Lösung ist, dass wir die Flexibilität verlieren, den Service im Controller für Tests zu mocken.)
