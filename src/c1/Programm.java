package c1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Programm {

    /**
     *
     * @param args
     */
    public static void main(String[] args){

        Adresse adresse = new Adresse();
        adresse.setStrasse("Ringstr. 1");
        adresse.setOrt("Musterstadt");

        Person hugo = new Person();
        hugo.setName("Hugo Schmidt");
        hugo.setAdresse(adresse);

        Person erika = new Person();
        erika.setName("Erika Schmidt");
        erika.setAdresse(adresse);

        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(hugo);
        personArrayList.add(erika);


        for(Person p:personArrayList){
            System.out.println(p.toString());
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C1.ser"));
            oos.writeObject(personArrayList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
