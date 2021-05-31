/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author megabit
 */
public class Cliente extends Thread{
    
    private String nombre;
    private Socket socket;
    private QueueMensajes cola;
    private ArrayList<Cliente> usuarios;

    public Cliente(String nombre, Socket socket, QueueMensajes cola) {
        this.nombre = nombre;
        this.socket = socket;
        this.cola = cola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
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

    @Override
    public void run() {
        System.out.println(nombre+" ah iniciado");
        Listener listen = new Listener(this.socket, this.nombre, this.cola);
        listen.start();
    }
    
    
    
}
