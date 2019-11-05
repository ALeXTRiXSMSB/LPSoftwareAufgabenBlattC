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


        zettelkasten.addMedium(new CD("Test","Test","Test"));
        zettelkasten.addMedium(new Buch("Test",1995,"Test","3-411-04013-0","3-411-04013-0"));
        zettelkasten.addMedium(new ElektronischesMedium("Test","Test"));
        zettelkasten.addMedium(new Zeitschrift("Test","Test","Test",0));
        zettelkasten.addMedium(new CD("Test","Test","Test"));
        zettelkasten.addMedium(new CD("Test","Test","Test"));
        zettelkasten.addMedium(new CD("Test","Test","Test"));
        zettelkasten.addMedium(new CD("Test","Test","Test"));
        zettelkasten.addMedium(new Buch("Test",1995,"Test","3-411-04013-0","3-411-04013-0"));
        zettelkasten.addMedium(new ElektronischesMedium("Test","Test"));
        zettelkasten.addMedium(new Zeitschrift("Test","Test","Test",0));
        zettelkasten.addMedium(new CD("Test","Test","Test"));
        zettelkasten.addMedium(new CD("Test","Test","Test"));
        zettelkasten.addMedium(new CD("Test","Test","Test"));


        /**
        zettelkasten.dropMedium("Test");
        System.out.println(zettelkasten.sort(zettelkasten.aBISz));

        for(Medium m : zettelkasten){
            System.out.println(m.calculateRepresentation());
        }

        System.out.println(zettelkasten.sort(zettelkasten.zBISa));

        for(Medium m : zettelkasten){
            System.out.println(m.calculateRepresentation());
        }
        **/
        DatabasePersistency test = new DatabasePersistency();
        test.save(zettelkasten,"test.store");
        Zettelkasten neu = test.load("test.store");
        for(Medium m : neu){
            System.out.println(m.calculateRepresentation());
        }

    }
}
