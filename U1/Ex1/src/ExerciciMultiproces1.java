import java.util.Scanner;
import java.io.File;

public class ExerciciMultiproces1 {
    public void lanzar(int n){
        String dirPath = "./out\\production\\Ex1";
        String fileName = "ParellSenar";
        try{
            ProcessBuilder pb = new ProcessBuilder("java", fileName, String.valueOf(n));
            pb.directory(new File(dirPath));
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String inputStr = "";
        int n = 0;
        while (true){
            System.out.println("Pare: Escriu un nombre enter:");
            ExerciciMultiproces1 ln = new ExerciciMultiproces1();
            inputStr = scanner.nextLine();
            try{
                n = Integer.valueOf(inputStr);
                ln.lanzar(n);
            } catch (NumberFormatException e){
                if(inputStr == "exit"){
                    break;
                }
                System.out.println("Pare: Invalid integer input");
            }//
        }

    }
}
