
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SayiToplama 
{
    public static File f = new File("sayilar.txt");
    
    public static ArrayList<Integer> convert(String s)
    {
        ArrayList<Integer> al = new ArrayList<>();
        
        //String teki her bir karakteri dolaşacak for...
        for (int i = 0; i < s.length(); i++) {
            int rakam = new Integer("" + s.charAt(i));
            al.add(i);
        }
        return al;
    }
    
    public static void main(String[] args) 
    {
        try 
        {
            Scanner oku = new Scanner(f, "UTF-8");
            String s1 = oku.nextLine();
            String s2 = oku.nextLine();
            
            System.out.println(s1 + "\n" + s2);
            
            ArrayList<Integer> n1 = convert(s1);
            ArrayList<Integer> n2 = convert(s2);
            
            System.out.println(n1 + "\n" + n2);
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
