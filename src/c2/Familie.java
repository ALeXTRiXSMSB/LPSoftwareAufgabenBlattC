package c2;

import java.util.ArrayList;

public class Familie {

    private ArrayList mitglieder;

    public Familie(String _vater, String _mutter){
        Person vater = new Person();
        Person mutter = new Person();
        vater.setName(_vater);
        mutter.setName(_mutter);
    }

    public void addKind(String kind){

    }

    public enum Familienmitglied{
        Vater,Mutter,Kind;
    }

    public ArrayList getMitglieder() {
        //MUss noch bearbeitet werden
        return mitglieder;
    }

    public void setMitglieder(ArrayList mitglieder) {
        this.mitglieder = mitglieder;
    }
}
