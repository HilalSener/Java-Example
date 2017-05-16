
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HocaninCozumu {
    // 11123 [1,1,1,2,3]

    public static ArrayList<Integer> convert(String s) {
        ArrayList<Integer> al = new ArrayList<>();

// Stringteki Her Bir Karakteri Dolaşacak Bir For...
        for (int i = 0; i < s.length(); i++) {
            int rakam = new Integer("" + s.charAt(i));
            al.add(rakam);
        }

        return al;
    }

    public static void main(String[] args) throws Exception {
        Scanner oku = new Scanner(
        new File("C:/Users/TuX/Desktop/d.txt"), "UTF-8");

        String s1 = oku.nextLine();
        String s2 = oku.nextLine();

        System.out.println(s1 + "n" + s2);

        ArrayList<Integer> n1 = convert(s1);
        ArrayList<Integer> n2 = convert(s2);

        System.out.println(n1 + "n" + n2);

// Toplama Sonucunun Tutulacağı ArrayList
        ArrayList<Integer> rL = new ArrayList<>();

        int eldeVar = 0;

// Son Rakamdan İlk Rakama Doğru For...
        for (int i = n1.size() - 1; i >= 0; i--) {
            int rakamToplami = eldeVar + n1.get(i) + n2.get(i);
            eldeVar = 0;

            if (rakamToplami >= 10) {
                rakamToplami %= 10;
                eldeVar = 1;
            }

            rL.add(rakamToplami);
        }

// Sayilarin Toplaması Bittiğinde eldeVar Değeri
// 1 ise, ArrayList'e Eklenmeli
        if (eldeVar == 1) {
            rL.add(eldeVar);
        }

// Sonuc Listesini Terse Çevir
        Collections.reverse(rL);

        System.out.println(rL);

    }
}
