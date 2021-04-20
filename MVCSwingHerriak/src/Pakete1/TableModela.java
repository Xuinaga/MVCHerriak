/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pakete1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jon
 */
public class TableModela extends AbstractTableModel {

    private String[] izenaZutabe = {"HERRIA", "PROBINTZIA", "HONDARTZA", "HONDARTZA"};
    private ArrayList<Herria> nireDatuak = new ArrayList<>();

    private Connection connect() {
        // SQLite connection string
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost/db_herriak", "root", "");;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public TableModela() {

        String sql = "SELECT herria, probintzia, hondartza, oharrak FROM Herriak";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {

                nireDatuak.add(new Herria(rs.getString("herria"), rs.getString("probintzia"), rs.getBoolean("hondartza"), rs.getString("oharrak")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public int getRowCount() {
        return nireDatuak.size();
    }

    @Override
    public int getColumnCount() {
        return izenaZutabe.length;
    }

    @Override
    public String getColumnName(int col) {
        return izenaZutabe[col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public Object getValueAt(int row, int col) {
        if (col == 0) {
            return nireDatuak.get(row).getHerria();
        } else if (col == 1) {
            return nireDatuak.get(row).getProbintzia();
        } else if (col == 2) {
            return nireDatuak.get(row).isHondartza();
        } else if (col == 3) {
            return nireDatuak.get(row).getOharrak();
        } else {
            return null;
        }
    }

}
