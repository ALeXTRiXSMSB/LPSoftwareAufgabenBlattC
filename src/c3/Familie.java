package c3;

import java.util.ArrayList;
import java.util.Iterator;

public class Familie implements Iterable<String>{

    private ArrayList<String> mitglieder = new ArrayList<String>();

    public enum Familienmitglied {
        Vater, Mutter, Kind;
    }

    public Familie(String _vater, String _mutter) {
            if (_vater == null ||_vater.isBlank()) {
                throw new IllegalArgumentException();
            } else if (_mutter == null || _mutter.isBlank()) {
                throw new IllegalArgumentException();
            } else {
                this.mitglieder.add(_mutter);
                this.mitglieder.add(_vater);
            }
    }

    public ArrayList<String> getMitglieder(){
        return this.mitglieder;
    }

    public String getMitglieder(Familienmitglied typ) {
        switch (typ) {
            case Vater: {
                return this.mitglieder.get(1);
            }
            case Mutter: {
                return this.mitglieder.get(0);
            }
            case Kind: {
                if (this.mitglieder.size() > 2) {
                    StringBuilder sb = new StringBuilder("");
                    for (int i = 2; i < this.mitglieder.size(); i++) {
                        sb.append(this.mitglieder.get(i)).append(",");
                    }
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

    public void setMitglieder(ArrayList mitglieder) {
        this.mitglieder = mitglieder;
    }

    public void addKind(String kind) {
            if (kind.isBlank()) {
                throw new IllegalArgumentException();
            } else {
                this.mitglieder.add(kind);
            }
    }

    @Override
    public Iterator<String> iterator() {
        return this.mitglieder.iterator();
    }
}
