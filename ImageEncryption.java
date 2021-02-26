import java.io.*;
import java.util.*;
import javax.swing.*;

import java.awt.*;

public class ImageEncryption {
    
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setTitle("Image processing");
        f.setSize(800,400);
        f.setLocationRelativeTo(null); //alligns image to centre;
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        Font font=new Font("Arial",Font.BOLD,25);
 
        // create buttons
        
        JButton button=new JButton();
        button.setText("Open");
        button.setFont(font);
 
          
        //textfield
        JTextField textField=new JTextField(10);
        textField.setFont(font);
        //textField.setBackground(Color.getHSBColor(5.0f, 1.0f, 1.0f));
 
        button.addActionListener(e->{
           String text= textField.getText();
           int tmp=Integer.parseInt(text);
           helper(tmp);
        });
 
 
        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);
       
 
         return;
     }

     
    public static void helper(int key){
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();

        //reading data
        try{
            
            FileInputStream fis=new FileInputStream(file);
            byte[] b=new byte[fis.available()];
            fis.read(b);
            int i=0;
            for(byte data:b)
            {
                System.out.println(data);
                //encrypting bytes
                b[i]=(byte) (data^key);
                i++;

            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(b);
            fos.close();
            fis.close();

            //message
            JOptionPane.showMessageDialog(null,"DONE");

        }catch(Exception e){
           e.printStackTrace(); //print on console 
        }
    }
}
