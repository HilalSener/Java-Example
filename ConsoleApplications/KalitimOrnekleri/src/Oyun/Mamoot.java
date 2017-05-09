package Oyun;

public class Mamoot extends Entity 
{
    int goldDrop = 0;
    
    public Mamoot()
    {
        hp = 60;
        dmg = 15;
        avatar = "\u2126";
        goldDrop = 20 + (int)(Math.random() * 21);
    }
}
