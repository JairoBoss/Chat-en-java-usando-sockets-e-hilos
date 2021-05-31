/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author megabit
 */
public class ThreadEscribir extends Thread {

    private QueueMensajes cola;
    private ArrayList<Cliente> usuarios;

    public ThreadEscribir(QueueMensajes cola, ArrayList<Cliente> usuarios) {
        this.cola = cola;
        this.usuarios = usuarios;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadEscribir.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!cola.isEmpty()) {
                try {
                    for (Cliente usuario : usuarios) {
                        ObjectOutputStream out = new ObjectOutputStream(usuario.getSocket().getOutputStream());
                        out.writeObject(cola.getMensaje());
                        out.flush();
                    }
                    cola.popCola();
                } catch (Exception e) {
                }
            }
        }
    }

    public QueueMensajes getCola() {
        return cola;
    }

    public void setCola(QueueMensajes cola) {
        this.cola = cola;
    }

    public ArrayList<Cliente> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Cliente> usuarios) {
        this.usuarios = usuarios;
    }

}
