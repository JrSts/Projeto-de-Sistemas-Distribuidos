package servidorArquivo;


import java.net.ServerSocket;
import java.net.Socket;

public class SolicitacaoArquivo implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket servsock = new ServerSocket(6001);
            while (true) {
                System.out.println("Esperando Solicitação de arquivo");
                Socket sock = servsock.accept();
                System.out.println("Arquivo solicitado");
                new Thread(new enviarArquivo(sock)).start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
