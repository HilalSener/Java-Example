package for_dongusu;

public class Ornek1 
{
    public static void main(String[] args) 
    {
         /*
            for(baslangic; devam kosulu; ilerleyis)
            {
                ...
            }
        */   
        
        //Ekrana 5 kere merhaba yazdırma
        for(int i=0; i<5; i++)
            System.out.println("Merhaba");
        
        //Bu döngü int in sınırlarına kadar çalışır
        for(int i=0; i<10; i--)
            System.out.println("HaHa");
        
        //Bu döngü hiç çalışmaz
        for(int i=0; i>10; i++)
            System.out.println("Java");
    }
}