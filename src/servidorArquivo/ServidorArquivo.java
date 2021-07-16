package servidorArquivo;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServidorArquivo {

    public static void escutarServerPrincipal() {

        String dadosRecebidos[];//0 nome do arquivo, 1 porta
        try {
            MulticastSocket mcs = new MulticastSocket(6000);
            InetAddress grp = InetAddress.getByName("239.0.0.1");
            mcs.joinGroup(grp);
            byte rec[] = new byte[256];
            DatagramPacket pkg = new DatagramPacket(rec, rec.length);
            while (true) {
                // recebendo os dados enviados via multicast
                mcs.receive(pkg);
                dadosRecebidos = new String(pkg.getData(), 0, pkg.getLength()).split(";");
                new Thread(new pesquisarNaBase(dadosRecebidos[0], pkg.getAddress(), Integer.parseInt(dadosRecebidos[1]))).start();
            }
        } catch (Exception e) {
            System.out.println("Erro : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Servidor arquivo operante");
        new Thread(new SolicitacaoArquivo()).start();
        escutarServerPrincipal();
    }
}
