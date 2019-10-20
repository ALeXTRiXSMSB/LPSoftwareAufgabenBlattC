package c4;

import java.util.ArrayList;
import java.util.Scanner;

public class Zettelkasten {

    private ArrayList<Medium> medien;

    Zettelkasten(){
        medien = new ArrayList<>();
    }

    public void addMedium(){
        Scanner tastatur = new Scanner(System.in);
        System.out.println("Was für ein Typ?");
        System.out.println("Buch");
        System.out.println("CD");
        System.out.println("Zeitschrift");
        String eingabe = tastatur.nextLine();
        switch(eingabe){
            case "Buch":{
                System.out.println("Titel: ");
                String titel = tastatur.nextLine();
                System.out.println("Erscheinungsjahr: ");
                int erscheinungsjahr = tastatur.nextInt();
                System.out.println("Verlag: ");
                String verlag = tastatur.nextLine();
                System.out.println("ISBN: ");
                String isbn = tastatur.nextLine();
                System.out.println("Verfasser: ");
                String verfasser = tastatur.nextLine();
                medien.add(new Buch(titel,erscheinungsjahr,verlag,isbn,verfasser));
                break;
            }
            case "CD":{
                System.out.println("Titel: ");
                String titel = tastatur.nextLine();
                System.out.println("Label: ");
                String label = tastatur.nextLine();
                System.out.println("Künstler: ");
                String kuenstler = tastatur.nextLine();
                medien.add(new CD(titel,label,kuenstler));
                break;
            }
            case "Zeitschrift":{
                System.out.println("Titel: ");
                String titel = tastatur.nextLine();
                System.out.println("ISSN: ");
                String issn = tastatur.nextLine();
                System.out.println("Volume: ");
                String volume = tastatur.nextLine();
                System.out.println("Nummer: ");
                int nummer = tastatur.nextInt();
                medien.add(new Zeitschrift(titel,issn,volume,nummer));
                break;
            }
            default:{
                System.out.println("Bitte den Wert genauso wie angegeben eingeben");

            }
        }
    }

    public void dropMedium(){

    }

    public Medium findMedium(){

        for(Medium m:medien){

        }
        return null;
    }

    public void sort(){

    }
}