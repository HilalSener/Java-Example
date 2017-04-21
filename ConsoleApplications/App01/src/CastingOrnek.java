public class CastingOrnek 
{
    public static void main(String[] args) 
    {
        double d= 99.876;
        int sayi = (int)d;
        
        char c = 'A';
        int karakterDegeri = (int)c;
        System.out.println("KD: " + karakterDegeri);
        
        int kenar = 5;
        double sonuc = (double)kenar * 4;
    }
}
