package com.excercise.method;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckIfImageExists {

    public static boolean CheckIfImageAlreadyExistsInAlbum (String SearchingImageName,String AlbumName) throws SQLException {
        boolean ImageExists= false;
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("select * from "+AlbumName+"");
        ResultSet s1=st.executeQuery();
        int code=0;
        String DatabaseImageName;
        while(s1.next()){
            code=s1.getInt("ImageSC");
            DatabaseImageName=s1.getString("ImageName");
            if (SearchingImageName==DatabaseImageName){
                return true;
            }
            System.out.println(code);
        }
        return false;
    }

    public static boolean CheckIfImageAlreadyExists (String SearchingImageName) throws SQLException {
        boolean ImageExists= false;
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("select * from SavedImages");
        ResultSet s1=st.executeQuery();
        int code=0;
        String DatabaseImageName;
        while(s1.next()){
            code=s1.getInt("ImageSC");
            DatabaseImageName=s1.getString("ImageName");
            if (SearchingImageName==DatabaseImageName){
                return true;
            }
            System.out.println(code);
        }
        return false;
    }
}
