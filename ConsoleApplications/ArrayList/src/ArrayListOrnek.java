import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ArrayListOrnek {

    /*
    Generic Class : Belli Parametreler Gore
    Kendi Icinde Calisan Methodların Dönüş Türleri
    Ve Aldığı Parametre Türleri Değişen Sınıflara
    Generic Sınıf Denir
     */

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();

    // ArrayList Eleman Sayısı
        int cnt = al.size();

    // Eleman Ekleme :: Listenin Sonuna
        al.add("Emir");
        al.add("Sercan");

    // Eleman Ekleme :: IStedigin Index'e
        al.add(1, "Efe");

    // ArrayList'i Ekrana Bastır
        System.out.println(al);

    // ArrayList'te Bir Elemana Erişme
        String ad = al.get(0); // ar[0]
        System.out.println("Ilk Eleman : " + ad);
        System.out.println("Son Eleman : " + al.get(al.size() - 1));

    // ar[11] = 53;
        al.set(2, "Ezgi");

        boolean isExists = al.contains("Emir");

    // Array List Boş Mu
        boolean isEmpty = al.isEmpty();

    // ArrayList'i Temizle
        al.clear();
        System.out.println(al.size());

    // ArrayList'teki Bir Elemanı Index'e Gore Sil
    //al.remove(0);
    // ArrayList'teki Bir Elemanı Değere Göre Sil
        al.remove("Efe");

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(5);
        al2.add(8);
        al2.add(49);
        al2.add(2);
        al2.add(101);

    // ArrayList'in Bir Bolumunu Baska Bir
    // Liste Olarak Al
        List<Integer> subList = al2.subList(0, 3);
        System.out.println(al2);
        System.out.println(subList);

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(456);
        numbers.add(145);
        numbers.add(999);

    // sublistteki her sayiyi, numbers'a ekle
        numbers.addAll(subList);
        System.out.println(numbers);

    // al2deki her sayiyi, numbers'tan cikar
        numbers.removeAll(al2);

        System.out.println(numbers);

    // ArrayListteki Elemanları Karıştır
        Collections.shuffle(numbers);
    // ArrayListteki Elemanları Sırala
        Collections.sort(numbers); // 0-9, A-Z
    // ArrayListteki Elemanların Sıralamasını Terse Çevi
        Collections.reverse(numbers);

    // Bir Elemanın Index Değerini Öğren (0-> N)
        int fNdx = numbers.indexOf(834);
        int lNdx = numbers.lastIndexOf(834);

        ArrayList<Kisi> kisiler = new ArrayList<>();
        /* ÖZEL SORTING YONTEMI
        Comparator<Kisi> kiyaslamaMethodu = 
        new Comparator<Kisi>()
        {
        public int compare(Kisi o1, Kisi o2)
        {
        if (o1.dogumYili < o2.dogumYili)
        return 1;
        else if (o1.dogumYili == o2.dogumYili)
        return 0;
        else
        return 2;
        }
        };

        Collections.sort(kisiler, kiyaslamaMethodu); */
    }
}
