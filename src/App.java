import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        String rutaArchivo = "src/config.txt";
        int piezasTotales = 0;
        ArrayList<Maquina> maquinas = new ArrayList<>();
        SolucionBacktracking sBacktracking = new SolucionBacktracking();
        SolucionGreedy sGreedy = new SolucionGreedy();


        try (Scanner scanner = new Scanner(new File(rutaArchivo))) {
            
            if (scanner.hasNextLine()) {
                piezasTotales = Integer.parseInt(scanner.nextLine());
            }

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");

                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    int piezas = Integer.parseInt(partes[1].trim());
                    maquinas.add(new Maquina(nombre, piezas));
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir a número: " + e.getMessage());
        }

        
        ArrayList<Maquina> resultadoBacktracking = sBacktracking.buscarSolucion(maquinas, piezasTotales);
        if (resultadoBacktracking.size() > 0) {
            System.out.println("Mejor secuencia encontrada con Backtracking:");
            System.out.print("[ ");
            for (Maquina m : resultadoBacktracking) {
                System.out.print(m + " ");
            }
            System.out.println(']');
            System.out.println("Metricas:");
            System.out.println("Cantidad de estados generados: " + sBacktracking.getCantidadEstados());
            System.out.println("Cantidad piezas producidas: " + piezasTotales);
            System.out.println("Cantidad de puestas en funcionamiento: " + resultadoBacktracking.size());
        } else {
            System.out.println("No se encontró una combinación válida.");
        }

        //ArrayList<Maquina> resultadoGreedy = sGreedy.buscarSolucion(maquinas);

        /* 
            Solución obtenida: secuencia de máquinas.
            Solución obtenida: cantidad de piezas producidas y cantidad de puestas en funcionamiento
            requeridas.
            Métrica para analizar el costo de la solución (cantidad de estados generados)
        */
    }

}

