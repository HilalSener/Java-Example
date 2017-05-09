package Oyun;

public class Player extends Entity 
{
    public int goldCnt = 0, killCnt = 0, level = 1;
    
    public Player()
    {
        avatar = "\u263A";
        hp = 100;
        dmg = 20;
    }
}
