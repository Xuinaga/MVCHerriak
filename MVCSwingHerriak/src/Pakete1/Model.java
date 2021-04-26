/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pakete1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author suinaga.jon
 */
public class Model {

    private static Connection connect() {
        // SQLite connection string
        String dbi="jdbc:mariadb://192.168.65.1:3306/HerrienDBa";
        String useri="dam1";
        String passi="dam1";
        String dbni="jdbc:mariadb://192.168.65.1:3306/HerrienDBa";
        String userni="dam1";
        String passni="dam1";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbi,useri,passi);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static ArrayList<Herria> arrayListaBete() {
        
        ArrayList<Herria> datuak=new ArrayList<>();
        
        String sql = "SELECT * FROM Herriak";

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {

                datuak.add(new Herria(rs.getString("herria"), rs.getString("probintzia"), rs.getBoolean("hondartza"), rs.getString("oharrak")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datuak;
    }

    public void gehitu(Herria h) {
        String sql = "INSERT INTO Herriak(herria,probintzia,hondartza,oharrak) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, h.getHerria());
            pstmt.setString(2, h.getProbintzia());
            pstmt.setBoolean(3, h.isHondartza());
            pstmt.setString(4, h.getOharrak());
            pstmt.executeUpdate();
            System.out.println("Herria ondo gehitu da.");
        } catch (SQLException e) {
            System.out.println("Herria ez da gehitu");
        }
    }
    public void ezabatu(){
        int ilara = View.jTable1.getSelectedRow();
        String ezabatzekoHerria= (String)View.jTable1.getValueAt(ilara, 0);
        String sql = "DELETE FROM Herriak WHERE herria = ?; ";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ezabatzekoHerria);
            pstmt.executeUpdate();
            System.out.println("Herria ezabatu da.");
        }catch(SQLException e){
            System.out.println("Herria ez da ezabatu.");
        }
    }
}
