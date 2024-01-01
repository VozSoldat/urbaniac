import java.util.Random;
import java.util.Scanner;
public class battle {



    static boolean isWin = true;
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    public static void main(String[] args) {
;

        chara john = new chara();
            john.hp  = 20;
            john.atkBonus = ActualToChanceMachine(die20());
            john.armorClass = ActualToChanceMachine(12);

            john.str = ActualToChanceMachine(die20());
            john.dex = ActualToChanceMachine(die20());
            john.con = ActualToChanceMachine(die20());
            john.inte = ActualToChanceMachine(die20());
            john.wis = ActualToChanceMachine(die20());
            john.cha = ActualToChanceMachine(die20());


        CharacterAbility(john.str, john.dex, john.con, john.inte, john.wis, john.cha, john.hp);

        // encounter enemy
        System.out.println("A goblin appears before you.");
        chara goblin = new chara();
            goblin.hp  = 9;
            goblin.atkBonus = ActualToChanceMachine(die20());
            goblin.armorClass = ActualToChanceMachine(12);

            goblin.str = ActualToChanceMachine(die20());
            goblin.dex = ActualToChanceMachine(die20());
            goblin.con = ActualToChanceMachine(die20());
            goblin.inte = ActualToChanceMachine(die20());
            goblin.wis = ActualToChanceMachine(die20());
            goblin.cha = ActualToChanceMachine(die20());

        CharacterAbility(goblin.str, goblin.dex, goblin.con, goblin.inte, goblin.wis, goblin.cha, goblin.hp);


        // roll initiative
        System.out.println("===\nROLLING INITIATIVE\n===");

        int initA = die20() + john.initBonus;
        System.out.println("Your initiative is " + initA);

        int initB = die20() + goblin.initBonus;
        System.out.println("Goblin's initiative is "+initB);

        if (initA>initB) {
            System.out.println("You are first.");
            PlayerFight(john.atkBonus, john.armorClass, goblin.atkBonus, goblin.armorClass);
        }else{
            System.out.println("Goblin is first.");
            EnemyFight(john.atkBonus, john.armorClass, goblin.atkBonus, goblin.armorClass);
        }

        if (isWin==true) {
            System.out.println("You are win.");
        } else {
            System.out.println("You are lose.");
        }
        
    }

    public static void PlayerFight(int atk, int def, int atk1, int def1){
        int weapId = ChooseWeap();
        int weapStats[] = pedang.main(weapId);
        System.out.println("===\nYOU ARE ATTACKING\n===");

         if (weapStats[0] + die20() > def1+die20()) {
            System.out.println("You succesfully land an attack.");
            isWin = true;
        }else{
            System.out.println("Goblin parries your attack.");
            EnemyFight(atk, def, atk1, def1);
        };
    }
    
    public static void EnemyFight(int atk, int def, int atk1, int def1){
        System.out.println("===\nENEMY IS ATTACKING\n===");

        if (atk1+rand.nextInt(1,20)>def+rand.nextInt(1,20)) {
            System.out.println("Goblin lands a blow.");
            isWin=false;
        } else {
            System.out.println("You block Goblin's attack.");
            PlayerFight(atk, def, atk1, def1);
        }
    }

    public static int ActualToChanceMachine(int actual){
    int chance = (actual-10)/2;
    return chance;
    }

    public static void CharacterAbility(int a, int b, int c, int d, int e, int f, int hp){
        System.out.printf("HP = %d | \n", hp );
        System.out.printf("STR = %d | DEX = %d | CON =  %d | INT = %d | CHA = %d\n", a, b, c, d, e, f);
        return;
    }

    public static int die20(){
        int diceResult = rand.nextInt(1,20);
        return diceResult;
    }

    public static int die6(){
        int diceResult = rand.nextInt(1,6);
        return diceResult;
    }

    public static int ChooseWeap(){
        System.out.println("Choose your weapon.");
        System.out.println("1. Pedang\n2. Kapak");
        int input = sc.nextInt();
        int weapId=0;

        switch (input) {
            case 1:
                weapId = 4;
                break;

            case 2:
                weapId = 2;
                break;

            default:
                break;
        }

        return weapId;
    }
    
}
