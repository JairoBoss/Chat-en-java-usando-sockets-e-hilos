/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.TextArea;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;
import javax.swing.JPanel;

/**
 *
 * @author megabit
 */
public class Mensajes extends Thread implements Serializable{
    private TextArea textArea;
    private Socket socket;
    private JPanel jPanel;

    public Mensajes(Socket socket) {
        this.socket = socket;
        textArea = new TextArea();
        textArea.setSize(190,390);
        textArea.setEditable(false);
        textArea.setText("Welcome");        
        jPanel = new JPanel();
        jPanel.add(textArea);
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    @Override
    public void run() {
        while (true) {            
            try {
                System.out.println("Entro");                
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                String x = (String) in.readObject();
                //System.out.println("Me enviaron : " + x);
                actualizar(x);
                textArea.repaint();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("GG");
            }
        }
    }
    
    
    
    public void actualizar(String x){
        String a = textArea.getText();
        textArea.setText(a +"\n"+x );                
    }
    
    
    
}
