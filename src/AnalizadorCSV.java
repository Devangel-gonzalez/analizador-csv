import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class AnalizadorCSV {

    public static void main(String[] args) {

        Configuracion configuracion = new Configuracion(args);

        System.out.println(
                "Configuración de la aplicación");

        System.out.println(
                "Archivo: "
                        + configuracion.getArchivo());

        System.out.println(
                "Separador: "
                        + configuracion.getSeparador());

        System.out.println(
                "Salida: "
                        + configuracion.getDirectorioSalida());

        // Cargar archivo de propiedades
        Properties propiedades = new Properties();
        try (
                FileInputStream archivo = new FileInputStream(
                        "config/application.properties")) {
            propiedades.load(archivo);
        } catch (IOException e) {
            System.out.println(
                    "Se utilizará configuración predeterminada.");
        }

        // 1. Valor predeterminado (Menor prioridad)
        String separador = ",";

        // 2. Archivo properties (Sobrescribe al predeterminado)
        separador = propiedades.getProperty("separador", separador);

        // 3. Variable de ambiente (Sobrescribe al properties)
        separador = System.getenv().getOrDefault("CSV_SEPARATOR", separador);

        // 4. Argumentos de línea de comandos (Máxima prioridad)
        if (args.length >= 2) {
            separador = args[1];
        }
        /*
         * String archivo = (args.length >= 1) ? args[0] :
         * propiedades.getProperty("archivo", "datos/datos.csv");
         * System.out.println("Archivo a procesar: " + archivo);
         * System.out.println("Separador final: " + separador);
         * 
         */

        // Leer propiedades desde el archivo de configuración
        String archivoDatos = propiedades.getProperty("archivo");

        // String separador = propiedades.getProperty("separador");

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