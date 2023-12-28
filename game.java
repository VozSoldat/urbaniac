import java.util.Scanner;

/**
 * game
 */
public class game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        chara p1 = new chara();

        System.out.print("Insert name : ");
        p1.name = sc.next();
        System.out.print("Insert level : ");
        p1.level = sc.nextInt();

        

        System.out.println("Your character's name is "+ p1.name);
        System.out.println("Your character's level is "+p1.level);
    }
}