
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

    Scanner dl, oku = new Scanner(System.in);
    PrintWriter ul;

    public Client() throws Exception {
        Socket cSock = new Socket("localhost", 6666);
        dl = new Scanner(cSock.getInputStream(), "UTF-8");
        ul = new PrintWriter(cSock.getOutputStream(), true);

        new Thread(this).start();

        while (true) {
            String giden = oku.nextLine();
            ul.println(giden);
        }
    }

    public void run() {
        while (true) {
            String gelen = dl.nextLine(); 
            System.out.println(gelen);
        }
    }

    public static void main(String[] args) throws Exception {
        new Client();
    }
}
