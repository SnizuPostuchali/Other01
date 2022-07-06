package lotteryOdds;

public class LotteryArray {
    public static void main(String[] args) {
        int rows = 10;
        int [][] odds = new int[rows+1][];
        for(int i = 0; i<=rows; i++){
            odds[i] = new int[i+1];
        }

        for(int i = 0; i<odds.length; i++){
            for (int j = 0; j<odds[i].length; j++){
                int lottetyOdds = 1;
                for (int k = 1; k<=j; k++){
                    lottetyOdds = lottetyOdds * (i - k + 1) / k;
                }
                odds[i][j] = lottetyOdds;
            }
        }
        for(int [] row: odds){
            for (int odd: row){
                System.out.printf("%4d",odd);
            }
            System.out.println();
        }
    }
}
