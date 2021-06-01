/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author megabit
 */
public class PnlEnviar extends JPanel{
    private JTextField txtTexto;
    private JButton btnSend;
    private EnviarActionListener listener;

    public void setListener(EnviarActionListener listener) {
        this.listener = listener;
    }
    
    
    public PnlEnviar(){
        txtTexto = new JTextField(20);
        btnSend = new JButton("Enviar");
        
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.enviarButtonClick();
            }
        });
        
        this.add(txtTexto);
        this.add(btnSend);
    }
    
    public void clean(){
        this.txtTexto.setText("");
    }

    public JTextField getTxtTexto() {
        return txtTexto;
    }

    public void setTxtTexto(JTextField txtTexto) {
        this.txtTexto = txtTexto;
    }

    public JButton getBtnSend() {
        return btnSend;
    }

    public void setBtnSend(JButton btnSend) {
        this.btnSend = btnSend;
    }
    
    
    
    public String getMensaje(){
        return txtTexto.getText();
    }
}
