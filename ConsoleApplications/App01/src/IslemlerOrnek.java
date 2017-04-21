public class IslemlerOrnek 
{
    public static void main(String[] args)
    {
        int a = 10, b=20;
        int c = a + b;          //30
        int d = c / 2;            //15
        int e = d % 3;            //0
        int f = a * (b + d) -c; //10*(20+15)-30

        a = 20;
        a = a + 20;
        a = a - 20;
        a = a * 2;
        a = a / 4;
        a = a % 10;
        
        double sonuc = 22 / 7.0;
        System.out.println(sonuc);
    }
}
