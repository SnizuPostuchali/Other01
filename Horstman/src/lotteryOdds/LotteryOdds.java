package lotteryOdds;

import java.math.BigInteger;
import java.util.Scanner;

public class LotteryOdds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Сколько чисел нужно угадать?");
        int k = in.nextInt();
        System.out.println("Сколько чисел всего?");
        int n = in.nextInt();
        BigInteger bigOdds = new BigInteger("1");
//        int odds = 1;
        for(int i = 1; i<=k; i++){
            bigOdds = bigOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
//            odds = odds * (n-i+1)/i;
        }
//        System.out.println("Шансы на выигрыш 1 к " + odds + " или " +1/(double)odds +"%");
        System.out.println("Шансы на выигрыш 1 к " + bigOdds);
    }
}
