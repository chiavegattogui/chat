package mchatclient;

import java.io.InputStream;
import java.util.Scanner;

class ClientHandler implements Runnable {

    private InputStream servidor;

    public ClientHandler(InputStream servidor) {
        this.servidor = servidor;
    }

    public void run() {
        try (Scanner s = new Scanner(this.servidor)) {
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
        }
    }
}
