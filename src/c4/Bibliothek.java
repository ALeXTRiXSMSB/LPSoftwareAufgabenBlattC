package c4;

public class Bibliothek {

    public static void main(String[] args){
        Zettelkasten zettelkasten = new Zettelkasten();
        zettelkasten.addMedium(new CD("Live At Wembley","Queen","Parlophone (EMI)"));
        zettelkasten.addMedium(new Buch("Duden 01. Die deutsche Rechtschreibung",2004,"Bibliographisches Institut, Mannheim","3-411-04013-0","-"));
        zettelkasten.addMedium(new ElektronischesMedium("Hochschule-Stralsund","https://hochschule-stralsund.de"));
        zettelkasten.addMedium(new Zeitschrift("Der Spiegel","0038-7452","54",6));
        zettelkasten.addMedium(new Zeitschrift("Der Spiegel","0038-7452","54",6));
        zettelkasten.addMedium(new Zeitschrift("Der Spiegel","0038-7452","54",6));


        Object o = zettelkasten.findmMedium("Der Spiegel");
        Medium tmp = (Medium)o;
        System.out.println(tmp.calculateRepresentation());
        System.out.println(zettelkasten.dropMedium("Der Spiegel"));
        System.out.println(zettelkasten.sort(zettelkasten.aufsteigend));

        for(Medium m : zettelkasten){
            System.out.println(m.calculateRepresentation());
        }

        System.out.println(zettelkasten.sort(zettelkasten.absteigend));

        for(Medium m : zettelkasten){
            System.out.println(m.calculateRepresentation());
        }
    }
}
