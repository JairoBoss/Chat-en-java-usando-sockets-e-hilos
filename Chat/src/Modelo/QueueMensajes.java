/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author megabit
 */
public class QueueMensajes {

    public Queue<String> mensajes;

    public QueueMensajes() {
        this.mensajes = new LinkedList();
    }

    public String getMensaje() {
        if (!this.mensajes.isEmpty()) {
            return this.mensajes.peek();
        } else {
            return "";
        }
    }

    public void addMensaje(String mensaje) {
        this.mensajes.add(mensaje);
    }

    public boolean isEmpty() {
        return mensajes.isEmpty();
    }

    public void popCola() {
        mensajes.poll();
    }

}
