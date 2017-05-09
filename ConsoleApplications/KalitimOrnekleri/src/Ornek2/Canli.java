package Ornek2;

public class Canli 
{
    public String ad;
    public int yas;
    public int omur;
    
    public void beslen()
    {
        System.out.println("Canlı beslenir");
    }
    
    public void dinlen()
    {
        System.out.println("Canlı ZzZzZz");
    }
    
    public void yaslan()
    {
        System.out.println("Bir sene daha gitti");
        yas++;
    }
    
    //Bir instance ı ekrana istediğimiz gibi basmak için
    //Object sınıfından gelen ToString()' override ederiz.
    
    @Override
    public String toString()
    {
        return "Canli datası";
    }
}
