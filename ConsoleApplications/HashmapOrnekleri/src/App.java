
import java.util.HashMap;
import java.util.Iterator;

public class App 
{
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        
        hm.put("id", "112");
        hm.put("ad", "Hilal Şener");
        hm.put("e-mail", "hilal.sener@outlook.com.tr");
        
        System.out.println(hm);
        String userId = hm.get("id");
        
        System.out.println("USER ID: " + userId);
        
        //HashMap teki KeyValue Sayısı
        int size = hm.size();
        System.out.println(hm.get(0));
        
        //HashMap lerden aynı anahtardan 2 tane olamaz
        //2.si eklendiğinde, 1.si güncellenir.
        hm.put("email", "hilal.sener@hotmail.com");
        
        //HashMapler for döngüleri ya da indexle dolaşılmaz. 
        //İteratorlerle dolaşılırlar
        Iterator<String> it = hm.keySet().iterator();
        while(it.hasNext())
        {
            String key = it.next();
            String val = hm.get(key);
            System.out.println(key + "-->" + val);
        }
    }
}
