public class DegiskenlerOrnek
{
    public static void main(String[] args)
    {
        byte b = 10;
        short s = 20;
        int i = 40;
        long l = 410;
        
        System.out.println("Byte min: "  + Byte.MIN_VALUE + " , " + Byte.MAX_VALUE);
        System.out.println("Byte min: " + Short.MIN_VALUE + " , " + Short.MAX_VALUE);
        System.out.println("Int min: " + Integer.MIN_VALUE + " , " + Integer.MAX_VALUE);
        System.out.println("Long min: " + Long.MIN_VALUE + " , " + Long.MAX_VALUE);
        
        float f = 14.3323f;
        double d = 3.14287123456;
        
        System.out.println("Float: " + Float.MIN_VALUE + " , " + Float.MAX_VALUE);
        System.out.println("Long min: " + Double.MIN_VALUE + " , " + Double.MAX_VALUE);
        
        char c= 'A';
        System.out.println("Char: " + Character.MIN_VALUE + " , " + Character.MAX_VALUE);
        
        
    }
}
