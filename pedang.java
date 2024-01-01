import java.util.Random;

public class pedang {
    static Random rand = new Random();
    static int[] weapStats = new int[3];

    public static int[] main(int weapId) {
        switch (weapId) {
            case 1:
                weapStats[0] = 3;
                weapStats[1] = rand.nextInt(1,6) +1;
                break;
        
            case 2:
                weapStats[0] = 1;
                weapStats[1] = rand.nextInt(1,6) +2;
                break;

            case 3:
                weapStats[0] = 2;
                weapStats[1] = rand.nextInt(1,6) +2;
                break;

            case 4:
                weapStats[0] = 3;
                weapStats[1] = rand.nextInt(1,6) +4;
                break;

            default:
                break;
        }
        return weapStats;
    }

}