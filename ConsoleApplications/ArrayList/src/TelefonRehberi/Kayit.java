package TelefonRehberi;

import java.util.ArrayList;

public class Kayit
{
    public ArrayList<String> numaralar = new ArrayList<>();
    public String ad;
    
    public Kayit(String ad, String tel)
    {
        this.ad = ad;
        numaralar.add(tel);
    }
    
    public String toString()
    {
        String tmp = ad+"\n";
        for (int i = 0; i < numaralar.size(); i++)
        {
            tmp += (i+1)+" - "+numaralar.get(i)+"\n";
        }
        
        return tmp;
    }
}
