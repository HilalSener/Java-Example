/*
 1 den 1000 e kadarki sayilarin arasından 3 e ve 5 e kalansız bölünen ama 10'un katı olmayan sayıları ekrana yazdırın
 */
package for_dongusu;

public class Ornek4 
{
    public static void main(String[] args)
    {
        for(int i=0; i<1000; i++)
        {
            if(i%3==0 && i%5==0 && i%10!=0)
                System.out.println(i);
        }
    }
}
