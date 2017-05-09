
package Ornek2;

public class App {
    public static void doOp(Canli param)
    {
        // Sınıf adını al
        String ad = param.getClass().getSimpleName();
        System.out.println("Param Type: " + ad);
        
        //Instance Of Kullanımı
        if(param instanceof Balik)
        {
            System.out.println("Balik instance' ı");
        }
        if(param instanceof Agac)
        {
            System.out.println("Agac instance' ı");
        }
        /*
        if(param instanceof Canli)
        {
            System.out.println("Canli instance' ı");
        }
        */
    }
    
    public static void main(String[] args) {
        Canli c = new Canli();
        Agac a = new Agac();
        Balik b = new Balik();
        
        doOp(c);
        //doOp(a);
        //doOp(b);
    }
}
