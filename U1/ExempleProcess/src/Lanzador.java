import java.io.File;

public class Lanzador {
    public void execSuma(String n1,String n2){
        String ruta = "U1/ExempleProcess/src/Sumador.java";
        try{
            ProcessBuilder pb = new ProcessBuilder("java", ruta, n1, n2); // "java U1/ExempleProcess/src/Sumador.java arg1 arg2"
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectError(new File("U1/ExempleProcess/src/errors1.txt"));
            pb.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Lanzador l = new Lanzador();
        String n1 = args[0];
        String n2 = args[1];
        l.execSuma("1","50000");
        l.execSuma("500","1000");
        System.out.println("End");
    }
}
