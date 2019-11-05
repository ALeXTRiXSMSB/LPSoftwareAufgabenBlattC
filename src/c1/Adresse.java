package c1;

import java.io.Serializable;

public class Adresse implements Serializable{

    /**
     * Klassenattribute
     */
    private String strasse;
    private String ort;

    /**
     * Gettermethode für das Attribut Strasse
     * @return
     */
    public String getStrasse(){
        return this.strasse;
    }

    /**
     * Settermethode für das Attribut Strasse
     * @param strasse
     */
    public void setStrasse(String strasse){
        this.strasse = strasse;
    }

    /**
     * Gettermethode für das Attribut Ort
     * @return
     */
    public String getOrt(){
        return ort;
    }

    /**
     * Settermethode für das Attribut Ort
     * @param ort
     */
    public void setOrt(String ort){
        this.ort = ort;
    }

    /**
     * Überschriebene toString methode
     * gibt die Strasse und den Ort zurück
     * @return
     */
    public String toString(){
        return new StringBuilder().append(strasse).append(", ").append(ort).toString();
    }
}
