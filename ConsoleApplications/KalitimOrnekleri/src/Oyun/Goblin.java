package Oyun;

public class Goblin extends Entity {
    int goldDrop = 0;
    
    public Goblin()
    {
        hp = 90;
        dmg = 35;
        avatar = "\u25b2";
        goldDrop = 30 + (int)(Math.random() * 31);
    }
}
