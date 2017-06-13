package mchat;

import dto.Client;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomChat {
    
    private int porta;
    private List<Client> clientes;
    
    public RoomChat(int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<>();
    }
    
    public void executa() throws IOException {
        try (ServerSocket servidor = new ServerSocket(this.porta)) {
            System.out.println("mCHAT");
            System.out.println("Porta " + this.porta + " aberta!");
            
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Nova conexão com o cliente "
                        + cliente.getInetAddress().getHostAddress());
                
                String nickName = (new Scanner(cliente.getInputStream()).nextLine());
                
              
                try {
                    Client c = new Client(cliente, nickName);
                    this.clientes.add(c);
                    
                    this.distribuiMensagem(c, "Entrei na sala!");
                      
                    ClientManager tc = new ClientManager(c, this);
                    new Thread(tc).start();
                } catch (Exception ex) {
                    System.err.print(ex.getMessage());
                }
            }
        }
    }
    
    public void distribuiMensagem(Client clienteQueEnviou, String msg) {
        for (Client cliente : this.clientes) {
            if (!cliente.equals(clienteQueEnviou)) {
                try {
                    PrintStream ps = new PrintStream(cliente.getSocket().getOutputStream());
                    ps.println(clienteQueEnviou.getNickName() + ": " + msg);
                    ps.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
