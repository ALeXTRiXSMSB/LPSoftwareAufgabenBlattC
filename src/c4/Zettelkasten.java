package c4;

import java.util.*;
import java.util.function.Consumer;

public class Zettelkasten implements Iterable<Medium> {

    private ArrayList<Medium> myZettelkasten;
    private boolean issorted = false;
    public final int aufsteigend = 0;
    public final int absteigend = 1;

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

    public boolean dropMedium(String titel){
        if(this.myZettelkasten.contains(findmMedium(titel))){
            this.myZettelkasten.remove(findmMedium(titel));
            return true;
        }else{
            return false;
        }
    }

    public Object findmMedium(String titel){
        ArrayList<Medium> rueckgabe = new ArrayList<>();
        for(Medium m:myZettelkasten){
            if(m.getTitel().equals(titel)){
                rueckgabe.add(m);
            }
        }
        if(rueckgabe.size() == 1){
            return rueckgabe.get(0);
        }else{
            if(rueckgabe != null){
                return rueckgabe;
            }else{
                return null;
            }
        }
    }

    @Override
    public Iterator<Medium> iterator() {
        return this.myZettelkasten.iterator();
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
