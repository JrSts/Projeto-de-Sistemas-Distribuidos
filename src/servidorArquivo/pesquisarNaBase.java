package servidorArquivo;


import java.io.DataOutputStream;
import java.io.File;
import java.net.InetAddress;
import java.net.Socket;

public class pesquisarNaBase implements Runnable {

    String nomeArquivo;
    InetAddress IPServer;
    int PORTA;

    public pesquisarNaBase(String nomeArquivo, InetAddress IPServer, int PORTA) {
        this.nomeArquivo = nomeArquivo;
        this.IPServer = IPServer;
        this.PORTA = PORTA;
    }

    @Override
    public void run() {
        if (existeNaBase(nomeArquivo)) {
            confirmarArquivoNaBase();
        }
    }

    public void confirmarArquivoNaBase() {
        try {
            Socket clientSocket = new Socket(IPServer, PORTA);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeBytes(InetAddress.getLocalHost().getHostAddress()+"#"+InetAddress.getLocalHost().getHostName()+ "\n");
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean existeNaBase(String nomeArquivo) {
        return new File(nomeArquivo).exists();
    }
}
