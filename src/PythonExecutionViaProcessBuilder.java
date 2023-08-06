import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonExecutionViaProcessBuilder {
    public static void main(String[] args)throws IOException {
        try{
            // The following function is accepting command to run, followed by file path, arguments to pass for the python
            ProcessBuilder builder = new ProcessBuilder
                    (
                            "py",
                            System.getProperty("user.dir")+"\\PythonScripts\\pythonCodeAcceptingArgumentsFromProcessBuilder.py",
                            "10",
                            "473"
                    );
            Process process = builder.start();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errorBufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String lines = null;
            while ((lines=bufferedReader.readLine())!=null) {
                System.out.println("Lines: "+lines);
            }

            String errorLines = null;
            while ((errorLines=errorBufferedReader.readLine())!=null) {
                System.out.println("Error Lines: "+errorLines);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}