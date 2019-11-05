package c4;

/**
 * Klasse ElektronischesMedium die von der Abstrakten Klasse Medium Erbt
 */
public class ElektronischesMedium extends Medium {

    /**
     * Klassenattribute
     */
    private String url;

    /**
     * Konstruktor zum Erstellen von einem Objekt ElektronischesMedium
     * @param _titel
     * @param _url
     */
    public ElektronischesMedium(String _titel, String _url) {
        super(_titel);
        this.setUrl(_url);
    }

    /**
     * Gettermethode für das Attribut url
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Settermethode für das Attribut url
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * methode zum überprüfen einer URL
     * @param url
     * @return
     */
    public boolean checkURL(String url){
        return true;
    }

    /**
     * Geerbte Funktion zum Ausgeben der Daten vom Medium
     * Werte Werden aus den Klassenattributen mittels Objekt vom Typ StringBuilder hinter einander gehängt
     * und dann als String formatiert und zurückgegeben
     * @return String
     */
    @Override
    public String calculateRepresentation() {
        StringBuilder rueckgabe = new StringBuilder();
        rueckgabe.append(super.calculateRepresentation() + " ")
                .append("URL: " + this.getUrl());
        return rueckgabe.toString();
    }
}
