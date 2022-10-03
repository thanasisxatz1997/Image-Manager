package com.excercise.method;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CreateImageAlbum {
    private Connection CurConnection=ConnectToDatabase.DbConnection;
    private JPanel CreateAlbum;
    private JTextField NewAlbumName_textField;
    private JButton CreateAlbum_button;
    private JLabel CreateAlbumName_label;
    private JTextPane textPane1;
    private int SavedAlbumsCount=Albums.CountSavedAlbums(ConnectToDatabase.DbConnection);
    private String[] SavedAlbumsAr =new String[SavedAlbumsCount];
    private String AlbumDescription;

    public CreateImageAlbum() throws SQLException {
        CreateAlbum_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(NewAlbumName_textField.getText()!="")
                {
                    try {
                        CreateNewAlbum(NewAlbumName_textField.getText(),textPane1.getText());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
    }

    public static void CreateImageAlbumWindow() throws SQLException {
        JFrame frame=new JFrame("CreateImageAlbum");
        frame.setContentPane(new CreateImageAlbum().CreateAlbum);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        JFrame frame=new JFrame("CreateImageAlbum");
        frame.setContentPane(new CreateImageAlbum().CreateAlbum);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void CreateNewAlbum(String AlbumName,String AlbumDescription) throws SQLException {
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("INSERT INTO SavedAlbums(AlbumID,AlbumName,AlbumDescription) VALUES ("+Albums.FindNewAlbumID()+",'"+AlbumName+"','"+AlbumDescription+"');");
        st.execute();
        Statement st2 =ConnectToDatabase.DbConnection.createStatement();
        st2.executeUpdate("CREATE TABLE "+AlbumName+" ("
                + "ImageID INT ,"
                + "ImageName VARCHAR(45))");
        System.out.println("DONE");
    }
}
