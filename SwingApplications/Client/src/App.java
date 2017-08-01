
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class App implements Runnable{
    Socket cSock;
    PrintWriter up;
    Scanner dl, oku = new Scanner(System.in);
    
    public App()
    {
        try {
            cSock = new Socket("localhost", 11111);
            up = new PrintWriter(cSock.getOutputStream(), true);
            dl = new Scanner(cSock.getInputStream(), "UTF-8");
            
            new Thread(this).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run()
    {
        while(true)
        {
            String cmd = oku.nextLine();
            up.println(cmd);
            String resp = dl.nextLine();
            System.out.println(resp);
        }
    }
    public static void main(String[] args) {
        new App();
    }
}
