/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;

/**
 *
 * @author rasmusstamm
 */
public class SQLDatabase {

    public void loadData() {
        String url = "jdbc:postgresql://horton.elephantsql.com:5432/zibscemz";
        String username = "zibscemz";
        String passwd = "7A1e6LvgBXjitm0pjGI3tIOf5aCpr0Qe";

        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
