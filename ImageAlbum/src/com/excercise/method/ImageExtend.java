package com.excercise.method;

import javax.swing.*;
import java.io.File;
import java.nio.file.Path;
import java.sql.SQLException;

public class ImageExtend {
    private JPanel ImageExtendP1;
    private JLabel DisplayedImage_label;
    private static File PathToImageR;

    public ImageExtend(){
        DisplayedImage_label.setIcon(ImageChange.ScaleImageForDisplay(PathToImageR));
    }

    public static void ImageExtendPanel(File PathToImage){
        PathToImageR=PathToImage;
        JFrame frame=new JFrame("aaa");
        frame.setContentPane(new ImageExtend().ImageExtendP1);
        frame.pack();
        frame.setVisible(true);;
        PathToImageR=PathToImage;
        System.out.println("The pic path is"+PathToImageR);
    }

}
