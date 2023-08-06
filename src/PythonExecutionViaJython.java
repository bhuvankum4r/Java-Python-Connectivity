import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import java.util.Properties;

public class PythonExecutionViaJython {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("python.path","PythonScripts");
        PythonInterpreter.initialize(System.getProperties(),properties,new String[]{"115145","35151"});
        try (PythonInterpreter pythonInterpreter = new PythonInterpreter()) {
            pythonInterpreter.exec("print('Python code Via Command')");
            pythonInterpreter.execfile("PythonScripts/pythonCodeWithoutArguments.py");
            pythonInterpreter.execfile("PythonScripts/pythonCodeAcceptingArgumentsFromJython.py");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
