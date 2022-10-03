package com.excercise.method;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUI {
    private JPanel DeleteImagePanel;
    private JTextField textField1;
    private JButton DELETEIMAGE_button;
    private JLabel ImageName_label;

    public DeleteUI() {
        DELETEIMAGE_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DeleteImage(textField1.getText());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public static void DeleteImageUI() throws SQLException {
        JFrame frame=new JFrame("Delete Image");
        frame.setContentPane(new DeleteUI().DeleteImagePanel);
        frame.pack();
        frame.setVisible(true);
        final DefaultListModel<String> l1 = new DefaultListModel<>();
    }

    public static void DeleteImage(String NameOfImageToDelete) throws SQLException {
        PreparedStatement st =ConnectToDatabase.DbConnection.prepareStatement("DELETE FROM SavedImages WHERE ImageName='"+NameOfImageToDelete+"';");
        st.execute();
        File ImageFile=new File("C:\\Users\\thana\\Desktop\\CODING\\JAVA\\METHODOLOGIA_PROGRAMMATISMOU_E\\ImageAlbum\\"+NameOfImageToDelete);
        ImageFile.delete();
        System.out.println("DONE");
    }

}
