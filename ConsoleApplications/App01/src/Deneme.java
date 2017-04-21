public class Deneme 
{
    //Main Methodu
    //Bir sınıfın tek başına bir uygulama olarak çalıştırılabilmesi için gerekli olan method.
    //Uygulama başlangıç noktası
    public static void main(String[] args)
    {
        System.out.println("Merhaba Dünya");
        System.out.println("Yeni satır");
        //PrintF formatlanmış çıktı almak için
        /*
            Kaçış seansları - Escape Sequences
            \n      Yeni Satır
            \t      Tab Karakteri
            \b      Backspace
            \\      \ karakteri
            \"      " Karakteri
            \'      ' Karakteri
            \ uXXXX Kodu bilinen UTF8 Karakteri
        */
        System.out.println("Bugün\nJava Dersinin\n1.Günü");
        System.out.println("Hilal: \"Herkese Merhaba\"");
    } 
}
