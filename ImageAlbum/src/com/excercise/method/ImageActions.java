package com.excercise.method;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class ImageActions {
    public static ImageIcon ImageRotate(String[] ActionArray, int ArraySize, ImageIcon ImageIconToBeRotated){
        BufferedImage Image = new BufferedImage(ImageIconToBeRotated.getIconWidth(),ImageIconToBeRotated.getIconHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics g= Image.createGraphics();
        ImageIconToBeRotated.paintIcon(null,g,0,0);
        g.dispose();
        double RotationDegrees = Math.toRadians(Integer.parseInt(ActionArray[1]));
        double LocationX=Image.getWidth()/2;
        double LocationY=Image.getHeight()/2;
        AffineTransform tx= AffineTransform.getRotateInstance(RotationDegrees,LocationX,LocationY);
        AffineTransformOp op= new AffineTransformOp(tx,AffineTransformOp.TYPE_BILINEAR);
        BufferedImage RotatedImage=op.filter(Image,null);
        ImageIcon RotatedImageIcon=new ImageIcon(RotatedImage);
        return RotatedImageIcon;
    }
}
