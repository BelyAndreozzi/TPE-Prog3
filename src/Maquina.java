public class Maquina {
    private String nombre;
    private Integer piezasPorUso;

    public Maquina(String nombre, int piezasPorUso) {
        this.nombre = nombre;
        this.piezasPorUso = piezasPorUso;
    }

    public Integer getPiezasPorUso() {
        return piezasPorUso;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}