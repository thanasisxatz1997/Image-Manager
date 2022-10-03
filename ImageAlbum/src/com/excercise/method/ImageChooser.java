package com.excercise.method;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.sql.SQLException;

public class ImageChooser {
    static Component parent;
    public static String[] BrowseImage() throws SQLException {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(parent);
        String SpArray[] = new String[2];
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getPath());
            String PicToOpenPath;
            String PicToOpenName;
            PicToOpenPath = chooser.getSelectedFile().getPath();
            PicToOpenName = chooser.getSelectedFile().getName();
            SpArray[0]=PicToOpenPath;
            SpArray[1]=PicToOpenName;
            System.out.println(PicToOpenPath);
            Images.AddImageToSavedImages(PicToOpenName);
        }
        return SpArray;
    }
}
