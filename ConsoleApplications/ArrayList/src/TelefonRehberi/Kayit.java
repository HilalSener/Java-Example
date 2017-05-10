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
    
    public void Guncelle()
    {
        
    }
}
