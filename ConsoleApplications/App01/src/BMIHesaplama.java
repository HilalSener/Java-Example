
import java.util.Scanner;

/*
 Kullanıcıdan Boy ve Kilo değerleri alınacak
Boy  : 1.80
Kilo : 75.5

Body Mass Index Hesaplama = Boy /(Kg*Kg)
 */
public class BMIHesaplama 
{
    public static void main(String[] args) 
    {
        Scanner oku = new Scanner(System.in);
        System.out.print("Boyunuzu giriniz:");
        double boy = oku.nextDouble();
        
        System.out.print("Kilonuzu giriniz:");
        double kilo = oku.nextDouble();
        
        double sonuc = kilo / (boy*boy);
        System.out.printf("Vücut kitle indeksiniz: %.3f\n",sonuc);
    }
}
