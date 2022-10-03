package com.excercise.method;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;

public class AddImageToAlbum {
    private JPanel AddToAlbum;
    private JComboBox comboBox1;
    private JButton addButton;
    private JLabel AddToAlbum_label;
    private JTextField ImageName_textField;
    private JLabel ImageName_label;
    private Connection DbConnection;
    private int SavedAlbumsCount=Albums.CountSavedAlbums(ConnectToDatabase.DbConnection);
    private String[] AlbumArray=new String[SavedAlbumsCount];
    private JList AlbumsListP;

    public AddImageToAlbum() throws SQLException {
        AlbumArray=Albums.CreateAlbumArray();
        int i=0;
        for(i=0;i<SavedAlbumsCount;i++)
        {
            System.out.println(AlbumArray[i]);
            comboBox1.addItem(AlbumArray[i]);
        }
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ImageNameToAdd=ImageName_textField.getText();
                String AlbumName= (String) comboBox1.getSelectedItem();
                System.out.println(comboBox1.getSelectedItem());
                try {
                    Images.AddImageToAlbum(ImageNameToAdd,AlbumName);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }


    public static void AddToAlbumPanel() throws SQLException {
        JFrame frame=new JFrame("aaa");
        frame.setContentPane(new AddImageToAlbum().AddToAlbum);
        frame.pack();
        frame.setVisible(true);
        final DefaultListModel<String> l1 = new DefaultListModel<>();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JFrame frame=new JFrame("AddToAlbum");
        frame.setContentPane(new AddImageToAlbum().AddToAlbum);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
