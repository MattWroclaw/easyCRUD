package poMojemu;

import poMojemu.DAO;

public class main {
    public static void main(String[] args) {

        DAO dao = new DAO();

//        dao.findById(5);
//        dao.deleteById(10);
//        dao.newBooks("Kordian");
//        dao.updateById(11, "Podróże w czasie");
        dao.listaWszystkichKsiazek();


    }
}
