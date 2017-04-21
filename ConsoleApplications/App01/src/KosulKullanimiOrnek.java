public class KosulKullanimiOrnek 
{
    public static void main(String[] args) 
    {
         int a = 10;
         //if(a<20)
         //{
         //    System.out.println("A sayısı, 20' den küçük");
         //}
         
         if(a%2==0)
             System.out.println("A çifttir");
         if(a%2==1)
             System.out.println("A tektir");
         
         if(a<20)
             System.out.println("K");
         if(a>20)
             System.out.println("B");
         if(a==20)
             System.out.println("E");
         
         if((a<10 && a%2==1) || (a>10 && a%2==0))
         {}
         
         int t;
         if(a%2==0)
             t=2;
         else
             t=50;
         
         //t=(a % 2 == 0) ? 2 : 50;
    }
}
