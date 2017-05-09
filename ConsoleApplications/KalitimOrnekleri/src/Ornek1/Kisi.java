package Ornek1;

public class Kisi {
    public String ad, soyad, tel, ePosta, tcNo;
    
    public Kisi()
    {
        System.out.println("Kisi instance ı oluşturuldu.");
    }
    
    public Kisi(String ad, String soyad, String tel, String ePosta, String tcNo)
    {
        this.ad = ad;
        this.soyad = soyad;
        this.tel = tel;
        this.ePosta = ePosta;
        this.tcNo = tcNo;
    }
    
    public void printInfo()
    {
        System.out.println("Kisi info: " + ad + "" + soyad + "" + tel + " -> " + ePosta);
    }
}
