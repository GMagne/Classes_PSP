import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ExempleMultiProcesEntradaSortida {

    final static String[] command = {
            "java",
            "-jar",
            "C:\\Users\\34667\\Desktop\\GS_DAM\\PPS\\ExempleRunTime\\out\\artifacts\\ExempleRunTime_jar\\ExempleRunTime.jar"
    };

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.print("Introdueix un nombre: ");
                String value = scan.nextLine();

                if ("exit".equals(value)) return;

                System.out.println(getSon(value));
                System.out.println("================");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static String getSon(String value) throws IOException {
        Runtime console = Runtime.getRuntime();

        Process proces = console.exec(command);

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(proces.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(proces.getInputStream()));

        out.write(value);
        out.close();

        String readLine = in.readLine();
        in.close();
        return readLine;
    }
}
