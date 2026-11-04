public class TareaController {
    private final AlmacenarTareas almacenamiento;
    private int siguienteId = 0;

    public TareaController(AlmacenarTareas almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public Tarea agregarTarea(String titulo, String descripcion) {
        Tarea tarea = new Tarea(siguienteId, titulo, descripcion);
        almacenamiento.guardar(tarea);
        siguienteId++;
        return tarea;
    }
    public void completarTarea(int id) {
        Tarea tarea = almacenamiento.buscarPorId(id);

        if (tarea == null) {
            throw new IllegalArgumentException(
                "No existe una tarea con ese ID."
            );
        }

        if (tarea.getCompletada()) {
            throw new IllegalStateException(
                "La tarea ya estaba completada."
            );
        }

        tarea.setCompletada(true);
    }

    public void eliminarTarea(int id) {
        boolean eliminada = almacenamiento.eliminar(id);

        if (!eliminada) {
            throw new IllegalArgumentException(
                "No existe una tarea con ese ID."
            );
        }
    }
}