/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pakete1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author suinaga.jon
 */
public class Model {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:db/Herriak.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void gehitu(Herria h) {
        String sql = "INSERT INTO Herriak VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, h.getHerria());
            pstmt.setString(2, h.getProbintzia());
            pstmt.setBoolean(3, h.isHondartza());
            pstmt.setString(4, h.getOharrak());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Herria ez da gehitu");
        }
    }
}
