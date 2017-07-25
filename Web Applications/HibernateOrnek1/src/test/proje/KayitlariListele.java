package test.proje;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class KayitlariListele {
    public static void main(String[] args) throws Exception{
        Session s = HibernateUtil.getSessionFactory().openSession();
        
        List<Kisiler> kl = null;
        kl = (List<Kisiler>)
                s.createQuery("from Kisiler").list();
        
        System.out.println("Kisi #: " + kl.size());
        
        //Her bir kişi için
        for (Kisiler kisi : kl) {
            int id = kisi.getId();
            String adSoyad = kisi.getAd() + " " + kisi.getSoyad(); 
            System.out.println(id + " " + adSoyad);
        }
        
        //Parametreli sorgu
        Query q = s.createQuery("from Kisiler where yas >= :yas");
        q.setParameter("yas", 30);
        List<Kisiler> kl2 = (List<Kisiler>) q.list();
        
        System.out.println("+30 yaş cnt: " + kl2.size());
        for (Kisiler k : kl2) {
            System.out.println(k.getAd() + " " + k.getYas());
        }
    }
}
