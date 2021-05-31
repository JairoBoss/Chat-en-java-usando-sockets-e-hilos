/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author megabit
 */
public class Listener extends Thread{
    
    private Socket socket;
    private String usuario;
    private QueueMensajes cola;
    private ObjectInputStream in;

    public Listener(Socket socket, String usuario, QueueMensajes cola) {
        this.socket = socket;
        this.usuario = usuario;
        this.cola = cola;
        //in = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        System.out.println("ESCUCHANDO");
        while (true) {            
            try {
                in = new ObjectInputStream(socket.getInputStream());                                                
                String x = (String) in.readObject();
                System.out.println(usuario + ": " +x);
                cola.addMensaje(usuario + ": " +x);                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    
    
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public QueueMensajes getCola() {
        return cola;
    }

    public void setCola(QueueMensajes cola) {
        this.cola = cola;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }
    
    
    
    
}
