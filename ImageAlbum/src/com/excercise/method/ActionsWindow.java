package com.excercise.method;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionsWindow {

    private JPanel ActionsWindowPanel;
    private JTextField ImageName_textField;
    private JButton Open_Button;
    private JTextField Action_textField;
    private JButton Perform_Button;
    private JLabel ImageName_Label;
    private JLabel WriteAction_Label;
    private JLabel ImageLoaded_Label;

    public ActionsWindow() {
        Open_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ImageName= ImageName_textField.getText();
                String ImagePath="C:\\Users\\thana\\Desktop\\CODING\\JAVA\\METHODOLOGIA_PROGRAMMATISMOU_E\\ImageAlbum\\"+ImageName+".JPG";
                ImageLoaded_Label.setIcon(ImageChange.ScaleImageToDim(ImagePath,800,600));
            }
        });
        Perform_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String StrRotate="Rotate";
                String StrCrop="Crop";
                String StrMirror="Mirror";
                int ArraySize=0;
                String ActionWritten=Action_textField.getText();
                String[] ActionWrittenArray = ActionWritten.split("_",10);
                for (String a:ActionWrittenArray)
                {
                    System.out.println(a);
                    ArraySize++;
                }
                if (ActionWrittenArray[0].equals(StrRotate))
                {
                    System.out.println("HERE");
                    ImageIcon RotatedImageIcon=ImageActions.ImageRotate(ActionWrittenArray,ArraySize, (ImageIcon) ImageLoaded_Label.getIcon());
                    ImageLoaded_Label.setIcon(RotatedImageIcon);
                    System.out.println("Done");
                }
            }
        });
    }

    public static void ActionsWindowPanel(){
        JFrame frame=new JFrame("Image Actions");
        frame.setContentPane(new ActionsWindow().ActionsWindowPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame=new JFrame("Image Actions");
        frame.setContentPane(new ActionsWindow().ActionsWindowPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
