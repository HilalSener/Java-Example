package Ornek1;

public class test{
    public static void main(String[] args) {
        Kisi k = new Kisi();
        Personel p = new Personel();
        IdariPersonel ip = new IdariPersonel();
        AkademikPersonel a = new AkademikPersonel();
        
        System.out.println(ip);
        
        p.printInfo();
        k.printInfo();
        ip.printInfo();
    }
}
 