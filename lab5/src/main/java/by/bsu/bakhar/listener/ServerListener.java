package by.bsu.bakhar.listener;

import by.bsu.bakhar.exception.EncryptException;
import by.bsu.bakhar.service.EncryptService;
import by.bsu.bakhar.service.impl.EncryptServiceImpl;

import java.io.*;
import java.net.Socket;


public class ServerListener extends Thread {
    private final Socket socket;
    private final InputStream in;
    private final OutputStream out;

    public ServerListener(Socket socket) throws IOException {
        this.socket = socket;
        in = socket.getInputStream();
        out = socket.getOutputStream();
        start();
    }

    @Override
    public void run() {
        try {
            DataInputStream sin = new DataInputStream(in);
            DataOutputStream sout = new DataOutputStream(out);
            while (true) {
                EncryptService service = new EncryptServiceImpl();
                String text = sin.readUTF();
                String encrypted = service.encrypt(text);
                sout.writeUTF(encrypted);
                sout.flush();
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (EncryptException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
