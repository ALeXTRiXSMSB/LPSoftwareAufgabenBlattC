package c4;

public interface Persistency {
    void save(Zettelkasten zk, String dateiname);
    Zettelkasten load(String dateiname);
}
