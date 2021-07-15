package servidorPrincipal;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Acao implements Runnable {
    Socket pacote;
    int porta;

    public Acao(Socket itemSurdo, int porta) {
        this.pacote = itemSurdo;
        this.porta = porta;
    }
    
    @Override
    public void run() {
        try {
            BufferedReader leitor = new BufferedReader(new InputStreamReader(
                    pacote.getInputStream()));
            String IPs = dispararMultCast(leitor.readLine());
            DataOutputStream dos = new DataOutputStream(
                    pacote.getOutputStream());
            dos.writeBytes(IPs + "\n");
            dos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static byte[] toByteArray(String value) {
        return value.getBytes();
    }

    public String dispararMultCast(String arquivo) {

        DatagramSocket ds = null;
        String ipRetorno = "";

        try {
            byte[] b = (arquivo + ";" + porta).getBytes();
            InetAddress addr = InetAddress.getByName("239.0.0.1");
            DatagramPacket pkg = new DatagramPacket(b, b.length, addr, 6000);
            ds = new DatagramSocket();
            // enviando pacote multicast
            ds.send(pkg);

            ServerSocket conexao = new ServerSocket(porta);
            String resposta = "";
            conexao.setSoTimeout(10000);

            while (true) {
                try {
                    Socket novaConexao = conexao.accept();
                    BufferedReader leitor = new BufferedReader(
                            new InputStreamReader(novaConexao.getInputStream()));
                    resposta = leitor.readLine();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }
                ipRetorno += resposta + ";";
            }
            ds.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ipRetorno;
    }
}
