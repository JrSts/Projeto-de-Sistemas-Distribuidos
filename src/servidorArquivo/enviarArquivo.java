package servidorArquivo;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class enviarArquivo implements Runnable {

    Socket socket;

    public enviarArquivo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader leitor;
        try {
            leitor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            File myFile = new File(leitor.readLine());
            byte[] mybytearray = new byte[(int) myFile.length()];
            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read(mybytearray, 0, mybytearray.length);
            OutputStream os = socket.getOutputStream();
            os.write(mybytearray);
            os.flush();
            socket.close();
            bis.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
