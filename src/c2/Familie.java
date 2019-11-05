package c2;

import java.util.ArrayList;

public class Familie {

    /**
     * Klassenattribut
     */
    private ArrayList<String> mitglieder = new ArrayList();

    /**
     * Enumdatentyp mit dem Inhalt Vater,Mutter,Kind
     */
    public enum Familienmitglied {
        Vater, Mutter, Kind;
    }

    /**
     * Klassenkontruktor
     * prüfung ob eingaben korrekt sind sonst wird eine
     * IllegalArgumentException geschmissen
     * @param _vater
     * @param _mutter
     */
    public Familie(String _vater, String _mutter) {
        //Prüfen um übergabeparameter leer oder null wenn ja wird eine IllegalargumentException geschmissen
            if (_vater == null ||_vater.isBlank()) {
                throw new IllegalArgumentException();
            } else if (_mutter == null || _mutter.isBlank()) {
                throw new IllegalArgumentException();
            } else {
                //Arrayliste mit den werten von Vater und Mutter füllen
                this.mitglieder.add(_mutter);
                this.mitglieder.add(_vater);
            }
    }

    /**
     * Gettermethode für das die Mitglieder
     * gibt einen String zurück anstatt einer Arrayliste
     * unterscheidung findet mittels Familienmitglied als Enum wert statt
     * @param typ
     * @return
     */
    public String getMitglieder(Familienmitglied typ) {
        //Switch case anweisung zur typunterscheidung ob vater, mutter oder kind
        switch (typ) {
            case Vater: {
                return this.mitglieder.get(1);
            }
            case Mutter: {
                return this.mitglieder.get(0);
            }
            case Kind: {
                //wenn kind prüfen ob kinder vorhanden sind wenn nein wird ein leerer String zurückgegeben
                if (this.mitglieder.size() > 2) {
                    StringBuilder sb = new StringBuilder("");
                    //über alle "kinder" iterieren und an einen StringBuilder anhängen
                    for (int i = 2; i < this.mitglieder.size(); i++) {
                        sb.append(this.mitglieder.get(i)).append(",");
                    }
                    //zum schluss das letzte "," löschen
                    sb.deleteCharAt(sb.length() - 1);
                    return sb.toString();
                } else {
                    return "";
                }
            }
            default: {
                return "";
            }
        }
    }

    /**
     * Settermethode für das Attribut Mitglieder
     * @param mitglieder
     */
    public void setMitglieder(ArrayList mitglieder) {
        this.mitglieder = mitglieder;
    }

    /**
     * Methode für ein kind zum Attribut Mitglieder hinzu
     * @param kind
     */
    public void addKind(String kind) {
        //Prüfen ob kind leer oder null ist wenn ja wird eine Exception geschmissen wenn nein dann wird es hinzugefügt
            if (kind == null || kind.isBlank()) {
                throw new IllegalArgumentException();
            } else {
                this.mitglieder.add(kind);
            }
    }
}
