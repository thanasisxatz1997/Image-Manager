package com.excercise.method;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteImageAlbum {
    private JPanel DeleteAlbumPanel;
    private JButton deleteAlbumButton;
    private JTextField DeleteAlbumName_textField;

    public DeleteImageAlbum(){

        deleteAlbumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(DeleteAlbumName_textField.getText()!="")
                {
                    try {
                        DeleteAlbum(DeleteAlbumName_textField.getText());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                JOptionPane.showMessageDialog(null,"Album Deleted!");
            }
        });
    }

    public static void DeleteImageAlbumWindow(){
        JFrame frame=new JFrame("DeleteImageAlbum");
        frame.setContentPane(new DeleteImageAlbum().DeleteAlbumPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void DeleteAlbum(String NameOfAlbumToDelete) throws SQLException {
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("DELETE FROM SavedAlbums WHERE AlbumName='"+NameOfAlbumToDelete+"';");
        st.execute();
        System.out.println("DONE");
    }
}
