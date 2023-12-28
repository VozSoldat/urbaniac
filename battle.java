import java.util.Random;
public class battle {
    static boolean isWin = true;
    static Random rand = new Random();
    public static void main(String[] args) {
        int atk = 100;
        int def = 100;
        int init = -2;

        System.out.printf("ATK = %d | DEF = %d | INIT+ =  %d\n", atk, def, init);

        // encounter enemy
        System.out.println("A goblin appears before you.");
        int atk1 = 91;
        int def1 = 102;
        int init1 = 1;

        System.out.printf("ATK = %d | DEF = %d | INIT+ =  %d\n", atk1, def1, init1);


        // roll initiative
        int initX = rand.nextInt(1,20);
        int initA = initX + init;
        System.out.println("Your initiative is " + initA);

        int initY = rand.nextInt(1,20);
        int initB = initY + init1;
        System.out.println("Goblin's initiative is "+initB);

        if (initA>initB) {
            System.out.println("You are first.");
            PlayerFight(atk, def, atk1, def1);
        }else{
            System.out.println("Goblin is first.");
            EnemyFight(atk, def, atk1, def1);
        }

        if (isWin==true) {
            System.out.println("You are win.");
        } else {
            System.out.println("You are lose.");
        }
        
    }

    public static void PlayerFight(int atk, int def, int atk1, int def1){
         if (atk+rand.nextInt(1,20)>def1+rand.nextInt(1,20)) {
            System.out.println("You succesfully land an attack.");
            isWin = true;
        }else{
            System.out.println("Goblin parries your attack.");
            EnemyFight(atk, def, atk1, def1);
        };
    }
    
    public static void EnemyFight(int atk, int def, int atk1, int def1){
        if (atk1+rand.nextInt(1,20)>def+rand.nextInt(1,20)) {
            System.out.println("Goblin lands a blow.");
            isWin=false;
        } else {
            System.out.println("You block Goblin's attack.");
            PlayerFight(atk, def, atk1, def1);
        }
    }
}
