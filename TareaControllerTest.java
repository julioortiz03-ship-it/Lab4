import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TareaControllerTest {
    private TareaController controlador;
    private AlmacenarTareas almacenamiento;

    @Before
    public void setUp() {
        almacenamiento = new AlmacenamientoMemoria();
        controlador = new TareaController(almacenamiento);
    }

    @Test
    public void testAgregarVariosElementosYRevisarIds() {
        Tarea t = controlador.agregarTarea("atender estudiantes", "Ximena");
        Tarea t2 = controlador.agregarTarea("atender estudiantes", "Luis Diego");
        Tarea t3 = controlador.agregarTarea("atender estudiantes", "william");

        assertNotNull(t);
        assertNotNull(t2);
        assertNotNull(t3);

        assertEquals(0, t.getId());
        assertEquals(1, t2.getId());
        assertEquals(2, t3.getId());

        assertNotEquals(t.getId(), t2.getId());

        assertEquals(3, almacenamiento.obtenerTodas().size());
    }

    @Test
    public void validarCambioDeEstado() {
        Tarea t = controlador.agregarTarea("atender estudiantes", "william");

        assertFalse(t.getCompletada());

        controlador.completarTarea(t.getId());

        assertTrue(t.getCompletada());
    }

    @Test
    public void testCompletarTareaInexistenteLanzaExcepcion() {
        assertThrows(
            IllegalArgumentException.class,
            () -> controlador.completarTarea(99)
        );
    }

    @Test
    public void testCompletarTareaYaCompletadaLanzaExcepcion() {
        Tarea t = controlador.agregarTarea("estudiar", "POO");
        controlador.completarTarea(t.getId());

        assertThrows(
            IllegalStateException.class,
            () -> controlador.completarTarea(t.getId())
        );
    }

    @Test
    public void testCompletarConIdIgualAlContador() {
        controlador.agregarTarea("a", "a");
        controlador.agregarTarea("b", "b");
        controlador.agregarTarea("c", "c");

        assertThrows(
            IllegalArgumentException.class,
            () -> controlador.completarTarea(3)
        );
    }

    @Test
    public void testEliminarTareaExistente() {
        Tarea t = controlador.agregarTarea("borrar", "prueba");

        controlador.eliminarTarea(t.getId());

      
        assertNull(almacenamiento.buscarPorId(t.getId()));

        assertTrue(almacenamiento.obtenerTodas().isEmpty());
    }

    @Test
    public void testEliminarTareaInexistenteLanzaExcepcion() {
        assertThrows(
            IllegalArgumentException.class,
            () -> controlador.eliminarTarea(99)
        );
    }
}