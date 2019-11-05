package c4;

import java.util.*;

public class Zettelkasten implements Iterable<Medium> {

    private ArrayList<Medium> myZettelkasten;
    private boolean issorted = false;
    public final int aBISz = 0;
    public final int zBISa = 1;

    public Zettelkasten(){
        this.myZettelkasten = new ArrayList<>();
    }

    public Zettelkasten(ArrayList<Medium> myZettelkasten) {
        this.myZettelkasten = myZettelkasten;
    }

    public boolean addMedium(Medium m){
        switch(m.getClass().getSimpleName()){
            case "Buch":{
                Buch tmp =(Buch)m;
                myZettelkasten.add(tmp);
                return true;
            }
            case "CD":{
                CD tmp =(CD)m;
                myZettelkasten.add(tmp);
                return true;
            }
            case "Zeitschrift":{
                Zeitschrift tmp =(Zeitschrift) m;
                myZettelkasten.add(tmp);
                return true;
            }
            case "ElektronischesMedium":{
                ElektronischesMedium tmp =(ElektronischesMedium) m;
                myZettelkasten.add(tmp);
                return true;
            }
            default:{
                System.out.println("Bitte den Wert genauso wie angegeben eingeben");
                return false;
            }
        }
    }

    public void dropMedium(String titel){
        ArrayList<Medium> tmp = findMedium(titel);
        if(tmp != null){
            if(tmp.size() == 1){
                this.myZettelkasten.remove(tmp.get(0));
            }else{
                try {
                    throw new DuplicateEntryException("Es befinden sich mehrere Elemente in der Liste");
                } catch (DuplicateEntryException e) {
                    System.out.println("Medien mit dem Titel: "+titel+" sind mehrfach aufgetaucht");
                    System.out.println("1) Alle Löschen");
                    System.out.println("2) Auswahl Löschen");
                    System.out.println("3) nichts Löschen");
                    Scanner tastatur = new Scanner(System.in);
                    switch(tastatur.nextInt()){
                        case 1:{
                            this.dropAllMedien(titel);
                            break;
                        }
                        case 2:{
                            this.dropMedien(titel);
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                }
            }
        }else{
            throw new NullPointerException("Element befindet sich nicht in dem Zettelkasten");
        }
    }

    private void dropMedien(String titel){
        ArrayList<Medium> tmp = findMedium(titel);
        Scanner tastatur = new Scanner(System.in);
        String auswahl = "";
        for(int i = 0; i < tmp.size();i++){
            System.out.println(tmp.get(i).calculateRepresentation());
            System.out.println("Löschen [j/n]");
            auswahl = tastatur.nextLine();
            switch(auswahl){
                case "j":{
                    this.myZettelkasten.remove(tmp.get(i));
                    break;
                }
                case "n":{
                    System.out.println("Element wird nicht gelöscht");
                    break;
                }
                default:{
                    this.dropMedien(titel);
                }
            }
        }
    }

    private void dropAllMedien(String titel){
        ArrayList<Medium> tmp = findMedium(titel);
        this.myZettelkasten.removeAll(tmp);
    }

    public ArrayList<Medium> findMedium(String titel){
        ArrayList<Medium> rueckgabe = new ArrayList<>();
        for(Medium m:myZettelkasten){
            if(m.getTitel().equals(titel)){
                rueckgabe.add(m);
            }
        }
        if(rueckgabe.size() != 0){
            rueckgabe = this.sortDuplicates(rueckgabe);
            return rueckgabe;
        }else{
            return null;
        }
    }

    @Override
    public Iterator<Medium> iterator() {
        return this.myZettelkasten.iterator();
    }

    private ArrayList<Medium> sortDuplicates(ArrayList<Medium> unsortet){
        Collections.sort(unsortet);
        return unsortet;
    }

    public boolean sort(int richtung){
        if(!this.issorted){
            Collections.sort(myZettelkasten);
            this.issorted = true;
        }
        if(richtung == 0){
            Collections.sort(myZettelkasten);
        }else{
            Collections.sort(myZettelkasten,Collections.reverseOrder());
        }
        return true;
    }
}
