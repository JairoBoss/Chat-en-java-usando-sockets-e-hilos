/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Gui.PrincipalFrame;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author megabit
 */
public class MainFrame extends JFrame {

    private Login login;
    private Botones botnes;

    public MainFrame() {

        super("Login");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(410, 473);

        login = new Login();
        botnes = new Botones();
        botnes.setListener(new BotonesListener() {
            @Override
            public void loginButtonClick() {
                new PrincipalFrame(login.getUser(), login.getIcono());
                //MainFrame.this.setVisible(false);
                MainFrame.this.setVisible(Boolean.FALSE);
            }

            @Override
            public void cancelarButtonClick() {
                System.exit(0);
            }
        });

        super.add(login, BorderLayout.CENTER);
        super.add(botnes, BorderLayout.SOUTH);
        super.setVisible(true);

    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
