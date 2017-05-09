package Ornek1;

public class IdariPersonel extends Personel{
    public String dept = "";
    
    public IdariPersonel()
    {
        System.out.println("IdariPersonel instance' ı oluşturuldu.");
    }
    
    public void ustSiniftaIslem() 
    {
        //This: Şu an kullandığınız instance ı refer ederken
        //Super: Şu an kullandığınız instance' ı oluşurmak için
        //Arka planda oluşturulan üst sınıf instance ını refer eder. 
    }
    
    public void getPersonelData()
    {
        System.out.println("Pernonel data: ");
        super.printInfo();
    }
}
