
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ClientHolder  implements Runnable
{
    public Socket cSock;
    public Scanner dl;
    public PrintWriter ul;
    public String nick = "";
    
    public ClientHolder(Socket cSock)  throws Exception
    {
        this.cSock = cSock;
        dl = new Scanner(cSock.getInputStream(), "UTF-8");
        ul = new PrintWriter(cSock.getOutputStream(), true);
        System.out.println("Nick Bekleniyor");
        nick = dl.nextLine();
        System.out.println("Client Nick : "+nick);
        new Thread(this).start();
    }
    
    public void run()
    {
        while (true)
        {
            String gelen = listen();
            for (ClientHolder ch : Server.cL)
                ch.say(nick+" : "+gelen);
        }
    }
    
    public String listen()
    {
        return dl.nextLine();
    }
    
    public void say(String msg)
    {
        ul.println(msg);
    }
    
    
}
