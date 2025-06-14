import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SolucionBacktracking {
    private ArrayList<Maquina> mejorSolucion;
    private int cantidadEstados;
    
    public SolucionBacktracking() {
        this.mejorSolucion = new ArrayList<>();
    }
    
    public ArrayList<Maquina> buscarSolucion(ArrayList<Maquina> maquinas, int piezasTotales) {
        mejorSolucion.clear();
        ArrayList<Maquina> solucionActual = new ArrayList<Maquina>();
        solucionBacktracking(maquinas, piezasTotales, solucionActual);
        return mejorSolucion;
    }

    /*
 *      <<Breve explicación de la estrategia de resolución. Por ejemplo:
 *          - Cómo se genera el árbol de exploración.
 *          - Cuáles son los estados finales y estados solución.
 *          - Posibles podas. (Piezas restantes negativas; una vez encontrada el de mejor size no creamos mas estados mayores a ese size)
 *       etc.>>
 */
    private void solucionBacktracking(ArrayList<Maquina> maquinas, int piezasRestantes, ArrayList<Maquina> actual) {

        if (piezasRestantes == 0) {
            if (mejorSolucion.isEmpty() || actual.size() < mejorSolucion.size()) {
                this.mejorSolucion.clear();
				this.mejorSolucion.addAll(actual);
            }
            
        } else if (piezasRestantes < 0) {
            return;
        } else if (!mejorSolucion.isEmpty() && actual.size() > mejorSolucion.size()) {
            return;
        } else { 
            cantidadEstados++;
            for (Maquina m : maquinas) {
                actual.add(m);
                solucionBacktracking(maquinas, piezasRestantes - m.getPiezasPorUso(), actual);
                actual.remove(actual.size() - 1);
            } 
        }

    }

    public int getCantidadEstados() {
        return cantidadEstados;
    }
    
}