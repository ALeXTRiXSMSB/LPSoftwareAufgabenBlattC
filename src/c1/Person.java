package c1;

import java.io.Serializable;

public class Person implements Serializable{

    /**
     * Klassenattribute
     */
    private String name;
    private Adresse adresse;


    /**
     * Gettermethode für das Attribut Name
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Settermethode für das Attribut Name
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Gettermethode für das Attribut Adresse
     * @return
     */
    public Adresse getAdresse(){
        return adresse;
    }

    /**
     * Settermethode für das Attribut Adresse
     * @param adresse
     */
    public void setAdresse(Adresse adresse){
        this.adresse = adresse;
    }

    /**
     * Überschriebene toString methode
     * gibt den Namen und die Adresse zurück
     * @return
     */
    public String toString(){
        return new StringBuilder().append(name).append(", ").append(adresse.toString()).toString();
    }
}
