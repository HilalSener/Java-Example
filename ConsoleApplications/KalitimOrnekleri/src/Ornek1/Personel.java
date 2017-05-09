package Ornek1;

import javax.print.attribute.standard.PrinterInfo;

/*
exntends Terimi, bu sınıfın hangi sınıftan 

Personel sınıfında, hiçbir değişken & method tanımlanmamasına ragmen
Bu sınıf, Kisi sınıfından üretildği için Kisi sınıfındaki bütün
Değişken ve ve methodları bünysinde barındırır.

Personel : Sub Class
Kisi     : Super Class

Java daki her sınıf otomatik olarak, object sınıfından Extend edilir.

Bunun dışında kalıtım kullanılacaksa sadece bir sınıf extend edilir. 
*/
public class Personel extends Kisi
{
    public boolean isFreelance = false;
    
    public Personel()
    {
        System.out.println("Personel instance ı oluşturuldu.");
    }
    
    public Personel(String ad, String soyad)
    {
        this.ad = ad;
        this.soyad = soyad;
    }
    
    public String get4ADokum()
    {
        return "1231";
    }
    
    @Override
    public void printInfo()
    {
        
    }
}
