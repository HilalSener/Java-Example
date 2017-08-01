/*
whereami O An Calistigim Klasoru
go C:Windows.. Calistigim Klasoru Degistirir
bye Programdan Cikmami Sağlar
del DosyaAdi Bir Dosya Silmemi Sağlar
add DosyaAdi Bir Dosya Olusturmami Saglar
show DosyaAdi Bir Dosyanin Icerigini Gostermemi Saglar
list KlasorAdi Bir Klasordeki Dosyalari Listelememi Saglar
*/

import java.io.File;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import static java.net.URLEncoder.encode;
import java.util.Scanner;

public class App implements Runnable{
    ServerSocket sSock;
    Socket cSock;
    PrintWriter ul;
    Scanner dl;
    File root = new File("C:");
    
    public App()
    {
        try {
            sSock = new ServerSocket(11111);
            
            while(true)
            {
                cSock = sSock.accept();
                System.out.println("İstemci bağlandı");
                ul = new PrintWriter(cSock.getOutputStream(), true);
                dl = new Scanner(cSock.getInputStream(), "UTF-8");
                new Thread(this).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run()
    {
        try {
            while(true)
            {
                String cmd = dl.nextLine();
                
                if(cmd.equals("whereami"))
                    ul.println(root.getAbsolutePath());
                if(cmd.startsWith("go"))
                {
                    String path = cmd.replace("go", "");
                    File tmp = new File(path);
                    if(tmp.exists())
                    {
                        root = new File(path);
                        ul.println("ok");
                    }
                    else
                        ul.println("error - no directory");
                }
                if(cmd.startsWith("del"))
                {
                    String path = cmd.replace("del", "");
                    File tmp = new File(path);
                    if(!tmp.exists())
                    {
                        ul.println("error - no file to delete");
                    }
                    else
                    {
                        boolean sonuc = tmp.delete();
                        ul.println("del result: " + sonuc);
                    }
                }
                
                if(cmd.equals("bye"))
                {
                    ul.println("Bye !!!");
                    break;
                }
                
                if(cmd.startsWith("add"))
                {
                    String path = cmd.replace("add", "");
                    File f = new File(path);
                    boolean res = f.createNewFile();
                    ul.println("add result: " + res);
                }
                
                if(cmd.startsWith("show"))
                {
                    String path = cmd.replace("show", "");
                    File f = new File(path);
                    
                    if(!f.isFile())
                        ul.println("error - not a file");
                    else
                    {
                        StringBuilder sb = new StringBuilder();
                        
                        try {
                            Scanner oku = new Scanner(f, "UTF-8");
                            while(oku.hasNextLine())
                                sb.append(oku.nextLine() + "\n");
                            oku.close();
                            ul.println(encode(sb.toString()));
                            
                        } catch (Exception e) {
                        }
                    }
                }
                
                if(cmd.startsWith("list"))
                {
                    String path = cmd.replace("list", "");
                    File f = new File(path);
                    if(!f.isDirectory())
                    {
                        ul.println("error - not a directory");
                    }
                    else
                    {
                        StringBuilder sb = new StringBuilder();
                        File[] altDosyalar = f.listFiles();
                        if(altDosyalar != null)
                        {
                            for(File altDosya : altDosyalar)
                                sb.append(altDosya.getAbsolutePath() + "\t\t" + altDosya.length() + " Bytes\n");
                        }
                        ul.println(encode(sb.toString()));
                    }  
                }
            }
            
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        new App();
    }
}
