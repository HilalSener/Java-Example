
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
    1 - 49 arası, 6 tane birbirinden farklı sayı
*/
public class SayisalLoto 
{
    public static void main(String[] args) {
        int sayilar[] = new int[6];
        int cnt = 0;
        while(cnt != 6)
        {
            int r = 1 + (int)(Math.random()*49);

            //Çektiğim sayı önceki sayılar arasında var mı?
            boolean found = false;
            for (int i = 0; i < cnt; i++) {
                if(sayilar[i] == r)
                {
                    found = true;
                    break;
                }
            }
            
            if(!found)
            {
                sayilar[cnt] = r;
                cnt++;
            }
            System.out.println(Arrays.toString(sayilar));
            
            //İçinde tam sayıların tutulduğu bir arraylist oluştur.
            ArrayList<Integer> al = new ArrayList<>();
            
            //1,2,3,4,5,....48,49 sayılarını ArrayList' e ekle
            for (int i = 0; i < 50; i++) {
                al.add(i);
            }
            
            //Listeyi karıştır.
            Collections.shuffle(al);
            
            //İlk 6 topu al
            System.out.println(al.subList(0, 6));
        }
    }
}
