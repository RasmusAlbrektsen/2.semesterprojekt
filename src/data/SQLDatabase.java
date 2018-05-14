/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.IUser;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rasmusstamm
 */
public class SQLDatabase {

    public void loadData() {
        String url = "jdbc:postgresql://horton.elephantsql.com:5432/zibscemz";
        String username = "zibscemz";
        String passwd = "7A1e6LvgBXjitm0pjGI3tIOf5aCpr0Qe";
        List<IUser> users = new ArrayList<>();

        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                users.add(new DataUser(Integer.parseInt(rs.getString("id")), rs.getString("username"), rs.getString("password")));
            }
            System.out.println(users.get(3).getUsername());
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
