package c3;

public class Programm {

    public static void main(String[] args) {
        Familie familie = new Familie("vater","mutter");
        familie.addKind("Kind1");
        familie.addKind("Kind2");
        familie.addKind("Kind3");
        for(String name : familie.getMitglieder()){
            System.out.println(name);
        }
    }
}
