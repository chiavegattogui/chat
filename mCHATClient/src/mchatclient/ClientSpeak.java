package mchatclient;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSpeak {

    private String host;
    private int porta;

    public ClientSpeak(String host, int porta) {
        this.host = host;
        this.porta = porta;
    }

    public void executa() throws UnknownHostException, IOException {
        try (Socket cliente = new Socket(this.host, this.porta);
                Scanner teclado = new Scanner(System.in);
                PrintStream saida = new PrintStream(cliente.getOutputStream())) {
            System.out.println("O cliente se conectou ao servidor!");

            System.out.print("Digite seu nickName: ");
            saida.println(teclado.nextLine());
            saida.flush();

            System.out.println("Bem vindo!");

            ClientHandler r = new ClientHandler(cliente.getInputStream());
            new Thread(r).start();

            while (teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
                saida.flush();
            }
        }
    }
}
