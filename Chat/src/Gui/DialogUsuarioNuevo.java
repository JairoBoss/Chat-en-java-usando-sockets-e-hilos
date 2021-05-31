/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author megabit
 */
public class DialogUsuarioNuevo extends JDialog {

    private JLabel lblImage;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private ImageIcon imageIcon;
    private JPanel panel;
    private JButton btnAceptar;
    private ActionListenerDialogNuevoUsuario listener;

    public void setListener(ActionListenerDialogNuevoUsuario listener) {
        this.listener = listener;
    }

    public DialogUsuarioNuevo(JFrame parent) {

        super(parent, true);
        super.setTitle("Login");
        super.setSize(340, 200);
        panel = new JPanel();
        panel.setSize(340, 200);

        imageIcon = new ImageIcon("src/Imagenes/Login.png");
        lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        lblImage.setBounds(190, 40, 60, 60);

        lblNombre = new JLabel("Ingresa tu nombre");
        lblNombre.setBounds(20, 10, 200, 100);

        txtNombre = new JTextField(15);
        txtNombre.setBounds(20, 80, 100, 30);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(190, 110, 100, 20);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                
                DialogUsuarioNuevo.this.setVisible(false);
            }   
        });

        panel.setLayout(null);
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblImage);
        panel.add(btnAceptar);

        this.add(panel);

    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    
}
