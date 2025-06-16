import java.util.ArrayList;


public class SolucionBacktracking {
    private ArrayList<Maquina> mejorSolucion;
    private int cantidadEstados;
    
    public SolucionBacktracking() {
        this.mejorSolucion = new ArrayList<>();
    }
    
    /* 
    - Generamos el árbol de exploración eligiendo en cada nivel una de las máquinas disponibles con posibilidad de reutilización. 

    - Llegamos a un Estado Final cuando todavía hay piezas restantes y ya se probaron todas las combinaciones de máquinas. 
    - Llegamos al Estado Solución cuando las piezas restantes son 0 y ya fue comparado con la mejor solución.

    - Las posibles podas son: 
        - Si llegamos a piezas restantes negativas
        - Si ya se ha encontrado una solución y la cantidad de máquinas usadas en la solución parcial actual es mayor a la cantidad en la mejor solución.
    */

    public ArrayList<Maquina> buscarSolucion(ArrayList<Maquina> maquinas, int piezasTotales) {
        mejorSolucion.clear();
        ArrayList<Maquina> solucionActual = new ArrayList<Maquina>();
        solucionBacktracking(maquinas, piezasTotales, solucionActual);
        return mejorSolucion;
    }

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