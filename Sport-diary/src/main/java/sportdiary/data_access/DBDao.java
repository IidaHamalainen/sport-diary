/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportdiary.data_access;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import sportdiary.domain.Liikuntakerta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author iida
 */
public class DBDao implements SportDao{
    
    private String url;
    
    public DBDao(String url) {
        this.url = url;
    }

    @Override
    public List<Liikuntakerta> listAll() throws Exception {
        Connection conn = DriverManager.getConnection(url);
        List<Liikuntakerta> liikunnat = new ArrayList<>();
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Liikunta");
            liikunnat = createListFromResult(result);
            
        } catch (Exception e) {
            System.out.println("Database is empty.");
        }

        conn.close();

        return liikunnat;
    }

    @Override
    public void add(Liikuntakerta liikunta) throws Exception {
        Connection conn = DriverManager.getConnection(url);
        createTable(conn);
        
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO Liikunta (laji, km, pvm) "
                + "VALUES (?,?,?)");
        
        stmt.setString(1, liikunta.getLaji());
        stmt.setDouble(2, liikunta.getKm());
        stmt.setString(3, liikunta.getPvm());
        stmt.execute();
        conn.close();
    }

    private List<Liikuntakerta> createListFromResult(ResultSet result) throws Exception {
        List<Liikuntakerta> liikunnat = new ArrayList<>();
        while(result.next()) {
            int id = result.getInt("id");
            String laji = result.getString("laji");
            Double km = result.getDouble("km");
            String pvm = result.getString("pvm");
            
            Liikuntakerta suoritus = new Liikuntakerta(id,laji, km, pvm);
            suoritus.setId(id);
            suoritus.setLaji(laji);
            suoritus.setKm(km);
            suoritus.setPvm(pvm);
            liikunnat.add(suoritus);
            
        }
        return liikunnat;
    }
    public void createTable(Connection conn) throws SQLException {
        
        Statement stmt = conn.createStatement();
        
        try {

            stmt.execute(
                    "CREATE TABLE Liikunta ("
                    + "id INTEGER PRIMARY KEY, "
                    + "laji TEXT, "
                    + "km DOUBLE, "
                    + "pvm TEXT)");              
                    
        } catch (Exception e) {
            System.out.println("Database schema already exists.");
        }

    }
}
  