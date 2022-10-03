package com.excercise.method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Albums {
    public static Connection DbConnection;

    public static int CountSavedAlbums(Connection DbConnection) throws SQLException {
        int SavedAlbumsCount=0;
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("select * from SavedAlbums");
        ResultSet s1=st.executeQuery();
        int code=0;
        while(s1.next()){
            SavedAlbumsCount++;
            code=s1.getInt("AlbumID");
            System.out.println(code);
        }
        return SavedAlbumsCount;
    }

    public static int FindNewAlbumID() throws SQLException {
        int NewID = 0;
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("select * from SavedAlbums");
        ResultSet s1=st.executeQuery();
        int code=0;
        while(s1.next()){
            code=s1.getInt("AlbumID");
            System.out.println(code);
        }
        NewID=code+1;
        return NewID;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int temp;
        temp=CountSavedAlbums(DbConnection);
        System.out.println(temp);
    }

    public static String[] CreateAlbumArray() throws SQLException {
        String[] AlbumArray=new String[CountSavedAlbums(DbConnection)];
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("select * from SavedAlbums");
        ResultSet s1=st.executeQuery();
        int i=0;
        String code;
        while(s1.next()){
            code=s1.getString("AlbumName");
            AlbumArray[i]=code;
            i++;
            System.out.println(code);
        }
        return AlbumArray;
    }
}
