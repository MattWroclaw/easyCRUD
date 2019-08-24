package poMojemu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    DBProperties db = new DBProperties();

    public KsiazkaMoje findById(int idKsiazki) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        KsiazkaMoje ks = new KsiazkaMoje();
        try { //tuaj już nie ma ClasForName ..

            connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            preparedStatement = connection.prepareStatement("SELECT * FROM ksiazka WHERE id=?");
            preparedStatement.setInt(1, idKsiazki);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            ks.setId(resultSet.getInt("id"));
            ks.setTytul(resultSet.getString("tytul"));

            int anInt = resultSet.getInt("id");
            String tytul = resultSet.getString("tytul");
            System.out.println(tytul);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ks;
    }

    public void newBooks(String tytul) {

        String dodanyTytulSQL = "INSERT INTO ksiazka (tytul) VALUES (?);";

        try (Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
        PreparedStatement prepareSmt = connection.prepareStatement(dodanyTytulSQL);){

        prepareSmt.setString(1, tytul);
        int liczbaDodanychKsiazek = prepareSmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateById(int id, String updateTytul) {
        String dodanyTytulSQL = "UPDATE ksiazka SET tytul =? WHERE id =?";
        String url = "jdbc:mysql://localhost:3306/ksiegarnia";
        String user = "sdatest";
        String password = "Start123!";

        try (Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
             PreparedStatement prepareSmt = connection.prepareStatement(dodanyTytulSQL);){

            prepareSmt.setString(1, updateTytul);
            prepareSmt.setInt(2, id);
            int liczbaDodanychKsiazek = prepareSmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteById(int idKsiazkiDoSkasowania) {

        Connection connection = null;
        PreparedStatement preStmt = null;
        try {
            String url = "jdbc:mysql://localhost:3306/ksiegarnia";
            String user = "sdatest";
            String password = "Start123!";
            connection = DriverManager.getConnection(url, user, password);

            preStmt = connection.prepareStatement("DELETE FROM ksiazka WHERE id=?");
            preStmt.setInt(1, idKsiazkiDoSkasowania);
            int countUpdateRecords = preStmt.executeUpdate();

            System.out.println("zaktualizowano " + countUpdateRecords + " rekordow");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preStmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void listaWszystkichKsiazek(){
        String sqlSelect = "SELECT * FROM ksiazka;";
        List<KsiazkaMoje> listaKsiazek = new ArrayList<KsiazkaMoje>();

        try (Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
        Statement statement = connection.createStatement();){
        ResultSet resultSet =statement.executeQuery(sqlSelect);

        while(resultSet.next()){
        KsiazkaMoje ksiazkaMojeDB =new KsiazkaMoje();
        ksiazkaMojeDB.setId(resultSet.getInt("id"));
        ksiazkaMojeDB.setTytul(resultSet.getString("tytul"));
        listaKsiazek.add(ksiazkaMojeDB);
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Lista wszystkich książek w liczbie: "+ listaKsiazek.size()  );
        for (KsiazkaMoje ksiazkaMoje : listaKsiazek) {
            System.out.println(ksiazkaMoje.getId()+", tytuł:"+ ksiazkaMoje.getTytul());

        }


    }
}
