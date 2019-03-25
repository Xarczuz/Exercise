package Misc;

import java.util.ArrayList;
import java.util.List;

// Klassen Person med endast tre variabler -----
class Person {
    String namn;
    String tel;
    int ålder;
    int id;

    // Getter ---
    public String getNamn() { return namn; }
    public String getTel()  { return tel;  }
    public int getÅlder()   { return ålder;}
    public int getId()      { return id;   }

    // Konstruktuor ---
    Person(String namn, String tel, int ålder, int id){
        this.namn  = namn;
        this.tel   = tel;
        this.ålder = ålder;
        this.id    = id;
    }

    // Utskrift av rubrik för Person poster ----
    public void rubrikPost() {
        System.out.printf("\n  %-12s %-12s %-4s %-6s \n", "Namn","Tel","Ålder","Id");
        System.out.printf("----------------------------------------------------\n");
    }

    // Utskrift av Post för Person  ----
    public void visaPost() {
        System.out.printf("  %-12s %-12s %-4d %-6d \n", namn, tel, ålder, id);
    }

    // Override för att kunna skriva ut objekt som text ----
    @Override public String toString() {
        return ("Person[ "+"Name:"+this.getNamn()+
                " Tel: "+ this.tel +
                " Age: "+ this.getÅlder() +
                " Id: " + this.getId()+"]");
    }
}

// ------------------------------------------------------------
//  Main - Sortering av ArrayList med lambda            -------
// ------------------------------------------------------------

public class lambdaSort {

    public static void main(String[] args) {
        // Sortering av arrayList med Lambda  ---

        List<Person> pers = new ArrayList<Person>();
        pers.add(new Person("Bertil","070-1221223",22, 1011));
        pers.add(new Person("Ulla","08-4944239 ",19, 1002));
        pers.add(new Person("Stefan","070-323233",23, 1008));
        pers.add(new Person("Sara","08-2343344",20, 1010));
        pers.add(new Person("Adam","090-1223332", 18, 1101));

        System.out.println("Osorterad arrayList med Person poster:");
        // Formaterade utskrift av rubrik och poster ---
        pers.get(0).rubrikPost();
        for( Person s: pers)
            s.visaPost();
        System.out.println("\n");
        
        System.out.println("Person sorterad i Ålders ordning:");
        //Lambda uttryck för sortering i Ålders ordning
        pers.sort((Person s1, Person s2)->s1.getÅlder()-s2.getÅlder());
        //for printing the list för att få med i som kan användas till rad nummer
        pers.get(0).rubrikPost();
        for(int i=0; i < pers.size(); i++)
            pers.get(i).visaPost(); // Skriver ut posten
        System.out.println("\n");

        System.out.println("Person sorterad i Namn ordning:");
        //Lambda uttryck för sortering i Namn ordning
        pers.sort((Person s1, Person s2)->s1.getNamn().compareTo(s2.getNamn()));
        // Skapa en enkel rapport rad över listade posterna
        int antal =0; int summa = 0;
        pers.get(0).rubrikPost();
        for( Person s: pers) {
            s.visaPost();
            antal++;
            summa+= s.getÅlder();
        }
        System.out.printf("----------------------------------------------------\n");
        System.out.printf("  Poster: %d st  Ålder summa: %d  Medelålder: %d\n",
                antal, summa, summa/antal);
        System.out.println("\n");

        System.out.println("Person sorterad i Omvänd Namn ordning:");
        System.out.println("------------------------------------------");
        //Lambda uttryck för sortering i Namn ordning
        pers.sort((Person s1, Person s2)->s2.getNamn().compareTo(s1.getNamn()));
        pers.forEach((s)->System.out.println(s));System.out.println();


        System.out.println("Person sorterad i Id ordning:");
        System.out.println("------------------------------------------");
        //Lambda uttryck för sortering i Id ordning
        pers.sort((Person s1, Person s2)->s1.getId()-s2.getId());
        pers.forEach((s)->System.out.println(s));System.out.println();


        // Skriv ut en lista med utvalda fält
        // forEach metoden från ArrayList person
        // Skriver bara ut namnen och åldern via en metoden print()
        System.out.println("Skriver ut valda fält från en arrayList");
        System.out.println("------------------------------------------");
        pers.forEach((n) -> print(n));


        // Sök efter index för en post med matchande Heltal
        System.out.println("\nSöker efter posten med heltalet: id i arraylist");
        System.out.println("------------------------------------------");
        int post = 0;
        for( Person s: pers) {
            if( s.id == 1008)
                System.out.println("Raden innehåller "  + s.id + "  post " + post);
            post++;
        }

        // Sök efter index för en post matchande Strängar
        System.out.println("\nSöker efter posten med Strängen: namn i arraylist");
        System.out.println("------------------------------------------");
        post = 0; String n2 = "Ber";
        for( Person s: pers) {
            if( s.namn.toLowerCase().contains(n2.toLowerCase()))
                System.out.println("Raden innehåller "  + s.namn + "  post " + post+"\n");
            post++;
        }

        // Sök efter index för en post matchande Strängar som bara söker från start
        System.out.println("\nSöker efter posten med Strängen: namn i arraylist");
        System.out.println("------------------------------------------");
        post = 0;  n2 = "sa";
        for( Person s: pers) {
            if( s.namn.toLowerCase().startsWith(n2.toLowerCase()))
                System.out.println("Raden innehåller "  + s.namn + "  post " + post+"\n");
            post++;
        }
    }

    // Metoder -----------------------------------------

    // Skriv ut personen namn och ålder från listan ---
    public static void print(Person n)
    {
        // Skriver ut namnet som är nåbar
        System.out.printf("Name: %-7s ", n.namn);
        // Skriver ut ålder som om den vore privat med getÅlder()
        System.out.printf("  Ålder: %2d\n", n.getÅlder());
    }

}
