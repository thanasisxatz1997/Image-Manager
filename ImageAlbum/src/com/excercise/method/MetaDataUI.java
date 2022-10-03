package com.excercise.method;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.awt.Desktop;
import java.net.URI;

public class MetaDataUI {
    private JPanel MetadataPanel;
    private JTextField textField1;
    private JButton getDataButton;
    private JTextField Latitude_textField;
    private JTextField Longitude_textField;
    private JLabel ChoosePhoto_button;
    private JLabel Latitude_button;
    private JLabel Longitude_button;
    private JButton openInBrowserButton;

    public MetaDataUI(){

        getDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] CoordinatesTaken=new String[2];
                File ImageFile= new File("C:\\Users\\thana\\Desktop\\CODING\\JAVA\\METHODOLOGIA_PROGRAMMATISMOU_E\\ImageAlbum\\"+textField1.getText());
                /*try {
                    CoordinatesTaken=GetImageMetadata.metadataExample(ImageFile);
                } catch (ImageReadException imageReadException) {
                    imageReadException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                 */
                Latitude_textField.setText(CoordinatesTaken[0]);
                Longitude_textField.setText(CoordinatesTaken[1]);
            }
        });
        openInBrowserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String LatitudeSearch=new String(Latitude_textField.getText());
                String LongitudeSearch=new String(Longitude_textField.getText());
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/"+LatitudeSearch+"+"+LongitudeSearch+""));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (URISyntaxException uriSyntaxException) {
                        uriSyntaxException.printStackTrace();
                    }
                }
            }
        });
    }

    public static void FiltersPanel() throws SQLException {
        JFrame frame=new JFrame("Metadata");
        frame.setContentPane(new MetaDataUI().MetadataPanel);
        frame.pack();
        frame.setVisible(true);
        final DefaultListModel<String> l1 = new DefaultListModel<>();
    }
}
