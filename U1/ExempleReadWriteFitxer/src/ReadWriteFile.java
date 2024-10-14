import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ReadWriteFile{

    public static BufferedReader getBufferedReader(String filePath) throws FileNotFoundException {
        FileReader reader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(reader);
        return bufferedReader;
    }

    public static PrintWriter getPrintWriter(String filePath) throws IOException {
        FileWriter filewriter = new FileWriter(new File(filePath));
        PrintWriter printWriter = new PrintWriter(filewriter);
        return printWriter;
    }

    public static void main(String[] args){

        String filePath = args[0];

        PrintWriter pw = null;
        try{
            pw = getPrintWriter(filePath);
            pw.println("Hola");
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            pw.close();
        }


        try (BufferedReader bfr = getBufferedReader(filePath)){
            System.out.println(bfr.readLine());
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}