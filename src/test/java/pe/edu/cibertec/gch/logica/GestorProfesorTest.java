package pe.edu.cibertec.gch.logica;


import java.util.Date;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pe.edu.cibertec.gch.modelo.EstadoProfesor;
import pe.edu.cibertec.gch.modelo.Genero;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 * Prueba la funcionalidad del gestor de profesor
 */
public class GestorProfesorTest {

    private GestorProfesor gestorProfesor;

    @Before
    public void prepararPruebas() {
        // preparacion primaria de pruebas
        gestorProfesor = new GestorProfesor();
    }

    @After
    public void limpiar() {
        // limpieza posterior a todas las pruebas
        gestorProfesor.borrarTodos();
    }

    @Test
    public void cuandoRegistraExitosamente() {
        // preparacion adicional
        Profesor profesor = new Profesor() {
            {
                setCodigo("pxvbalta");
                setNombres("Victor");
                setApellidoPaterno("Balta");
                setFechaNacimiento(new Date());
                setSexo(Genero.Masculino);
                setEstado(EstadoProfesor.Activo);
            }
        };
        gestorProfesor.borrarTodos();
        // ejecucion
        gestorProfesor.registrar(profesor);
        // verificacion
        assertEquals(1, gestorProfesor.listarTodos().size());
        
    }

    @Test
    public void cuandoRegistraVariosExitosamente() {
        // preparacion de data
        Profesor profesor1 = new Profesor() {
            {
                setCodigo("pxvbalta");
                setNombres("Victor");
                setApellidoPaterno("Balta");
                setFechaNacimiento(new Date());
                setSexo(Genero.Masculino);
                setEstado(EstadoProfesor.Activo);
            }
        };
        Profesor profesor2 = new Profesor() {
            {
                setCodigo("pxgcarra");
                setNombres("Paolo");
                setApellidoPaterno("Carrasco");
                setFechaNacimiento(new Date());
                setSexo(Genero.Masculino);
                setEstado(EstadoProfesor.Activo);
            }
        };
        // ejecucion
        gestorProfesor.borrarTodos();
        gestorProfesor.registrar(profesor1);
        gestorProfesor.registrar(profesor2);

        // verificacion
        assertEquals(2, gestorProfesor.listarTodos().size());
        
    }

    @Test
    public void cuandoEliminaExitosamente() {
        // preparacion de data
        Profesor profesor = new Profesor() {
            {
                setCodigo("pxvbalta");
                setNombres("Victor");
                setApellidoPaterno("Balta");
                setFechaNacimiento(new Date());
                setSexo(Genero.Masculino);
                setEstado(EstadoProfesor.Activo);
            }
        };
        gestorProfesor.registrar(profesor);
        // ejecucion
        gestorProfesor.eliminarPorCodigo("pxvbalta");
        // verificacion
        Profesor profesorEliminado = gestorProfesor.consultarPorCodigo("pxvbalta");
        assertSame(EstadoProfesor.Inactivo, profesorEliminado.getEstado());
    }

    @Test
    public void cuandoConsultaProfesorExitosamente() {
        // preparacion de data
        Profesor profesor1 = new Profesor() {
            {
                setCodigo("pxvbalta");
                setNombres("Victor");
                setApellidoPaterno("Balta");
                setFechaNacimiento(new Date());
                setSexo(Genero.Masculino);
                setEstado(EstadoProfesor.Activo);
            }
        };
        Profesor profesor2 = new Profesor() {
            {
                setCodigo("pxgcarra");
                setNombres("Paolo");
                setApellidoPaterno("Carrasco");
                setFechaNacimiento(new Date());
                setSexo(Genero.Masculino);
                setEstado(EstadoProfesor.Activo);
            }
        };
        gestorProfesor.registrar(profesor1);
        gestorProfesor.registrar(profesor2);

        Profesor profesorBuscado = gestorProfesor.consultarPorCodigo("pxvbalta");
        assertSame(profesorBuscado.getNombres(), profesor1.getNombres());
    }
}
