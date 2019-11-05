package c3;

public class Programm {

    /**
     * Programm Einstiegspunkt
     * @param args
     */
    public static void main(String[] args) {
        Familie familie = new Familie("vater","mutter");
        familie.addKind("Kind1");
        familie.addKind("Kind2");
        familie.addKind("Kind3");
        for(String name : familie){
            name = "bob";
            System.out.println(name);
        }
    }
}
