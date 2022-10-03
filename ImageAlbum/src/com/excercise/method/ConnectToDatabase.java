package com.excercise.method;

import javax.swing.*;
import java.sql.*;

public class ConnectToDatabase {
    public static Connection DbConnection;

    static {
        try {
            DbConnection = ConnectToMyLocalDatabase();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    }

    public static Connection ConnectToMyLocalDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String ConnectionUrl1="jdbc:sqlserver://DESKTOP-KQF883T;database=Images;integratedSecurity=true;";
        Connection con = DriverManager.getConnection(ConnectionUrl1);
        JOptionPane.showMessageDialog(null,"Connected");
        PreparedStatement st =con.prepareStatement("select * from SavedImages");
        ResultSet s1=st.executeQuery();
        int code=0;
        while(s1.next()){
            code=s1.getInt("ImageSC");
            System.out.println(code);
        }
        return con;
    }
}
