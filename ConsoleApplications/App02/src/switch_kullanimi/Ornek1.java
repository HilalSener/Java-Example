package switch_kullanimi;

public class Ornek1 
{
    public static void main(String[] args) 
    {
        /*
        switch(degisken)
        {
        case deger1: ... break;
        case deger2: ... break;
        default: ... break;
        }
        */
        
        int a=3;
        switch(a)
        {
            case 1: System.out.println("Bir"); break;
            case 2: System.out.println("İki"); break;
            case 3: System.out.println("Üç"); break;
            case 4: System.out.println("Dört"); break;
            default: System.out.println("Başka bir sayı"); break;
        }
        
        int q = 4;
        switch(q)
        {
            case 0:
            case 2:
            case 4:
            case 6: System.out.println("Çift"); break;
            case 1:
            case 3:
            case 5:
            case 7: System.out.println("Tek"); break;
        }
    }
}
