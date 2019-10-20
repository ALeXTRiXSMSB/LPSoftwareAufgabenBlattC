/**
 * @author Alexander Karg
 */
package c4;

/**
 * Klasse Buch die von der Abstrakten Klasse Medium Erbt
 */
public class Buch extends Medium {

    /**
     * Klassenattribute
     * von außerhalb der Klasse nicht sichtbar bzw veränderbar nur über aufruf der jeweiligen
     * setter oder Getter Methode aufruf oder veränderbar
     */
    private int erscheinungsjahr;
    private String verlag;
    private String isbn;
    private String verfasser;

    /**
     * Konstruktor zum Erstellen von einem Objekt Buch
     *
     * @param _titel
     * @param _erscheinungsjahr
     * @param _verlag
     * @param _isbn
     * @param _verfasser
     */
    public Buch(String _titel, int _erscheinungsjahr, String _verlag, String _isbn, String _verfasser) {
        super(_titel);
        this.setErscheinungsjahr(_erscheinungsjahr);
        this.setIsbn(_isbn);
        this.setVerfasser(_verfasser);
        this.setVerlag(_verlag);
    }

    /**
     * Getter Methode zum abrufen des Wert im Attribut erscheinungsjahr
     *
     * @return Integer
     */
    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    /**
     * Getter Methode zum abrufen des Wert im Attribut isbn
     *
     * @return String
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Getter Methode zum abrufen des Wert im Attribut Verlag
     *
     * @return String
     */
    public String getVerlag() {
        return verlag;
    }

    /**
     * Getter Methode zum abrufen des Wert im Attribut Verfasser
     *
     * @return String
     */
    public String getVerfasser() {
        return verfasser;
    }

    /**
     * Setter Methode zum setzen eines Wertes im Attribut Erscheinungsjahr
     *
     * @param erscheinungsjahr
     */
    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    /**
     * Erweiterte Setter Methode zum setzen eines Wertes im Attribut isbn
     * 1) Ermitteln der Länge der ISBN Nummer ohne Bindestriche. Bindestriche müssen bei der ISBN trotzdem angegeben werden
     * default Anweisung vom Switch gibt sonst eine Fehlermeldung aus das die Länge nicht korrekt ist.
     * 2) ISBN String Manipulation: Bindespriche werden aus der ISBN Herrausgefiltert.
     * 3) Switch-Case Anweisung für Fall Unterscheidung ob 10 oder 13 Ziffern
     * Attribut zuweisung erfolgt nur bei true Rückgabewert der Methode "checkISBN10()" "oder checkISBN13()"
     * 4) Bei Fehlern werden dem Nutzer vorschläge gemacht was eventuell falsch sein könnte
     * 5) Attribut bekommt bei Fehlerhafter ISBN den Wert "/" um in Späteren aufgaben bücher dannach
     * zu filtern und Attribut werte zu ergänzen
     *
     * @param isbn
     */
    public void setIsbn(String isbn) {
        int laengeisbn = 0;
        for (int i = 0; i < isbn.length(); i++) {
            if (Character.isDigit(isbn.toCharArray()[i])) {
                laengeisbn++;
            }
        }
        int[] isbnarr = new int[laengeisbn];
        int count = 0;
        for (int i = 0; i < isbn.length(); i++) {
            if (Character.isDigit(isbn.toCharArray()[i])) {
                isbnarr[count] = ((int)isbn.charAt(i) - 48);
                count++;
            }
        }
        switch (laengeisbn) {
            case 10: {
                if (Buch.checkISBN10(isbnarr)) {
                    this.isbn = isbn;
                } else {
                    System.out.println("ISBN-10 Ist Fehlerhaft und wird als / gespeichert um später noch änderungen zu machen");
                    this.isbn = "/";
                }
                break;
            }
            case 13: {
                if (Buch.checkISBN13(isbnarr)) {
                    this.isbn = isbn;
                } else {
                    System.out.println("ISBN-13 Ist Fehlerhaft und wird als / gespeichert um später noch änderungen zu machen");
                    this.isbn = "/";
                }
                break;
            }
            default: {
                System.out.println("ISBN Hat die Falsche Länge und wird als / gespeichert um Später noch änderungen zu machen");
                this.isbn = "/";
            }
        }
    }

    /**
     * Setter Methode zum setzen eines Wertes im Attribut Verfasser
     *
     * @param verfasser
     */
    public void setVerfasser(String verfasser) {
        this.verfasser = verfasser;
    }

    /**
     * Setter Methode zum setzen eines Wertes im Attribut Verlag
     *
     * @param verlag
     */
    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    /**
     * Gegebene Funktion zum Validieren der ISBN mit 10 Stellen
     *
     * @param isbn
     * @return boolean
     */
    public static boolean checkISBN10(int[] isbn) {
        int sum = 0;
        for (int i = 1; i <= isbn.length; i++) {
            sum += i * isbn[i - 1];
        }
        return sum % 11 == 0;
    }

    /**
     * Gegebene Funktion zum Validieren der ISBN mit 13 Stellen
     *
     * @param isbn
     * @return boolean
     */
    public static boolean checkISBN13(int[] isbn) {
        int sum = 0;
        for (int i = 1; i < isbn.length; i++) {
            if (i % 2 == 0) {
                sum += isbn[i - 1] * 3;
            } else {
                sum += isbn[i - 1];
            }
        }
        int lastDigit = sum % 10;
        int check = (10 - lastDigit) % 10;
        return isbn[isbn.length - 1] == check;
    }

    /**
     * Geerbte Funktion zum Ausgeben der Daten vom Medium
     * Werte Werden aus den Klassenattributen mittels Objekt vom Typ StringBuilder hinter einander gehängt
     * und dann als String formatiert und zurückgegeben
     *
     * @return String
     */
    public String calculateRepresentation() {
        StringBuilder rueckgabe = new StringBuilder();
        rueckgabe.append("Titel: " + super.getTitel() + " ").append("Erscheinungsjahr: " + this.getErscheinungsjahr() + " ").append("Verlag: " + this.getVerlag() + " ").append("ISBN: " + this.getIsbn() + " ").append("Verfasser: " + this.getVerfasser() + " ");
        return rueckgabe.toString();
    }
}
