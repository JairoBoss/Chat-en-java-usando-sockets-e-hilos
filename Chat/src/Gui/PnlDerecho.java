/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author megabit
 */
public class PnlDerecho extends JPanel {

    private JLabel lblUser;
    private JLabel lblUsuario;
    private JLabel lblImg;
    private ImageIcon imageIcon;
    private JPanel pnl;

    public PnlDerecho(ImageIcon x, String usuario, String usuarios) {
//        200 240

        pnl = new JPanel();
        pnl.setSize(200, 240);

        imageIcon = x;
        lblImg = new JLabel();
        lblImg.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        lblImg.setBounds(675, 20, 50, 50);
        lblUser = new JLabel("User: "+usuario);
        lblUser.setBounds(635, 95, 100, 100);
        //lblUsuario = new JLabel("Estas charlando con:");
        
        //lblUsuario.setBounds(900, 900, 100, 100);
        this.add(lblImg);
        this.add(lblUser);
        //this.add(lblUsuario);
        GridLayout gridLayout = new GridLayout(2, 1);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        this.setLayout(gridLayout);

        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        

    }

}
