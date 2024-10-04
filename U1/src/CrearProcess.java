public class CrearProcess {
    public void execPB(String ruta){

        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(ruta);
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void execR(String ruta){

        Runtime runtime;
        try {
            runtime = Runtime.getRuntime();
            Process process = runtime.exec(ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String ruta=
                "C:/Program Files/Microsoft Office/root/Office16/WINWORD.EXE";
        CrearProcess lp=new CrearProcess();
        lp.execR(ruta);
        System.out.println("Finalizado");
    }
}
