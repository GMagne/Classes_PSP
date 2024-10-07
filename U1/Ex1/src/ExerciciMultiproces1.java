import java.util.Scanner;

public class ExerciciMultiproces1 {
    public void lanzar(int n){
        String ruta = "src\\ParellSenar.java";
        try{
            ProcessBuilder pb = new ProcessBuilder("java", ruta, String.valueOf(n));
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            pb.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String inputStr = "";
        int n = 0;
        System.out.println("Escriu un nombre enter:");
        while (true){
            ExerciciMultiproces1 ln = new ExerciciMultiproces1();
            inputStr = scanner.nextLine();
            try{
                System.out.println("Escriu un nombre enter:");
                n = Integer.valueOf(inputStr);
                ln.lanzar(n);


            } catch (NumberFormatException e){
                if(inputStr == "exit"){
                    break;
                }
                System.out.println("Invalid integer input");
            }//
        }

    }
}
