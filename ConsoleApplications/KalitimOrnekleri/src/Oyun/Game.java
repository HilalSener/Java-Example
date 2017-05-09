
package Oyun;

import java.util.Scanner;

public class Game 
{
    public static int GAME_SIZE = 8;    
    public static Entity [][] map = new Entity[GAME_SIZE][GAME_SIZE];
    
    public static int monsterCnt = GAME_SIZE - 1;  //player ın bulunduğu location hariç
    public static Player player = new Player();
    public static int PX = 0, PY = 0;
    public static Scanner oku = new Scanner(System.in);
    
    public static void initGame()
    {
        //Haritadaki tüm alanları, boş entity instanceları ile doldur
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                map[i][j] = new Entity();
            }
        }
        
        //Oyuncuyu 0x0 a yerleştir
        map[0][0] = player;
        
        //1,2,3,4,5,6,7 satırlara x ler random olacak şekilde canavarlar yerleştir
        for (int i = 1; i < GAME_SIZE; i++) {
            int r = (int)(Math.random() * 2);
            int rX = (int)(Math.random() * GAME_SIZE);
            //Eğer r 0 ise, rX' e Goblin, r 1 ise, rX' e Mamoot yerleştir.
            Entity monster = (r == 0) ? new Goblin() : new Mamoot();
            
            map[i][rX] = monster;
        }
    }
    
    public static void printMap()
    {
        System.out.println("\n\n");
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }
    
    
    public static void main(String[] args) {
        initGame();
        
        while(monsterCnt > 0)
        {
            printMap();
            System.out.println("Yon : w, s, a, d: ");
            char yon = oku.next().toLowerCase().charAt(0);
            int tmpX = PX;
            int tmpY = PY;
            
            switch(yon)
            {
                case 'w' : tmpY--; break;
                case 's' : tmpY++; break;
                case 'a' : tmpX--; break;
                case 'd' : tmpX++; break;
            }
            
            //Harita dışına çıkılıyorsa, hareket etme
            if (tmpX < 0 || tmpY < 0 || tmpX >= GAME_SIZE || tmpY >= GAME_SIZE)
            {
                continue;
            }
            
            // Eğer Hareketin Sonucunda, Oyuncu Haritanın İçinde
            // Kalıyorsa, Hareket Ettiği Yerde Canavar Var Mı
            // Diye Kontrol Et
            Entity nextMove = map[tmpY][tmpX];
            // Bu Alan Boş, Oyuncu Hareket Edebilir
            if(nextMove.avatar.equals(" "))
            {
                map[PY][PX] = new Entity();
                map[tmpY][tmpX] = player;
                PX = tmpX;
                PY = tmpY;
            }
            else
            {
                System.out.println("Gitmek istediğiniz noktada bir canavar var, emin misiniz? 1 - E, 2 - H");
                int sec = oku.nextInt();
                if(sec == 2)
                    continue;
                
                if(sec == 1)
                { 
                    Entity canavar = map[tmpY][tmpX];
                    System.out.println("Bir " + canavar.getClass().getName() + " ile karşılaştın.");
                    
                    //TODO SAVASMA
                    /*
                        Savaş mekanizması :
                        Her zaman ilk oyuncu vurur
                        Rand(0.5 DMG - DMG)
                        Sonra Canavar
                        Bu sıra ile vurma işlemi,
                        2 taraftan birinin HP değer <= 0 olana
                        kadar devam edecek.
                        Eğer Oyuncunun HP'si 0 Olursa,
                        Döngü Kırılacak
                    */
                    
                    int rDmg = (int)(Math.random()*5);
                    while(player.hp > 0 || canavar.hp > 0)
                    {
                        if(canavar.isAlive())
                        {
                            canavar.hp -= rDmg;  
                            continue;
                        }
                        
                        
                    }
                    
                        
                    int altin = 0;
                    if(canavar instanceof Goblin)
                        altin = ((Goblin) canavar).goldDrop;
                    if(canavar instanceof Mamoot)
                        altin = ((Mamoot) canavar).goldDrop;
                    
                    player.goldCnt += altin;
                    player.killCnt += 1;
                    System.out.println("Canavarı Öldürdün, " + altin + " altın kazandın!");
                    
                    map[PY][PX] = new Entity();
                    map[tmpY][tmpX] = player;
                    PY = tmpY;
                    PX = tmpX;
                    
                    monsterCnt--;
                }
            }
        }
        
        //Döngü bitince eğer canavar sayısı 0 ise oyun kazanıldı
        //Ama hala canavar var ise karakter ölmüş demektir.
        if(monsterCnt == 0)
        {
            System.out.println("Tebrikler!");
        }
        else
        {
            System.out.println("Öldünüz, oyun bitti.");
        }
        
        //Kullanıcı her GAMESIZE /3 - 1 canavar öldürdüğüne 
        //Level atlayacak.
        //Her level atladığında
        //Canına +10, DMG'a +2 eklenecek ve canı fullenecek
        //Harita basıldıktan sonra, kullanıcının statlarını
        //Haritanın altına bastır.
    }
}
