import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        String rutaArchivo = "src/config.txt";
        int piezasTotales = 0;
        List<Maquina> maquinas = new ArrayList<>();
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

        System.out.println("Piezas totales a producir: " + piezasTotales);
        for (Maquina m : maquinas) {
            System.out.println(m);
        }

        //sBacktracking.buscarSolucion(maquinas)
        //sGreedy.buscarSolucion(maquinas)
        //System.out.println(sBacktracking.getSolucion())
        //System.out.println(sGreedy.getSolucion())
    
    }

    /*
     * <<Breve explicación de la estrategia de resolución. Por ejemplo:
     * - Cómo se genera el árbol de exploración.
     * - Cuáles son los estados finales y estados solución.
     * - Posibles podas.
     * - etc.>>
     */

    //public Solucion backtracking() {}



    /*
     * <<Breve explicación de la estrategia de resolución. Por ejemplo:
     * - Cuáles son los candidatos.
     * - Estrategia de selección de candidatos.
     * - Consideraciones respecto a encontrar o no solución.
     * - etc.>>
     */

    //public Solucion greedy() {}
}
