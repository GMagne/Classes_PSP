import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String inputStr = scanner.nextLine();
        int n;
        try{
            n = Integer.valueOf(inputStr);

        } catch (NumberFormatException e){
            System.out.println("Invalid integer input");
        }//

        System.out.println("Hello, " + name + "!");
    }
}