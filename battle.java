import java.util.Random;
public class battle {
    static boolean isWin = true;
    static Random rand = new Random();
    public static void main(String[] args) {
        weapons pedang = new weapons();
        pedang.name = "Broom";

        chara john = new chara();
            john.hp  = 20;
            john.atkBonus = ActualToChanceMachine(DiceMachine());
            john.armorClass = ActualToChanceMachine(12);

            john.str = ActualToChanceMachine(DiceMachine());
            john.dex = ActualToChanceMachine(DiceMachine());
            john.con = ActualToChanceMachine(DiceMachine());
            john.inte = ActualToChanceMachine(DiceMachine());
            john.wis = ActualToChanceMachine(DiceMachine());
            john.cha = ActualToChanceMachine(DiceMachine());


        CharacterAbility(john.str, john.dex, john.con, john.inte, john.wis, john.cha, john.hp);

        // encounter enemy
        System.out.println("A goblin appears before you.");
        chara goblin = new chara();
            goblin.hp  = 9;
            goblin.atkBonus = ActualToChanceMachine(DiceMachine());
            goblin.armorClass = ActualToChanceMachine(12);

            goblin.str = ActualToChanceMachine(DiceMachine());
            goblin.dex = ActualToChanceMachine(DiceMachine());
            goblin.con = ActualToChanceMachine(DiceMachine());
            goblin.inte = ActualToChanceMachine(DiceMachine());
            goblin.wis = ActualToChanceMachine(DiceMachine());
            goblin.cha = ActualToChanceMachine(DiceMachine());

        CharacterAbility(goblin.str, goblin.dex, goblin.con, goblin.inte, goblin.wis, goblin.cha, goblin.hp);


        // roll initiative
        int initA = DiceMachine() + john.initBonus;
        System.out.println("Your initiative is " + initA);

        int initB = DiceMachine() + goblin.initBonus;
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

    public static int ActualToChanceMachine(int actual){
    int chance = (actual-10)/2;
    return chance;
    }

    public static void CharacterAbility(int a, int b, int c, int d, int e, int f, int hp){
        System.out.printf("HP = %d | \n", hp );
        System.out.printf("STR = %d | DEX = %d | CON =  %d | INT = %d | CHA = %d\n", a, b, c, d, e, f);
        return;
    }

    public static int DiceMachine(){
        int diceResult = rand.nextInt(1,20);
        return diceResult;
    }
}
