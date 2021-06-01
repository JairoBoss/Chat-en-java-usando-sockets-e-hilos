/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 *
 * @author megabit
 */
public class Login extends JPanel {
    private JTextField txtUser;
    private JLabel lblUser;
    private JPasswordField txtContraseña;
    private JLabel lblUContraseña;
    private JLabel lblImg;
    private ImageIcon imageIcon;

    public Login(){
        txtUser = new JTextField(15);
        lblUser = new JLabel("Usuario");

        

        imageIcon = null;
        seleccionarImagen();
        lblImg = new JLabel();
        lblImg.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH)));
        //lblImg.setBounds(10,80,200,200);

        /*GridLayout gridLayout = new GridLayout(1,1);
        gridLayout.setHgap(10);
        gridLayout.setVgap(40);
        this.setLayout(gridLayout);*/

        this.setBorder(new EmptyBorder(30,100,20,100));


        this.add(lblImg);
        this.add(lblUser);
        this.add(txtUser, BorderLayout.WEST);

    }
    
    public void seleccionarImagen(){
        int numero = (int) (Math.random() * 5) + 1;
        switch (numero) {
            case 1:
                imageIcon = new ImageIcon("src/Imagenes/Login.png");
                break;
            case 2:
                imageIcon = new ImageIcon("src/Imagenes/2.png");
                break;
            case 3:
                imageIcon = new ImageIcon("src/Imagenes/3.png");
                break;
            case 4:
                imageIcon = new ImageIcon("src/Imagenes/4.png");
                break;
            case 5:
                imageIcon = new ImageIcon("src/Imagenes/5.png");
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public String getUser(){
        return txtUser.getText();
    }
    
    public ImageIcon getIcono(){
        System.out.println("xd");
        return this.imageIcon;
    }
}

