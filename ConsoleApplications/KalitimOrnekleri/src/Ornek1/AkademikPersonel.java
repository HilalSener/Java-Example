package Ornek1;

public class AkademikPersonel extends Personel
{
    //Kalıtım olduğunda, üst sınıfın
    //null constructor' ı otomatik 
    //olarak çağrılır. Bunun yerine,
    //üst sınıfın, constructor ları
    //alt sınıfın, constructor ında
    //ilk statement olarak super(..) şeklinde çağrılır.
    public AkademikPersonel()
    {
        super("Falan", "Filan");
        System.out.println("Islem...");
    }
}
