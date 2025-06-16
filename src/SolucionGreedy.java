import java.util.ArrayList;

public class SolucionGreedy {
    private ArrayList<Maquina> resultado;
    private int cantidadCandidatos;
    
    public SolucionGreedy() {
        this.resultado = new ArrayList<>();
    }


    /*
    - Tomando las máquinas dadas y ordenandolas de mayor a menor y posteriomente filtrándolas (aquellas iguales a 0 o que superan la cantidad de piezas necesarias), nos quedamos con nuestros candidatos a considerar.
    - Por cada máquina se checkea que sus piezas producidas por uso sean iguales o menores a las piezas restantes, si lo son se añaden a la solucion y se actualizan las piezas restantes. Utilizamos break para darle la posibilidad de volver a usar la pieza más grande. Si no se usó ninguna máquina, nos saca del bucle.
    */
    
    public ArrayList<Maquina> buscarSolucion(ArrayList<Maquina> maquinas, int piezasObjetivo) {
        maquinas.sort((a, b) -> b.getPiezasPorUso() - a.getPiezasPorUso());
        maquinas = this.filtrarValidas(maquinas, piezasObjetivo);   
        int piezasRestantes = piezasObjetivo;


        while (piezasRestantes > 0) {
            boolean seUsoMaquina = false;
            
            for (Maquina m : maquinas) {
                if (m.getPiezasPorUso() <= piezasRestantes) {
                    resultado.add(m);
                    piezasRestantes -= m.getPiezasPorUso();
                    seUsoMaquina = true;
                    break;
                }
            }

            if (!seUsoMaquina) {
                return null;
            }
        }

        if (resultado != null) {
            return resultado;
        } else {
            return null;
            
        }
    }

    public ArrayList<Maquina> filtrarValidas(ArrayList<Maquina> maquinas, int piezasObjetivo) {
        ArrayList<Maquina> validas = new ArrayList<>();
        for (Maquina m : maquinas) {
            if (m.getPiezasPorUso() > 0 && m.getPiezasPorUso() <= piezasObjetivo) {
                validas.add(m);
            }
        }
        cantidadCandidatos = validas.size();
        return validas;
    }

    public int getCantidadCandidatos() {
        return this.cantidadCandidatos;
    }


}