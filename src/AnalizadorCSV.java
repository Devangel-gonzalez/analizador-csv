import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class AnalizadorCSV {

    public static void main(String[] args) {

        Properties propiedades = new Properties();

        try (
                FileInputStream archivo = new FileInputStream(
                        "config/application.properties")) {

            propiedades.load(archivo);

        } catch (IOException e) {

            System.out.println(
                    "No fue posible cargar la configuración.");

            return;
        }

        String archivoDatos = propiedades.getProperty("archivo");

        String separador = propiedades.getProperty("separador");

        String directorioSalida = propiedades.getProperty(
                "directorioSalida");

        System.out.println(
                "Archivo: " + archivoDatos);

        System.out.println(
                "Separador: " + separador);

        System.out.println("Directorio: " + directorioSalida);

        // Argumentos y variables de entorno
        /*
         * String javaHome = System.getenv("JAVA_HOME");
         * System.out.println(
         * "JAVA_HOME = " + javaHome);
         * 
         * String directorioSalida = System.getenv("ANALIZADOR_OUTPUT");
         * System.out.println("Directorio de salida: " + directorioSalida);
         * 
         * if (args.length < 1) {
         * System.out.println(
         * "Uso: java AnalizadorCSV <archivo.csv> [separador]");
         * return;
         * }
         * 
         * String archivo = args[0];
         * 
         * String separador = ",";
         * 
         * if (args.length >= 2) {
         * separador = args[1];
         * }
         * 
         * System.out.println("Archivo: " + archivo);
         * System.out.println("Separador: " + separador);
         */

    }
}