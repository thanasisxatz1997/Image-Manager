package com.excercise.method;

import java.awt.*;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Images {

    public static void AddImageToSavedImages(String ImageName) throws SQLException {
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("INSERT INTO SavedImages(ImageSC,ImageName) VALUES ("+Images.FindNewImageID()+",'"+ImageName+"');");
        st.execute();
    }

    public static void AddImageToAlbum(String ImageName, String AlbumName) throws SQLException {
        int IdOfImage=Images.SearchForImageID(ImageName);
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("INSERT INTO "+AlbumName+"(ImageID,ImageName) VALUES ("+IdOfImage+",'"+ImageName+"');");
        st.execute();
    }

    public static int FindNewImageID() throws SQLException {
        int NewID = 0;
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("select * from SavedImages");
        ResultSet s1=st.executeQuery();
        int code=0;
        while(s1.next()){
            code=s1.getInt("ImageSC");
        }
        NewID=code+1;
        return NewID;
    }

    public static int SearchForImageID(String ImageNameToSave) throws SQLException {
        int ImageID = 0;
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("select * from SavedImages");
        ResultSet s1=st.executeQuery();
        int code=0;
        String CurImageName;
        while(s1.next()){
            code=s1.getInt("ImageSC");
            CurImageName=s1.getString("ImageName");
            ImageID=code;
            if(CurImageName.equals(ImageNameToSave))
            {
                return ImageID;
            }
        }
        return 0;
    }

    public static int CountSavedFilteredImages(String Album,String People, String Place) throws SQLException {
        int SavedImagesCount=0;
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("select * from SavedImages where Place='"+Place+"'");
        System.out.println("The Place is: "+Place);
        ResultSet s1=st.executeQuery();
        String code="";
        while(s1.next()){
            SavedImagesCount++;
            code=s1.getString("ImageName");
            System.out.println("Count ends at: "+code);
        }
        return SavedImagesCount;
    }

    public static File[] ReturnSavedFilteredImages(String Album, String People, String Place, int count) throws SQLException {
        int i=0;
        File[] FilteredImages=new File[count];
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("select * from SavedImages where Place='"+Place+"'");
        ResultSet s1=st.executeQuery();
        String code="";
        while(s1.next()){
            code=s1.getString("ImageName");
            System.out.println("The image name is: "+code);
            FilteredImages[i]=new File("C:\\Users\\thana\\Desktop\\CODING\\JAVA\\METHODOLOGIA_PROGRAMMATISMOU_E\\ImageAlbum\\"+code+"");;
            i++;
        }
        return FilteredImages;
    }

}
