package c2;

import java.util.ArrayList;

public class Familie {

    private ArrayList mitglieder;

    public enum Familienmitglied{
        Vater,Mutter,Kind;
    }

    public Familie(String _vater, String _mutter){

    }

    public ArrayList getMitglieder() {
        return mitglieder;
    }

    public void setMitglieder(ArrayList mitglieder) {
        this.mitglieder = mitglieder;
    }

    public void addKind(String kind){

    }
}
