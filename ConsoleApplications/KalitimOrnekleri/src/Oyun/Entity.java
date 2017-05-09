package Oyun;

public class Entity {
    public String avatar;
    public int hp;
    public int dmg;
    
    public Entity(String avatar, int hp, int dmg)
    {
        this.avatar = avatar;
        this.hp = hp;
        this.dmg = dmg;
    }
    
    public Entity()
    {
        avatar = " ";
        hp = 0;
        dmg = 0;
    }
    
    public boolean isAlive() { return hp >0; }
    
    public String toString() { return "[" + avatar + "]"; }
}
