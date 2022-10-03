package com.excercise.method;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveImage {
    public static void SaveImageToAppDir(String SourceDirectoryFilePath,String SourceDirectoryFileName){
        String AppDirectoryPath="C:\\Users\\thana\\Desktop\\CODING\\JAVA\\METHODOLOGIA_PROGRAMMATISMOU_E\\ImageAlbum\\";
        String TargetDirectoryFullName=AppDirectoryPath+SourceDirectoryFileName;
        Path TargetDirectory = Paths.get(TargetDirectoryFullName);
        Path SourceDirectory = Paths.get(SourceDirectoryFilePath);
        try {
            Files.copy(SourceDirectory,TargetDirectory);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
