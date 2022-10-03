package com.excercise.method;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FiltersUI {
    private JPanel FiltersPanel1;
    private JComboBox comboBox1;
    private JButton SAVE_Button;
    private JLabel AlbumChoose_label;
    private JLabel PlaceChoose_label;
    private JLabel PeopleChoose_label;
    private JTextField textField1;
    private JTextField textField2;
    private int SavedAlbumsCount=Albums.CountSavedAlbums(ConnectToDatabase.DbConnection);
    private String[] AlbumArray=new String[SavedAlbumsCount];

    public FiltersUI() throws SQLException {
        AlbumArray=Albums.CreateAlbumArray();
        int i=0;
        comboBox1.addItem("ALL");
        for(i=0;i<SavedAlbumsCount;i++)
        {
            System.out.println(AlbumArray[i]);
            comboBox1.addItem(AlbumArray[i]);
        }
        SAVE_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String FilteredAlbum=comboBox1.getSelectedItem().toString();
                String FilteredPlace=textField1.getText();
                String FilteredPeople=textField2.getText();
                try {
                    BasicUI.FilterChange(FilteredAlbum,FilteredPeople,FilteredPlace);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public static void FiltersPanel() throws SQLException {
        JFrame frame=new JFrame("FILTERS");
        frame.setContentPane(new FiltersUI().FiltersPanel1);
        frame.pack();
        frame.setVisible(true);
        final DefaultListModel<String> l1 = new DefaultListModel<>();
    }

}
