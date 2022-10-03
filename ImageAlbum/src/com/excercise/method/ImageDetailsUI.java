package com.excercise.method;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageDetailsUI {
    private JPanel ImageDetailsPanel;
    private JTextField ImageName_textField;
    private JTextField Description_textField;
    private JButton SaveImageDetails_Button;
    private JTextField Coordinates_textField;
    private JTextField Date_textField;
    private JTextField Time_textField;
    private JTextField People_textField;
    private JTextField Place_textField;
    private JButton ShowDetails_Button;

    public  ImageDetailsUI(){

        SaveImageDetails_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query="Update SavedImages set Description = '"+Description_textField.getText()+"' ,Coordinates = '"+Coordinates_textField.getText()+"' ,DateCreated = '"+ Date_textField.getText() +"' ,Time = '"+Time_textField.getText()+"' ,People = '"+People_textField.getText()+"' ,Place = '"+Place_textField.getText()+"' where ImageName = '"+ImageName_textField.getText()+"';";
                try {
                    PreparedStatement PrepSt = ConnectToDatabase.DbConnection.prepareStatement(query);
                    PrepSt.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        ShowDetails_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement st1 =ConnectToDatabase.DbConnection.prepareStatement("SELECT * from SavedImages where ImageName = '"+ImageName_textField.getText()+"' ;");
                    ResultSet s1=st1.executeQuery();
                    while(s1.next()){
                        Description_textField.setText(s1.getString("Description"));
                        Coordinates_textField.setText(s1.getString("Coordinates"));
                        Date_textField.setText(s1.getString("DateCreated"));
                        Time_textField.setText(s1.getString("Time"));
                        People_textField.setText(s1.getString("People"));
                        Place_textField.setText(s1.getString("Place"));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public static void ImageDetailsUIPanel() throws SQLException {
        JFrame frame=new JFrame("ImageDetails");
        frame.setContentPane(new ImageDetailsUI().ImageDetailsPanel);
        frame.pack();
        frame.setVisible(true);
        final DefaultListModel<String> l1 = new DefaultListModel<>();
    }

}
