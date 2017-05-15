
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.net.URI;

public class App01 {
    public static void main(String[] args) {
        String dosyaYolu = "C:\\Windows\\System32\\calc.exe";
        String path = "C:/Windows/System32/calc.exe";
        
        File f1 = new File("C:/Users/Hilal/notes.txt");
        File f2 = new File(URI.create("file://C:/Users/notes.txt"));
        File klasor = new File("C:Windows");
        
        File f3 = new File(klasor, "format.com");
        File f4 = new File("C:/Users/Hilal/Desktop", "data.txt");
        
        //Belirtilen dosya gerçekten var mı
        boolean dosyaVarMi = f1.exists();
        
        //Dosyanın byte cinsinden boyutu (long)
        long dosyaBoyutu = f1.length();
        
        //File bir dosya mı
        boolean isFile = f1.isFile();
        
        //File bir klasör mü
        boolean isDir = f1.isDirectory();
        
        // c:/Windows/System32/calc.exe
        //Dosyanın adını al
        String ad = f1.getName();  //cals.exe
        
         //Dosyanın bulunduğu klasörü döndürür.
        String rF = f1.getParent();  // C:/Windows/System32
        
        //Klasörü belli olmayan dosyalar çalışma klasörü olarak 
        //uygulamanızın bulunduğu klasörü baz alırlar. 
        //Bu yola erişim için getAbsolutePath() kullanılabilir.
        File df = new File("java.dat");
        //Dosyanın tam yolunu alır
        String tamYol = f1.getAbsolutePath();
        
        //Dosyanın bulunduğu klasörü bir file instance olarak döndürür
        File ustKlasor = f1.getParentFile();
        
        boolean canRead = f1.canRead();
        boolean canWrite = f1.canWrite();
        boolean canExec = f1.canExecute();
        
        //Dosya izinlerini değiştirme
        f1.setReadable(true);
        f1.setWritable(true);
        f1.setExecutable(true);
        
        //Dosya gizlenmiş mi
        boolean isHidden = f1.isHidden();
        
        long hddToplamAlan = f1.getTotalSpace();
        long hddBosAlan =  f1.getFreeSpace();
        long hddKullanilabilirAlan = f1.getUsableSpace();
        
        //Bir doyayı silmek
        //Klasörler bu şekilde silinemez.
        boolean sonuc = f1.delete();
        
        //Boş bir doya oluşturmak
        try 
        {
            boolean dosyaOlusturulduMu = f1.createNewFile();
            boolean klasorOlusturulduMu = f1.mkdirs();
        } catch (Exception e) 
        {
            System.out.println("Dosya oluşturma hatası: " + e.toString());
        }
        
        File d1 = new File("C:/aaa.txt");
        File d2 = new File("C:/Users/Hilal/aaa.txt"); 
        
        //Dosyanın adını / Konumunu değiştir
        d1.renameTo(d2);
        
        //Uygulamanız sırasında çalıştığınız dosyanın uygulamanız kapandığında 
        //Sistem tarafından otomatik olarak silinmesini istiyorsanız
        d1.deleteOnExit();
        
        //Eğer kullanılan File instance' ı bir klasörü gösteriyorsa
        //O klasördeki alt dosyaları almak için
        String doyaAdlari[] = f1.list();
        File altDosyalar[] = f1.listFiles();
        
        /*Eğer bir klasörün altındaki tüm dosyaları almak yerine belli kriterlere uyan dosya 
        ve klasörleri toplamak istiyorsanız fileFİlter veya FileNameFilter kullanabilirsiniz*/
        
        //İsminde process kelimesi geçen dosyaları toplamak için filtre
        FilenameFilter ff = new FilenameFilter() {
            public boolean accept(File dir, String name) 
            {
                if(name.contains("process")) return true;
                else return false;
            }
        };
        
        File processDosyalari[] = f1.listFiles(ff);
        
        //Alt dosyaları belli özllikler neticesinde toplamak için filtre
        //1 mb den küçük file ları
        FileFilter dFiltre = new FileFilter() {
            public boolean accept(File f) 
            {
                return (f.length() < 1048576 && f.isFile());
            }
        };
        
        File kucukDosyalar[] = f1.listFiles(dFiltre);
    }
}
