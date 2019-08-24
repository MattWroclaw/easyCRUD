package poTrenerowemu;

import java.util.List;

public class RozwiazanieZad3 {
    public static void main(String[] args) {
        KsiazkaDAO dao = new KsiazkaDAO();

        //wczytujemy wszystkie ksiazki i wyswietlamy
        List<Ksiazka> ksiazkaLista = dao.findAll();
        System.out.println("lista ksiazek: ");
        for (Ksiazka ksiazka : ksiazkaLista) {
            System.out.println(ksiazka.toString());
        }

        System.out.println("-------------------------------------------------------");

        //dodajemy 4 nowe ksiazki
        System.out.println("Dodajemy 4 nowe ksiazki");
        Ksiazka nowaKsiazka1 = new Ksiazka(null, "Pan Tadeusz");
        dao.newBook(nowaKsiazka1);
        Ksiazka nowaKsiazka2 = new Ksiazka(null, "Dziady");
        dao.newBook(nowaKsiazka2);
        Ksiazka nowaKsiazka3 = new Ksiazka(null, "Chlopi");
        dao.newBook(nowaKsiazka3);
        Ksiazka nowaKsiazka4 = new Ksiazka(null, "Boska komedia");
        dao.newBook(nowaKsiazka4);

        System.out.println("-------------------------------------------------------");

        //ponownie wczytujemy wszystkie ksiazki i wyswietlamy
        ksiazkaLista = dao.findAll();
        System.out.println("lista ksiazek: ");
        for (Ksiazka ksiazka : ksiazkaLista) {
            System.out.println(ksiazka.toString());
        }

        System.out.println("-------------------------------------------------------");

        //modyfikujemy ostatni rekord w tabeli ksiazka (z maksymalnym id)
        System.out.println("Modyfikujemy ostatni rekord");
        Ksiazka lastBook = dao.getLastBook();
        lastBook.setTytul("naklad wyczerpany");
        dao.ubdateById(lastBook);

        System.out.println("-------------------------------------------------------");

        //ponownie wczytujemy wszystkie ksiazki i wyswietlamy
        ksiazkaLista = dao.findAll();
        System.out.println("lista ksiazek: ");
        for (Ksiazka ksiazka : ksiazkaLista) {
            System.out.println(ksiazka.toString());
        }

        System.out.println("-------------------------------------------------------");

        //usuwamy ostatni rekord
        System.out.println("Usuwamy ostatni rekord");
        lastBook = dao.getLastBook();
        dao.deleteById(lastBook.getId());

        System.out.println("-------------------------------------------------------");

        //ponownie wczytujemy wszystkie ksiazki i wyswietlamy
        ksiazkaLista = dao.findAll();
        System.out.println("lista ksiazek: ");
        for (Ksiazka ksiazka : ksiazkaLista) {
            System.out.println(ksiazka.toString());
        }
    }
}
