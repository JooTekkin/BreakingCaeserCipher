import java.util.Random;

public class DiceRolls {

    public void simpleSimulate(int rolls){
        Random rr = new Random();
        int[] check = new int[13];
        for (int i = 0; i < rolls; i++) {
            int nar1 = rr.nextInt(6) + 1;
            int nar2 = rr.nextInt(6) + 1;

            check[nar1+nar2]++;
        }

        for (int k = 2; k < check.length; k++) {
            System.out.println("number is = " + k + " shows = " + check[k]);
        }
    }
}

class DiceRollsMain{
    public static void main(String[] args) {
        DiceRolls dr = new DiceRolls();
        dr.simpleSimulate(10);
    }
}