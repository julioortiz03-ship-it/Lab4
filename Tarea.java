public class Tarea {
    private final int id;
    private final String titulo;
    private final String descripcion;
    private boolean completada;
    public Tarea(int id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = false;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean getCompletada() {
        return completada;
    }

    public void setCompletada(boolean estadoNuevo) {
        this.completada = estadoNuevo;
    }
}