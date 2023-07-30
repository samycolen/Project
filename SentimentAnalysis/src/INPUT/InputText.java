package INPUT;

import java.util.Scanner;

public class InputText {
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence for sentiment analysis:");
        return scanner.nextLine();

    }
}
