import java.util.Random;
import java.util.Scanner;

public class FirstClass {
    public static void main(String[] args) {
        Scanner arg = new Scanner(System.in);
        Random numbers = new Random();
        int ang = 0;
        int random = numbers.nextInt(9);
        System.out.println("Угадай число");

        while (ang < 3) {
            System.out.print("Введи число от 0 до 9");
            int number = arg.nextInt();

            if (number > random) {
                System.out.println("Укажи числи меньше");
                System.out.println("");

            } else if (number < random) {
                System.out.println("Укажи число больше");
                System.out.println("");

            } else if (number == random) {
                System.out.println("Ты угадал");
                System.out.println("");
            }
            ang++;

        }
        System.out.println("Ты проиграл, если хочешь начать занаво, нажми 1, или 0 для окончания ");

        String userData = arg.next();
        if (userData.equals("1")) {

        }
    }
}





