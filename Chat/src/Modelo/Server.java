/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author megabit
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket server;
        QueueMensajes mensajes = new QueueMensajes();
        ArrayList<Cliente> usuarios = new ArrayList<>();
        ThreadEscribir escribir = new ThreadEscribir(mensajes, usuarios);

        escribir.start();

        try {
            server = new ServerSocket(6125);
            while (true) {
                Socket socket = server.accept();

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                String x = (String) in.readObject();
                while (true) {
                    try {
                        //System.out.println(x + "DENTRO");
                        Cliente usuario = new Cliente(x, socket, mensajes);
                        usuarios.add(usuario);
                        usuario.setUsuarios(usuarios);
                        usuario.start();
                        break;
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
