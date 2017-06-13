package mchat;

import dto.Client;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class ClientManager implements Runnable {

    private Client cliente;
    private RoomChat servidor;

    public ClientManager(Client cliente, RoomChat servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    public void run() {
        try (Scanner s = new Scanner(this.cliente.getSocket().getInputStream())) {
            while (s.hasNextLine()) {
                servidor.distribuiMensagem(this.cliente, s.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
