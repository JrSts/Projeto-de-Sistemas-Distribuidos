package servidorPrincipal;


import java.io.IOException;
import java.net.ServerSocket;

public class ServidorPrincipal {
    
	public static void atendeSolicitacoesCliente() {
		try {
			ServerSocket conexao = new ServerSocket(6789);
			int porta = 8000;
			while (true) {
				new Thread(new Acao(conexao.accept(),porta==8900?porta=8000:porta++)).start();
				System.out.println("houve solicitacao!");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
        
	public static void main (String [] args){
		System.out.println("Servidor operante");
		atendeSolicitacoesCliente();
	}	
}