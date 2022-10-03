package com.excercise.method;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class ImageShow {

    public static void DisplayImage(){
    }

    public static File[] ReturnAllSavedImagesOfDir(File directory){
        File[] ImagesArray =new File[CountImagesOfDir(directory)];
        File[] f= directory.listFiles();
        int i=0;
        for(File file : f){
            if(file !=null && file.getName().toLowerCase().endsWith(".jpg") ){
                ImagesArray[i]= new File(file.getName());
                System.out.println(ImagesArray[i]);
                i++;
            }
        }
        return ImagesArray;
    }

    public static int CountImagesOfDir(File directory){
        int count=0;
        File[] f= directory.listFiles();
        for(File file : f){
            if(file !=null && file.getName().toLowerCase().endsWith(".jpg") ){
                count++;
            }
        }
        return count;
    }
}
