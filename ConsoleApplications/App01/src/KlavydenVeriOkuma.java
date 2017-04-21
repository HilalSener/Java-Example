
import java.util.Scanner;

public class KlavydenVeriOkuma 
{
    public static void main(String[] args) 
    {
        // Klavyeden Veri Okumak İçin
        Scanner oku = new Scanner(System.in);

        System.out.print("Merhaba, Adın Ne ?");
        String ad = oku.next();
        System.out.print(ad+", Kaç Yaşındasın ? ");
        int yas = oku.nextInt();
    }
}
