package com.excercise.method;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageChange {
    public static ImageIcon ScaleImage(File PathToImage){
        ImageIcon ScaledIcon;
        ImageIcon NewImageIcon = new ImageIcon(String.valueOf(PathToImage));
        Image scaleImage = NewImageIcon.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ScaledIcon = new ImageIcon(scaleImage);
        return ScaledIcon;
    }

    public static ImageIcon ScaleImageForDisplay(File PathToImage){
        ImageIcon ScaledIcon;
        ImageIcon NewImageIcon = new ImageIcon(String.valueOf(PathToImage));
        Image scaleImage = NewImageIcon.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        ScaledIcon = new ImageIcon(scaleImage);
        return ScaledIcon;
    }

    public static ImageIcon ScaleImageToDim(String PathToImage,int Width,int Height){
        ImageIcon ScaledIcon;
        ImageIcon NewImageIcon = new ImageIcon(String.valueOf(PathToImage));
        Image scaleImage = NewImageIcon.getImage().getScaledInstance(Width, Height, Image.SCALE_DEFAULT);
        ScaledIcon = new ImageIcon(scaleImage);
        return ScaledIcon;
    }
}
