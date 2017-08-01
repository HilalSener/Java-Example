
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server 
{
    public static ArrayList<ClientHolder> cL = new ArrayList<>();
    public ServerSocket sSock;
    // Wifi ad : TuX pw : 123qweasd666
    // Server IP : 192.168.43.207
    public Server() throws Exception 
    {
        sSock = new ServerSocket(6666);
        
        new Thread()
        {
            public void run()
            {
                int cnt = 0;
                while (true)
                {
                    try {
                    System.out.println("Bağlantı Bekleniyor");
                    if(cnt < 3)
                    {
                        Socket cSock = sSock.accept();
                        System.out.println("Client Bağlandı");
                        ClientHolder ch = new ClientHolder(cSock);
                        cL.add(ch);
                        cnt++;
                    }
                    else
                        break;
                } catch (Exception e) { e.printStackTrace(); }
                }
            }
        }.start();
        
        
    }
    
    
    public static void main(String[] args) throws Exception
    {
        new Server();
    }
    
}
