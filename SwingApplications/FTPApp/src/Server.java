
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public ServerSocket sSock;
    public Server() throws Exception 
    {
        sSock = new ServerSocket(6666);
        
        new Thread()
        {
            public void run()
            {
                while (true)
                {
                    try {
                    System.out.println("Bağlantı Bekleniyor");
                    Socket cSock = sSock.accept();
                    System.out.println("Client Bağlandı");
                } catch (Exception e) { e.printStackTrace(); }
                }
            }
        }.start();
    }
}
