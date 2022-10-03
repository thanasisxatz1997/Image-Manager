package com.excercise.method;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class BasicUI {
    private Connection CurConnection;
    private JPanel ImageWonder;
    private JButton ImageOpen_button;
    private JButton ImageDelete_button;
    private JButton ImageDetails_button;
    private JButton ImageActions_button;
    private Component parent;
    private JLabel[] ImageLabels = new JLabel[400];
    private JLabel Label2;
    private File ImageDetailsFile;
    private JPanel ImagePanel;
    private JScrollPane ImageScrollPane;
    private JButton CREATEALBUMButton;
    private JButton AddToAlbum_Button;
    private JButton DELETEALBUMButton;
    private JButton Filters_button;
    private JButton ClearFilters_button;
    private JButton GetMetadata_button;
    private JButton REFRESHButton;
    private int ImageShowCounter=0;
    private File ApplicationDir;
    private File[] SavedImages;
    private int SavedImagesCount;
    private static JPanel FilteredImagePanel = new JPanel();
    private static JLabel[] FilteredImageLabels = new JLabel[400];
    private static int FilteredImageCount;

    public BasicUI() {
        CurConnection=ConnectToDatabase.DbConnection;
        try {
            System.out.println(ApplicationDir=GetAppPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        SavedImages=ImageShow.ReturnAllSavedImagesOfDir(ApplicationDir);
        ImagePanel.setLayout(new GridLayout(3,3));
        SavedImagesCount=ImageShow.CountImagesOfDir(ApplicationDir);
        int i=0;
        Border BlackLine = BorderFactory.createLineBorder(Color.black);
        for (i=0;i<SavedImagesCount;i++){
            ImageLabels[ImageShowCounter]=new JLabel("");
            ImageLabels[ImageShowCounter].setBorder(BlackLine);
            ImageLabels[ImageShowCounter].setMinimumSize(new Dimension(300,200));
            ImageLabels[ImageShowCounter].setPreferredSize(new Dimension(300,200));
            ImageLabels[ImageShowCounter].setMaximumSize(new Dimension(300,200));
            ImageLabels[ImageShowCounter].setIcon(ImageChange.ScaleImage(SavedImages[i]));
            File ImageTempName=SavedImages[i];
            ImageLabels[ImageShowCounter].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    ImageExtend.ImageExtendPanel(ImageTempName);
                    System.out.println(ImageTempName);
                }
            });
            ImagePanel.add(ImageLabels[ImageShowCounter]);
            ImageShowCounter++;
        }


        ImageOpen_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageLabels[ImageShowCounter]=new JLabel("");
                ImageLabels[ImageShowCounter].setBorder(BlackLine);
                ImageLabels[ImageShowCounter].setMinimumSize(new Dimension(300,200));
                ImageLabels[ImageShowCounter].setPreferredSize(new Dimension(300,200));
                ImageLabels[ImageShowCounter].setMaximumSize(new Dimension(300,200));
                String[] SpFileString =new String[2];
                String PicToOpenPath;
                String PicToOpenName;
                try {
                    SpFileString=ImageChooser.BrowseImage();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                PicToOpenPath=SpFileString[0];
                PicToOpenName=SpFileString[1];
                try {
                    if(CheckIfImageExists.CheckIfImageAlreadyExists(PicToOpenName)==false){
                        ImageDetailsFile=new File(PicToOpenPath);
                        ImageLabels[ImageShowCounter].setIcon(ImageChange.ScaleImage(new File(PicToOpenPath)));
                        SaveImage.SaveImageToAppDir(PicToOpenPath, PicToOpenName);
                        ImagePanel.add(ImageLabels[ImageShowCounter]);
                        ImageShowCounter++;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"IMAGE ALREADY EXISTS");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        ImageDetails_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ImageDetailsUI.ImageDetailsUIPanel();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                //try {
                   // System.out.println(ImageDetailsFile.getPath());
                   // GetImageMetadata.metadataExample(ImageDetailsFile);
                //} catch (ImageReadException imageReadException) {
                   // imageReadException.printStackTrace();
                //} catch (IOException ioException) {
                    //ioException.printStackTrace();
                //}
            }
        });

        AddToAlbum_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddImageToAlbum.AddToAlbumPanel();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        CREATEALBUMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CreateImageAlbum.CreateImageAlbumWindow();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        DELETEALBUMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteImageAlbum.DeleteImageAlbumWindow();
            }
        });
        ImageActions_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionsWindow.ActionsWindowPanel();
            }
        });

        Filters_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FiltersUI.FiltersPanel();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        GetMetadata_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MetaDataUI.FiltersPanel();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        ClearFilters_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i;
                for (i=0;i<FilteredImageCount;i++){
                    ImagePanel.remove(FilteredImageLabels[i]);
                }
                for(i=0;i<SavedImagesCount;i++){
                    ImagePanel.add(ImageLabels[i]);
                }
                ImagePanel.revalidate();
                ImagePanel.repaint();
            }
        });
        REFRESHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i;
                for(i=0;i<SavedImagesCount;i++){
                    ImagePanel.remove(ImageLabels[i]);
                }
                for (i=0;i<FilteredImageCount;i++){
                    ImagePanel.add(FilteredImageLabels[i]);
                }
                ImagePanel.revalidate();
                ImagePanel.repaint();
            }
        });
        ImageDelete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DeleteUI.DeleteImageUI();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame=new JFrame("ImageWonder");
        frame.setContentPane(new BasicUI().ImageWonder);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        }

        public static File GetAppPath() throws IOException {
        File Path = new File(new File(".").getCanonicalPath());
        return Path;
        }

        public static JPanel FilterChange(String Album,String People, String Place) throws SQLException {
            int FilteredImagePanelRows = 2;
            int FilteredImagePanelCols = 0;
            int ImageCount=Images.CountSavedFilteredImages(Album,People,Place);
            FilteredImageCount=ImageCount;
            System.out.println("Saved Filtered Images are:"+ImageCount);
            FilteredImagePanelCols=ImageCount;
            FilteredImagePanel.setLayout(new GridLayout(FilteredImagePanelRows,FilteredImagePanelCols));
            File[] FilteredImagesArray=new File[ImageCount];
            FilteredImagesArray=Images.ReturnSavedFilteredImages(Album,People,Place,ImageCount);
            int i;
            int FilteredImageShowCounter=0;
            Border BlackLine = BorderFactory.createLineBorder(Color.black);
            for (i=0;i<ImageCount;i++){
                FilteredImageLabels[FilteredImageShowCounter]=new JLabel("");
                FilteredImageLabels[FilteredImageShowCounter].setBorder(BlackLine);
                FilteredImageLabels[FilteredImageShowCounter].setMinimumSize(new Dimension(300,200));
                FilteredImageLabels[FilteredImageShowCounter].setPreferredSize(new Dimension(300,200));
                FilteredImageLabels[FilteredImageShowCounter].setMaximumSize(new Dimension(300,200));
                FilteredImageLabels[FilteredImageShowCounter].setIcon(ImageChange.ScaleImage(FilteredImagesArray[i]));
                File ImageTempName=FilteredImagesArray[i];
                FilteredImageLabels[FilteredImageShowCounter].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        ImageExtend.ImageExtendPanel(ImageTempName);
                        System.out.println(ImageTempName);
                    }
                });
                FilteredImagePanel.add(FilteredImageLabels[FilteredImageShowCounter]);
                FilteredImageShowCounter++;
            }
            return FilteredImagePanel;
        }
}
