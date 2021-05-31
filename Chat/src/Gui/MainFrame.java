/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.BorderLayout;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JFrame;

/**
 *
 * @author megabit
 */
public class MainFrame extends JFrame {

    private DialogUsuarioNuevo inicio;
    private Socket socket;
    private Mensajes mensajes;
    private ObjectOutputStream out;
    private PnlEnviar enviar;

    public MainFrame() {
        super("Chat");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(500, 500);
        super.setLocationRelativeTo(null);

        inicio = new DialogUsuarioNuevo(this);
        inicio.setVisible(true);
        enviar = new PnlEnviar();

        while (true) {
            try {
                socket = new Socket("127.0.0.1", 6125);
                System.out.println("ACEPTADO");
                mensajes = new Mensajes(socket);
                mensajes.start();

                out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(inicio.getNombre());                
                this.add(mensajes.getjPanel(), BorderLayout.NORTH);                
                break;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        enviar = new PnlEnviar();
        enviar.setListener(new EnviarActionListener() {
            @Override
            public void enviarButtonClick() {
                try {
                    out = new ObjectOutputStream(socket.getOutputStream());
                    //System.out.println(enviar.getMensaje());
                    //out.reset();
                    out.writeObject(enviar.getMensaje());
                    enviar.clean();

                } catch (Exception e) {
                }
            }
        });

        super.add(enviar, BorderLayout.SOUTH);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}
