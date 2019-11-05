package c2;

public class Programm {


    /**
     * Programm Einstiegspunkt
     * @param args
     */
    public static void main(String[] args){
        try{
            //Familie mit kinder
            Familie fam1 = new Familie("Vater1","Mutter1");
            fam1.addKind("Kind1");
            fam1.addKind("Kind2");
            System.out.println("Vater: " + fam1.getMitglieder(Familie.Familienmitglied.Vater));
            System.out.println("Mutter: " + fam1.getMitglieder(Familie.Familienmitglied.Mutter));
            System.out.println("Kind: " + fam1.getMitglieder(Familie.Familienmitglied.Kind));

            //Familie ohne kinder
            Familie fam2 = new Familie("Vater2","Mutter2");
            System.out.println("Vater: " + fam2.getMitglieder(Familie.Familienmitglied.Vater));
            System.out.println("Mutter: " + fam2.getMitglieder(Familie.Familienmitglied.Mutter));
            System.out.println("Kind: " + fam2.getMitglieder(Familie.Familienmitglied.Kind));

            //Familie ohne vater
            Familie fam3 = new Familie(null,"Mutter3");
            System.out.println("Vater: " + fam3.getMitglieder(Familie.Familienmitglied.Vater));
            System.out.println("Mutter: " + fam3.getMitglieder(Familie.Familienmitglied.Mutter));
            System.out.println("Kind: " + fam3.getMitglieder(Familie.Familienmitglied.Kind));

            //Familie ohne mutter
            Familie fam4 = new Familie("Vater4",null);
            System.out.println("Vater: " + fam4.getMitglieder(Familie.Familienmitglied.Vater));
            System.out.println("Mutter: " + fam4.getMitglieder(Familie.Familienmitglied.Mutter));
            System.out.println("Kind: " + fam4.getMitglieder(Familie.Familienmitglied.Kind));
        }catch(IllegalArgumentException e){
            System.out.println("Es wurde ein ungültiger name eingegeben");

        }
    }
}
