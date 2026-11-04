public class Tarea {

    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    
    public Tarea(int id, String t, String c) {
        this.id = id;
        titulo = t;
        descripcion = c;
        completada = false;
    }

    void setCompletada(boolean estadoNuevo){
        completada = estadoNuevo;
    }

    boolean getCompletada(){
        return completada;
    }

    int getId(){
        return id;
    }

}