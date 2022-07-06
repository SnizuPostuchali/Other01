package lotteryOdds;

import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Сколько чисел нужно угадать?");
        int k = in.nextInt();
        System.out.println("Сколько чисел всего?");
        int n = in.nextInt();

        int[] numbers = new int[n];
        for(int i = 0; i<numbers.length; i++){
            numbers[i] = i+1;
        }

        int[] result = new int[k];
        for (int i = 0; i<result.length; i++){
            int r = (int)(Math.random()*n);
            result[i] = numbers[r];
            numbers[r] = numbers[n-1];
            n--;
        }

        Arrays.sort(result);
        System.out.println("Выигрышная комбинация: ");
        for(int a: result){
            System.out.print(a + " ");
        }
    }
}
