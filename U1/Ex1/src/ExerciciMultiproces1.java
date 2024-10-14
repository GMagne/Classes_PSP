import java.util.Scanner;
import java.io.File;

public class ExerciciMultiproces1 {
    public void lanzar(int n){
        String ruta = "ParellSenar.java";
        try{
            ProcessBuilder pb = new ProcessBuilder("java", ruta, String.valueOf(n));
            pb.directory(new File("C:\\Users\\34667\\Desktop\\GS_DAM\\PPS\\Classes_PSP\\U1\\Ex1\\src"));
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
