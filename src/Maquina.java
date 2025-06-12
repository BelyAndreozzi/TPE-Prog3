public class Maquina {
    String nombre;
    int piezasPorUso;

    public Maquina(String nombre, int piezasPorUso) {
        this.nombre = nombre;
        this.piezasPorUso = piezasPorUso;
    }

    @Override
    public String toString() {
        return nombre + " produce " + piezasPorUso + " piezas";
    }
}
