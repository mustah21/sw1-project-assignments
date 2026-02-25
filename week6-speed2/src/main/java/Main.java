

import java.util.Scanner;

public class Main {

    public static int speed(int distance, int time ) {
        return distance / time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the distance in km: ");
        int distance = sc.nextInt();

        System.out.println("Enter the time in hrs: ");
        int time = sc.nextInt();

        int speed1 = Main.speed(distance, time);
        System.out.println("The speed is: " + speed1);


    }
}