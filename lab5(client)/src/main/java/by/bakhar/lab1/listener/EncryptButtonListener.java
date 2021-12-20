package by.bakhar.lab1.listener;


import by.bakhar.lab1.swing.CustomFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class EncryptButtonListener implements ActionListener {
    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private Socket clientSocket;
    private InputStream in;
    private OutputStream out;

    {
        try {
            clientSocket = new Socket(HOST, PORT);
            in = clientSocket.getInputStream();
            out = clientSocket.getOutputStream();

        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    private final CustomFrame frame;

    public EncryptButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DataInputStream sin = new DataInputStream(in);
        DataOutputStream sout = new DataOutputStream(out);
        StringBuilder encryptedText = new StringBuilder();
        while (true) {
            try {
                String text = frame.getText();
                sout.writeUTF(text);
                sout.flush();
                encryptedText.append(sin.readUTF());
                break;
            } catch (IOException encryptException) {
                JOptionPane.showMessageDialog(null, encryptException.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }

        frame.setTextChanged(true);
        frame.setText(encryptedText.toString());
        String message = "Text was encrypted";
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.PLAIN_MESSAGE);

    }
}
